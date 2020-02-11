var api = 'http://localhost:8080/api/rooms';
var columns = [
    { "data": "id", "title": "ID" },
    { "data": "name", "title": "Name" },
    { "data": "price", "title": "Price" },
    { "data": "adult", "title": "Adults" },
    { "data": "children", "title": "Children" },
    {
        "data": "disabled",
        "title": "Suitable for disabled",
        "render": function(data) {
            if (data) {
                return "Yes"
            } else {
                return "No"
            }
        }
    },
    {
        "data": "smoking",
        "title": "Smoking allowed"
    },
    { "data": "status", "title": "Status" },
    { "data": "type", "title": "Type" },
    { "data": "beds", "title": "Beds" },
    //{ "data": "image", "title": "Image" },
];
var createTitle = "Add a new room";

function mapBool(data) {
    if (data) {
        return "Yes";
    } else {
        return "False";
    }
}

function mapStatus(data) {

}

function fillModal(record) {
    $('#modalForm').removeClass("was-validated");
    // fill the modal
    $("#id").val(record.id);
    $("#name").val(record.name);
    $("#price").val(record.price);
    $("#adult").val(record.adult);
    $("#children").val(record.children);
    $("#status").val(record.status);
    $("#type").val(record.type);
    //$("#image").val(record.image);
    $("#smoking").attr('checked', record.smoking);
    $("#disabled").attr('checked', record.disabled);
}

function getFormData() {
    let formObj = {
        id: $("#id").val(),
        name: $("#name").val(),
        price: $("#price").val(),
        adult: $("#adult").val(),
        children: $("#children").val(),
        status: $("#status").val(),
        type: $("#type").val(),
        //image: $("#image").val(),
        smoking: $("#smoking").is(":checked"),
        disabled: $("#disabled").is(":checked"),
    };
    return formObj;
}