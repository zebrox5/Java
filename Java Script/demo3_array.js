const numbers = [3,4,-1];

//add at end
numbers.push(5,6);

//add beginning
numbers.unshift(7); //shifts the array

// middle
numbers.splice(2, 0, 'a', 'b'); //(start position, delete numbers, {if not delete then adding number})

//exists or not
numbers.includes(1);

numbers.indexOf(1, 2); //(element, from index)

console.log(numbers);

// finding reference types

const courses = [
    {id: 1, name: 'a'},
    {id: 2, name: 'b'},
];

// use find - pass a function to the argument to that function
// if found true then search stops
// if not matched then retuns undefined
const course = courses.find( function(course) {
    course.name === 'a';
});

console.log(course);

// similarly findIndex will return the index of that element.. if not found it returns 0

// Arrow Function - passing function as a call back function or as an argument then we use it
const course2 = courses.find( course  => course.name === 'a');

//::::::::Removing elements to array

//from end
numbers.pop(); //returns the element that was removed

//from beginning
numbers.shift(); //returns the element that was removed

// from middle
numbers.splice(2, 1);


// *****************************

// Emptying an Array

// Sol 1.  
//numbers = [];

/**
 * It will only work if there is not another variable pointing to this array
 * i.e. const another = numbers
 * numbers = [] //this won't work
 */

// sol2. truncate the array - optimal
//numbers.length = 0;

// sol3.
//numbers.splice(0, numbers.length);

//sol4. 
//while(numbers.length > 0) numbers.pop();

// ******************************

const first = [1,2,3];
const second = [4,5,6];

const combined = first.concat(second);

// slice is like a substring of Arrays
const slice = combined.slice(2); //gives array after the index 2

const slice2 = combined.slice(); //copies the array

// if the array consists of object then they are copied by reference not value

// combine using spread operator
// we can add the elements in between or any position
const combined = [...first, ...second, 'a'];

/*************************** */

// Iterating
// for in, for of, forEach

numbers.forEach(number => console.log(number));

numbers.forEach((number, index) => console.log(number, index)); // second parameter to forEach is index

//Joining Array
//whenever you see a ? in parameter -- it is optional
numbers.join(","); //it will act as a seperator

//title to url --> String - split then join

// :::::::Sorting Array

const sort = [2,4,1,3];
sort.sort();
sort.reverse();

// for objects
const sortCourses = [
    {id: 1, name: 'Node.js'},
    {id: 2, name: 'JavaScript'}
];

// ? - function for comparision 
sortCourses.sort(function(a,b) {
    //  but if it isn't case retentive it will have not good effect as N comes before j
    
    const nameA = a.name.toLowerCase();
    const nameB = b.name.toLowerCase();
    
    if(nameA < nameB) return -1;
    if (nameA > nameB) return 1; // no need of else if as if first statement executes then it will not come down
    return 0;
});

// :::::::::::::::::::: New methods

// every - gives true/false
const allPositive = numbers.every(function(value){
    //check if it is positive number
    return value >=0;
});// as long as it doesn't find that number it stops searching

const atleastOnePositive = numbers.some(function(value){
    //check if it is positive number
    return value >=0;
});// as long as it  find that number that meets the criteria it stops searching


// :::::::::::::::::::: Filtering an Array

const filtered = numbers.filter(function(value) {
    return value >=0;
});

// we can filter array of objects too

// :::::::::::::::::::: Map method
const items = filtered.map(n => '<li>' + n + '</li>');
const html =  '<ul>' + items.join('') + '</ul>' ;

console.log('Type of html ', typeof html)

// can also map with objects

const itemObj = filtered.map(n => {
    // const obj = {value : n};
    // return obj;
    return {value : n};
    // {} this is code block and JS will think we put code block to return something
    // therefore to tackle this ({}) otherwise we get undefined
});

const itemObj2 = filtered.map(n => ({value: n}));

// These methods are chainable
// numbers.filter().map()

// :::::::::::::::Reducing an array - reduce to one single value or one single object
// two arguments (accumulator, currentValue)
numbers.reduce((accumulator, currentValue) => {

    return accumulator + currentValue;
}, 0);

// if current value not set to initial value i.e. 0 then 
// accumulator will get initial value as first value of array