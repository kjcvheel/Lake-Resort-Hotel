$(document).ready(function() {
    $("#TOP").load("header.html");
    getRooms();


});

$(document).on('click', "#booknow", function() {
    console.log($(this).parents().eq(2).attr('name'));

    sessionStorage.setItem('bookedRoom', $(this).parents().eq(2).attr('name'));
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

function getRoomsUnder() {
    let price = $("input[type=number][name=max]").val();

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