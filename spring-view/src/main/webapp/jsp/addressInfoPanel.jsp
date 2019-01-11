<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<div class="entity-info-panel">
  <form class="form" id="form">
    <label class="customize-label">id : </label>
    <input class="textbox-prop" id="id" type="text" placeholder="id" tabindex=1/>
    <label class="customize-label">Street : </label>
    <input class="textbox-prop" id="street" type="text" placeholder="Street" tabindex=2/>
    <label class="customize-label">City : </label>
    <input class="textbox-prop" id="city" type="text" placeholder="City" tabindex=3/>
    <label class="customize-label">Postal code : </label>
    <input class="textbox-prop" id="postalcode" type="text" placeholder="Postal Code" tabindex=4/>
    <button class="submit" type="button" id="submit">submit</button>
    <button class="reset" type="button" id="reset">Reset</button>
  </form>
</div>
<script src="scripts/address/addressInfoPanel.js"></script>