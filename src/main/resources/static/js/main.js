var api = "http://localhost:8080/guests";

function getData() {
    console.log("getting data...");

    $.ajax({
        url: "http://localhost:8080/api/guests/test",
        type: "get",
        success: function(result) {
            console.log("This is the data2: " + result);
        }
    });
}

function postData() {
    console.log("sending data...")

    let guestObj = {
        firstName: $("#fname").val(),
        lastName: $("#lname").val()
    };

    let jsonObj = JSON.stringify(guestObj);

    $.ajax({
        url: "http://localhost:8080/api/guests/test",
        type: "post",
        data: jsonObj,
        contentType: "application/json",
        success: function(result) {
            console.log("This was posted " + result.firstName + " " + result.lastName);
        }
    });

}

$(document).ready(function() {
    console.log("Fill drowndown options.");
    fillBirthdayDropdowns();
});

$("#getButton").click(function() {
    getData();
});

$("#postButton").click(function() {
    postData();
});

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