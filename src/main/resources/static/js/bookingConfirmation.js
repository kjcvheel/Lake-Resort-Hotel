$(document).ready(function() {
    getData();
});


function getData() {
    console.log("getting booking data...");

    let retrievedObjectID = sessionStorage.getItem('bookingConfirmation');

    console.log('retrievedObject: ', retrievedObjectID);

    $.ajax({
        url: "http://localhost:8080/api/booking/" + retrievedObjectID,
        type: "get",
        success: function(result) {
            console.log(result.id + " HELLOOOO " + result.mainBooker)
        }
    })


}