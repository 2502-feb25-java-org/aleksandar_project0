//Correct log-In Details for Redirect
const correctUser = "secretsnake";
const correctPassword = "snakehero";

function confirmLogIn(){
    let username = document.getElementById('login').value;
    console.log(username);
    let password = document.getElementById('password').value;
    if (username == correctUser && password == correctPassword){
        console.log("Correct");
        window.location.href="snakeGame.html"; 
    } else {
        console.log("Incorrect");
        //alert ('Please try again. \nHINT: Forgot your password?');
    }
    return false;
}
