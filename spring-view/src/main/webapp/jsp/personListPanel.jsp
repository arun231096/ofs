<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="list-panel" id="listPanel">
  <table class="table" id="table">
    <thead>
      <tr>
        <th>id</th>
        <th>First name</th>
        <th>Last name</th>
        <th>email</th>
        <th>Birth date</th>
      </tr>
    </thead>
    <tbody>
      <%@ include file="personTable.jsp" %>
    </tbody>
  </table>
  <button class="submit" type="button" id="add" onclick="reset()">Add</button>
</div>
