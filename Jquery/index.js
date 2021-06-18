/*
$(document).ready(function () {
    //making sure the jQuery loaded
    //otherwise add the library to the end of the body
    $("h1").css("color", "red"); //changing the css (property, value)
});

// document.querySelectorAll("button");
$("button")

//we can get the current values also

console.log($("h1").css("color"));
console.log($("h1").css("font-size"));

// single property - getting the values
// two properties - setting the values
*/

// $("h1").addClass("big-title");
$("h1").addClass("big-title margin-50"); //adding multiple classes

// ~ly $("h1").removeClass("big-title"); // to remove the class
// $("h1").hasClass("big-title"); true or false to check the class

// changing text of elements
$("h1").text("Bye");

$("button").text("Don't click me"); // it select all the elements

// innerHtml -> .html 
$("button").html("<em>Hey</em>");

// ********Manipulating attributes
// e.g. src in img & href in a tag

//attr - attribute method
console.log($("img").attr("src"));//getting the value of attribute

$("a").attr("href", "http://www.bing.com");

console.log('Class of h1 is ', $("h1").attr("class"));

// *************Adding event listerner with jQuery

$("h1").click(function () {
    $("h1").css("color", "purple");
});

/* Adding eventListerner to add all the buttons then we had to use for loop
for (var i = 0; i < 5; i++) {
    document.querySelectorAll("button")[i].addEventListener("click", function () {
        document.querySelector("h1").style.color = "purple";
    });
}
*/

$("button").click(function () {
    $("h1").css("color", "purple");
});

// keypress events
// $("input").keypress(function (event) {
$(document).keypress(function (event) {
    console.log(event.key);
    $("h1").text(event.key);
});

//to select the entire document
// 1. $("body")
// 2. $(document)

// more flexible way to add event listeners
// .on(eventName, callBack funtion)

$("h1").on("mouseover", function() {
    $("h1").css("color", "red");
});

// $("h1").on("click", function() { //or any other events

// ********Adding and removing elements with jQuery
$("h1").before("<button>Before</button>"); //this adds a button before h1
$("h1").after("<button>After</button>"); //this adds a button before h1
$("h1").prepend("<button>Prepend</button>"); //this adds a button before the text of H1 but inside the h1 tag
$("h1").append("<button>Append</button>"); //this adds a button after the text of H1 but inside the h1 tag

$("button").remove();// remove all the buttons