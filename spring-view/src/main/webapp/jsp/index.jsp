<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
  <head>
    <title>Dashboard</title>
  </head>
  <body onload="init()">
    <div class="app" id="app">
    <%@ include file="lspView.jsp" %>
    <%@ include file="rspView.jsp" %>
    </div>
  </body>
  <style>
  body{
  margin: 0;
}

.page-heading{
  position: sticky;
  top: 0;
  float: left;
  width: 100%;
  height: 50px;
  font-size: 20px;
  background-color: #00796B;
  background-size: cover;
  color: #FFFFFF;
  text-align: left;
  z-index: 5;
}
.left-side-panel{
  position: absolute;
  left: 0;
  width: 10%;
  height: 100vh;
  /* box-shadow: 5px 0px 5px -5px #BFBFBF; */
}

.menu-options{
  position: absolute;
  top: 10%;
  padding: 0;
  margin: 0;
  width: 100%;
}

.entity-list{
  border-bottom: 1px solid #BFBFBF;
  font-size: 30px;
  display: block;
  text-align: center;
  word-wrap: break-word;
}

.entity-list:hover{
  background-color: #BFBFBF;
  cursor: pointer;
  width: 100%;
}

.active{
  color: #1A73E8;
}


.right-side-panel{
  position: relative;
  left: 10%;
  height:100vh;
  width: 90%;
  background-color: #ECF0F5;
}

.list-panel{
  position: absolute;
  top: 3%;
  left: 0.5%;
  width:99%;
  height: 45vh;
  overflow: auto;
  box-shadow: 0px 2px 5px 1px #BFBFBF;
  border-radius: 5px;
  border-top: 5px solid #00A65A;
  background-color: #FFFFFF;
}

.table{
  position: absolute;
  width: 80%;
  height: auto;
  left: 5%;
  top: 10%;
  border: 1px solid #BFBFBF;
}

th{
  text-transform: uppercase;
}

tbody tr:hover{
  outline : 3px solid #00A65A;
  cursor: pointer;
}

td,th{
  width: 10%;
  height: 5vh;
  text-align:left;
  border: 1px solid #BFBFBF;
  border-collapse: collapse;
}

.active-row{
  color: #5100DE;
}
.entity-info-panel {
  position: absolute;
  top: 52%;
  left: 0.5%;
  box-shadow: 0px 2px 5px 1px #BFBFBF;
  width: 99%;
  height: 44vh;
  border-radius: 5px;
  border-top: 5px solid #00A65A;
  background-color: #FFFFFF;
}

.customize-label{
  position: relative;
  top: 8vh;
  left: 2%;
  width: 8%;
  display: block;
}

.textbox-prop{
  position: relative;
  top: 5vh;
  left: 15%;
  display: block;
  border: none;
  border-bottom: 1px solid #BFBFBF;
  outline: none;
  height: 7%;
}

.textbox-prop:focus{
  border-bottom : 2px solid #1A73E8;
}

.submit{
  position: absolute;
  border: none;
  border-radius: 5px;
  top: 80%;
  left: 75%;
  height: 50px;
  width: 10%;
  background-color: #1A73E8;
  color: #FFFFFF;
  outline: none;
  cursor: pointer;
}

.reset{
  position: absolute;
  border: none;
  border-radius: 5px;
  top: 80%;
  left: 86%;
  height: 50px;
  width: 10%;
  background-color: #1A73E8;
  color: #FFFFFF;
  outline: none;
  cursor: pointer;
}

#add{
  position: fixed;
  top: 40%;
  left: 90%;
  width: 5%;
  cursor: pointer;
}

.delete{
  background-color: #B34800;
  width: 30%;
  border : none;
  border-radius: 5px;
  width: 50%;
  height: 90%;
  color: #FFFFFF;
  outline: none;
  font-size: 90%;
  cursor: pointer;
}

@media (max-width : 1300px) {

  .list-panel {
    height: 40vh;
    top: 1%;
  }
  
  .entity-info-panel{
    height: 40vh;
  }
  
  .textbox-prop{
    top: 0;
    left: 25%;
  }
  
  .customize-label{
    top: 3vh;
    width: 20%;
  }
  
  .submit{
    left: 10%;
    width: 40%;
  }
  
  .reset{
    left: 52%;
    width: 40%;
  }
  #add{
    position: fixed;
    top: 35%;
    left: 30%;
    width: 50%;
  }
  
  .delete{
    width: 100%;
  }
}
  </style>
</html>