// Factory Function
function createCircle(radius) {
    // Literal function
    return {
        radius, //it is same is radius: radius
        location: {
            // object as value
            x: 1,
            y: 1
        },
        isVisible: true,
        /*
        draw : function() {
            console.log('draw');
        }
        */
        draw() {
            console.log('draw');
        }
    };
}

const circle1 = createCircle(2);
console.log(circle1);


// Constructor Function - PascalNotation: OneTwoThree

function Circle(radius) {
    // reference of an object executing this piece of code
    // it reference an empty object
    // with . notation we can read a property and set a property

    this.radius = radius; //adding the variable radius and setting it's value to radius (rhs)
    //it is possible as in js the objects are dynamic 

    this.draw = function () {
        console.log('draw');
    }
}

const circel = new Circle(1);
/*
new operator does 3 things under the hood
1. const x = {} //creates an empty object
2. set this to point empty new object
3. returns the object from Circle and sets to x // return this.
*/

// Mehtods are dynamic

const obj = {
    radius: 1
};

obj.color = 'yello';
obj.draw = function () { }

delete obj.color; //to delete an object property

console.log(obj);

// Constructor of Literal and Constructor Function

const circle = createCircle(1);
console.log(circle.constructor);
/*
it is created using object literal function
f Object()[]

As JS internally translate this as
let x = {} => let x = new Object();

String literal = new String()

Every object has constructor property that reference to the fun to create an object

*/

const anotherCircle = new Circle(1);
console.log(anotherCircle.constructor);

/*
Functions are object

Circle.constructor
-> f Function()[]
JS will use Function to create a function


*/

const Circle1 = new Function('radius', `
this.radius = radius;
this.draw = function() {
    console.log('draw');
}
`);

const circle1Obj = new Circle1(1);
const circle2Obj = Circle1(1); //if we don't write new then it will point to global object - window

//Various mehtods of Function

Circle.call({}, 1, 2, 3);
// call a function
//thisArg - {} - this will reference it, {} obj will be referenced by this of Function 
//after that we have to add arguments
//this expression is equal to ... new Circle(1); it creates an empty obj and pass it as an first argumet to Circle
Circle.apply({}, [1, 2, 3]);// if we want to send array

for (let key of Object.keys(circle)) // or Object.entries
    console.log(key);

for (let key of Object.entries(circle)) // It returns in key value form
    console.log(key);

//to check if a given property exist in a given object
if ('radius' in circle) { }

// Cloning an object
const anotherObj = {};

for (let key in circle) {
    another[key] = circle[key];
    //another['radius'] = circle['radius'];//sets the key value both
}

//or
const anotherObj2 = Object.assign({
    color: 'red'
}, circle); // (target Obj, Source)

// or

const anotherObj3 = { ...circle };//spread operator


// String primitive to object
// When we do dot notation JS will automatically wraps primitive to the object

const msg = 'hi'; // typeOf - string

const anotherMessage = new String('h1'); // typeOf - object

// :::::::::::::::::Dates

const now = new Date(); 
const date1 = new Date('May 31 2021 17:00');
const date2 = new Date(2021, 4, 11, 9, 0); //month is 0 based i.e. 0 = January

//get and set methods
now.toDateString();

now.toTimeString();
now.toISOString(); // common date format to work with web applications
