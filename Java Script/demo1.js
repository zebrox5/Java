//rules
/*
Variable name

cannot be a reserved keyword
should be meaningful
cannot start with a number (1name)
cannot contain a space or hyphen (-)
are case-sensitive

DEFAULT VALUE OF VARIABLE = undefined
*/

/*
Object : 
Key value pairs

let person = {
    name: 'Abhishek',
    age: 30 
}

Acessing

1. Dot Notation
person.name = 'John'

2. Bracket notation - useful when the key is unknown 
person['name'] = 'Abhi'

//make it dynamic
let selection = 'name'
person[selection] = 'Mary'

*/

/*
Array Literal
let array = ['red', 'blue']
console.log(array[0])

links of array and its value are dynamic
array[2] = 'green'

we can store different types in array 
array[3] = 25

Array is an object and it has various methods
fill
filter
find
findIndex
forEach
incudes
indexOf
join
keys
lastIndexOf
*/

/*
Function - performs a task

function greet(name) { //name is a parameter
    //body - logic of function
    console.log('Hello ', name)
}//we don't need to have semicolon

greet('Abhishek'); //argument

function square(number) {
    return number*number;
}

console.log() is also an function call
*/

// Looping - for in
const person = {
    name: 'Abhishek',
    age: 30
}

for(let key in person){
    console.log(key, person[key])
}

// for - of --- ES 6 to iterate over array

const colors = ['red', 'green', 'blue'];

for (let color of colors) {
    // here the each color is the value of items in the array not the index
    console.log(color);
}

/*********** It can only be used with iterables [array, map] not objects or functions
 To do so, use Object.keys(object)
 It will returns keys in form of array
 */


Math.floor(1.3); //displays maximum interger

/*
Falsy Values in JS

undefined
null
''
false
0
NaN
*/