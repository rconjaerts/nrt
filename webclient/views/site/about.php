<?php
use yii\helpers\Html;
use \Michelf\MarkdownExtra;

/**
 * @var yii\web\View $this
 * @var $content
 */
$this->title = 'About';
?>
<div class="site-about markdown">
	<?= MarkdownExtra::defaultTransform($content) ?>
</div>
