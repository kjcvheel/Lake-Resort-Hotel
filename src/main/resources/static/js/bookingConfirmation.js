$(document).ready(function() {
    getData();
});


function getData() {
    console.log("getting booking data...");

    let retrievedObjectID = sessionStorage.getItem('bookingConfirmation');
    let booking;


    $.ajax({
        url: "http://localhost:8080/bookings/" + retrievedObjectID,
        type: "get",
        success: function(result) {
            appendData(result)
        }
    })

}

function appendData(data) {
    var date1 = new Date(data.startDate);
    var date2 = new Date(data.endDate);
    var difference_In_Time = date2 - date1;
    var difference_In_Days = difference_In_Time / (1000 * 3600 * 24);

    let rooms = data.roomNumbers;
    var price1 = 0;
    rooms.forEach((element) => {
        price1 += element.price;
    });

    console.log("Difference in time" + difference_In_Days);
    var totalPrice = price1 * difference_In_Days;
    console.log(JSON.stringify(data));
    // console.log("firstname of the booker " + data.mainBooker);
    // console.log("startdate " + data.startDate)
    $("#guestName").append(data.mainBooker.firstName);
    $("#booking_id").append(data.id);
    $("#check_in").append(data.startDate);
    $("#check_out").append(data.endDate);
    $("#total_nights").append(difference_In_Days);
    $("#price").append("<span>&#165;</span>" +  " " + totalPrice);
    $("#email-address").html(data.mainBooker.email);


}

