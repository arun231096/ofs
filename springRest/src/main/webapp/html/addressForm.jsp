<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="div form" id="addressForm">
  <input type="hidden" name="id" id="addressId" />
  <input type="text" class="input" name="street" id="street" placeholder="Enter street" />
  <input type="text" class="input" name="city" id="city" placeholder="Enter city" />
  <input type="text" class="input" name="postal-code" id="postal-code" placeholder="Enter postal code" />
  <div align="right" class="div save">
    <button class="button" id="save-button" onclick="updateAddressDetail()">Save</button>
  </div>
</div>