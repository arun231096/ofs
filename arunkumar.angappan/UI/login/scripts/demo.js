
var readAddress = function () {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            addressContent = JSON.parse(this.responseText);
            table = createTable('addressTable-div');
            for (i=0; i< addressContent.length; i++) {
                row = createTableRow(i);
                row.setAttribute('onclick', 'displayAddress('+i+')');
                table.appendChild(row);
                var inp = generateCheckBox('address-delete', i+1);
                td = createTableData('checkbox');
                td.appendChild(inp);
                row.appendChild(td);
                td = createTableData('sno');
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
                    displayAddress(i);
                }
            }
        }
    };
    xhttp.open('GET', '../assets/json/address.json', true);
    xhttp.send();
};


var readPerson = function () {
    var xhttp = new XMLHttpRequest();
    xhttp.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
            personContent = JSON.parse(this.responseText);
            table = createTable('personTable-div');
            for (i=0; i< personContent.length; i++) {
                row = createTableRow(personContent[i].id);
                row.setAttribute('onclick', 'displayPerson('+personContent[i].id+')');
                table.appendChild(row);
                var inp = generateCheckBox('person-delete',personContent[i].id);
                td = createTableData('checkbox');
                td.appendChild(inp);
                row.appendChild(td);
                td = createTableData('sno');
                text = document.createTextNode(i+1);
                td.appendChild(text);
                for (var j=0; j<= person.length; j++ ) {
                    row.appendChild(td);
                    td = createTableData(person[j]);
                    var arrayjson = personContent[i];
                    for (x in arrayjson) {
                        if (person[j] === 'createdDate') {
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
    var arrayjson = addressContent[id];
    z = 0;
    for (x in arrayjson) {
        if (z < 3){
        arrayjson[address[z]] = document.getElementById(updateaddress[z+1]).value;
        }
        z++;
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
    var inp = generateCheckBox('person-delete',personId);
    row.appendChild(createTableData('checkbox').appendChild(inp));
    td = createTableData('sno');
    text = document.createTextNode(table.rows.length - 1);
    td.appendChild(text);
    row.appendChild(td);
    for (var j=0; j< person.length; ++j ) {
        td = createTableData(person[j]);
        if (person[j] === 'createdDate') {
            text = document.createTextNode(new Date().toLocaleDateString());
        } else if (person[j] === 'id') {
            text = document.createTextNode(personId);
        } else {
            text = document.createTextNode(document.getElementById(addPersonRecord[j-1]).value);
        }
        td.appendChild(text);
        row.appendChild(td);
    }
}

var addAddress = function() {

    z = 0;
    for (x in addressjson) {
        if (z < 3){
        addressjson[address[z]] = document.getElementById(addAddressRecord[z]).value;
        }
        z++;
    }
    addressContent[addressContent.length] = addressjson;
    console.log(addressContent);
}

var remove = function(field) {

    var checkbox = document.getElementsByName(field);
    for (i=0; i < checkbox.length; i++) {
        if (checkbox[i].checked) {
            if (field == 'person-delete'){
                document.getElementById('person-table')
                        .rows.namedItem(checkbox[i].value).style.display = 'none';
            } else {
                document.getElementById('address-table')
                        .rows.namedItem(checkbox[i].value).style.display = 'none';
            }
        }
    }
}
