{
    const message = 'hey';
    // when variables are defined with "let" & "const"
    // There scope is limit to the block of code
}
console.log(message);

function start() {
    for (var i = 0; i < 5; i++)
        console.log(i);

    console.log(i);

    /*
    Scope of var is in function not block - it creates function-scoped variable
    From ES6 we got let, const
    */
}


//  Globle variables

var color = 'red';
let age = 23;

// Whenever we define any global object with var it gets assign to Window object
// window is central and color is accessible - window.color