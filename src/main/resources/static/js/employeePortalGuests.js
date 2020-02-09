var api = 'http://localhost:8080/api/guests';
var columns = [
    { "data": "id", "title": "ID" },
    { "data": "firstName", "title": "first name" },
    { "data": "infix", "title": "infix" },
    { "data": "lastName", "title": "last name" },
    { "data": "country", "title": "country" },
    { "data": "city", "title": "city" },
    { "data": "address", "title": "address" },
    { "data": "zipcode", "title": "zipcode" },
    { "data": "phoneNumber", "title": "phone number" },
    { "data": "mobileNumber", "title": "mobile number" },
    //{ "data": "image", "title": "Image" },
];
var createTitle = "Add a new guest";

function fillModal(record) {
    $('#modalForm').removeClass("was-validated");
    console.log(record);
    // fill the modal
    $("#id").val(record.id);
    $("#firstname").val(record.firstName);
    $("#infix").val(record.infix);
    $("#lastname").val(record.lastName);
    $("#country").val(record.country);
    $("#city").val(record.city);
    $("#address").val(record.address);
    $("#zipcode").val(record.zipcode);
    $("#phoneNumber").val(record.phoneNumber);
    $("#mobileNumber").val(record.mobileNumber);
}

function getFormData() {
    let formObj = {
        id: $("#id").val(),
        firstName: $("#firstname").val(),
        infix: $("#infix").val(),
        lastName: $("#lastname").val(),
        country: $("#country").val(),
        city: $("#city").val(),
        address: $("#address").val(),
        zipcode: $("#zipcode").val(),
        phoneNumber: $("#phoneNumber").val(),
        mobileNumber: $("#mobileNumber").val(),
    };
    return formObj;
}