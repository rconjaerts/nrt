<?php

namespace app\controllers;

use Yii;
use yii\web\Controller;

use yii\helpers\ArrayHelper;


class SiteController extends Controller
{

	// Hardcoded user information 
	// Should be removed when user authentication is in place (not for now)
	private $accountId = 1;
	private $audioType= 1;
	private $videoType = 2;

    public function actions()
    {
        return [
            'error' => [
                'class' => 'yii\web\ErrorAction',
            ],
        ];
    }

    public function actionIndex($q = null)
    {
		
		/*
		$client = new \GuzzleHttp\Client();
		$res = $client->get('http://localhost:8080/BigSisterReboot/webresources/entities.event', [
		    'headers' => ['content-type' => 'application/json']
		]);
		echo $res->getStatusCode();           // 200
		echo $res->getHeader('content-type'); // 'application/json; charset=utf8'
		$data = $res->getBody();                 // {"type":"User"...'
		var_export($res->json());             // Outputs the JSON decoded data
	
		*/
        return $this->render('index', [
			//'data' => $data
			]);
    }
	
    public function actionAbout()
    {
		try{
			$content = file_get_contents(__DIR__ . '/../README.md');
		}catch(\Exception $e){
			// this shouldn't happen but hey
			$content = "Failed to retrieve README file";
		}
        return $this->render('about', ['content' => $content]);
    }
	
	public function actionVideolive(){
        return $this->render('videolive', [
			]);
	}
	public function actionData($date=null){
		if(is_null($date)){
			$today  = mktime(0, 0, 0, date("m")  , date("d"), date("Y"));
			$todayShow = date("d/m/Y");
			$now = time();
		} else {
			$today = \DateTime::createFromFormat('d/m/Y', $date);
			$todayShow = $today->format('d/m/Y');
			$today->setTime(0,0,1);
			$now = clone $today;
			$now->setTime(23,59,58);
			$today = $today->getTimestamp();
			$now = $now->getTimestamp();
		}

		//echo '<br><br><br>';
		//echo 'http://192.168.1.116:8080/BigSisterReboot/webresources/entities.event/historydata/'.$this->accountId.'/'.$this->videoType.'/'.$today.'/'.$now;
		
		$client = new \GuzzleHttp\Client();
		
		// Get video data
		$res = $client
				->get('http://192.168.1.116:8080/BigSisterReboot/webresources/entities.event/historydata/'
		.$this->accountId.'/'.$this->videoType.'/'.$today.'/'.$now, [
		    'headers' => ['content-type' => 'application/json']
		]);
		$videoData = $res->json();
		
		// Get audio data
		$res = $client
				->get('http://192.168.1.116:8080/BigSisterReboot/webresources/entities.event/historydata/'
						. $this->accountId.'/'.$this->audioType.'/'.$today.'/'.$now, [
		    'headers' => ['content-type' => 'application/json']
		]);			
		$audioData = $res->json();
		
		// sleep comfort
		$res = $client
				->get('http://192.168.1.116:8080/BigSisterReboot/webresources/entities.event/sleepcomfort/'
						. $this->accountId.'/'.'1'.'/'.$now, [
		    'headers' => ['content-type' => 'application/json']
		]);		
			
		$sleepComfort = $res->json();
		
		$audioValue = $sleepComfort['audioValue'];
		$audioCount = $sleepComfort['audioCount'];
		$videoValue = $sleepComfort['videoValue'];
		$videoCount = $sleepComfort['videoCount'];
		
		
		$comfortScore = 9;
		
		// Convert to easy arrays for graph
		$videoY = array();
		$videoX = array();
		$audioY = array();
		$audioX = array();
		$dataX = array();
		$movementAmount = 0;
		$movementValue = 0;
		$noiseAmount = 0;
		$noiseValue = 0;
		$sleepQualityValue = 0;
		$comfortScore = 0;
		if(count($videoData) > 0 && count($audioData) > 0){
			
	
		$firstTimestamp = min($videoData[0]["timestamp"], $audioData[0]["timestamp"]);
		foreach($videoData as $event){
		   $videoY[] = $event["value"];
		   $videoX[] = $event["timestamp"] - $firstTimestamp;;
		}
		foreach($audioData as $event){
		   $audioY[] = $event["value"];
		   $audioX[] = $event["timestamp"] - $firstTimestamp;;
		}
		
		$videoHighest = end($videoX)['timestamp'];
		$audioHighest = end($audioX)['timestamp'];
		
		
		if($videoHighest > $audioHighest){
			$dataX = $videoX;
		} else {
			$dataX = $audioX;
		}
		
		$videoRest = count($videoY) - $videoCount;
		$audioRest = count($audioY) - $audioCount;
		
		$movementAmount = $videoCount / count($videoY) * 100;
		$noiseAmount = $audioCount / count($audioY) * 100;
		
		$movementValue = $videoValue / ($videoRest) * 100;
		$noiseValue = $audioValue / ($audioRest) * 100;
	
		$sleepQualityValue = 100 - ((2*$movementAmount + 2*$noiseAmount + $movementValue + $noiseValue) / 4);
		//$sleepQualityValue = (400 - $movementAmount - $movementValue - $noiseAmount - $noiseValue)/4;
		$comfortScore = round($sleepQualityValue/10 + 0.5);
		if($comfortScore < 1){
			$comfortScore = 1;
		}
		if($comfortScore > 10){
			$comfortScore = 10;
		}
		
		}
        return $this->render('data', [
			'todayShow' => $todayShow,   
			'dataX' => $dataX,    
			'videoY' => $videoY,
			'videoX' => $videoX,
			'audioY' => $audioY,
			'audioX' => $audioX,
			'audioValue' => $audioValue,
			'audioCount' => $audioCount,
			'videoValue' => $videoValue,
			'videoCount' => $videoCount,
			'comfortScore' => $comfortScore,
			'sleepComfort' => $sleepComfort,
			//
			'movementAmount' => $movementAmount,
			'movementValue' => $movementValue,
			'noiseAmount' => $noiseAmount,
			'noiseValue' => $noiseValue,
			'sleepQualityValue' => $sleepQualityValue,
			'comfortScore' => $comfortScore,
			]);
	}
}
