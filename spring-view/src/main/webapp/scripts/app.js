var app = {};

app.init= function() {
    console.log('app');
    app.createChildren();
    app.createView();
    app.setView();
    app.listenEvents();
    app.setDefault();
}

app.createChildren = function () {
    lsp.createChildren();
    rsp.createChildren();
}

app.createView = function () {
    lsp.createView();
    rsp.createView();
}

app.setView = function() {
    document.getElementById('app').innerHTML = lsp.view;
    document.getElementById('app').innerHTML += rsp.view;
}

app.listenEvents = function () {
    lsp.listenEvents();
}

app.setDefault =  function() {

    lsp.setDefault();
}