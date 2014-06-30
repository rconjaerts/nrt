<?php

$db = require(__DIR__ . '/db.php');

$config = [
    'id' => 'basic',
    'basePath' => dirname(__DIR__),
    'bootstrap' => ['log'],
    'extensions' => require(__DIR__ . '/../vendor/yiisoft/extensions.php'),
    'components' => [
        'cache' => [
            'class' => 'yii\caching\FileCache',
        ],
        'errorHandler' => [
            'errorAction' => 'site/error',
        ],
        'log' => [
            'traceLevel' => YII_DEBUG ? 3 : 0,
            'targets' => [
                [
                    'class' => 'yii\log\FileTarget',
                    'levels' => ['error', 'warning'],
                ],
            ],
        ],
		'db' => $db,
		'urlManager' => [
		        'class' => 'yii\web\UrlManager',
		        'enablePrettyUrl' => true,
		        //'showScriptName' => false,
				'rules' =>  [
				    '<controller:\w+>s' => '<controller>/index',
	                '<controller:\w+>/<id:\d+>' => '<controller>/view',
	                '<controller:\w+>/<action:\w+>/<id:\d+>' => '<controller>/<action>',
	                '<controller:\w+>/<action:\w+>' => '<controller>/<action>',
            		]
		    ],
    ],
];

if (YII_ENV_DEV) {
    // configuration adjustments for 'dev' environment
    $config['bootstrap'][] = 'debug';
    $config['modules']['debug'] = 'yii\debug\Module';
    $config['modules']['gii'] = 'yii\gii\Module';
}

return $config;
