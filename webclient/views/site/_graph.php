<?php
use yii\helpers\Html;

/**
 * @var yii\web\View $this
 * @var $rows
 */
//$this->layout = '';
?>
<center>
<canvas id="mCanvas" style="max-width: 100%"></canvas>
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
	
	scaleOverride: true,
	
	// Number - The number of steps in a hard coded scale
	scaleSteps: 10,
	// Number - The value jump in the hard coded scale
	scaleStepWidth: 10,
	// Number - The scale starting value
	scaleStartValue: 0,
	
	
	
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
	
	
	var myLineChart = null;
		$(function() {
			
			var canvas = document.getElementById('mCanvas'),
				context = canvas.getContext('2d');
			function resizeCanvas() {
					canvas.width = 1280 //window.innerWidth;
					canvas.height = 636 //window.innerHeight;
					drawStuff(); 
			}
			window.addEventListener('resize', resizeCanvas, false);
			resizeCanvas();
			
		
			function drawStuff() {
				var data = {
				labels: <?php echo '[' . implode(', ', $dataX) . ']'; ?>,
				datasets: [
						{
							label: "Video",
							strokeColor: "rgba(<?php echo $color; ?>, 1)",
							fillColor: "rgba(<?php echo $color; ?>, 0.7)",
							pointColor: "rgba(220,220,220,1)",
							pointStrokeColor: "#fff",
							pointHighlightFill: "#fff",
							pointHighlightStroke: "rgba(220,220,220,1)",
							data: <?php echo '[' . implode(', ', $dataY) . ']'; ?>
						},
					]
				};
				// Get the context of the canvas element we want to select
				var ctx = document.getElementById("mCanvas").getContext("2d");
				myLineChart = new Chart(ctx).Line(data, options);
			}
		});
		
		function drawStuffX(xdata, ydata) {
			var data = {
			labels: xdata,
			datasets: [
					{
						label: "Video",
						strokeColor: "rgba(<?php echo $color; ?>, 1)",
						fillColor: "rgba(<?php echo $color; ?>, 0.7)",
						pointColor: "rgba(220,220,220,1)",
						pointStrokeColor: "#fff",
						pointHighlightFill: "#fff",
						pointHighlightStroke: "rgba(220,220,220,1)",
						data: ydata
					},
				]
			};
			// Get the context of the canvas element we want to select
			var canvas = document.getElementById('mCanvas'),
				ctx = canvas.getContext('2d');
			ctx.clearRect(0,0, canvas.width, canvas.height);
			scale = myLineChart.scale
			myLineChart = new Chart(ctx).Line(data, options);
			myLineChart.scale = scale
		}
		
        function refresh() {
			/*var url = '<?= Yii::$app->homeUrl; ?>' + '/graph/partial'
            console.log(url);
	
	        jQuery.ajax({
	        'type': 'POST',
	        'url': url,
	        'data': {
	        },
	        'success': function(data) {
				xdata = data[0];
				ydata = data[1];
				drawStuffX(xdata, ydata);
	         },
	         'cache': false
		 });
			*/
        }
	</script>	
</div>