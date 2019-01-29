<html class="bg">
<title>Payroll Portal</title>
<link href="css/Style.css" rel="stylesheet">
<body>
	<a href="IndexPage.jsp">Back</a>
	<div align="center">
		<form name="GetAssociateForm" action="GetAssociate">
			<hr>
			<h1>Associate Information</h1>
			<hr>
			<table>
				<tr>
					<td>Associate Id</td>
					<td><input type="number" name="associateId"></td>
				</tr>
				<tr>
					<td><input type="Submit" name="Display" value="Submit"></td>
					<td><input type="Reset" value="Reset" name="Reset"></td>
				</tr>
			</table>
			<hr>
		</form>
		<div align="center">
			<font size="10px" color="white">Associate Details : </font>
			<table>
				<tr>
					<th>Associate Id</th>
					<td>${requestScope.associate.associateId}</td>
				</tr>
				<tr>
					<th>First Name</th>
					<td>${requestScope.associate.firstName}</td>
				</tr>
				<tr>
					<th>Last Name</th>
					<td>${requestScope.associate.lastName}</td>
				</tr>
				<tr>
					<th>Email Id</th>
					<td>${requestScope.associate.emailId}</td>
				</tr>
				<tr>
					<th>Pancard</th>
					<td>${requestScope.associate.pancard}</td>
				</tr>
				<tr>
					<th>Department</th>
					<td>${requestScope.associate.department}</td>
				</tr>
				<tr>
					<th>Designation</th>
					<td>${requestScope.associate.designation}</td>
				</tr>
				<tr>
					<th>Yearly Investment Under 80C</th>
					<td>${requestScope.associate.yearlyInvestmentUnder80C}</td>
				</tr>
				<tr>
					<th>Account number</th>
					<td>${requestScope.associate.bankDetails.accountNumber}</td>
				</tr>
				<tr>
					<th>Bank Name</th>
					<td>${requestScope.associate.bankDetails.bankName}</td>
				</tr>
				<tr>
					<th>IFSC Code</th>
					<td>${requestScope.associate.bankDetails.ifscCode}</td>
				</tr>
				<tr>
					<th>Net Salary</th>
					<td>${requestScope.associate.salary.netSalary}</td>
				</tr>
				<tr>
					<th>Monthly Tax</th>
					<td>${requestScope.associate.salary.monthlyTax}</td>
				</tr>
			</table>
		</div>
	</div>
	<div align="right">Capgemini India</div>
</body>
</html>