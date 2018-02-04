<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
<head>
<title>NAI</title>
</head>
<body>
	<form action="/person" method="get">
		<button name="back">Back</button>
	</form>
	<h2>Edit person</h2>
	<div style="width: 50%">
		<form action="/person/update/+ ${person.id}" object="${person}" method="post">
			<div>
				<label> Username : <input type="text" name="name"
					value="${person.name}" />
				</label>
			</div>
			<div>
				<input type="submit" value="Edit" />
			</div>
		</form>
		<table border="0">
			<c:forEach items="${person.addresses}" var="address">
				<tr>
					<td style="padding: 5px">${address.country}</td>
					<td style="padding: 5px">${address.postalCode}</td>
					<td style="padding: 5px">${address.city}</td>
					<td style="padding: 5px">${address.street}</td>
					<td style="padding: 5px">${address.houseNo}</td>

					<td>
						<form
							action="/address/delete?addressId= + ${address.id} + &personId= + ${person.id}"
							method="post" object="${address}">
							<button name="remove">Remove</button>
						</form>
					</td>
				</tr>
			</c:forEach>

		</table>


	</div>
	<div style="width: 50%">
		<form action="/address/+ ${person.id}" object="${address}"
			method="post">
			<div>
				<label> Country : <input type="text" name="country" />
				</label> <label> Postal Code : <input type="text" name="postalCode" />
				</label> <label> City : <input type="text" name="city" />
				</label> <label> Street : <input type="text" name="street" />
				</label> <label> House No : <input type="text" name="houseNo" />
				</label>
			</div>
			<div>
				<input type="submit" value="Add address" />
			</div>

		</form>
	</div>
</body>
</html>