function store() {
    let id = event.target.id; //event wasn't available in firefox
    let value = event.target.value;
    localStorage.setItem(id, value);
}

$('#contact-form').on('submit', function () {
    $('#myModal').modal('show');
    return false;
})
$(document).ready(function() {
    $('#contact-form').on('submit', function(e){
        $('#myModal').modal('show');
        e.preventDefault();
    });
  });