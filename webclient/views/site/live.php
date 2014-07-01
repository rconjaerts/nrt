<?php
use yii\helpers\Html;

/**
 * @var yii\web\View $this
 * @var $content
 */
$this->title = 'Live';
?>

<div class="live">
	
	<div id="cal">
	</div>
	<script type="text/javascript">
        function refresh() {
			var url = '<?= Yii::$app->homeUrl; ?>' + '/graph/partial'
            console.log(url);
	
	        jQuery.ajax({
	        'type': 'POST',
	        'url': url,
	        'data': {
	        },
	        'success': function(data) {
				xdata = data[0];
				ydata = data[1];
	         },
	         'cache': false
		 });
        }
	</script>
</div>