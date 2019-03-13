

//store values per form
function store() {
    let id = event.target.id; //event wasn't available in firefox
    let value = event.target.value;
    localStorage.setItem(id, value);
}

function storePlace(addressText){
    let id = "address";
    let value = addressText;
    localStorage.setItem(id, value);
    //console.log(value);
}

function storeType(object){
    let id = Object.keys(object).toString();
    let value = Object.values(object).toString();
    localStorage.setItem(id, value);
}

function storeRadio() {
    let id = "faveCandy"; //event wasn't available in firefox
    let value = event.target.id;
    localStorage.setItem(id, value);
}

function getStore(id) {
    let element = document.getElementById(id);
    let value = localStorage.getItem(id);
    element.value = value;
}

function getRadio(id) {
    let localValue = localStorage.getItem("faveCandy");
    let element = document.getElementById(localValue);
    //console.log("local ID " + localValue);
    //console.log(element);
    element.checked = true;
}

//LEARNING MOMENT : DON"T USE NAME INSTEAD OF ID    

function load() {
    getStore('firstname');
    getStore("lastname");
    getStore("age");
    getStore("sex");
    getRadio("faveCandy"); //radio button is simply storing as "on"
    getStore("email");
    getStore("phonenum");
    getStore("address");
    getStore("middlename");
}
function loadAddress(){
    getStore("address");
    getStore("zipcode");
    getStore("street");
    getStore("country");
    getStore("state");

}

function checkDuplicate(input) {
    let first = document.getElementById("firstname");
    let middle = document.getElementById("middlename");
    let last = document.getElementById("lastname");
    if (first.value == middle.value || middle.value == last.value || first.value == last.value){
        input.setCustomValidity('Names cannot be the same.');
    } else {
        // input is valid -- reset the error message
        input.setCustomValidity('');
    }
}

//trigger when form is submitted
$("#myForm").submit(function(e){
    $('#myModal').modal('show');
    return false;
});

//This one took a while, openModal() no longer supported, jQuery must be loaded before script calls

function submitFunction() {
    alert("The form was submitted!");
  }