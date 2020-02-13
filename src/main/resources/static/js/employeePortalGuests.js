var api = 'http://localhost:8080/api/guests';
var columns = [
    { "data": "id", "title": "ID" },
    {
        "data": null,
        "title": "name",
        "render": function(data, type, full) {
            return formName(full)
        }
    },
    { "data": "email", "title": "email" },
    { "data": "country", "title": "country" },
    { "data": "city", "title": "city" },
    {
        "data": null,
        "title": "address",
        "render": function(data, type, full) {
            return formAddress(full)
        }
    },
    { "data": "zipcode", "title": "zipcode" },
    { "data": "phoneNumber", "title": "phone number" },
    { "data": "mobileNumber", "title": "mobile number" },
    //{ "data": "image", "title": "Image" },
];
var portalType = "guest";


function formName(full) {
    let fullname = "";
    if (full['firstName']) {
        fullname += full['firstName'] + " ";
    }
    if (full['infix']) {
        fullname += full['infix'] + " ";
    }
    if (full['lastName']) {
        fullname += full['lastName'] + " ";
    }
    return fullname;
}

function formAddress(full) {
    let address = "";
    if (full['streetName1']) {
        address += full['streetName1'] + " ";
    }
    if (full['streetName2']) {
        address += full['streetName2'] + " ";
    }
    if (full['streetName3']) {
        address += full['streetName3'] + " ";
    }
    if (full['addressNumber']) {
        address += full['addressNumber'];
    }

    return address;
}

function fillModal(record) {
    $('#modalForm').removeClass("was-validated");
    console.log(record);
    // fill the modal
    $("#id").val(record.id);
    $("#firstname").val(record.firstName);
    $("#infix").val(record.infix);
    $("#lastname").val(record.lastName);
    $("#email").val(record.email);
    $("#country").val(record.country);
    $("#city").val(record.city);
    $("#streetName1").val(record.streetName1);
    $("#streetName2").val(record.streetName2);
    $("#streetName3").val(record.streetName3);
    $("#addressNumber").val(record.addressNumber);
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
        email: $("#email").val(),
        country: $("#country").val(),
        city: $("#city").val(),
        streetName1: $("#streetName1").val(),
        streetName2: $("#streetName2").val(),
        streetName3: $("#streetName3").val(),
        addressNumber: $("#addressNumber").val(),
        zipcode: $("#zipcode").val(),
        phoneNumber: $("#phoneNumber").val(),
        mobileNumber: $("#mobileNumber").val(),
    };
    return formObj;
}