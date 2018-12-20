var rsp = {};
var personData;

rsp.createChildren = function () {
    console.log('rsp created');
}

rsp.createView = function(){
    var rspchild = service.doGet('../html/rsp.html');
    rsp.setView();
}

rsp.setView = function () {
    rsp.view = service.response;
}

rsp.createPersonPanel = function () {
    service.doGet('../html/personpanel.html');
    document.getElementById('details-container').innerHTML = service.response;
    rsp.getPerson();
    rsp.setViewPanel();
    rsp.listenEvents();
    rsp.setDefault();
}

rsp.getPerson = function(){
    //../assets/json/person.json
    service.doGet('http://192.168.16.172:8080/ws.ccc/do/person?field=readall');
    personData = JSON.parse(service.response);
    if (personData.length != 0) {
        rsp.AddTable();
        rsp.createPersonList();
    }
}

rsp.AddTable = function() {
    service.doGet('../html/personList.html');
    document.getElementById('person-panel').innerHTML += service.response;
}

rsp.createPersonList = function() {
    for(var i = 0; i< personData.length; i++) {
        service.doGet('../html/personTable.html');
        var personTable = service.response;
        personTable = personTable.replace('emp.id', personData[i].id);
        personTable = personTable.replace('firstname', personData[i].firstname);
        personTable = personTable.replace('lastname', personData[i].lastname);
        personTable = personTable.replace('email', personData[i].email);
        personTable = personTable.replace('dob', personData[i].dob);
        personTable = personTable.replace('admin', personData[i].isadmin);
        document.getElementById('personTable').innerHTML += personTable;
    }
}

rsp.setViewPanel = function(){
    service.doGet('../html/infopanel.html');
    document.getElementById('person-panel').innerHTML += service.response;
    service.doGet('../html/personform.html');
    document.getElementById('person-manipulation').innerHTML = service.response;
}

rsp.listenEvents = function () {
    var defaultData = document.getElementsByTagName('tr');
    for  (var i = 0; i< defaultData.length; i++) {
        defaultData[i].setAttribute('onclick','em.onselectedList("person", '+(i-1)+')');
    }
}

rsp.setDefault = function () {
    rsp.onselectedListPerson(0);
}

rsp.onselectedListPerson = function (row) {
    var inputs = document.getElementsByTagName('input');
    inputs[0].value = personData[row].id;
    inputs[1].value = personData[row].firstname;
    inputs[2].value = personData[row].lastname;
    inputs[3].value = personData[row].email;
    inputs[4].value = personData[row].dob;
    inputs[5].value = personData[row].isadmin;
}

