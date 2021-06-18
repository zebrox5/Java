/*
$("button").on("click", function () {
    //$("h1").toggle(); // toggle the element
    //$("h1").hide(); // hide the element
    //$("h1").show(); // show the element

    // with hide and show it suddenly removes and adds up in the flow of html document
    // $("h1").fadeOut(); //disappear by fading out
    // $("h1").fadeIn(); //appear by fading in
    $("h1").fadeToggle(); // all of these methods comes with toggle

    // ~ly slideUp, slideDown, slideToggle
});
*/

//custom animation
$("button").on("click", function () {
    //$("h1").animate({ opacity: 0.5 }); // give here custom css rules
    // but in between the {} we can only add those css rule that have numeric value
    //$("h1").animate({ margin: "5%" });

    //chaning the animations
    $("h1").slideUp().slideDown().animate({ opacity: 0.5 });

});
