<%@ include file="Header2.jsp" %>
<table align="center">
<form:form action="toAddBlog" commandName="AddPostKey" method="POST" enctype="multipart/form-data">
<tr>
<td style="font-size:20px; padding:20px;">Title:</td>
<td><form:input path="postSubject" style="width:300px; height:40px;" placeholder="Title"></form:input><form:errors path="postSubject" style="color:red;"></form:errors></td>
</tr>
<tr>
<td style="font-size:20px; padding:20px;">Description:</td>
<td><form:input path="postDescription" style="width:300px; height:40px;" placeholder="description"></form:input><form:errors path="postDescription" style="color:red;"></form:errors></td>
</tr>
<tr>
<td style="font-size:20px; padding:20px;">Image/Video:</td>
<td><input name="file" type="file" value="Choosefile" style="width:300px; height:40px;" required/></td>
</tr>
<tr>
<td><input type="submit" value="Add Blog" style="width:200px; height:40px; margin-left:3opx;"></input></td>
</tr>
</form:form>
</table>
<%@ include file="footer.jsp"%>