var api = 'http://localhost:8080/bookings';
var columns = [
    { "data": "id", "title": "ID" },
    {
        "data": "",
        "title": "main booker (ID)",
        "render": function(data, type, full) {
            return formBooker(full['mainBooker'])
        }
    },
    { "data": "startDate", "title": "Check in" },
    { "data": "endDate", "title": "Check out" },
    { "data": "adults", "title": "Adults" },
    { "data": "children", "title": "Children" },
    {
        "data": "paymentStatus",
        "title": "Payed",
        "render": function(data) {
            return mapBool(data)
        }
    },
    {
        "data": "status",
        "title": "Status",
        "render": function(data) {
            return mapStatus(data)
        }
    },
    {
        "data": "rooms",
        "title": "Rooms",
        "render": function(data, type, full) {
            return formRooms(full['roomNumbers'])
        }
    }
];
var portalType = "booking";
let thisBooking;


$(document).ready(function() {
    let date_input = $('input[name="checkin"]');
    setDate(date_input);

    let date_input2 = $('input[name="checkout"]');
    setDate(date_input2);
});

function fillModal(record) {
    $('#modalForm').removeClass("was-validated");
    // fill the modal
    $("#id").val(record.id);
    $("#mainbooker").val(formBooker(record.mainBooker));
    $("#checkin").val(formatDate(record.startDate));
    $("#checkout").val(formatDate(record.endDate));
    $("#adults").val(record.adults);
    $("#children").val(record.children);
    $("#payed").attr('checked', record.paymentStatus);
    $("#status").val(record.status);
    $("#rooms").val(formRooms(record.roomNumbers));
    thisBooking = record;
    changeDateRange();
}

function getFormData() {
    let formObj = {
        id: thisBooking.id,
        mainBooker: thisBooking.mainBooker,
        startDate: formatDateForSave($("#checkin").val()),
        endDate: formatDateForSave($("#checkout").val()),
        adults: $("#adults").val(),
        children: $("#children").val(),
        paymentStatus: $("#payed").is(":checked"),
        status: $("#status").val(),
        roomNumbers: thisBooking.roomNumbers
    };
    console.log(formObj);
    return formObj;
}

function setDate(dateInput) {
    let holidays = ['01/01/2020', '01/24/2020', '01/25/2020', '01/26/2020', '01/24/2020', '01/27/2020', '01/28/2020',
        '01/29/2020', '01/30/2020', '04/04/2020', '05/01/2020', '06/25/2020', '09/27/2020', '10/01/2020', '10/02/2020',
        '10/03/2020', '10/04/2020', '10/05/2020', '10/06/2020', '10/07/2020'
    ];

    dateInput.datepicker({
        format: 'mm/dd/yyyy',

        daysOfWeekHighlighted: '0,6',
        todayHighlight: true,
        autoclose: true,
        weekStart: 1,
        beforeShowDay: function(date) {
            calender_date = ('0' + (date.getMonth() + 1)) + '/' + ('0' + date.getDate()).slice(-2) + '/' + date.getFullYear();
            var search_index = $.inArray(calender_date, holidays);

            if (search_index > -1) {
                return { classes: 'highlight', tooltip: 'Holiday' };
            }

        }
    });
}


$('#checkin').change(function() {
    changeDateRange();
});

function changeDateRange() {
    let date = new Date($("#checkin").val());
    date.setDate(date.getDate() + 1);
    $("#checkout").datepicker('setStartDate', date);
    let dateOut = new Date($("#checkout").val());
    if (dateOut.getTime() < date.getTime()) {
        $('#checkout').datepicker('update', date);
    }
}

function formBooker(full) {
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
    fullname += " (" + full['id'] + ")";
    return fullname;
}

function formRooms(full) {
    let rooms = "";
    full.forEach(room => {
        rooms += room['name'] + ", ";
    });
    return rooms;
}

function formatDate(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [month, day, year].join('/');
}

function formatDateForSave(date) {
    var d = new Date(date),
        month = '' + (d.getMonth() + 1),
        day = '' + d.getDate(),
        year = d.getFullYear();

    if (month.length < 2)
        month = '0' + month;
    if (day.length < 2)
        day = '0' + day;

    return [year, month, day].join('-');
}