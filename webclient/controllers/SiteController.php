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
	
	public function actionAudio(){
        return $this->render('audio', [
			]);
	}
	
	public function actionVideo(){
		
		$today  = mktime(0, 0, 0, date("m")  , date("d"), date("Y"));
		$todayShow = date("d/m/Y");
		$now = time();
		
		$client = new \GuzzleHttp\Client();
		$res = $client->get('http://localhost:8080/BigSisterReboot/webresources/entities.event/historydata/'.$this->accountId.'/'.$this->videoType.'/'.$today.'/'.$now, [
		    'headers' => ['content-type' => 'application/json']
		]);
		$data = $res->json();
		
		$dataY = array();
		$dataX = array();
		$firstTimestamp = $data[0]["timestamp"];
		foreach($data as $event)
		{
		   $dataY[] = $event["value"];
		   $dataX[] = $event["timestamp"] - $firstTimestamp;
		}

        return $this->render('video', [
			'todayShow' => $todayShow,       
			'dataY' => $dataY,
			'dataX' => $dataX
			]);
	}
	
}
