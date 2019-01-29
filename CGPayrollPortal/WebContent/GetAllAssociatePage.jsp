<%@taglib prefix="m" uri="http://java.sun.com/jsp/jstl/core"%>
<html class="bg">
<title>Payroll Portal</title>
<link href="css/Style.css" rel="stylesheet">
<body>
	<div align="center">
		<h1>Associate Data</h1>
		<form action="GetAllAssociates">
			<input type="submit" value="Get Data">
		</form>
		<table>
			<tr>
				<th>Associate Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Email Id</th>
				<th>Pan card</th>
				<th>Department</th>
				<th>Designation</th>
				<th>Yearly Investment Under 80C</th>
				<th>Account number</th>
				<th>Bank Name</th>
				<th>IFSC Code</th>
				<th>Net Salary</th>
				<th>Monthly Tax</th>
			</tr>
			<m:forEach var="associates" items="${requestScope.associates}">
				<tr>
					<td>${associates.associateId}</td>
					<td>${associates.firstName}</td>
					<td>${associates.lastName}</td>
					<td>${associates.emailId}</td>
					<td>${associates.pancard}</td>
					<td>${associates.department}</td>
					<td>${associates.designation}</td>
					<td>${associates.yearlyInvestmentUnder80C}</td>
					<td>${associates.bankDetails.accountNumber}</td>
					<td>${associates.bankDetails.bankName}</td>
					<td>${associates.bankDetails.ifscCode}</td>
					<td>${associates.salary.netSalary}</td>
					<td>${associates.salary.monthlyTax}</td>
				</tr>
			</m:forEach>
		</table>

	</div>
	<div align="right">Capgemini India</div>
</body>
</html>