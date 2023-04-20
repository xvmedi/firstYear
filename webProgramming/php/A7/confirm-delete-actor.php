<?php
//confirm-delete-person.php

//receive POST variables
$actorId = $_POST['actorId'];

//connect
$dsn = "mysql:host=localhost;dbname=a5;charset=utf8mb4";
$dbusername = "root";
$dbpassword = "";

$pdo = new PDO($dsn, $dbusername, $dbpassword); 

//prepare
$stmt = $pdo->prepare("DELETE FROM actors 
	WHERE `actors`.`actorId` = '$actorId'");

//execute
if($stmt->execute()){ ?>
	<p>Record deleted</p>
    <a href="select-actor.php">Return to All Actors</a>
<?php }else{ ?>
	<p>Oops something went wrong</p>
<?php }
