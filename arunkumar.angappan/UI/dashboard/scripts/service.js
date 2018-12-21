var service = {};

service.doGet = function (method,url,asyc) {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            service.response = this.responseText;
        }
    };
    xhttp.open(method, url, asyc);
    xhttp.send();
}