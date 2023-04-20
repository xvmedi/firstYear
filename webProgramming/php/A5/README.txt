PART1:

Create a php script that: receives a GET parameter named "actorId". Using simple if statements or an associative array, show the actor's full name. 
So, if the GET id = 1, show "Daniel Craig". 
If the GET id = 2, show "Edward Norton"
If the GET id = 3, show "Dave Bautista"
If the GET id = 4, show "Kate Hudson"

Create only one one file: 
process-url.php
//receive GET variables
//show output

Test your file by sending variables and values via the URL

PART2: 

Create a form that would send  the following POST variables to a processing script:
firstName (text)
lastName (text)
date of birth (text) 
bio (textarea)
height in cm (number)
numberOfChildren (select with options and values so that the user can select 0-30 children). A smart way to do this is to use a  loop to display the options but if that is a challenge, hardcode the options
profilePicture (file)
isActive (checkbox)

Simply display the values of each POST variable on that processing page

2 files: 
form.php
//form sends POST variables to process-form.php

process-form.php
//remember to use isset to check if the checkbox variable is being passed to the script
//receive POST variables from the form
//display POST and FILES data
//optionally upload the file to an "uploads" folder