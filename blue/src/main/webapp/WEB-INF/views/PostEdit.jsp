<%@include file="Header2.jsp"%>
<div class="container">
	<hr></hr>
	<table class="table table-striped">
		<tr>
			<th>Id</th>
			<th>Subject</th>
			<th>Description</th>
			<th>Image</th>
		</tr>
		<tr>
			<form:form action="toUpdatePost" commandName="PostEditKey" method="post" enctype="multipart/form-data">
				<td><form:input value="${PostEditKey.postId}" path="postId" type="hidden" /></td>
				<td><form:input value="${PostEditKey.postSubject}" path="postSubject" /></td>
				<td><form:input value="${PostEditKey.postDescription}" path="postDescription" /></td>
				<td><img src="resources/images/Post${PostEditKey.postId}.jpg" style="width: 100px; height: 100px">
				<input name="file" type="file" value="Choosefile" style="width:300px; height:40px;" required/></td>
				<td><input type="submit" value="update"></td>
			</form:form>
		</tr>
	</table>
</div>
<%@include file="footer.jsp"%>