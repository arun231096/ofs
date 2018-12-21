var em = {};

em.boradCast = function(panel, item) {
    if (item === 'person') {
        rsp.createPersonPanel();
    } else if (item === 'address') {
        rsp.createAddressPanel();
    }
}

em.onselectedList = function(item, row) {
    if (item === 'person') {
        rsp.onselectedListPerson(row);
    } else if (item === 'address') {
        rsp.onselectedListAddress(row);
    }
}
em.add = function(item) {
    if(item === 'person') {
        rsp.addPersonFields();
    }else if (item === 'address') {
        rsp.addAddressFields();
    }
}
em.onSave = function(item, operation) {
    if (item === 'person') {
        if (operation === 'update') {
            rsp.updatePerson();
        } else if (operation === 'add') {
            rsp.addPerson();
        }
    }else if (item === 'address') {
        if (operation === 'update') {
            rsp.updateAddress();
        } else if (operation === 'add') {
            rsp.addAddress();
        }
    }
}