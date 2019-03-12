//Correct log-In Details for Redirect
const correctUser = "secretsnake";
const correctPassword = "revhero";

function confirmLogIn(){
    let username = document.getElementById('login').value;
    let password = document.getElementById('password').value;
    if (username == correctUser && password == correctPassword){

        window.location.href="snakeGame.html"; 
    } else {
        //console.log("Incorrect");
        alert ('Please try again. \nHINT: Forgot your password?');
    }
    return false;
}

