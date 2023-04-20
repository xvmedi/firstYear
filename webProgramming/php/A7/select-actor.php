<?php
//select-persons.php
// Connect, prepare and execute SQL that would
// 	retrieve all fields for all records 
// 	from the person table
?>

<!-- add button -->
<a href="insertForm.php">Add a new record</a>

<?php
//connect
$dsn = "mysql:host=localhost;dbname=a5;charset=utf8mb4";
$dbusername = "root";
$dbpassword = "";
$pdo = new PDO($dsn, $dbusername, $dbpassword); 


//prepare
$stmt = $pdo->prepare("SELECT * FROM `actors`");


//execute
$stmt->execute();


//display results
?><ul><?php
while($row = $stmt->fetch()) {     
	?><li>
		<?= $row["actorId"] ?>
		<?= $row["firstName"] ?>
		<?= $row["lastName"] ?>
		<?= $row["DOB"] ?>
        <img src="uploads/<?= $row["profilePicture"] ?>" height="60">
		<a href="delete-actor.php?actorId=<?= $row["actorId"] ?>">Delete</a>
        <a href="update-actor.php?actorId=<?= $row["actorId"] ?>">Update</a>
	</li>
<?php } ?>
</ul>


