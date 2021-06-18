// this reference to the current calling object

// if this is used in 

// 1. method -> it references obj
// 2. function -> it reference global(window or global{in node})

const video = {
    title: 'a',
    play() {
        console.log('This of video obj ', this);
    }
};

// we can also add a method later in this object
video.stop = function () {
    console.log('This of video {stop} obj ', this);
}

function playVideo() {
    console.log('This of global function ', this);
}

video.stop();
playVideo();

// But for constructor function theory is diff

function Video(title) {
    this.title = title;
    console.log(this);
}
function kideo(title) {
    this.title = title;
    console.log('Kideo this is ', this);
}

const v = new Video('B'); // this behind the scene makes an empty object {}
kideo();


const info = {
    title: 'title',
    names: ['a', 'b', 'c'],
    showNames() { //here showNames is method

        this.names.forEach(function (name) {
            console.log(name);
            /*
            But if we wish to attach title with each name
            */
            console.log(this.title, name); // it gives undefined
            /**
             * This is because this here is referencing to window object
             * since it is inside a function body not a method
             */
            console.log('This inside for each ', this);
        });
    },
    showNamesWithoutThis() {
        // make a note of the this of the info object
        const self = this; // some also call it that
        this.names.forEach(function (name) {
            console.log(self.title, name);
        });
    },

    showNamesUsingThis() {
        this.names.forEach(function (name) {
            console.log(this.title, name);
        },
            // second argument of forEach is thisArg {which is an object} and this will reference that object
            // {firstName: 'Abhishek'}); 
            this); // so we can pass this which currently the info object as it isn't inside any function 
    },

    showNamesUsingBind() {
        this.names.forEach(function (name) {
            console.log(this.title, name);
        }.bind(this));
    },

    showNamesUsingArrowFunction() {
        /**
         * Good thing about arrow function is that they inherit the 'this' value
         * it takes the value of above this
         * and the value of 'this' isn't rebound inside arrow function
         */
        this.names.forEach(name => {
            console.log(this.title, name);
        });
    }

};

info.showNamesUsingThis();




/***********************
 * Call 
 * Apply
 * Bind
 **********************/

function abcTest(a, b) {
    console.log('This of abcTest ', this);
}

//  passing custom function as this
abcTest.call({ method: 'Call' }, 1, 2);
abcTest.apply({ method: 'Apply' }, [1, 2]);

// difference b/w call and apply is that in call we can pass the arguments normally after the object
// but in apply we have to pass the arguments in form of array

const fn = abcTest.bind({ method: 'Bind' });

// fn will always reference to the this of the object passed
fn();

abcTest();
