//Introduction to Javascript

//variables
x = 10;
//alert(x);
console.log(x);
x = 10;
y = 5;
z = "Hello World!"
//alert(x+y+z);
//alert(z+x+y);
//alert(z+(x+y));
alert(typeof (z));
//alert(typeof (10 / abc)); //undefined 
alert(typeof (10 / "abc")); //NaN
alert(typeof (10 / 0)); //number
alert("" == false); //true
alert(typeof (1 / -0)); //number, negative infinity
alert(NaN == NaN); //false, NaN will always compare to false

//Hoisting Example
test(10); //call to function before function declaration
function test(a) {
    console.log(a);
}

//Function Expressions
var funcResult = function test(a) {
    console.log(a);
}
a = 5;
(function test1(a) {
        return a;
    })(a); //IIFE : Immediately Invoked Function Expressions


//Callback Function
function Agreement(policyAcceptance, yes, no) {
  //  debugger;
    if (confirm(policyAcceptance)) { //confirm is a built-in function, like alert, prompt, etc.
        yes();
    }
    else {
        no();
    }
}
//showOk and showCancel are passed in as parameters
function showOk() {
    alert('Policy is accepted');
}
function showCancel() {
    alert('Policy is denied');
}
Agreement("Do you agree to our policy", showOk, showCancel);


var resultfunc = function add(a, b, c = 10) { //c is established as a default parameter in case it isn't passed in
    return a + b + c;
}
console.log(resultfunc(10, 3));


//Closures Example
function outer(){
    var outerData="outerData";
    function inner(){   //inner function
        alert(outerData);
    }
    return inner; //returns reference to inner function
}
// alert(outerData); // not accessible b/c of scope
var funcCall = outer(); //function expression persisting scope of outerData outside function
funcCall();
//the outer function is not returning anything, because inner is returned within outer,
//it is called implicitly on function call to outer

//Closures Example2

var add = (function(){ //if add is const, the counter would still increment since it isn't 
    var counter = 0;
    return function(){
        counter++;
        return counter;
    }
})();
console.log(add());
console.log(add()); //preserving the reference of the counter variable even after function execution

var funcArr = ()=>alert('hi');
var resultExp = (a,b)=>(a*b);
console.log(resultExp(2,3));
()=>alert('hi'); //IIFE
console.log(((a,b)=>a*b)(5,3)); //arrow notation (parameter) => expression(variables)

//String functions
return 'cat'.charAt(1); //a
var s1 = new String('2+2');
console.log(eval(s1));
//valueOf can be used to convert String object to it's primitive counterpart

//DOM manipulation



