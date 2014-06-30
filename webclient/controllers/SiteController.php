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
		
		
        return $this->render('index', [
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
        return $this->render('live', []);
		
	}
	
}
