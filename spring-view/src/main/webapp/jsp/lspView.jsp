<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="left-side-panel" id="lsp">
  <p class="menu-options">
    <a class="entity-list active" id="person">Person</a>
    <a class="entity-list" id="address">Address</a>
  </p>
</div>

<script type="text/javascript">
var lsp = {};

lsp.createChildren = function() {}

lsp.createView = function() {
    /* lsp.view = service.doGet('html/lspView.jsp'); */
}

lsp.prePopulate = function() {}

lsp.listenEvents = function() {
    document.getElementById('person').addEventListener('click', personSelect);
    document.getElementById('address').addEventListener('click', addressSelect);
}

lsp.setDefault = function() {
    eventManager.broadcast('entitySelected', 'person');
}

var personSelect = function() {
    eventManager.broadcast('entitySelected', 'person');
    var current = document.getElementsByClassName('active');
    if (current.length > 0) { 
      current[0].className = current[0].className
      .replace(' active', '');
    }
    this.className += ' active';
}

var addressSelect = function() {
    eventManager.broadcast('entitySelected', 'address');
    var current = document.getElementsByClassName('active');
    if (current.length > 0) { 
      current[0].className = current[0].className.replace(' active', '');
    }
    this.className += ' active';
}
</script>
