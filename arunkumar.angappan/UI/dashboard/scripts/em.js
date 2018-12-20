var em = {};

em.boradCast = function(panel, item) {
    if (item === 'person') {
        rsp.createPersonPanel();
    }
}

em.onselectedList = function(item, row) {
    if (item === 'person') {
        rsp.onselectedListPerson(row);
    }
}