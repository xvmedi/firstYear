// In the HTML file, Add the provided HTML to the body tag, above the script tag: 
// Using JavaScript, 
// Using the provided categories array, create a list of links based on "category". 
// You should have category links for "business", "millionaire", and "leadership". Do not hardcode these links in HTML.
// These links should NOT have any href attributes. This will reduce the difficulty of the assignment to be reasonable.
// Display these links in the "categories" section.

// categories = ["millionaire", "business", "leadership"];

// When a user clicks on a category link, create a list of books from that category. Each list item will have a p tag for the name of the book and it's author. Each list item should also display an image. Set the image width to 100px.

// Show the books in the "bookList" section.

// Use the provided data for the book data:

let books = [

    {
        bookName: "Total Money Makeover",
        category: "millionaire",
        image: "https://smallbiztrends.com/ezoimgfmt/media.smallbiztrends.com/2020/06/The-Total-Money-Makeover.png?ezimgfmt=rs:185x277/rscb12/ngcb12/notWebP",
        author: "Dave Ramsey"
    },
    {
        bookName: "The 7 Habits of Highly Effective People",
        category: "leadership",
        image: "https://smallbiztrends.com/ezoimgfmt/media.smallbiztrends.com/2020/06/The-7-Habits-of-Highly-Effective-People.png?ezimgfmt=rs:185x277/rscb12/ng:webp/ngcb12",
        author: "Stephen R. Covey"
    },
    {
        bookName: "Rich Dad Poor Dad",
        category: "millionaire",
        image: "https://smallbiztrends.com/ezoimgfmt/media.smallbiztrends.com/2020/06/Rich-Dad-Poor-Dad.png?ezimgfmt=rs:185x277/rscb12/ng:webp/ngcb12",
        author: "Dave Ramsey"
    },
    {
        bookName: "Deep Work",
        category: "business",
        image: "https://m.media-amazon.com/images/I/51vmivI5KvL._SY346_.jpg",
        author: "Cal Newport"
    },
    {
        bookName: "Everyday Millionaires",
        category: "millionaire",
        image: "https://smallbiztrends.com/ezoimgfmt/media.smallbiztrends.com/2020/06/Everyday-Millionaires.png?ezimgfmt=rs:185x277/rscb12/ng:webp/ngcb12",
        author: "Chris Hogan"
    },
    {
        bookName: "The Innovators Dilemma",
        category: "business",
        image: "https://m.media-amazon.com/images/W/WEBP_402378-T2/images/I/51n5EwuYBwL.jpg",
        author: "Clayton M. Christensen"
    }
]

// categories array
let categories = ["millionaire", "business", "leadership"];

// ------------------------------------------------------------- DISPLAYING BOOKS --------------------------------------------//

// Create section for categories, set id
let categoriesSection = document.createElement("section")
categoriesSection.setAttribute("id", 'categories')

let categoryResults = document.createElement("div")
categoryResults.setAttribute("id", "categoryResults")

// create list for categories
let categoriesList = document.createElement("ul")

// append category list to category section
categoriesSection.appendChild(categoriesList)

// for each loop on categories
categories.forEach(category => {

    //create listItem for every category
    let listItem = document.createElement("li")

    //set its class to category
    listItem.setAttribute("id", category)
    //append to Category List
    categoriesList.appendChild(listItem)

    // create p label for categories and append to list item
    let categoryName = document.createElement("p")
    let categoryNameText = document.createTextNode(category)
    categoryName.appendChild(categoryNameText)
    listItem.appendChild(categoryName)

    //add event listener to list item
    listItem.addEventListener('click', categoryBookResults)
});

// append categories to DOM
document.body.appendChild(categoriesSection)


// function to remove list
function clearBooks(listName) {
    listName.remove();
};

// load the categories to the screen function
function categoryBookResults(e) {

    // if categoryResultsExists exist it will be removed from dom
    let categoryResultsExists = document.querySelector("#categoryResultsList")
    if (categoryResultsExists)
        clearBooks(categoryResultsExists)

    // to create a single list
    let categoryResultsList = document.createElement("ul")
    categoryResultsList.setAttribute("id", "categoryResultsList")

    books.forEach(book => {

        // if book category matches
        if (book.category == this.id) {

            // new book creation: book element <li>, booktitle <p>, text: name/author, 
            let newBook = document.createElement("li")
            let newBookTitle = document.createElement("p")
            let newBookTitleText = document.createTextNode(book.bookName + " by: " + book.author)
            newBookTitle.appendChild(newBookTitleText)
            newBook.appendChild(newBookTitle)

            // new book image
            let newBookImage = document.createElement("img")
            newBookImage.src = book.image;
            newBookImage.width = 100;
            newBook.appendChild(newBookImage)

            //li append to UL
            categoryResultsList.appendChild(newBook)
        }
    }) // end of for each book loop

    // ul append to div
    categoryResults.appendChild(categoryResultsList)

    // results apend to body
    document.body.appendChild(categoryResults)

} // end of categoryBookResults function


// ------------------------------------------------------------- SEARCH BAR --------------------------------------------//

// create section for search
search = document.createElement("section")
search.setAttribute("id", 'search')

// create search bar
searchTextArea = document.createElement("textarea")
searchTextArea.setAttribute("id", 'searchTextArea')

search.appendChild(searchTextArea)

// add input event listener for book validation 
searchTextArea.addEventListener("input", validateBook)

function validateBook() {

    // search for element
    let searchResult = document.getElementById("searchResult")

    //if exists, remove it immediately
    if (searchResult) {
        search.removeChild(searchResult)

        // if it does not exist continue
    } else {

        // create element give it id 
        searchResult = document.createElement("p")
        searchResult.setAttribute("id", 'searchResult')
        search.appendChild(searchResult)

        // for each book 
        books.forEach(book => {

            // if the value of input is equal to the book name (ignoring case)
            if (searchTextArea.value.toLowerCase() == book.bookName.toLowerCase()) {
                // create only state for p to be displayed
                // add the verification of the books existence
                let textnode = document.createTextNode(book.bookName + " is found")
                searchResult.appendChild(textnode)
            }
        }) // end of for each book loop
    } // end of else block

} // end of validateBook function

// apply to DOM
document.body.appendChild(search)