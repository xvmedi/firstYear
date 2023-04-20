<?php 
?>

<form action="process-form.php" enctype="multipart/form-data" method="POST">

    <label for="firstName">First Name:</label>
    <input name="firstName" type="text" placeholder="firstName"> <br>

    <label for="lastName">Last Name:</label>
    <input name="lastName" type="text" placeholder="lastName"> <br>

    <label for="dateOfBirth">Date of Birth:</label>
    <input name="dateOfBirth" type="text" placeholder="dateOfBirth"><br>

    <label for="bio">Bio:</label>
    <input name="bio" type="textarea"><br>

    <label for="heightCM">Height in centimeters:</label>
    <input name="heightCM" type="number"><br>

    <label for="numberOfChildren">Number of Children:</label>
    <input name="numberOfChildren" type="option" input type="number" max="30"> <br>

    <label for="profilePicture">Profile Picture:</label>
    <input name="profilePicture" type="file"><br>

    <label for="isActive">is Active?</label>
    <input name="isActive" type="checkbox"> <br>

    <input type="submit">
</form>
