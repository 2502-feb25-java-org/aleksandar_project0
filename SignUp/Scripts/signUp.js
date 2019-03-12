

//store values per form
function store() {
    let id = event.target.id; //event wasn't available in firefox
    let value = event.target.value;
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
    console.log("local ID " + localValue);
    console.log(element);
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
}



