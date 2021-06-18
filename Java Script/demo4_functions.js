// Setting Functions

// 1. Function Declaration

function walk() {
    console.log('walk');
}

// 2. Function Expression
// Anonymous Function Expression
let run = function () {
    console.log('run');
};

// Named Function Expression
let runName = function run() {
    console.log('run');
};

// call the function
let move = run;
move();
run();

/**************************/
test1(); // calling the function before declarion and it is possible
// This is due to Hosting

// Hosting - Process of Moving function declaration to the top of the program/ file.. Done automatically by JSEngine

function test1() {
    console.log('walk');
}

/*********** Arguments  ***************/

// it is a object in JS that holds all the arguments that are passed to the function
// keys are indexes and values are the arguments
// this has iterator therefore "for of" can be used

function sum(a, b) {
    console.log(arguments);
    let total = 0;
    for (let value of arguments) {
        total += value;
    }
    return total;
}

// Another approach :::: REST operator (...args) and it isn't spread operator
// args is an array of elements
function sum2(...args) {
    console.log(args);
    // let total = args.reduce((accumulator, initialValue) => {
    //     return accumulator + initialValue;
    // })

    return args.reduce((a, b) => a + b);
}

// Rest parameter must be last - We cannot add anything after that but can add before that
function sum3(discount, ...price) {
    //default value
    //discount = rate || 3.5;
    let total = price.reduce((a, b) => a + b);

    return total * (1 - discount);
}

function defaultTest(a, b = 5, c) {
    // function defaultTest (a, b = 5, c){ // as it doesn't know where to pass the second value to b or c
    // therefore it is recommended to use default value at the end
    return a * b * c;
}

function defaultTest2(a, b = 5, ...c) {
    let total = c.reduce((a, b) => a + b);
    return a + b + total;
}

// console.log(defaultTest(10, 2));
console.log(defaultTest2(10, 2, 1));

let result = sum(1, 2, 3, 4, 5);
console.log('Result is ', result);


/*********** Getters and setter ***************/

const person = {
    firstName: 'Abhishek',
    lastName: 'Kumar',
    get fullName() {
        return `${person.fistName} ${person.lastName}`
    },
    set fullName(value) {
        if (typeof value !== 'string')
            throw new Error('Value is not a string.');
        // if we throw an Error it becomes Exception

        const parts = value.split(' ');
        this.firstName = parts[0];
        this.lastName = parts[1];
    }
}
//(...)//is a getter value

try {
    person.fullName = 'John Smith';
} catch (e) {
    alert(e);
}
console.log(person);