<?php 

$firstName = $_POST["firstName"];
$lastName = $_POST["lastName"];
$dateOfBirth = $_POST["dateOfBirth"];
$bio = $_POST["bio"];
$heightCM = $_POST["heightCM"];
$numberOfChildren = $_POST["numberOfChildren"];
$isActive = isset($_POST['isActive']);
$uploaddir = "uploads/";
$uploadedfile = $uploaddir . basename($_FILES['profilePicture']['name']);
?>

<h1><?= $firstName; ?></h1>
<h1><?= $lastName; ?> </h1>
<h1><?= $dateOfBirth; ?></h1>
<h1><?= $bio; ?></h1>
<h1><?= $heightCM; ?></h1>
<h1><?= $numberOfChildren; ?></h1>
<h1><?= $isActive; ?></h1>
<img src="<?= $uploadedfile; ?>" height="200" width="200">

