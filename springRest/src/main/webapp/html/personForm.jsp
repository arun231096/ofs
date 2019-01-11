<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="div form" id="personForm">
  <input type="hidden" name="id" id="iPersonId" />
  <input type="text" class="input" name="firstname" id="firstname" placeholder="Enter Firstname" />
  <input type="text" class="input" name="lastname" id="lastname" placeholder="Enter Lastname" />
  <input type="text" class="input" name="dob" id="dob" placeholder="DOB : DD-MM-YYYY" />
  <input type="text" class="input" name="email" id="email" placeholder="Enter Email" />
  <input type="text" class="input" name="admin" id="admin" placeholder="Enter Admin detail" />
  <input type="hidden" class="input" name="street" id="street" placeholder="Enter street" />
  <input type="hidden" class="input" name="city" id="city" placeholder="Enter city" />
  <input type="hidden" class="input" name="postal-code" id="postal-code" placeholder="Enter postal code" />
  <div align="right" class="div save">
    <button class="button" id="save-button">Save</button>
  </div>
</div>