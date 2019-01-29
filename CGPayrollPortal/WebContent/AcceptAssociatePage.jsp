<html class="bg">
<head>
<title>Registration</title>
<link href="css/Style.css" rel="stylesheet">
</head>
<body>
	<a href="IndexPage.jsp">Back</a>
	<br>
	<div align="center">
		<form name="AcceptForm" action="accept">
			<hr>
			<h1>Registration</h1>
			<hr>
			<table>
				<tr>
					<td>First Name</td>
					<td><input type="text" name="firstName"></td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td><input type="text" name="lastName"></td>
				</tr>
				<tr>
					<td>Email Id</td>
					<td><input type="text" name="emailId"></td>
				</tr>
				<tr>
					<td>Department</td>
					<td><input type="text" name="department"></td>
				</tr>
				<tr>
					<td>Designation</td>
					<td><input type="text" name="designation"></td>
				</tr>
				<tr>
					<td>Pan Number</td>
					<td><input type="text" name="pancard"></td>
				</tr>
				<tr>
					<td>Bank Name</td>
					<td><input type="text" name="bankName"></td>
				</tr>
				<tr>
					<td>Account No</td>
					<td><input type="number" name="accountNumber"></td>
				</tr>
				<tr>
					<td>Bank ifscCode</td>
					<td><input type="number" name="ifscCode"></td>
				</tr>
				<tr>
					<td>Yearly Investment80C</td>
					<td><input type="number" name="yearlyInvestmentUnder80C"></td>
				</tr>
				<tr>
					<td>basic Salary</td>
					<td><input type="number" name="basicSalary"></td>
				</tr>
				<tr>
					<td>EPF</td>
					<td><input type="number" name="epf"></td>
				</tr>
				<tr>
					<td>Company PF</td>
					<td><input type="number" name="companyPf"></td>
				</tr>
				<tr>
					<td><input type="Submit" name="Register" value="Submit"></td>
					<td><input type="Reset" value="Reset" name="Reset"></td>
				</tr>
			</table>
			<hr>
		</form>
	</div>
	<div align="center">
	<font color="red" size="5px" >${requestScope.error }</font>
	<font color="green" size="5px">${requestScope.success }</font></div>
	<div align="right">Capgemini India</div>
</body>
</html>