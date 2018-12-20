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
var addressContent;
var personContent;
var text,row,td, table;
var address = ['street', 'city', 'postal_code'];
var person = ['id', 'firstname', 'lastname','dob', 'email', 'isadmin', 'createdDate'];
var updateaddress = [ "iAddressId", "istreet", "icity", "ipostal-code" ];
var updateperson = [ "iPersonId", "ifirstname", "ilastname", "idob", "iemail", "iadmin" , "icreated-date" ];
var personTableHead = ["Remove", "S.no", "Emp.Id", "First Name", "last Name", "DOB", "Email", "Admin", "Join Date"];
var addressTableHead = ["S.no", "Street", "City", "Postal Code"];
var addPersonRecord = ["pc-firstname", "pc-lastname", "pc-dob", "pc-email", "pc-admin"];
var addAddressRecord = [ "ac-street", "ac-city", "ac-postal-code" ];
var personDeleteIcon = document.createElement("img");
personDeleteIcon.setAttribute("src", "../assets/img/remove.png");
personDeleteIcon.setAttribute("class", "remove icon");
var addressDeleteIcon = document.createElement("img");
addressDeleteIcon.setAttribute("src", "../assets/img/remove.png");
addressDeleteIcon.setAttribute("class", "remove icon");

var displayPersonFiled = function () {

    var x = document.getElementById('address-pojo');
    var y = document.getElementById('person-pojo');
    x.style.display = 'none';
    y.style.display = 'block';
}

var displayAddressFiled = function () {

    var x = document.getElementById('address-pojo');
    var y = document.getElementById('person-pojo');
    x.style.display = 'block';
    y.style.display = 'none';
}

var generateCheckBox = function(name, value) {
     var inp = document.createElement("input");
     inp.setAttribute("type", "checkbox");
     inp.setAttribute("name", name);
     inp.setAttribute("value", value);
     return inp;
}

var createTable = function (field) {

    if (field === 'addressTable-div') {
        table = document.createElement('table');
        table.setAttribute("id", "address-table");
        row = createTableRow("addressTableHeader");
        table.appendChild(row);
        for (var i =0; i< addressTableHead.length; i++) {
            th = document.createElement('th');
            if(i == 0) {
                th.appendChild(addressDeleteIcon);
            } else {
                th.appendChild(document.createTextNode(addressTableHead[i]));
            }
            row.appendChild(th);
        }
    }
    if (field === 'personTable-div') {
        table = document.createElement('table');
        table.setAttribute("id", "person-table");
        row = row = createTableRow("personTableHeader");
        table.appendChild(row);
        for (var i =0; i< personTableHead.length; i++) {
            th = document.createElement('th');
            if(i == 0) {
                th.appendChild(personDeleteIcon);
            } else {
                th.appendChild(document.createTextNode(personTableHead[i]));
            }
            row.appendChild(th);
        }
    }
    document.getElementById(field).appendChild(table);
    return table;
}

var createTableRow = function(id) {
    row = document.createElement("tr");
    row.setAttribute("id", id);
    return row;
}

var createTableData =  function(id) {
    td = document.createElement("td");
    td.setAttribute("id", id);
    return td;
}

var readAddress = function () {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            addressContent = JSON.parse(this.responseText);
            table = createTable("addressTable-div");
            for (i=0; i< addressContent.length; i++) {
                row = createTableRow(addressContent[i].id);
                row.setAttribute('onclick', 'displayAddress('+addressContent[i].id+')');
                table.appendChild(row);
                var inp = generateCheckBox("address-delete",addressContent[i].id);
                row.appendChild(createTableData("checkbox").appendChild(inp));
                td = createTableData("sno");
                text = document.createTextNode(i+1);
                td.appendChild(text);
                for (var j=0; j<= address.length; j++ ) {
                    row.appendChild(td);
                    td = createTableData(address[j]);
                    var arrayjson = addressContent[i];
                    for (x in arrayjson) {
                        text = document.createTextNode(arrayjson[address[j]]);
                    }
                    td.appendChild(text);
                }
                if (i==0) {
                    displayAddress(addressContent[i].id);
                }
            }
        }
    };
    xhttp.open('GET', '../assets/json/address.json', true);
    xhttp.send();
};

var displayAddress = function (id) {

    var x = document.getElementById('address-manipulation');
    var y = document.getElementById('address-creation');
    x.style.display = 'block';
    y.style.display = 'none';
    var Row = document.getElementById('address-table').rows.namedItem(id);
    var Cells = Row.getElementsByTagName('td');
    for (var i = 0; i < updateaddress.length; i++) {
        document.getElementById(updateaddress[i]).value = Cells[i].innerText;
    }
}

var readPerson = function () {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            personContent = JSON.parse(this.responseText);
            table = createTable("personTable-div");
            for (i=0; i< personContent.length; i++) {
                row = createTableRow(personContent[i].id);
                row.setAttribute('onclick', 'displayPerson('+personContent[i].id+')');
                table.appendChild(row);
                var inp = generateCheckBox("person-delete",personContent[i].id);
                row.appendChild(createTableData("checkbox").appendChild(inp));
                td = createTableData("sno");
                text = document.createTextNode(i+1);
                td.appendChild(text);
                for (var j=0; j<= person.length; j++ ) {
                    row.appendChild(td);
                    td = createTableData(person[j]);
                    var arrayjson = personContent[i];
                    for (x in arrayjson) {
                        if (person[j] === "createdDate") {
                            text = document.createTextNode(new Date(arrayjson[person[j]]).toLocaleDateString());
                        } else { text = document.createTextNode(arrayjson[person[j]]); }
                    }
                    td.appendChild(text);
                }
                if (i==0) {
                    displayPerson(personContent[i].id);
                }
            }
            readAddress();
        }
    };
    xhttp.open('GET', '../assets/json/person.json', true);
    xhttp.send();
};

var displayPerson = function (id) {

    var x = document.getElementById('person-manipulation');
    var y = document.getElementById('person-creation');
    x.style.display = 'block';
    y.style.display = 'none';
    var Row = document.getElementById('person-table').rows.namedItem(id);
    var Cells = Row.getElementsByTagName('td');
    for (var i = 0; i < updateperson.length; i++) {
        document.getElementById(updateperson[i]).value = Cells[i+1].innerText;
    }
}

var createPerson = function () {

    var x = document.getElementById('person-manipulation');
    var y = document.getElementById('person-creation');
    x.style.display = 'none';
    y.style.display = 'block';
}

var createAddress = function () {

    var x = document.getElementById('address-manipulation');
    var y = document.getElementById('address-creation');
    x.style.display = 'none';
    y.style.display = 'block';
}

var updatePersonDetail = function() {

    var id =document.getElementById('iPersonId').value;
    var Row = document.getElementById('person-table').rows.namedItem(id);
    var Cells = Row.getElementsByTagName('td');
    for (var i = 0; i < updateperson.length; i++) {
        Cells[i+1].innerText = document.getElementById(updateperson[i]).value;
    }
}

var updateAddressDetail = function() {

    var id =document.getElementById('iAddressId').value;
    var Row = document.getElementById('address-table').rows.namedItem(id);
    var Cells = Row.getElementsByTagName('td');
    for (var i = 0; i < updateaddress.length; i++) {
        Cells[i].innerText = document.getElementById(updateaddress[i]).value;
    }
}

var addPerson = function() {

    table = document.getElementById('person-table');
    var lastRowCells = table.rows[ table.rows.length - 1 ].getElementsByTagName('td');
    var personId = lastRowCells[1].innerHTML;
    personId++;
    var addressId = addressContent[addressContent.length -1].id + 1;
    row = createTableRow(personId);
    row.setAttribute('onclick', 'displayPerson('+personId+')');
    table.appendChild(row);
    var inp = generateCheckBox("person-delete",personId);
    row.appendChild(createTableData("checkbox").appendChild(inp));
    td = createTableData("sno");
    text = document.createTextNode(table.rows.length - 1);
    td.appendChild(text);
    row.appendChild(td);
    for (var j=0; j< person.length; ++j ) {
        td = createTableData(person[j]);
        if (person[j] === "createdDate") {
            text = document.createTextNode(new Date().toLocaleDateString());
        } else if (person[j] === 'id') {
            text = document.createTextNode(personId);
        } else {
            text = document.createTextNode(document.getElementById(addPersonRecord[j-1]).value);
        }
        td.appendChild(text);
        row.appendChild(td);
    }
    // table = document.getElementById('address-table');
    // row = document.createElement('tr');
    // row.setAttribute('id', addressId);
    // row.setAttribute('onclick', 'displayPerson('+addressId+')');
    // table.appendChild(row);
    // td = document.createElement('td');
    // text = document.createTextNode(table.rows.length - 1);
    // td.appendChild(text);
    // for (var j=0; j<= address.length; j++ ) {
        // row.appendChild(td);
        // td = document.createElement('td');
        // td.setAttribute('id', address[j]);
        // if (address[j] === 'street') {
            // text = document.createTextNode(document.getElementById('pc-city').value);
        // } else if (address[j] === 'city') {
            // text = document.createTextNode(document.getElementById('pc-street').value);
        // } else {
            // text = document.createTextNode(document.getElementById('pc-postalcode').value);
        // }
        // td.appendChild(text);
    // }
    // document.getElementById('pc-password');
}

var addAddress = function() {

    table = document.getElementById('address-table');
    var lastRowCells = table.rows[ table.rows.length - 1 ].getElementsByTagName('td');
    var addressId = lastRowCells[0].innerHTML;
    addressId++;
    row = createTableRow(addressId);
    row.setAttribute('onclick', 'displayPerson('+addressId+')');
    table.appendChild(row);
    var inp = generateCheckBox("address-delete",addressId);
    row.appendChild(createTableData("checkbox").appendChild(inp));
    td = createTableData("sno");
    text = document.createTextNode(table.rows.length - 1);
    td.appendChild(text);
    row.appendChild(td);
    for (var j=0; j<= address.length; j++ ) {
        td = createTableData(address[j]);
        text = document.createTextNode(document.getElementById(addAddressRecord[j]).value);
        td.appendChild(text);
        row.appendChild(td);
    }
}

var remove = function(field) {

    var checkbox = document.getElementsByName(field);
    for (i=0; i < checkbox.length; i++) {
        if (checkbox[i].checked) {
            if (field == "person-delete"){
                document.getElementById('person-table')
                        .rows.namedItem(checkbox[i].value).style.display = 'none';
            } else {
                document.getElementById('address-table')
                        .rows.namedItem(checkbox[i].value).style.display = 'none';
            }
        }
    }
}
