// Wasim Singh
// SYST10199 Web Programming
// Cristo Vasilaros A2

//Find 4 images online and download them to your computer. Double click the images to ensure that the images work properly. 
//Close them once you have confirmed that they work. Make sure they all have different names
// Using JavaScript, Create DOM elements for a paragraph element and an image element.

//<p id="showImage">Load random image</p>
//<img id="randomImage">

//On your own, create an array that stores your image names as array elements.
// Add a click event listener onto the p tag. When a user clicks on the p tag, display a random image.
//-----------------------------------------------------------|---------------------------------------------------------------------\\

//define img arr
let imgArr = ['img/pic1.webp', 'img/pic2.jpg', 'img/pic3.webp', 'img/pic4.jpg'];

// creating p tag with its text, and an img tag
let showImageP = document.createElement("P");
let showimagetext = document.createTextNode("Load random image"); // txt
let img = document.createElement("img");
showImageP.appendChild(showimagetext); // txt added to p tag

// giving them id's
showImageP.setAttribute('id', 'showImage')
img.setAttribute('id', 'randomImage')

// appending both to body
document.body.appendChild(showImageP);
document.body.appendChild(img);

// attach event click to the button variable
showImageP.addEventListener('click', nextImage);

// function for next image
function nextImage(event) {
    img.src = imgArr[Math.floor(Math.random() * imgArr.length)];
}

