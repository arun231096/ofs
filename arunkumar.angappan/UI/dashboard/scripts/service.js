var service = {};

service.doGet = function (url) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            service.response = this.responseText;
        }
    };
    xhttp.open('GET', url, false);
    xhttp.send();
}