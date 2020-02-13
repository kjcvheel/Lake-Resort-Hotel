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
    {
        "data": "birthday",
        "title": "Date of birth",
        "render": function(data) {
            return formatDate(data)
        }
    },
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


function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [day, month, year].join('-');
}

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
    console.log("filling modal with: " + record);
    // fill the modal
    $("#id").val(record.id);
    $("#firstname").val(record.firstName);
    $("#infix").val(record.infix);
    $("#lastname").val(record.lastName);
    $("#bdate").val(formatDate(record.birthday));
    $("#email").val(record.email);
    $("#country").val(record.country);
    $("#city").val(record.city);
    $("#streetname1").val(record.streetName1);
    $("#streetname2").val(record.streetName2);
    $("#streetname3").val(record.streetName3);
    $("#streetnumber").val(record.addressNumber);
    $("#zipcode").val(record.zipcode);
    $("#phonenumber").val(record.phoneNumber);
    $("#mobilenumber").val(record.mobileNumber);
    $("#creditcard").val(record.creditcard);
}

function getFormData() {
    let formObj = {
        id: $("#id").val(),
        firstName: $("#firstname").val(),
        infix: $("#infix").val(),
        lastName: $("#lastname").val(),
        email: $("#email").val(),
        birthday: $("#bdate").val().split('-').reverse().join('-'),
        country: $("#country").val(),
        city: $("#city").val(),
        streetName1: $("#streetname1").val(),
        streetName2: $("#streetname2").val(),
        streetName3: $("#streetname3").val(),
        addressNumber: $("#streetnumber").val(),
        zipcode: $("#zipcode").val(),
        phoneNumber: $("#phonenumber").val(),
        mobileNumber: $("#mobilenumber").val(),
        creditcard: $("#creditcard").val(),
    };
    console.log("Guest:" + formObj);
    return formObj;
}