var rsp = {};
var personData;
var addressData;

rsp.createChildren = function () {
    console.log('rsp created');
}

rsp.getPojo= function() {
    service.doGet('GET','../assets/json/personPojo.json', false);
    rsp.jsonPerson = JSON.parse(service.response);
    service.doGet('GET','../assets/json/addressPojo.json', false);
    rsp.jsonAddress = JSON.parse(service.response);
}
rsp.createView = function(){
    var rspchild = service.doGet('GET','../html/rsp.html', false);
    rsp.setView();
}

rsp.setView = function () {
    rsp.view = service.response;
}

rsp.createPersonPanel = function () {
    service.doGet('GET', '../html/personpanel.html', false);
    document.getElementById('details-container').innerHTML = service.response;
    rsp.getData('person');
    rsp.setViewPanel('person');
    rsp.listenEvents('person');
    rsp.setDefault('person');
}

rsp.createAddressPanel = function() {
    service.doGet('GET', '../html/addressPanel.html', false);
    document.getElementById('details-container').innerHTML = service.response;
    rsp.getData('address');
    rsp.setViewPanel('address');
    rsp.listenEvents('address');
    rsp.setDefault('address');
}

rsp.getData = function(field){
    if (field === 'person') {
        service.doGet('GET','../assets/json/person.json', false);
        personData = JSON.parse(service.response);
        if (personData.length != 0) {
            rsp.AddTable(field);
            rsp.createPersonList();
        }
    } else if (field === 'address') {
        service.doGet('GET','../assets/json/address.json', false);
        addressData = JSON.parse(service.response);
        if (addressData.length != 0) {
            rsp.AddTable(field);
            rsp.createAddressList();
        }
    }
}

rsp.setViewPanel = function(field){
    if (field === 'person') {
        service.doGet('GET','../html/personInfopanel.html', false);
        document.getElementById('person-panel').innerHTML += service.response;
        service.doGet('GET','../html/personform.html', false);
        document.getElementById('person-manipulation').innerHTML = service.response;
    }else if (field === 'address') {
        service.doGet('GET','../html/addressInfopanel.html', false);
        document.getElementById('address-panel').innerHTML += service.response;
        service.doGet('GET','../html/addressForm.html', false);
        document.getElementById('address-manipulation').innerHTML = service.response;
    }
}

rsp.listenEvents = function (field) {
    if (field === 'person') {
        var defaultData = document.getElementsByTagName('tr');
        for  (var i = 0; i< defaultData.length; i++) {
            if (i != 0){
                defaultData[i].setAttribute('onclick','em.onselectedList("person", '+(i-1)+')');
                var button = defaultData[i].getElementsByTagName('button');
                // button.setAttribute('onclick','em.removeItem("person",'+(i-1)+')');
            }
        }
    }else if (field === 'address') {
        var defaultData = document.getElementsByTagName('tr');
        for  (var i = 0; i< defaultData.length; i++) {
            if (i != 0) {
                defaultData[i].setAttribute('onclick','em.onselectedList("address", '+(i-1)+')');
                var button = defaultData[i].getElementsByTagName('button');
                // button.setAttribute('onclick','em.removeItem("address",'+(i-1)+')');
            }
        }
    }
}

rsp.setDefault = function (field) {
    if (field === 'person') {
        em.onselectedList('person', 0);
    }else if (field === 'address') {
        em.onselectedList('address', 0);
    }
}

rsp.AddTable = function(field) {
    if (field === 'person') {
        service.doGet('GET','../html/personList.html', false);
        document.getElementById('person-panel').innerHTML += service.response;
        document.getElementById('add-button').setAttribute('onclick', 'em.add("person")');
    }else if (field === 'address') {
        service.doGet('GET','../html/addressList.html', false);
        document.getElementById('address-panel').innerHTML += service.response;
        document.getElementById('add-button').setAttribute('onclick', 'em.add("address")');
    }
}

rsp.createPersonList = function() {
    for(var i = 0; i< personData.length; i++) {
        service.doGet('GET', '../html/personTable.html', false);
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

rsp.createAddressList = function() {
    for(var i=0; i< addressData.length; i++) {
        service.doGet('GET', '../html/addressTable.html', false);
        var addressTable = service.response;
        addressTable = addressTable.replace('street', addressData[i].street);
        addressTable = addressTable.replace('city', addressData[i].city);
        addressTable = addressTable.replace('pc', addressData[i].postal_code);
        document.getElementById('addressTable').innerHTML += addressTable;
    }
}

rsp.onselectedListPerson = function (row) {
    document.getElementById('save-button').setAttribute('onclick', 'em.onSave("person","update")');
    var doc = document.getElementById('personForm');
    var inputs = doc.getElementsByTagName('input');
    inputs[0].value = personData[row].id;
    inputs[1].value = personData[row].firstname;
    inputs[2].value = personData[row].lastname;
    inputs[3].value = personData[row].email;
    inputs[4].value = personData[row].dob;
    inputs[5].value = personData[row].isadmin;
}

rsp.onselectedListAddress = function(row) {
    document.getElementById('save-button').setAttribute('onclick', 'em.onSave("address","update")');
    var doc = document.getElementById('addressForm');
    var inputs = doc.getElementsByTagName('input');
    inputs[0].value = addressData[row].id;
    inputs[1].value = addressData[row].street;
    inputs[2].value = addressData[row].city;
    inputs[3].value = addressData[row].postal_code;
}

rsp.updatePerson = function() {

    var doc = document.getElementById('personForm');
    var inputs = doc.getElementsByTagName('input');
    for(var i =0; i < personData.length; i++) {
        id = inputs[0].value;
        if (id == personData[i].id) {
            rsp.jsonPerson = personData[i];
            rsp.jsonPerson.firstname = inputs[1].value;
            rsp.jsonPerson.lastname = inputs[2].value;
            rsp.jsonPerson.email = inputs[3].value;
            rsp.jsonPerson.dob = inputs[4].value;
            rsp.jsonPerson.isadmin = inputs[5].value;
            console.log(rsp.jsonPerson);
        }
    }
}

rsp.updateAddress = function() {

    var doc = document.getElementById('addressForm');
    var inputs = doc.getElementsByTagName('input');
    for(var i =0; i < addressData.length; i++) {
        id = inputs[0].value;
        if (id == addressData[i].id) {
            rsp.jsonAddress = addressData[i];
            rsp.jsonAddress.street = inputs[1].value;
            rsp.jsonAddress.city = inputs[2].value;
            rsp.jsonAddress.postal_code = inputs[3].value;
            console.log(rsp.jsonAddress);
        }
    }
}

rsp.addPersonFields= function() {
    var doc = document.getElementById('personForm');
    document.getElementById('save-button').setAttribute('onclick', 'em.onSave("person","add")');
    var inputs = doc.getElementsByTagName('input');
    for(var i=0; i< inputs.length; i++) {
        if ( i != 0){
        inputs[i].setAttribute('type', 'text');
        inputs[i].value = '';
        }
    }
}

rsp.addAddressFields= function() {
    var doc = document.getElementById('addressForm');
    document.getElementById('save-button').setAttribute('onclick', 'em.onSave("address","add")');
    var inputs = doc.getElementsByTagName('input');
    for(var i=0; i< inputs.length; i++) {
        if ( i != 0){
        inputs[i].setAttribute('type', 'text');
        inputs[i].value = '';
        }
    }
}

rsp.addPerson = function() {

    var doc = document.getElementById('personForm');
    var inputs = doc.getElementsByTagName('input');
    rsp.getPojo();
    rsp.jsonPerson.firstname = inputs[1].value;
    rsp.jsonPerson.lastname = inputs[2].value;
    rsp.jsonPerson.email = inputs[3].value;
    rsp.jsonPerson.dob = inputs[4].value;
    rsp.jsonPerson.isadmin = inputs[5].value;
    rsp.jsonAddress.street = inputs[6].value;
    rsp.jsonAddress.city = inputs[7].value;
    rsp.jsonAddress.postal_code = inputs[8].value;
    rsp.jsonPerson.address = rsp.jsonAddress;
    console.log(rsp.jsonPerson);
}

rsp.addAddress = function() {
    var doc = document.getElementById('addressForm');
    var inputs = doc.getElementsByTagName('input');
    rsp.getPojo();
    rsp.jsonAddress.street = inputs[1].value;
    rsp.jsonAddress.city = inputs[2].value;
    rsp.jsonAddress.postal_code = inputs[3].value;
    console.log(rsp.jsonAddress);
}