<?php

session_start();    
   $_SESSION["session-name"] = $_POST["name"];
   $_SESSION["session-email"] = $_POST["email"];
?>

<form action="form3.php" enctype="multipart/form-data" method="POST">

    <label for="street">Street:</label>
    <input name="street" type="text" placeholder="Street Name"> <br>

    <label for="city">City:</label>
    <input name="city" type="text" placeholder="City"> <br>
    
    <label for="country">Country:</label>
    <input name="country" type="text" placeholder="Country"> <br>

    <label for="province">Province:</label>
    <input name="province" type="text" placeholder="province"> <br>

    <label for="postal">Postal:</label>
    <input name="postal" type="text" placeholder="postal"> <br>
    
    <input type="submit">
</form>