$(document).ready(function () {
    getRooms();
    setDatePicker();
});

let selectedRooms = [];
var slider = document.getElementById("price");
var output = document.getElementById("priceselect");
output.innerHTML = slider.value;

slider.oninput = function () {
    console.log("moving");
    output.innerHTML = this.value;
}

$(document).on("click", '.collapse-trigger', function () {
    console.log("Trigger collapse");
    $(this).next().collapse('toggle');
});


$(document).on('click', "#selectnow", function () {
    let index = $(this).parents().eq(2).attr('name');
    selectRoom(index);

});



$(document).on('click', "#booknow", function () {
    if (selectedRooms.length == 0 || $("#dateFrom").text() == "Invalid Date" || $("#dateTo").text() == "Invalid Date") {
        return;
    }
    sessionStorage.setItem('dateFrom', $("#dateFrom").text());
    sessionStorage.setItem('dateTo', $("#dateTo").text());

    console.log(selectedRooms);
    sessionStorage.setItem('bookedRooms', JSON.stringify(selectedRooms));
    window.location.href = "http://localhost:8080/BookingGuestForm";

});

$(document).on('click', "#checkout", function () {
    let date = new Date($("#checkin").val());
    date.setDate(date.getDate() + 1);
    $("#checkout").datepicker('setStartDate', date);
});




$(document).on('click', '#roomFilter', function () {
    filter();
    //getRoomsByDate();
    resetSelected();
});

function setDatePicker() {
    let holidays = ['01/01/2020', '01/24/2020', '01/25/2020', '01/26/2020', '01/24/2020', '01/27/2020', '01/28/2020',
        '01/29/2020', '01/30/2020', '04/04/2020', '05/01/2020', '06/25/2020', '09/27/2020', '10/01/2020', '10/02/2020',
        '10/03/2020', '10/04/2020', '10/05/2020', '10/06/2020', '10/07/2020'];
    var date_input = $('input[name="checkin"]'); //our date input has the name "date"

    date_input.datepicker({
        format: 'mm/dd/yyyy',

        daysOfWeekHighlighted: '0,6',
        todayHighlight: true,
        autoclose: true,
        startDate: new Date(),
        weekStart: 1,
        beforeShowDay: function (date) {

            calender_date = ('0' + (date.getMonth() + 1)) + '/' + ('0' + date.getDate()).slice(-2) + '/' + date.getFullYear();
            var search_index = $.inArray(calender_date, holidays);


            if (search_index > -1) {
                return { classes: 'highlight', tooltip: 'Holiday' };
            }

        }
    }).on('changeDate', function() {
        let date = new Date($("#checkin").val());
        date.setDate(date.getDate() + 1);
        $("#checkout").datepicker('setDate', date);
    });

    var date_input2 = $('input[name="checkout"]'); //our date input has the name "date"

    date_input2.datepicker({
        format: 'mm/dd/yyyy',
        daysOfWeekHighlighted: "0,6",
        todayHighlight: true,
        autoclose: true,
        weekStart: 1

    }).on('changeDate', function() {
        filter();
    });
}

function getRooms() {
    console.log("getting data.. ");

    $.ajax({
        url: "http://localhost:8080/api/rooms",
        type: "get",
        success: function (result) {
            console.log("This is the data: " + result);

            $.each(result, function (index, value) {
                console.log(value.type + " " + value.price + " " + value.disabled);
                makeCard(index, value);

            });
        }
    });


}

function getFilterData() {
    let filterObj = {
        adult: $("#adults").val(),
        children: $("#children").val(),
        maxPrice: $("#price").val(),
        smoking: $("#smoking").is(":checked"),
        disabled: $("#disabled").is(":checked"),
        startDate: $("#checkin").val(),
        endDate: $("#checkout").val(),
    };
    return filterObj;
}

function filter() {
    let filterObj = getFilterData();
    console.log(filterObj);
    let jsonObj = JSON.stringify(filterObj);

    $.ajax({
        url: "http://localhost:8080/api/rooms/filter",
        type: "post",
        data: jsonObj,
        contentType: "application/json",
        success: function (result) {
            console.log("This is the data: " + result);
            $("#roomlist").html("");

            $.each(result, function (index, value) {
                console.log(value.type + " " + value.price + " " + value.disabled);
                makeCard(index, value);

            });
        }
    });


}

function getRoomsUnder() {
    let price = $("input[type=range][name=price]").val();

    $.ajax({
        url: "http://localhost:8080/api/rooms/under" + price,
        type: "get",
        success: function (result) {
            console.log("This is the data: " + result);
            $("#roomlist").html("");

            $.each(result, function (index, value) {
                console.log(value.type + " " + value.price + " " + value.disabled);
                makeCard(index, value);

            });
        }
    });
}

function getRoomsByDate() {
    let incheck = $("#checkin").val();
    let uitcheck = $("#checkout").val();



    $.ajax({
        url: "http://localhost:8080/api/rooms/date/" + incheck + "/" + uitcheck,
        type: "get",
        success: function (result) {
            console.log("This is the data: " + result);
            $("#roomlist").html("");

            $.each(result, function (index, value) {
                console.log(value.type + " " + value.price + " " + value.disabled);
                makeCard(index, value);

            });
        }
    });
}

function makeCard(index, value) {
    $("#roomlist").append("<div id='room" + index + "'></div>");
    $("#room" + index).load("cards/roomViewRoomCard.html", function () {
        let card = $("#room" + index);
        console.log("Filling in details of room: " + value.id);
        card.find(".card").attr('name', value.id);
        card.find("#price").html("<span>&#165;</span> " + value.price + "");

        card.find("#people").html(value.adult + ' <i class="fas fa-male fa-2x"></i> ' + value.children + ' <i class="fas fa-baby fa-2x"></i> ')
        if (value.disabled) {
            card.find("#disabled").html('<i class="fas fa-wheelchair fa-2x" ></i>');
        }
        if (value.smoking) {
            card.find("#smoking").attr("class", "fas fa-smoking fa-2x");
        }

        if (!"SINGLE".localeCompare(value.type)) {
            card.find("#image").attr("src", "roomImages/SINGLE.jpg");
            card.find("#type").html(value.type + " ROOM");
            card.find("#specificInfo").html("A beautiful room with a single bed.")
        } else if (!"DOUBLE".localeCompare(value.type)) {
            card.find("#image").attr("src", "roomImages/DOUBLE.jpg");
            card.find("#type").html(value.type + " ROOM");
            card.find("#specificInfo").html("A beautiful room with a large double bed.")
        } else if (!"DOUBLEX_2".localeCompare(value.type)) {
            card.find("#image").attr("src", "roomImages/DOUBLEX2.jpg");
            card.find("#type").html("DOUBLE-DOUBLE ROOM");
            card.find("#specificInfo").html("A beautiful room with two double beds. Perfect for families.")
        } else {
            card.find("#image").attr("src", "roomImages/PENTHOUSE.jpg");
            card.find("#type").html(value.type);
            card.find("#specificInfo").html("Luxurious penthouse on the top floors of the hotel.")
        }
        card.find(".card-title").html(value.id);
    });



}

function selectRoom(index) {

    console.log(index);

    $.ajax({
        url: "http://localhost:8080/api/rooms/" + index,
        type: "get",
        success: function (result) {
            var dateOptions = { weekday: 'long', year: 'numeric', month: 'long', day: 'numeric' };
            let dateFrom = new Date($("#checkin").val()).toLocaleDateString("en-US", dateOptions);
            let dateTo = new Date($("#checkout").val()).toLocaleDateString("en-US", dateOptions);
            if(!(dateFrom == $("#dateFrom").text()) || !(dateTo == $("#dateTo").text())){
                console.log("different dates");
                resetSelected();
            }
            $("#dateFrom").html(dateFrom);
            $("#dateTo").html(dateTo);

            $("#selectedRooms").append("<div id='selectedroom" + index + "'></div>");
            $("#selectedroom" + index).load("cards/smallRoomCard.html", function () {
                let card = $("#selectedroom" + index);
                console.log("Filling in details of room: " + result.id);
                card.find("#price").html("Price: " + result.price);
                card.find("#size").html("Adults: " + result.adult + ", Children: " + result.children);
                card.find(".card-title").html(result.name);
                card.find("#room-image").attr('src', result.image);
                if (selectedRooms.includes(result.id)) {
                    return;
                }
                selectedRooms.push(result.id);

            });


        }
    });
}

function resetSelected() {
    $("#dateFrom").html("");
    $("#dateTo").html("");
    $("#selectedRooms").html("");
    selectedRooms = [];
}