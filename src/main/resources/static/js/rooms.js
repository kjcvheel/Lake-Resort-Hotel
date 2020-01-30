$(document).ready(function () {
    getRooms();


});

$(document).on('click', 'div[class^="single_room"]', function () {
    alert($(this).html());
});

$("single_room").click(function(){
   alert($(this).html());

});

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

function getRoomsUnder() {
    let price = $("input[type=number][name=max]").val();

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
        }});
}

function makeCard(index, value){
    $("#roomlist").append("<div id='room" + index + "'></div>");
    $("#room" + index).load("cards/roomViewRoomCard.html", function() {
        let card = $("#room" + index);
        console.log("Filling in details of room: " + value.id);
        card.find("#price").html("Price per night: " + value.price + "<br/>");
        card.find("#type").html("Room type: " + value.type.toLowerCase() + "<br/>");
        card.find("#disabled").html("Suitable with disabilities: " + value.disabled);
        if (!"SINGLE".localeCompare(value.type)) {
            card.find("#image").attr("src", "roomImages/SINGLE.jpg");
        } else if (!"DOUBLE".localeCompare(value.type)) {
            card.find("#image").attr("src", "roomImages/DOUBLE.jpg");
        } else if (!"DOUBLEX_2".localeCompare(value.type)) {
            card.find("#image").attr("src", "roomImages/DOUBLEX2.jpg");
        } else {
            card.find("#image").attr("src", "roomImages/PENTHOUSE.jpg");
        }
        card.find(".card-title").html(value.id);
    });



}







