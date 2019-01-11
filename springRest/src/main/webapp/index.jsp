<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <%@ jsp:include page ="html/personForm.jsp" %>
    <%@ jsp:include page ="html/personInfopanel.jsp" %>
    <%@ jsp:include page ="html/personList.jsp" %>
    <%@ jsp:include page ="html/personpanel.jsp" %>
    <%@ jsp:include page ="html/personTable.jsp" %>

<html>
  <head>
    <title> Dashboard </title>
    <link rel="icon" href="assets/img/logo.png" type="image/png" />
    <link rel="stylesheet" type="text/css" href="styles/dashboard.css" />
  </head>
  <body onload="app.init()" id="bg">
    <div class="container">
      <div id="app" class="app-class"></div>
      <%@ 
        jsp:include page ="html/lsp.jsp"
       %>
    </div>
    <!-- <script src="scripts/app.js"></script>
    <script src="scripts/lsp.js"></script>
    <script src="scripts/rsp.js"></script>
    <script src="scripts/em.js"></script>
    <script src="scripts/service.js"></script>  -->
  </body>
</html>
