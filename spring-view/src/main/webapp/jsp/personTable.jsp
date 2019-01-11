<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<c:forEach var="personL" items="${personList}">
  <tr>
    <td><c:out value="${personL.getId()}"/></td>
    <td><c:out value="${personL.getFirstname()}"/></td>
    <td><c:out value="${personL.getLastname()}"/></td>
    <td><c:out value="${personL.getEmail()}"/></td>
    <td><c:out value="${personL.getDob()}"/></td>
    <td>
    <button class="delete" id="delete" type="button">delete</button>
    </td>
  </tr>
</c:forEach>
