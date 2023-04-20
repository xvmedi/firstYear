<?php 
// process-input-form

// recieve post variabels 
$actorId = $_POST['actorId'];
$firstName = $_POST['firstName'];
$lastName = $_POST["lastName"];
$DOB = $_POST["DOB"];
$bio = $_POST["bio"];
$heightCM = $_POST["heightCM"];
$numberOfChildren = $_POST["numberOfChildren"];
$profilePicture = "";
$isActive = 0;
if(isset($_POST['isActive'])) $isActive == 1;

if(isset($_FILES['profilePicture'])){
    $uploaddir = "uploads/";
    $uploadedfile = $uploaddir . basename($_FILES['profilePicture']['name']);
    move_uploaded_file($_FILES['profilePicture']['name'], $uploadedfile);
    $profilePicture = $_FILES['profilePicture']['name'];
}

//connect 
// data source name 
$dsn = "mysql:host=localhost;dbname=a5;charset=utf8mb4";
$dbusername = "root";
$dbpassword = "";
$pdo = new PDO($dsn, $dbusername, $dbpassword); 


//prepare
$stmt = $pdo->prepare("UPDATE `actors`
    SET `firstName` = '$firstName', 
	`lastName` = '$lastName', 
	`DOB` = '$DOB',
    `bio` = '$bio',
    `height` = '$heightCM',
    `numChildren` = '$numberOfChildren',
    `profilePicture` = '$profilePicture',
    `isActive` = '$isActive'
    WHERE `actors`.`actorId` = $actorId;");


//execute 
if ($stmt->execute()){
    ?> <p>Updated record, <?= $firstName ." ". $lastName ?></p> 
    <a href="select-actor.php">Return to All Actors</a>
    <?php
}else {
   ?><p>record not recorded</p> 
<?php } ?>

