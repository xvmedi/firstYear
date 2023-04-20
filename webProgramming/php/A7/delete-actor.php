
<?php
//delete-person.php
$actorId = $_GET['actorId'];

//connect
$dsn = "mysql:host=localhost;dbname=a5;charset=utf8mb4";
$dbusername = "root";
$dbpassword = "";

$pdo = new PDO($dsn, $dbusername, $dbpassword); 

//prepare
$stmt = $pdo->prepare("SELECT * FROM `actors` 
	WHERE `actorId` = $actorId");

//execute
$stmt->execute();

 //connect to display
$row = $stmt->fetch();
?>

<!-- Display record information -->
<h1>Are you sure you want to delete this record?</h1>
<p><?= $row['actorId'] ?></p>
<p><?= $row['firstName'] ?></p>
<p><?= $row['lastName'] ?></p>
<p><?= $row['date_of_Birth'] ?></p>
<p><?= $row['bio'] ?></p>
<p><?= $row['height'] ?></p>
<p><?= $row['numChildren'] ?></p>

<!-- confirm and delete -->
<a href="select-actor.php">No</a>
<form action="confirm-delete-actor.php" method="POST">
	<input name="actorId" value=" <?=$row['actorId'] ?>" type="hidden">
	<input type="submit" value="Yes">
</form>

