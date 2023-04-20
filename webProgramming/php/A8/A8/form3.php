<?php

session_start();    
   $_SESSION["session-street"] = $_POST["street"];
   $_SESSION["session-city"] = $_POST["city"];
   $_SESSION["session-country"] = $_POST["country"];
   $_SESSION["session-province"] = $_POST["province"];
   $_SESSION["session-postal"] = $_POST["postal"];
?>

<form action="display-info.php" enctype="multipart/form-data" method="POST">

    <label for="card">Card Number:</label>
    <input name="card" type="text" placeholder="Card Number"> <br>

    <label for="expiry">Expiry Date:</label>
    <input name="expiry" type="text" placeholder="Expiry Date"> <br>
    
    <label for="ccv">CCV:</label>
    <input name="ccv" type="text" placeholder="CCV"> <br>
    
    <input type="submit">
</form>