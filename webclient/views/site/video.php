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
	<p>Data from today: <b><?= $todayShow; ?></b></p>
	
	<canvas id="myChart" width="400px" height="400px"></canvas>
	<script>
		(function() {
			var canvas = document.getElementById('myChart'),
				context = canvas.getContext('2d');
			// resize the canvas to fill browser window dynamically
			window.addEventListener('resize', resizeCanvas, false);

			function resizeCanvas() {
					canvas.width = window.innerWidth;
					canvas.height = window.innerHeight;
					drawStuff(); 
			}
			resizeCanvas();

			function drawStuff() {
				var data = {
				labels: <?php echo '[' . implode(', ', $dataX) . ']'; ?>,
				datasets: [
						{
							label: "Video",
							fillColor: "rgba(220,220,220,0.7)",
							strokeColor: "rgba(220,220,220,1)",
							pointColor: "rgba(220,220,220,1)",
							pointStrokeColor: "#fff",
							pointHighlightFill: "#fff",
							pointHighlightStroke: "rgba(220,220,220,1)",
							data: <?php echo '[' . implode(', ', $dataY) . ']'; ?>
						}
					]
				};
				// Get the context of the canvas element we want to select
				var ctx = document.getElementById("myChart").getContext("2d");
				var myLineChart = new Chart(ctx).Line(data);
			}
		})();	
	</script>
	<?php print_r($dataX); ?>
</div>