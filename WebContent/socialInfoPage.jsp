
<!DOCTYPE html >
<html>
<body>
	<div align="center">
		<form name="socialInfoForm" method="post"
			action="SocialInfoServlet">
			<h2>Welcome ${requestScope.bean.firstName}</h2>
			<table>
				<tr>
					<td>Enter Movie Name</td>
					<td><input type="text" name="movieName"></td>
				</tr>
				<tr>
					<td>Enter FruitName</td>
					<td><input type="text" name="fruitName"></td>
				</tr>
				<tr>
					<td>Enter BookName</td>
					<td><input type="text" name="bookName"></td>
				</tr>
				<tr>
					<td><input type="hidden" name="firstName" value="${requestScope.bean.firstName}"></td>
				</tr>
				<tr>
					<td><input type="hidden" name="lastName" value="${requestScope.bean.lastName}"></td>
				</tr>
				<tr>
					<td><input type="submit" name="submit" value="Submit">
					</td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>