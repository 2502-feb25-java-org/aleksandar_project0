//Correct log-In Details for Redirect
const correctUser = "secretsnake";
const correctPassword = "revhero";

function confirmLogIn(){
    let username = document.getElementById('login').value;
    let password = document.getElementById('password').value;
    if (username == correctUser && password == correctPassword){
        myFunction();
        window.location.href="snakeGame.html"; 
    } else {
        //console.log("Incorrect");
        alert ('Please try again. \nHINT: Forgot your password?');
    }
    return false;
}


function myFunction() {
    var x = document.getElementById("logIn");
    if (x.style.display === "none") {
      x.style.display = "block";
    } else {
      x.style.display = "none";
    }
  }