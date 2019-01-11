<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<div class="entity-info-panel">
  <form class="form" id="form">
    <label class="customize-label">id : </label>
    <input class="textbox-prop" 
           id="id" 
           type="number" 
           placeholder="id" 
           tabindex=1
           value=<c:out value="${personList.get(0).getId()}" />
           />
    <label class="customize-label">First name : </label>
    <input class="textbox-prop" 
           id="firstName" 
           type="text" 
           placeholder="First name" 
           tabindex=2
           value=<c:out value="${personList.get(0).getFirstName()}" />
           />
    <label class="customize-label">Last name : </label>
    <input class="textbox-prop" 
           id="lastName" 
           type="text" 
           placeholder="Last name" 
           tabindex=3
           value=<c:out value="${personList.get(0).getLastName()}" />
           />
    <label class="customize-label">Email : </label>
    <input class="textbox-prop" 
           id="email" 
           type="email" 
           placeholder="john@abc.com" 
           tabindex=4
           value=<c:out value="${personList.get(0).getEmail()}" />
           />
    <label class="customize-label">Birthdate : </label>
    <input class="textbox-prop" 
           id="birth_date" 
           type="text" 
           placeholder="dd-mm-yyyy" 
           tabindex=5
           value=<c:out value="${personList.get(0).getDob()}" />
           />
    <button class="submit" type="button" id="submit">submit</button>
    <button class="reset" type="button" id="reset">Reset</button>
  </form>
</div>
<script type="text/javascript">
var personInfoPanel = {};
var personKeys = ['id', 'firstName', 'lastName', 'email', 'birth_date'];

personInfoPanel.createChildren = function() {}

personInfoPanel.createView = function() {
    personInfoPanel.view = service.doGet('html/personInfoPanel.html');
}

personInfoPanel.prePopulate = function() {}

personInfoPanel.listenEvents = function() {
    eventManager.subscribe('personSelected', onPersonSelect);
    eventManager.subscribe('personAdded', onPersonAdd);
    document.getElementById('submit').addEventListener('click', personSubmitted);
}

personInfoPanel.setDefault = function () {}

var onPersonAdd = function () {
    for(i = 0; i< personKeys.length; i++) {
        document.getElementById(personKeys[i]).value = '';
    }
    document.getElementById('id').disabled = true;
};

var personSubmitted = function () {
    var temp = {};
    var person = [];
    for(i = 0; i< personKeys.length; i++) {
        temp[personKeys[i]] = document.getElementById(personKeys[i]).value;
    }
    person.push(temp);
    eventManager.broadcast('personSubmitted', person);
};

var onPersonSelect = function(tableRow) {
    for(i = 0; i < personKeys.length; i++) {
        document.getElementById(personKeys[i]).value = tableRow.cells[i].innerHTML;
        var current = document.getElementsByClassName('active-row');
        if (current.length > 0) { 
            current[0].className = current[0].className.replace(' active-row', '');
        }
        tableRow.className += ' active-row';
    }
    document.getElementById('id').disabled = true
};
</script>