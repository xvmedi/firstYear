<?php 
// process-input-form


// recieve psot variabels 
$firstName = $_POST['firstName'];
$lastName = $_POST["lastName"];
$date_of_Birth = $_POST["date_of_Birth"];
$bio = $_POST["bio"];
$heightCM = $_POST["heightCM"];
$numberOfChildren = $_POST["numberOfChildren"];
$profilePicture = "";
$isActive = 0;
if(isset($_POST['isActive'])) $isActive == 1;

// if there is profile pic
if(isset($_FILES['profilePicture'])){
    $uploaddir = "uploads/";
    $uploadedfile = $uploaddir . basename($_FILES['profilePicture']['name']);
    move_uploaded_file($_FILES['profilePicture']['name'], $uploadedfile);
    $profilePicture = $_FILES['profilePicture']['name'];
}

//connect 
$dsn = "mysql:host=localhost;dbname=a5;charset=utf8mb4";
$dbusername = "root";
$dbpassword = "";

$pdo = new PDO($dsn, $dbusername, $dbpassword); 

//prepare
$stmt = $pdo->prepare("INSERT INTO `actors` 
	(`actorId`, `firstName`, `lastName`, `DOB`,`bio`,`height`,`numChildren`,`profilePicture`,`isActive`) 
	VALUES 
	(NULL, '$firstName', '$lastName', '$date_of_Birth', '$bio','$heightCM','$numberOfChildren','$profilePicture','$isActive');");

//execute 
if ($stmt->execute()){
    ?> <p>Added record, <?= $firstName ." ". $lastName ?></p> 
    <a href="select-actor.php">Return to All Actors</a>
    <?php
}else {
   ?><p>record not recorded</p> 
<?php } ?>

