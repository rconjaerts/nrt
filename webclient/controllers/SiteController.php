<?php

namespace app\controllers;

use Yii;
use yii\web\Controller;

use yii\helpers\ArrayHelper;


class SiteController extends Controller
{

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
			'data' => $data
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
	
	public function actionLive(){
        return $this->render('live', [
			]);
	}
	
}
