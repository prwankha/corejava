<html class="bg">
<title>Registration</title>
<link href="css/Style.css" rel="stylesheet">
<body>
	<a href="IndexPage.jsp">Back</a>
	<br>
	<div align="center">
		<form name="CalSalForm" action="CalculateSalary">
			<hr>
			<h1>Salary Calculation</h1>
			<hr>
			<table>
				<tr>
					<td>Associate Id</td>
					<td><input type="number" name="associateId"></td>
				</tr>
				<tr>
					<td><input type="Submit" name="Calculate" value="Submit"></td>
					<td><input type="Reset" value="Reset" name="Reset"></td>
				</tr>
			</table>
			<hr>
		</form>
	</div>
	<div align="center">
		<b><font size="5px" color="blue">Associate salary calculated successfully</font></b>
		<br>
		<table>
			<tr>
				<th>Net Salary</th>
				<td>${requestScope.salary.netSalary}</td>
			</tr>
			<tr>
				<th>Monthly Tax</th>
				<td>${requestScope.salary.monthlyTax}</td>
			</tr>
		</table>
	</div>
	<div align="right">Capgemini India</div>
</body>
</html>