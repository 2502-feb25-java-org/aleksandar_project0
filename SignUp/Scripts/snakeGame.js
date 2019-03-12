/*
Built Using Tutorial and Media Assets by 'Learn Web Development' Youtube Channel
Youtube channel : https://www.youtube.com/channel/UC8n8ftV94ZU_DJLOLtrpORA
*/
//Select canvas and method properties
const cvs = document.getElementById("snake");
const ctx = cvs.getContext("2d");   //2-dimensions context

//Create single snake unit
const unit = 32; //for use in drawing

//Load Images
const fieldImg = new Image();
fieldImg.src = "./Media/ground.png";

const foodImg = new Image();
foodImg.src = "./Media/food.png";

const title = "Secret Snake Game";

let isAlive = "true";

//Create the snake array at starting position
let snake = [];
snake[0] = {
    x: 9 * unit,
    y: 10 * unit
};

//Load relevant audio files for snake events
let dead = new Audio();
let eat = new Audio();
let up = new Audio();
let right = new Audio();
let left = new Audio();
let down = new Audio();

dead.src = "./Audio/dead.mp3";
eat.src = "./Audio/eat.mp3";
up.src = "./Audio/up.mp3";
right.src = "./Audio/right.mp3";
left.src = "./Audio/left.mp3";
down.src = "./Audio/down.mp3";


//Create the food object and place randomly on the field
let food = {
    x: Math.floor(Math.random() * 17 + 1) * unit,
    y: Math.floor(Math.random() * 15 + 3) * unit
};

//Initalize score keeping
let score = 0;

//Create controls for the snake
let d;
document.addEventListener("keydown", direction);

function direction(event) {
    let key = event.keyCode; //keyCode property of event retrieves the code for key pressed

    if (key == 37 && d != "RIGHT") {     //Don't want snake going in the opposite direction
        d = "LEFT";
        left.play();
    } else if (key == 38 && d != "DOWN") {
        d = "UP";
        up.play();
    } else if (key == 39 && d != "LEFT") {
        d = "RIGHT";
        right.play();
    } else if (key == 40 && d != "UP") {
        d = "DOWN"
        down.play();
    }
}

//Check collision with self
function collision(head, snakeArray) {
    for (let i = 0; i < snakeArray.length; i++) {      //Loop through snake cell positons
        if (head.x == snakeArray[i].x && head.y == snakeArray[i].y) {
            return true;
        }
    }
    return false;
}



//With collision logic, snake, and food created
//... We may draw our objects to canvas

function draw() {
    ctx.drawImage(fieldImg, 0, 0);

    for (let i = 0; i < snake.length; i++) {
        ctx.fillStyle = (i == 0) ? "blue" : "white";
        ctx.fillRect(snake[i].x, snake[i].y, unit, unit);

        ctx.strokeStyle = "red";
        ctx.strokeRect(snake[i].x, snake[i].y, unit, unit);
    }
    ctx.drawImage(foodImg, food.x, food.y);
    // old head position
    let snakeX = snake[0].x;
    let snakeY = snake[0].y;

    // Redraw snake in new position based on most recent keystroke
    if (d == "LEFT") snakeX -= unit;
    if (d == "UP") snakeY -= unit;
    if (d == "RIGHT") snakeX += unit;
    if (d == "DOWN") snakeY += unit;

    // Collision / Snake eats the food
    if (snakeX == food.x && snakeY == food.y) {
        score++;
        eat.play();
        food = {
            x: Math.floor(Math.random() * 17 + 1) * unit,
            y: Math.floor(Math.random() * 15 + 3) * unit
        }
        //Tail is kept, snake increments
    } else {
        //Empty the snake array
        snake.pop();
    }

    //Create a new head
    let newHead = {
        x: snakeX,
        y: snakeY
    }

    //Game Over, Clear timer and play "death" tune
    if (snakeX < unit || snakeX > 17 * unit || snakeY < 3 * unit || snakeY > 17 * unit || collision(newHead, snake)) {
        clearInterval(game);
        isAlive = "false";
        dead.play();
        //Temporary timeout to reload on hitting the wall
        setTimeout(function() { alert("Play again!");
        location.reload();
        }, 500);
    }
    snake.unshift(newHead);


    //Display Score and Game Title
    ctx.fillStyle = "white";
    ctx.font = "45px Changa one";
    ctx.fillText(score, 2 * unit, 1.6 * unit);
    ctx.fillText(title, 4.75 * unit, 1.6 * unit);
}

let game = setInterval(draw, 100);

/*
//Main function for game functionality
function playGame() {
    // call draw function every 75 ms
    let game = setInterval(draw, 75);
}

playGame();
*/
