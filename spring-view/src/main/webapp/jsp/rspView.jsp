<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="right-side-panel" id="rsp">
    <%@ include file="personPanel.jsp" %>
</div>
<script type="text/javascript">
var rsp = {};

rsp.createChildren = function() {}

rsp.createView = function() {
    /* rsp.View = service.doGet('html/rspView.jsp'); */
}

rsp.prePopulate = function() {};

rsp.listenEvents = function () {
    eventManager.subscribe('entitySelected', onSelectEntity);
}

rsp.setDefault = function() {}

var onSelectEntity = function(entity) {
    if(entity === 'person'){
        personPanel.init();
    } else if(entity === 'address'){
        addressPanel.init();
    }
}
</script>