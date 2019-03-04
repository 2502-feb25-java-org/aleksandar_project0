//JavaScript Coding Challenge 1 Week 1
//Aleksandar Antonov


//Challenge 1 : Fizz Buzz Division Word Game

function fizzBuzz(x) {
    //Where x is a positive integer
    if (x % 3 == 0 && x % 5 == 0) {
        //console.log("Fizz Buzz");
        return "Fizz Buzz";
    } else if (x % 3 == 0) {
        //console.log("Fizz");
        return "Fizz"
    } else if (x % 5 == 0) {
        //console.log("Buzz");
        return "Buzz";
    } else {
        //console.log(x.toString());
        return x.toString();
    }
};