var api = 'http://localhost:8080/bookings';
var columns = [
    { "data": "id", "title": "ID" },
    //{ "data": "mainbooker.firstName", "title": "main booker" },
];
var portalType = "booking";

function fillModal(record) {
    $('#modalForm').removeClass("was-validated");
    console.log(record);
    // fill the modal
    $("#id").val(record.id);
    $("#mainbooker").val(record.mainBooker.firstName);
}

function getFormData() {
    let formObj = {
        id: $("#id").val(),
    };
    return formObj;
}