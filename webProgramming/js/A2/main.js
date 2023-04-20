// Wasim Singh
// SYST10199 Web Programming
// Cristo Vasilaros A2

// Output that DOM to an element that is already coded on the HTML page (such as a section tag or a div)

//defining button
let movieDropDown = document.querySelector("#movieDropDown");

// attach event click to the button variable
movieDropDown.addEventListener('click', listMovies);

// movies list array
var moviesArr = [
    {
        title: "GLASS ONION: A KNIVES OUT MYSTERY",
        actors: ["Daniel Craig", "Edward Norton", "Dave Bautista", "Kate Hudson"],
        director: "Rian Johnson",
        audienceScore: 93,
        link: "https://www.rottentomatoes.com/m/glass_onion_a_knives_out_mystery"
    }
]

function listMovies(event) {

    // check / validate
    let moviesDiv = document.querySelector("#moviesDiv");
    if (moviesDiv) {
        alert('out of movies :(');
    }

    else {
        //create div for movie, set id
        let moviesDiv = document.createElement("div");
        moviesDiv.setAttribute("id", "moviesDiv");

        // iterate over movies list
        for (let i = 0; i < moviesArr.length; i++) {

            // create title element and variable (with moviearr[i]), then append to parent and super
            let title = document.createElement("h1")
            let textTitle = document.createTextNode(moviesArr[i].title)
            title.appendChild(textTitle)
            moviesDiv.appendChild(title)

            // create movie rating/score element and variable (with moviearr[i]), then append to parent and super
            let scoreSpan = document.createElement("span")
            let score = document.createTextNode(moviesArr[i].audienceScore.toString())
            scoreSpan.appendChild(score)
            moviesDiv.appendChild(scoreSpan)


            // create actor list element, iterate over actors, adding arr variables (moviearr[i]),
            let actor = document.createElement("ul")
            let actortext = document.createElement("h2")
            let actortexttitle = document.createTextNode("Actors")
            actortext.appendChild(actortexttitle)
            for (let a = 0; a < moviesArr[i].actors.length; a++) {
                let li = document.createElement("li")

                let liText = document.createTextNode(moviesArr[i].actors[a])
                li.appendChild(liText)
                actor.appendChild(li)
            }
            moviesDiv.appendChild(actortext)                        //  then append to parent and super
            moviesDiv.appendChild(actor)

            // create director element and variable (with moviearr[i]), then append to parent and super
            let director = document.createElement("p")
            let directorText = document.createTextNode("Directed By: " + moviesArr[i].director)
            director.appendChild(directorText)
            moviesDiv.appendChild(director)


            // create a href element and variable (with moviearr[i]), then append to parent and super
            let link = document.createElement('a')
            let linkText = document.createTextNode("Link for the movie: " + moviesArr[i].title)
            link.appendChild(linkText)
            moviesDiv.appendChild(link)

            // adding href hyperlink to a element
            link.href = moviesArr[i].link;
            link.title = "Link for the movie: " + moviesArr[i].title; // adding hover title
        }

        // appending function created div to document body
        document.body.appendChild(moviesDiv)

    }
}