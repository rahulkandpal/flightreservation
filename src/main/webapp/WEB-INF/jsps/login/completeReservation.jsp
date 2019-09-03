<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Reservation</title>
</head>
<body>
<h2>Complete Reservation</h2>

Airline : ${flight.operatingAirlines } <br/>
Airline : ${flight.departureCity }<br/>
Airline : ${flight.arrivalCity }<br/>

<form action="completeReservation" method="post">
<pre>
<h2>Passenger Details</h2>

First name: <input type="text" name="passengerFirstName"/>
Last name: <input type="text" name="passengerLastName"/>
Email: <input type="text" name="passengerEmail"/>
Phone: <input type="text" name="passengerPhone"/>

<h2>Card Detail</h2>


Name on card: <input type="text" name="nameOnCard"/>
Card No: <input type="text" name="cardNumber"/>
Expiry Date: <input type="text" name="expirationDate"/>
Security code: <input type="text" name="securitycode"/>

<input type="hidden" name="flightId" value="${flight.id }"/>
<input type="submit" value="confirm"/>
</pre>
</form>

</body>
</html>