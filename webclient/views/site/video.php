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
	<?php print_r($data); ?>
</div>