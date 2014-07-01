<?php
use yii\helpers\Html;

/**
 * @var yii\web\View $this
 * @var $content
 */
$this->title = 'Live';
?>
<div class="live">
	<?php echo $latestTimestamp; ?>
	<script type="text/javascript">
		setInterval ( "checkForNewData()", 5000 );

		function checkForNewData()
		{
		  console.log("test");
		}
	</script>
</div>