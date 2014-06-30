OpenIS Project: Non-trivial implementation
===========================================

BRIEF
-----
The starting point is a user looking to go holiday in a given city. We then create a page that gives a bunch of information about that city, its country, and its capital city. We show some recreational activities (e.g., museums or parks) around the city. Finally the user gets to see some pictures of the city.

From here on, the user can continue to submit a RFP for an accommodation to stay in this city.


TEAM
----
- Robrecht Conjaerts
- Stijn De Pestel
- Tom Jaspers
- Mathieu Thys



LIBRARIES / FRAMEWORKS:
-----------------------

- Yii2 Framework (https://github.com/yiisoft/yii2)
- ARC2-SPARQL1.1 (https://github.com/stuartraetaylor/arc2-sparql11)
- Geocoder (https://github.com/geocoder-php/Geocoder)
- TwitterOAuth (https://github.com/abraham/twitteroauth), modified for 500px use
- PHP-Markdown (http://michelf.ca/projects/php-markdown/)



DIRECTORY STRUCTURE (provided by Yii2)
--------------------------------------
Irrelevant directories ommited from overview.

      assets/             contains assets definition
      config/             contains application configurations
      controllers/        contains Web controller classes
      models/             contains model classes
      vendor/             contains dependent 3rd-party packages (e.g, ARC2)
      views/              contains view files for the Web application
      web/                contains the entry script and Web resources


REQUIREMENTS
------------

- Web server supports PHP 5.4.0.

INSTALLATION
------------

- Clone this repo or download the archived file, and place in Web root.

You can then access the application through the following URL:
~~~
http://localhost/openis-project/web/
~~~
