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
			<form:form action="toUpdateTopic" commandName="TopicEditKey" method="post" enctype="multipart/form-data">
				<td><form:input value="${TopicEditKey.topicId}" path="topicId" type="hidden" /></td>
				<td><form:input value="${TopicEditKey.topicSubject}" path="topicSubject" /></td>
				<td><form:input value="${TopicEditKey.topicDescription}" path="topicDescription" /></td>
				<td><img src="resources/images/Topic${TopicEditKey.topicId}.jpg" style="width: 100px; height: 100px">
				<input name="file" type="file" value="Choosefile" style="width:300px; height:40px;" required/></td>
				<td><input type="submit" value="update"></td>
			</form:form>
		</tr>
	</table>
</div>
<%@include file="footer.jsp"%>