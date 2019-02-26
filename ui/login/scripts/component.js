var addressContent;
var personContent;
var text,row,td, table;
var address = ['street', 'city', 'postal_code'];
var person = ['id', 'firstname', 'lastname','dob', 'email', 'isadmin', 'createdDate'];
var updateaddress = [ 'iAddressId', 'istreet', 'icity', 'ipostal-code' ];
var updateperson = [ 'iPersonId', 'ifirstname', 'ilastname', 'idob', 'iemail', 'iadmin' , 'icreated-date' ];
var personTableHead = ['Remove', 'S.no', 'Emp.Id', 'First Name', 'last Name', 'DOB', 'Email', 'Admin', 'Join Date'];
var addressTableHead = ['Remove', 'S.no', 'Street', 'City', 'Postal Code'];
var addPersonRecord = ['pc-firstname', 'pc-lastname', 'pc-dob', 'pc-email', 'pc-admin'];
var addAddressRecord = [ 'ac-street', 'ac-city', 'ac-postal-code' ];
var personDeleteIcon = document.createElement('img');
personDeleteIcon.setAttribute('src', '../assets/img/remove.png');
personDeleteIcon.setAttribute('class', 'remove icon');
var addressDeleteIcon = document.createElement('img');
addressDeleteIcon.setAttribute('src', '../assets/img/remove.png');
addressDeleteIcon.setAttribute('class', 'remove icon');
var addressjson = { 'id':'', 'street':'', 'city':'', 'postal_code':'' };
var personjson = {'id':'', 'firstname':'', 'lastname':'','dob':'', 'email':'', 'isadmin':'', 'createdDate':'', 'address':                       addressjson};
var addressAttributes = ["personlink", "h-link", "loadPersonFiled()", "Address"];
var personAttributes = ["personlink", "h-link", "loadPersonFiled()", "Person"];
var hyperLinks = [ personAttributes, addressAttributes];

var generateDiv = function(cls, id) {

    var div= document.createElement("div");
    div.setAttribute("class", cls);
    div.setAttribute("id", id);
    return div;
}

var constructLsp = function() {

    var hyperlink = function() {
        var attributes = ["id", "class", "onclick"];
        for (i= 0; i< hyperLinks.length; i++) {
            var div = generateDiv("link", "navigationLinks");
            var field = hyperLinks[i];
            var anchor = document.createElement("a");
            anchor.setAttribute("href", "#");
            for (j= 0; j<field.length; j++) {
                if ((field.length -1) == j) {
                    anchor.appendChild(document.createTextNode(field[j]));
                } else {
                    anchor.setAttribute(attributes[j], field[j]);
                }
            }
            div.appendChild(anchor);
            document.getElementById('links').appendChild(div);
        }
    }();
    constructRsp();
}

var constructRsp = function () {

        document.getElementById("details-container").appendChild(createSearch());
        document.getElementById("details-container").appendChild(createListDiv());
        document.getElementById("details-container").appendChild(createAddRemoveElements());
        document.getElementById("details-container").appendChild(createInfoDiv());
}

var createSearch = function() {
        div = generateDiv("div", "search-bar");
        div.setAttribute("align", "right");
        var inp= generateinput("text", "search-box","search", "input srch");
        inp.setAttribute("placeholder", "Search");
        div.appendChild(inp);
        return div;
}

var createListDiv=  function() {
    div = generateDiv("list-panel", "listPanel");
    div.appendChild(createTable("address"));
    // div.appendChild(createTable("person"));
    return div;
}
var createAddRemoveElements = function(field) {
    div = generateDiv("add div", "manipulationDivision");
    div.setAttribute("align", "right");
    div = addressButtons();
    return div;
}

var addressButtons = function() {
        var inp = generateinput("button", "removeButton", "removeAddress","button");
        inp.setAttribute("onclick", "remove('address')");
        inp.setAttribute("value", "Remove");
        div.appendChild(inp);
        inp = generateinput("button", "addButton", "addAddress","button");
        inp.setAttribute("onclick", "add('address')");
        inp.setAttribute("value", "Add");
        div.appendChild(inp);
        return div;
};

var createInfoDiv = function() {
    div = generateDiv("div insert", "infoPanel");
    return div;
}

var addressUpdateFileds= function() {
    div = generateDiv("div form", "form");
    
}

var loadPersonFiled = function () {

    var x = document.getElementById('address-pojo');
    var y = document.getElementById('person-pojo');
    x.style.display = 'none';
    y.style.display = 'block';
}

var loadAddressFiled = function () {

    var x = document.getElementById('address-pojo');
    var y = document.getElementById('person-pojo');
    x.style.display = 'block';
    y.style.display = 'none';
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

var generateinput = function(type, id, name, cls) {
     var inp = document.createElement('input');
     inp.setAttribute('id', id);
     inp.setAttribute('name', name);
     inp.setAttribute('type', type);
     inp.setAttribute('class', cls);
     return inp;
}

var createTable = function (field) {

    if (field === 'address') {
        table = document.createElement('table');
        table.setAttribute('id', 'address-table');
        row = createTableRow('addressTableHeader');
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
    if (field === 'person') {
        table = document.createElement('table');
        table.setAttribute('id', 'person-table');
        row = row = createTableRow('personTableHeader');
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
    return table;
}

var createTableRow = function(id) {
    row = document.createElement('tr');
    row.setAttribute('id', id);
    return row;
}

var createTableData =  function(id) {
    td = document.createElement('td');
    td.setAttribute('id', id);
    return td;
}


var displayAddress = function (id) {

    var x = document.getElementById('address-manipulation');
    var y = document.getElementById('address-creation');
    x.style.display = 'block';
    y.style.display = 'none';
    // var Row = document.getElementById('address-table').rows.namedItem(id);
    // var Cells = Row.getElementsByTagName('td');
        document.getElementById(updateaddress[0]).value = id;
        var arrayjson = addressContent[id];
        z = 0;
        for (x in arrayjson) {
            if (z < 3){
            console.log(arrayjson[address[z]]);
            document.getElementById(updateaddress[z+1]).value = arrayjson[address[z]];
            }
            z++;
        }
}

var displayPerson = function (id) {

    var x = document.getElementById('person-manipulation');
    var y = document.getElementById('person-creation');
    x.style.display = 'block';
    y.style.display = 'none';
    var Row = document.getElementById('person-table').rows.namedItem(id);
    var Cells = Row.getElementsByTagName('td');
    for (var i = 0; i < updateperson.length; i++) {
        document.getElementById(updateperson[i]).value = Cells[i+2].innerText;
    }
}