// var content;
// var readPerson = function () {
    // var xhttp = new XMLHttpRequest();
    // xhttp.onreadystatechange = function() {
        // if (this.readyState == 4 && this.status == 200) {
        // content = this.responseText;
        // console.log(content);
        // content = JSON.parse(content);
        // document.getElementById('personIdDetail').innerHTML = content.id;
        // document.getElementById('personFirstNameDetail').innerHTML = content.firstname;
        // document.getElementById('personLastNameDetail').innerHTML = content.lastname;
        // document.getElementById('personEmailDetail').innerHTML = content.email;
        // document.getElementById('personPasswordDetail').innerHTML = content.password;
        // document.getElementById('personadminDetail').innerHTML = content.isadmin.toString();
        // document.getElementById('personDobDetail').innerHTML = content.dob;
        // document.getElementById('personCdDetail').innerHTML = content.createdDate;
        // document.getElementById('personStreetDetail').innerHTML = content.address.street;
        // document.getElementById('personCityDetail').innerHTML = content.address.city;
        // document.getElementById('personPcDetail').innerHTML = content.address.postal_code;
        // }
    // };
    // xhttp.open('GET', '../assets/json/person.json', true);
    // xhttp.send();
// };
function displayPersonFiled() {
    
    var x = document.getElementById('address-pojo');
    var y = document.getElementById('person-pojo');
    x.style.display = 'none';
    y.style.display = 'block';
    
}
function displayAddressFiled() {
    
    var x = document.getElementById('address-pojo');
    var y = document.getElementById('person-pojo');
    x.style.display = 'block';
    y.style.display = 'none';
    
}

var content;
var text,row,td;
var address = ['street', 'city', 'pc'];
var person = ['id', 'firstname', 'lastname','dob', 'email', 'isadmin', 'createdDate'];

var readAddress = function () {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            content = JSON.parse(this.responseText);
            for (i=0; i< content.length; i++) {
                row = document.createElement('tr');
                var cc = i+1;
                row.setAttribute('id', content[i].id);
                row.setAttribute('onclick', 'displayAddress('+content[i].id+')');
                document.getElementById('address-table').appendChild(row);
                td = document.createElement('td');
                text = document.createTextNode(i+1);
                td.appendChild(text);
                for (var j=0; j<= address.length; j++ ) {
                    document.getElementById(content[i].id).appendChild(td);
                    td = document.createElement('td');
                    td.setAttribute('id', address[j]);
                    if (address[j] === 'street') {
                        text = document.createTextNode(content[i].street);
                    } else if (address[j] === 'city') {
                        text = document.createTextNode(content[i].city);
                    } else {
                        text = document.createTextNode(content[i].postal_code);
                    }
                    td.appendChild(text);
                }
                if (i==0) {
                    displayAddress(content[i].id);
                }
            }
        }
    };
    xhttp.open('GET', '../assets/json/address.json', true);
    xhttp.send();
};

function displayAddress(id) {

    var x = document.getElementById('address-manipulation');
    var y = document.getElementById('address-creation');
    x.style.display = 'block';
    y.style.display = 'none';
    var Row = document.getElementById('address-table').rows.namedItem(id);
    var Cells = Row.getElementsByTagName('td');
    document.getElementById('istreet').value = Cells[1].innerText;
    document.getElementById('icity').value = Cells[2].innerText;
    document.getElementById('ipostal-code').value = Cells[3].innerText;
}


var readPerson = function () {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            console.log(this.responseText);
            content = JSON.parse(this.responseText);
            for (i=0; i< content.length; i++) {
                row = document.createElement('tr');
                row.setAttribute('id', content[i].id);
                row.setAttribute('onclick', 'displayPerson('+content[i].id+')');
                document.getElementById('person-table').appendChild(row);
                td = document.createElement('td');
                text = document.createTextNode(i+1);
                td.appendChild(text);
                for (var j=0; j<= person.length; j++ ) {
                    document.getElementById(content[i].id).appendChild(td);
                    td = document.createElement('td');
                    td.setAttribute('id', person[j]);
                    if (person[j] === 'id') {
                        text = document.createTextNode(content[i].id);
                    } else if (person[j] === 'firstname') {
                        text = document.createTextNode(content[i].firstname);
                    } else if (person[j] === 'lastname') {
                        text = document.createTextNode(content[i].lastname);
                    } else if (person[j]=== 'dob'){
                        text = document.createTextNode(content[i].dob);
                    } else if (person[j] === 'email') {
                        text = document.createTextNode(content[i].email);
                    } else if (person[j] === 'isadmin') {
                        text = document.createTextNode(content[i].isadmin);
                    } else {
                        text = document.createTextNode(new Date(content[i].createdDate).toLocaleDateString());
                    }
                    td.appendChild(text);
                }
                if (i==0) {
                    displayPerson(content[i].id);
                }
            }
            readAddress();
        }
    };
    xhttp.open('GET', '../assets/json/person.json', true);
    xhttp.send();
};
function displayPerson(id) {

    var x = document.getElementById('person-manipulation');
    var y = document.getElementById('person-creation');
    x.style.display = 'block';
    y.style.display = 'none';
    var Row = document.getElementById('person-table').rows.namedItem(id);
    var Cells = Row.getElementsByTagName('td');
    document.getElementById('ifirstname').value = Cells[2].innerText;
    document.getElementById('ilastname').value = Cells[3].innerText;
    document.getElementById('idob').value = Cells[4].innerText;
    document.getElementById('iemail').value = Cells[5].innerText;
    document.getElementById('iadmin').value = Cells[6].innerText;
    document.getElementById('icreated-date').value = Cells[7].innerText;
}

function createPerson() {

    var x = document.getElementById('person-manipulation');
    var y = document.getElementById('person-creation');
    x.style.display = 'none';
    y.style.display = 'block';
}

function createAddress() {

    var x = document.getElementById('address-manipulation');
    var y = document.getElementById('address-creation');
    x.style.display = 'none';
    y.style.display = 'block';
}
