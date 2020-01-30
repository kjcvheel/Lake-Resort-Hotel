$(document).ready(function() {
    getRooms();


});

$(document).on('click', 'div[class^="single_room"]', function() {
    console.log($(this).attr('name'));
    sessionStorage.setItem("bookedRoom", $(this).attr('name'));
    alert($(this).html());
    window.location.href = "http://localhost:8080/bookingGuest.html"

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

                // $("#roomTable").append(`<tr><td>${value.type}</td><td>${value.price}</td><td>${value.disabled}</td></tr>`);
                if (!"SINGLE".localeCompare(value.type)) {
                    $("div.roomlist").append(`<div class="single_room" name="${value.id}"><img src="roomImages/SINGLE.jpg" alt="Single room"><p class="description">Price per night: ${value.price}<br />Room type: ${value.type}<br />Suitable with disabilities: ${value.disabled}</p></div>`);
                } else if (!"DOUBLE".localeCompare(value.type)) {
                    $("div.roomlist").append(`<div class="single_room" name="${value.id}"><img src="roomImages/DOUBLE.jpg" alt="Double room"><p class="description">Price per night: ${value.price}<br />Room type: ${value.type}<br />Suitable with disabilities: ${value.disabled}</p></div>`);
                } else if (!"DOUBLEX_2".localeCompare(value.type)) {
                    $("div.roomlist").append(`<div class="single_room" name="${value.id}"><img src="roomImages/DOUBLEX2.jpg" alt="2x double room"><p class="description">Price per night: ${value.price}<br />Room type: ${value.type}<br />Suitable with disabilities: ${value.disabled}</p></div>`);
                } else {
                    $("div.roomlist").append(`<div class="single_room" name="${value.id}"><img src="roomImages/PENTHOUSE.jpg" alt="Penthouse"><p class="description">Price per night: ${value.price}<br />Room type: ${value.type}<br />Suitable with disabilities: ${value.disabled}</p></div>`);
                }
            });
        }
    });


}

function getRoomsUnder() {
    let price = $("input[type=number][name=max]").val();

    $.ajax({
        url: "http://localhost:8080/api/rooms/under" + price,
        type: "get",
        success: function(result) {
            console.log("This is the data: " + result);
            $("div.roomlist").html("");

            $.each(result, function(index, value) {
                console.log(value.type + " " + value.price + " " + value.disabled);



                if (!"SINGLE".localeCompare(value.type)) {
                    $("div.roomlist").append(`<div class="single_room" name="${value.id}"><img src="roomImages/SINGLE.jpg" alt="Example room 1"><p class="description">Price per night: ${value.price}<br />Room type: ${value.type}<br />Suitable with disabilities: ${value.disabled}</p></div>`);
                } else if (!"DOUBLE".localeCompare(value.type)) {
                    $("div.roomlist").append(`<div class="single_room" name="${value.id}"><img src="roomImages/DOUBLE.jpg" alt="Example room 1"><p class="description">Price per night: ${value.price}<br />Room type: ${value.type}<br />Suitable with disabilities: ${value.disabled}</p></div>`);
                } else if (!"DOUBLEX_2".localeCompare(value.type)) {
                    $("div.roomlist").append(`<div class="single_room" name="${value.id}"><img src="roomImages/DOUBLEX2.jpg" alt="Example room 1"><p class="description">Price per night: ${value.price}<br />Room type: ${value.type}<br />Suitable with disabilities: ${value.disabled}</p></div>`);
                } else {
                    $("div.roomlist").append(`<div class="single_room" name="${value.id}"><img src="roomImages/PENTHOUSE.jpg" alt="Example room 1"><p class="description">Price per night: ${value.price}<br />Room type: ${value.type}<br />Suitable with disabilities: ${value.disabled}</p></div>`);
                }
            });
        }
    });
}