var lsp = {};

lsp.createChildren = function() {
    console.log('lsp created');
}

lsp.createView = function(){
    service.doGet('GET','html/lsp.jsp', false);
    lsp.setView();
}

lsp.setView = function () {
    lsp.view = service.response;
}

lsp.listenEvents = function () {

    document.getElementById('person-link').setAttribute('onclick', 'lsp.onItemSelected("person")');
    document.getElementById('address-link').setAttribute('onclick', 'lsp.onItemSelected("address")');
}

lsp.setDefault =  function() {

    var personField = document.getElementById('person-link');
    personField.addEventListener('click', lsp.onItemSelected('person'));
}

lsp.onItemSelected = function (field) {
    em.boradCast('panel', field);
}
