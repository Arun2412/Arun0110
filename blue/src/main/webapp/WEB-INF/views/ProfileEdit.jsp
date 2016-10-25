<%@include file="Header2.jsp"%>
<div class="container">
	<hr></hr>
	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Address</th>
			<th>Date Of Birth</th>
			<th>Email</th>
		</tr>
		<tr>
			<form:form action="toUpdateProfile" commandName="ClientEditKey" method="post" enctype="multipart/form-data">
				<td><form:input value="${ClientEditKey.clientid}" path="clientid" type="hidden" /></td>
				<td><form:input value="${ClientEditKey.name}" path="name" /></td>
				<td><form:input value="${ClientEditKey.address}" path="address" /></td>
				<td><form:input value="${ClientEditKey.dob}" path="dob" /></td>
				<td><form:input value="${ClientEditKey.emailid}" path="emailid" /></td>
				<td><img src="resources/images/${ClientEditKey.clientid}.jpg" style="width: 100px; height: 100px">
				<input name="file" type="file" value="Choosefile" style="width:300px; height:40px;" required/></td>
				<td><input type="submit" value="update"></td>
			</form:form>
		</tr>
	</table>
</div>
<%@include file="footer.jsp"%>