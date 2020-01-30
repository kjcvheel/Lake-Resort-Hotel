var api = "http://localhost:8080/guests";

$(document).ready(function() {
    console.log("Fill drowndown options.");
    fillBirthdayDropdowns();
    $("#fname").val(sessionStorage.getItem("fname"));
    getData();
    console.log("Find 404 01");
});

$("#submitButton").click(function() {
    postData();
});

$(document).on("click", '.collapse-trigger', function() {
    console.log("Trigger collapse");
    $(this).next().collapse('toggle');
});

function getData() {
    console.log("getting data...");

    let rooms = ["Suite 02", "Suite 34"];
    rooms.forEach(function(item, index) {
        $.ajax({
            url: "http://localhost:8080/api/rooms/" + item,
            type: "get",
            success: function(result) {
                setRoomsInfo(result, index);
                console.log("Find 404 04");
            }
        });
    })
    console.log("Find 404 02");

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
            console.log("This was posted " + result.firstName + " " + result.lastName);
        }
    });

}

function setRoomsInfo(room, index) {
    $("#rooms-container").append("<div id='room" + index + "'></div>");
    $("#room" + index).load("cards/smallRoomCard.html", function() {
        let card = $("#room" + index);
        console.log("Filling in details of room: " + room.id);
        card.find("#price").html("Price: " + room.price);
        card.find("#size").html("Adults: " + room.adult + ", Children: " + room.children);
        card.find(".card-title").html(room.id);
    });
    //$(".roomname").html("hello" + index);
    //$("#room" + index).find(".roomname")[0].html("hello");
    //$("#rooms-container").find(".roomname").html("<p>Hello<p>");
    //$("#rooms-container").append("<p>" + Room.id + ": " + Room.number + "</p>");
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
    for (i = new Date().getFullYear(); i >= 1900; i--) {
        let option = "<option value='" + i + "'>" + i + "</option>";
        $(".yearSelect").append($(option));
    }
}

function getFormData() {
    let dayString = $("#bDay").val();
    if (dayString.length < 2) {
        dayString = '0' + dayString;
    }

    let monthString = $("#bMonth").val();
    if (monthString.length < 2) {
        monthString = '0' + monthString;
    }

    let guestObj = {
        firstName: $("#fname").val(),
        lastName: $("#lname").val(),
        birthday: $("#bYear").val() + "-" + monthString + "-" + dayString,
        country: $("#country").val(),
        address: $("#streetname").val() + " " + $("#streetnumber").val(),
        city: $("#city").val(),
        zipcode: $("#zipcode").val(),
        phoneNumber: $("#phonenumber").val(),
        mobileNumber: $("#mobilenumber").val(),
        email: $("#email").val(),
        creditcard: $("#creditcard").val(),
    };
    return guestObj;
}

$("#fname").change(function() {
    console.log($("#fname").val());
    sessionStorage.setItem("fname", $("#fname").val())
    console.log("written to storage: " + sessionStorage.getItem("fname"));
});