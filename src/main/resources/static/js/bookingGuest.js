var api = "http://localhost:8080/guests";
var regexName = /^[a-zA-Z]+(([',. -][a-zA-Z ])?[a-zA-Z]*)*$/;
var roomNumbers = [];

$(document).ready(function() {
    $("#TOP").load("header.html");
    console.log("Fill drowndown options.");
    fillBirthdayDropdowns();
    $("#fname").val(sessionStorage.getItem("fname"));
    getData();
});

$(document).on("click", '.collapse-trigger', function() {
    console.log("Trigger collapse");
    $(this).next().collapse('toggle');
});

function getData() {
    console.log("getting data...");
    var dateOptions = { year: 'numeric', month: 'long', day: 'numeric' };
    // Get Start and To date
    //    sessionStorage.setItem("dateFrom", new Date('March 2 2020'));
    //    sessionStorage.setItem("dateTo", new Date('March 7 2020'));

    let dateFrom = new Date(sessionStorage.getItem("dateFrom")).toLocaleDateString("en-US", dateOptions);
    let dateTo = new Date(sessionStorage.getItem("dateTo")).toLocaleDateString("en-US", dateOptions);
    $("#dateFrom").append(dateFrom);
    $("#dateTo").append(dateTo);
    console.log(dateFrom);
    console.log(dateTo);

    // Get Selected Rooms
     var retrievedObject = sessionStorage.getItem('bookedRooms');
     let rooms = JSON.parse(retrievedObject);
        console.log('retrievedObject: ', JSON.parse(retrievedObject));
   // let rooms = [sessionStorage.getItem("bookedRoom")];
    console.log(rooms);
    rooms.forEach(function(item, index) {
        $.ajax({
            url: "http://localhost:8080/api/rooms/" + item,
            type: "get",
            success: function(result) {
                setRoomsInfo(result, index);
            }
        });
    })

}

function checkIfFieldsValid() {
    if (regexName.test($("#fname").val()) && regexName.test($("#lname").val())) {
        return true
    }

    return false;
}

function postData() {
    console.log("sending data...")

    let guestObj = getFormData();
    console.log(guestObj);
    let jsonObj = JSON.stringify(guestObj);

    $.ajax({
        url: "http://localhost:8080/api/guests/add",
        type: "post",
        data: jsonObj,
        contentType: "application/json",
        success: function(result) {
            console.log("This was posted " + result.firstName + " " + result.guestId);
            postBooking(result)
        }

    });

}

function postBooking(mainBooker) {
    console.log("Creating booking...");
    console.log(roomNumbers);
    // Get data for booking
    let dateFrom = formatDate(sessionStorage.getItem("dateFrom"));
    let dateTo = formatDate(sessionStorage.getItem("dateTo"))
    let bookingObj = {
        mainBooker: mainBooker,
        startDate: dateFrom,
        endDate: dateTo,
        adults: $("#adults").val(),
        children: $("#children").val(),
        roomNumbers: roomNumbers
    };
    console.log(bookingObj);
    let jsonObj = JSON.stringify(bookingObj);
    $.ajax({
        url: "http://localhost:8080/bookings/add",
        type: "post",
        data: jsonObj,
        contentType: "application/json",
        success: function(result) {
            alert("The booking has been posted under the name " + result.mainBooker.firstName + " " + result.mainBooker.lastName);
            console.log("This was posted " + result.id);
            sessionStorage.setItem("bookingConfirmation", result.id)
            console.log("In the storage" + sessionStorage.getItem("bookingConfirmation"))
            window.location.href = "http://localhost:8080/confirmation"
        },
        error: function(result) {
            console.log(result.responseText);
        }
    });

}

function setRoomsInfo(room, index) {
    roomNumbers.push(room);
    $("#rooms-container").append("<div id='room" + index + "'></div>");
    $("#room" + index).load("cards/smallRoomCard.html", function() {
        let card = $("#room" + index);
        console.log("Filling in details of room: " + room.id);
        card.find("#price").html("Price: " + room.price);
        card.find("#size").html("Adults: " + room.adult + ", Children: " + room.children);
        card.find(".card-title").html(room.name);
        card.find("#room-image").attr('src', room.image);
    });

}

function fillBirthdayDropdowns() {
    let i;
    for (i = 1; i <= 31; i++) {
        let option = "<option value='" + i + "'>" + i + "</option>";
        $(".daySelect").append($(option));
    }
    for (i = 1; i <= 12; i++) {
        let option = "<option value='" + i + "'>" + i + "</option>";
        $(".monthSelect").append($(option));
    }
    for (i = new Date().getFullYear() - 16; i >= 1900; i--) {
        let option = "<option value='" + i + "'>" + i + "</option>";
        $(".yearSelect").append($(option));
    }
}

function getFormData() {
    let guestObj = {
        firstName: $("#fname").val(),
        infix: $("#infix").val(),
        lastName: $("#lname").val(),
        birthday: $("#bdate").val().split('-').reverse().join('-'),
        country: $("#country").val(),
        address: $("#streetname").val() + " " + $("#streetnumber").val(),
        city: $("#city").val(),
        zipcode: $("#zipcode").val(),
        phoneNumber: $("#phonenumber").val(),
        mobileNumber: $("#mobilenumber").val(),
        email: $("#email").val(),
        creditcard: $("#creditcard").val()
    };
    return guestObj;
}

$("#fname").change(function() {
    sessionStorage.setItem("fname", $("#fname").val());
});

(function() {
    'use strict';
    window.addEventListener('load', function() {
        // Fetch all the forms we want to apply custom Bootstrap validation styles to
        var forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
                if (form.checkValidity() === false) {
                    event.preventDefault();
                    event.stopPropagation();
                } else {
                    event.preventDefault();
                    postData();
                }
                form.classList.add('was-validated');
            }, false);
        });
    }, false);
})();

function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    console.log(d);
    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [year, month, day].join('-');
}