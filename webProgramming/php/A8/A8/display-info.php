<?php

session_start();    
   $_SESSION["session-card"] = $_POST["card"];
   $_SESSION["session-expiry"] = $_POST["expiry"];
   $_SESSION["session-ccv"] = $_POST["ccv"];
   session_destroy();
?>

   <h1><?= ($_SESSION["session-name"]); ?></h1>
   <h1><?= ($_SESSION["session-email"]); ?></h1>
   <h1><?= ($_SESSION["session-street"]); ?></h1>
   <h1><?= ($_SESSION["session-city"]); ?></h1>
   <h1><?= ($_SESSION["session-country"]); ?></h1>
   <h1><?= ($_SESSION["session-province"]); ?></h1>
   <h1><?= ($_SESSION["session-postal"]); ?></h1>
   <h1><?= ($_SESSION["session-card"]); ?></h1>
   <h1><?= ($_SESSION["session-expiry"]); ?></h1>
   <h1><?= ($_SESSION["session-ccv"]); ?></h1>

