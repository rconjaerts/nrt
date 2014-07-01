<?php

namespace app\controllers;

use Yii;
use yii\web\Controller;

use yii\helpers\ArrayHelper;


class GraphController extends Controller
{	
	public $layout = 'empty';
	
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
	
	public function actionMovement($date=null){
		if(is_null($date)){
			$today  = mktime(0, 0, 0, date("m")  , date("d"), date("Y"));
			$todayShow = date("d/m/Y");
			$now = time();
		} else {
			$today = \DateTime::createFromFormat('d/m/Y', $date);
			$today->setTime(0,0,1);
			$now = clone $today;
			$now->setTime(23,59,58);
			$today = $today->getTimestamp();
			$now = $now->getTimestamp();
		}
		
		$client = new \GuzzleHttp\Client();		
		$res = $client
				->get('http://192.168.1.116:8080/BigSisterReboot/webresources/entities.event/historydata/'
		.$this->accountId.'/'.$this->videoType.'/'.$today.'/'.$now, [
		    'headers' => ['content-type' => 'application/json']
		]);
		$videoData = $res->json();
		
		$videoY = array();
		$videoX = array();
		$firstTimestamp = $videoData[0]["timestamp"];
		foreach($videoData as $event){
		   $videoY[] = $event["value"];
		   $videoX[] = $event["timestamp"] - $firstTimestamp;;
		}
		
        return $this->render('/site/_graph', [
			'dataY' => $videoY,
			'dataX' => $videoX,
			'color' => '91,192,222'
			]);
	}

	public function actionNoise($date=null){
		if(is_null($date)){
			$today  = mktime(0, 0, 0, date("m")  , date("d"), date("Y"));
			$todayShow = date("d/m/Y");
			$now = time();
		} else {
			$today = \DateTime::createFromFormat('d/m/Y', $date);
			$today->setTime(0,0,1);
			$now = clone $today;
			$now->setTime(23,59,58);
			$today = $today->getTimestamp();
			$now = $now->getTimestamp();
		}
		
		$client = new \GuzzleHttp\Client();		
		$res = $client
				->get('http://192.168.1.116:8080/BigSisterReboot/webresources/entities.event/historydata/'
		.$this->accountId.'/'.$this->audioType.'/'.$today.'/'.$now, [
		    'headers' => ['content-type' => 'application/json']
		]);
		$videoData = $res->json();
		
		$videoY = array();
		$videoX = array();
		$firstTimestamp = $videoData[0]["timestamp"];
		foreach($videoData as $event){
		   $videoY[] = $event["value"];
		   $videoX[] = $event["timestamp"] - $firstTimestamp;;
		}
		
        return $this->render('/site/_graph', [
			'dataY' => $videoY,
			'dataX' => $videoX,
			'color' => '240,173,78'
			]);
	}


}
