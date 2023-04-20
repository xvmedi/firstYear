<?php?>

<form action="process-insert-form.php" enctype="multipart/form-data" method="POST">

    <label for="firstName">First Name:</label>
    <input name="firstName" type="text" placeholder="firstName"> <br>

    <label for="lastName">Last Name:</label>
    <input name="lastName" type="text" placeholder="lastName"> <br>

    <label for="DOB">Date of Birth:</label>
    <input name="date_of_Birth" id="DOB" type="text" placeholder="date of Birth"><br>

    <label for="bio">Bio:</label>
    <input name="bio" type="textarea"><br>

    <label for="heightCM">Height in centimeters:</label>
    <input name="heightCM" type="number"><br>

    <label for="numberOfChildren">Number of Children:</label>
    <input name="numberOfChildren" type="option" input type="number" max="30"> <br>

    <label for="PFP">Profile Picture:</label>
    <input name="profilePicture" id="PFP" type="file"><br>

    <label for="isActive">is Active?</label>
    <input name="isActive" type="checkbox"> <br>

    <input type="submit">
</form>