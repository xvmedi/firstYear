
<?php

$actorId = $_GET["actorId"];

// $actors = array();
// $actors[0] = "Daniel Craig";
// $actors[1] = "Edward Norton";
// $actors[2] = "Dave Bautista";
// $actors[3] = "Kate Hudson";



if($actorId==1){
    echo("<h1>Daniel Craig</h1>");
}
elseif ($actorId==2){
    echo("<h1>Edward Norton</h1>");
}
elseif($actorId==3)
{
    echo("<h1>Dave Bautista</h1>");
}   
else{
    echo("<h1>Kate Hudson</h1>");
}

?>
