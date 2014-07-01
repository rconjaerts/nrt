<?php
use yii\helpers\Html;
use yii\widgets\ActiveForm; 
use dosamigos\datepicker\DatePicker;

/**
 * @var yii\web\View $this
 * @var $rows
 */
?>
<style>
input {
	border: 0;
	font-size:63px;
	font-weight: 500;
	text-align: center;
	padding: 0;
	margin: 0;
	line-height: normal;
	width: 400px;
	margin-bottom: 5px;
}

</style>
<div class="site-index">	

	<div class="jumbotron" style="padding-bottom: 10px; padding-top: 0;">
	  <h1>Overall sleeping quality for</h1>
	  <input type="text" data-date-format="dd/mm/yyyy" value="<?= $todayShow; ?>" id="datepicker" width=300>
	  <br>
	  <div class="row">
	  <?php for($i = 1; $i <= 10; $i++){
		  if($i==$comfortScore){
			  echo '<div class="col-md-3">';
			  echo '<img src=' . Yii::$app->homeUrl .'/../img/bbsc'.$i.'.png style="width: 200px; height:200px;">';
			  echo '</div>';
		  } else {
			  echo '<div class="col-md-1">';
			  echo '<img src=' . Yii::$app->homeUrl .'/../img/bbsc'.$i.'.png style="width: 50px; height:50px; opacity:0.6">';
			  echo '</div>';
		  }
	  }
	  ?>
  	 </div>
  	<!-- <img src=<?= Yii::$app->homeUrl.'/../img/bbsc'.$comfortScore.'.png'; ?> -->
	</div>
	<div style="padding-right: 60px; padding-left:60px;">
		<h4>Good nights' rest</h4>
		
	<div class="progress">
	  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="<?= $sleepQualityValue ?>" aria-valuemin="0" aria-valuemax="100" style="width: <?= $sleepQualityValue ?>%">
	    <span class="sr-only"><?= $sleepQualityValue ?>% Complete (success)</span>
	  </div>
	</div>
	<h4>Movement</h4>
	<div class="progress">
	  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="<?= $movementValue ?>" aria-valuemin="0" aria-valuemax="100" style="width: <?= $movementValue ?>%">
	    <span class="sr-only"><?= $movementValue ?>% Complete</span>
	  </div>
	</div>
	<h4>Noise</h4>
	<div class="progress">
	  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="<?= $noiseValue ?>" aria-valuemin="0" aria-valuemax="100" style="width: <?= $noiseValue ?>%">
	    <span class="sr-only"><?= $noiseValue ?>% Complete (warning)</span>
	  </div>
	</div>

</div>

	<!-- <canvas id="myChart" style="max-width: 80%"></canvas> -->
	<h2 style="margin-left:60px;">Movement graph</h2>	
	<center>

	<canvas id="video" style="max-width: 80%"></canvas>
</center>
	<h2 style="margin-left:60px;">Noise graph</h2>	
	<center>
	
	<canvas id="audio" style="max-width: 80%"></canvas>
	</center>
	<script>


	var options = {

    ///Boolean - Whether grid lines are shown across the chart
    scaleShowGridLines : true,

	showTooltips: false,
	
	// Boolean - Whether to animate the chart
	animation: false,

	// Boolean - If we should show the scale at all
	showScale: true,

	scaleShowLabels: true,
	
	
    //String - Colour of the grid lines
    scaleGridLineColor : "rgba(0,0,0,.05)",

    //Number - Width of the grid lines
    scaleGridLineWidth : 1,

    //Boolean - Whether the line is curved between points
    bezierCurve : true,

    //Number - Tension of the bezier curve between points
    bezierCurveTension : 0.4,

    //Boolean - Whether to show a dot for each point
    pointDot : false,

    //Number - Radius of each point dot in pixels
    pointDotRadius : 4,

    //Number - Pixel width of point dot stroke
    pointDotStrokeWidth : 1,

    //Number - amount extra to add to the radius to cater for hit detection outside the drawn point
    pointHitDetectionRadius : 10,

    //Boolean - Whether to show a stroke for datasets
    datasetStroke : true,

    //Number - Pixel width of dataset stroke
    datasetStrokeWidth : 3,

    //Boolean - Whether to fill the dataset with a colour
    datasetFill : true,

    //String - A legend template
    legendTemplate : false,
	
	labelTemplateString : '',

};
		(function() {
	
				
			var canvas1 = document.getElementById('video'),
				context1 = canvas1.getContext('2d');
				
			var canvas2 = document.getElementById('audio'),
				context2 = canvas2.getContext('2d');	
			
			window.addEventListener('resize', resizeCanvas1, false);
			window.addEventListener('resize', resizeCanvas2, false);

	
			function resizeCanvas1() {
					canvas1.width = window.innerWidth;
					canvas1.height = window.innerHeight;
					drawStuff1(); 
			}
			function resizeCanvas2() {
					canvas2.width = window.innerWidth;
					canvas2.height = window.innerHeight;
					drawStuff2(); 
			}
			
			resizeCanvas1();
			resizeCanvas2();
			
		
			function drawStuff1() {
				var data = {
				labels: <?php echo '[' . implode(', ', $videoX) . ']'; ?>,
				datasets: [
						{
							label: "Video",
							strokeColor: "rgba(91,192,222, 1)",
							fillColor: "rgba(91,192,222, 0.7)",
							pointColor: "rgba(220,220,220,1)",
							pointStrokeColor: "#fff",
							pointHighlightFill: "#fff",
							pointHighlightStroke: "rgba(220,220,220,1)",
							data: <?php echo '[' . implode(', ', $videoY) . ']'; ?>
						},
					]
				};
				// Get the context of the canvas element we want to select
				var ctx = document.getElementById("video").getContext("2d");
				var myLineChart = new Chart(ctx).Line(data, options);
			}
			
			function drawStuff2() {
				var data = {
				labels: <?php echo '[' . implode(', ', $audioX) . ']'; ?>,
				datasets: [
						{
							label: "Audio",
							fillColor: "rgba(240,173,78,0.7)",
							strokeColor: "rgba(240,173,78,,1)",
							pointColor: "rgba(220,220,220,1)",
							pointStrokeColor: "#fff",
							pointHighlightFill: "#fff",
							pointHighlightStroke: "rgba(220,220,220,1)",
							data: <?php echo '[' . implode(', ', $audioY) . ']'; ?>
						}
					]
				};
				// Get the context of the canvas element we want to select
				var ctx = document.getElementById("audio").getContext("2d");
				var myLineChart = new Chart(ctx).Line(data, options);
			}
		})();	
		
		$('#datepicker').datepicker(
		).on('changeDate', function(e){
			d = $('#datepicker').val()
			
			var link = window.location.href.split('?')[0];
		    link = link + '?' + 'date=' + d;
		    window.location.href = link;
	     });
		
	</script>	
</div>