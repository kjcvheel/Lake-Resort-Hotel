var api = "http://localhost:8080/guests";

function getData() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {}
    }
}

function sendData() {
    let xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            let myObj = JSON.parse(this.responseText);
            // Set inner html to this.
        }
    };
    let form = "#guest-information-form";
    let guest = JSON.stringify($(form).serializeArray());
    xhttp.open("POST", "application/json", true);
    xhttp.send(guest);
}