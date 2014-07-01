<?php
use yii\helpers\Html;
use yii\widgets\ActiveForm; 
/**
 * @var yii\web\View $this
 * @var $rows
 */
$this->title = 'Test';
?>
<div class="site-index">	
	<?php
	print_r($sleepComfort);
		
	?>
	<div class="jumbotron" style="padding-bottom: 0;">
	  <h1>Sleep summary for <?= $todayShow; ?></h1>
  	<img src=<?= Yii::$app->homeUrl.'/../img/bbsc'.$comfortScore.'.png'; ?>>
	</div>
	<div style="padding-right: 60px; padding-left:60px;">
		<h4>Good nights' rest</h4>
		
	<div class="progress">
	  <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
	    <span class="sr-only">40% Complete (success)</span>
	  </div>
	</div>
	<h4>Movement</h4>
	
	<div class="progress">
	  <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
	    <span class="sr-only">20% Complete</span>
	  </div>
	</div>
	<h4>Noise</h4>
	<div class="progress">
	  <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
	    <span class="sr-only">60% Complete (warning)</span>
	  </div>
	</div>

</div>

	<h3 style="margin-left:60px;">Graph overview</h3>	
	<center>
	<!-- <canvas id="myChart" style="max-width: 80%"></canvas> -->
	<canvas id="video" style="max-width: 80%"></canvas>
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
			/*
			var canvas0 = document.getElementById('myChart'),
				context0 = canvas0.getContext('2d');
			*/
				
			var canvas1 = document.getElementById('video'),
				context1 = canvas1.getContext('2d');
				
			var canvas2 = document.getElementById('audio'),
				context2 = canvas2.getContext('2d');	
			
			window.addEventListener('resize', resizeCanvas0, false);
			window.addEventListener('resize', resizeCanvas1, false);
			window.addEventListener('resize', resizeCanvas2, false);

			function resizeCanvas0() {
					canvas0.width = window.innerWidth;
					canvas0.height = window.innerHeight;
					drawStuff0(); 
			}
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
			
			//resizeCanvas0();
			resizeCanvas1();
			resizeCanvas2();
			
			function drawStuff0() {
				var data = {
				labels: <?php echo '[' . implode(', ', $dataX) . ']'; ?>,
				datasets: [
						{
							label: "Video",
							strokeColor: "rgba(91,192,222, 1)",
							fillColor: "rgba(91,192,222, 0.7)",
							pointColor: "rgba(220,220,220,1)",
							pointStrokeColor: "#fff",
							pointHighlightFill: "#fff",
							pointHighlightStroke: "rgba(91,192,222, 1)",
							data: <?php echo '[' . implode(', ', $videoY) . ']'; ?>
						},
						{
							label: "audio",
							fillColor: "rgba(240,173,78,0.7)",
							strokeColor: "rgba(240,173,78,,1)",
							pointColor: "rgba(220,220,220,1)",
							pointStrokeColor: "#fff",
							pointHighlightFill: "#fff",
							pointHighlightStroke: "rgba(240,173,78,,1)",
							data: <?php echo '[' . implode(', ', $audioY) . ']'; ?>
						}
					]
				};
				// Get the context of the canvas element we want to select
				var ctx = document.getElementById("myChart").getContext("2d");
				var myLineChart = new Chart(ctx).Line(data, options);
			}
			
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
	</script>
	<?php //print_r($dataX); ?>
</div>