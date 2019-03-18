function store() {
    let id = event.target.id; //event wasn't available in firefox
    let value = event.target.value;
    localStorage.setItem(id, value);
}

//trigger when form is submitted
$("#myForm").submit(function(e){
    $('#myModal').modal('show');
    return false;
});

//This one took a while, openModal() no longer supported, jQuery must be loaded before script calls