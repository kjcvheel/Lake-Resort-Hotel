$(document).ready(function() {
    getRooms();

    let holidays = ['01/24/2020', '01/25/2020','01/26/2020','01/24/2020','01/27/2020','01/28/2020','01/29/2020','04/30/2020', '05/01/2020', '06/25/2020'];
    var date_input=$('input[name="checkin"]'); //our date input has the name "date"

    date_input.datepicker({
       		format: 'mm/dd/yyyy',

        	daysOfWeekHighlighted: '0,6',
        	todayHighlight: true,
          	autoclose: true,
          	startDate: new Date(),
          	weekStart: 1,
          	beforeShowDay: function (date) {

                calender_date = ('0'+(date.getMonth()+1)) + '/' + ('0'+date.getDate()).slice(-2) + '/' +date.getFullYear();
                var search_index = $.inArray(calender_date, holidays);


                if (search_index > -1) {
                   return {classes: 'highlight', tooltip: 'Holiday'};
                }

            }

    });

    var date_input2=$('input[name="checkout"]'); //our date input has the name "date"

        date_input2.datepicker({
           		format: 'mm/dd/yyyy',

                daysOfWeekHighlighted: "0,6",
            	todayHighlight: true,
              	autoclose: true,
              	weekStart: 1

        });


});

$(function () {
  $('[data-toggle="popover"]').popover()
})



$(document).on('click', "#booknow", function() {
    console.log($(this).parents().eq(2).attr('name'));

    sessionStorage.setItem('bookedRoom', $(this).parents().eq(2).attr('name'));
    sessionStorage.setItem('dateFrom', $("#checkin").val());
    sessionStorage.setItem('dateTo', $("#checkout").val());
    console.log(sessionStorage.getItem("bookedRoom"));
    window.location.href = "http://localhost:8080/BookingGuestForm";

});

$(document).on("click", '.collapse-trigger', function() {
    console.log("Trigger collapse");
    $(this).next().collapse('toggle');
});



function getRooms() {
    console.log("getting data.. ");

    $.ajax({
        url: "http://localhost:8080/api/rooms",
        type: "get",
        success: function(result) {
            console.log("This is the data: " + result);

            $.each(result, function(index, value) {
                console.log(value.type + " " + value.price + " " + value.disabled);
                makeCard(index, value);

            });
        }
    });


}

function getFilterData(){
    let filterObj = {
        adult: $("#adults").val(),
        children: $("#children").val(),
        maxPrice: $("#price").val(),
        smoking: $("#smoking").is(":checked"),
        disabled: $("#disabled").is(":checked"),

    };
    return filterObj;
}

function filter(){
    let filterObj = getFilterData();
    console.log(filterObj);
    let jsonObj = JSON.stringify(filterObj);

        $.ajax({
            url: "http://localhost:8080/api/rooms/filter",
            type: "post",
            data: jsonObj,
            contentType: "application/json",
            success: function(result) {
                console.log("This is the data: " + result);
                $("#roomlist").html("");

                $.each(result, function(index, value) {
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
        success: function(result) {
            console.log("This is the data: " + result);
            $("#roomlist").html("");

            $.each(result, function(index, value) {
                console.log(value.type + " " + value.price + " " + value.disabled);
                makeCard(index, value);

            });
        }
    });
}

function makeCard(index, value) {
    $("#roomlist").append("<div id='room" + index + "'></div>");
    $("#room" + index).load("cards/roomViewRoomCard.html", function() {
        let card = $("#room" + index);
        console.log("Filling in details of room: " + value.id);
        card.find(".card").attr('name', value.id);
        card.find("#price").html("<span>&#165;</span> " + value.price + "");

        card.find("#people").html(value.adult + ' <i class="fas fa-male fa-2x"></i> ' + value.children + ' <i class="fas fa-baby fa-2x"></i> ')
        if(value.disabled){
            card.find("#disabled").html('<i class="fas fa-wheelchair fa-2x" ></i>');
        }
        if(value.smoking){
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


var slider = document.getElementById("price");
var output = document.getElementById("priceselect");
output.innerHTML = slider.value;

slider.oninput = function() {
console.log("moving");
  output.innerHTML = this.value;
}

$(document).on('click', "#checkout", function() {
    let date = new Date($("#checkin").val());
    date.setDate(date.getDate()+1);
    $("#checkout").datepicker('setStartDate', date);
});

$(document).on('click', '#roomFilter', function(){
    filter();
});
