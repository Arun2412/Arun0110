<%@include file="Header.jsp"%>
<div style="padding: 50px 40px 10px 10px; width: 300px; float: right;">
<h2>Sign Up Here</h2>
<table>
	<form:form action="toSignUp" method="POST" commandName="ClientKey">
		<tr><div class="form-group"> 
				<form:input type="email" path="emailid" class="form-control"
					id="exampleInputEmail" placeholder="Email Address" required=""/>
			</div></tr>
		<tr><div class="form-group">
				<form:input type="password" path="password" class="form-control"
					id="exampleInputPassword" placeholder="Password" required=""/>
			</div></tr>
		<tr><div class="form-group"> 
				<form:input type="address" path="address" class="form-control" id="exampleInputAddress"
					placeholder="Address" required=""/>
			</div></tr>
		<tr><div class="form-group"> 
				<form:input type="date" path="dob" class="form-control" id="exampleInputDOB"
					placeholder="Date Of Birth" required=""/>
			</div></tr>
		<tr><div class="form-group"> 
				<form:input type="text" path="name" class="form-control" id="exampleInputName"
					placeholder="Name" required=""/>
			</div></tr>
		<tr><div class="checkbox">
				<input type="checkbox">I hereby Confirm all
					the details are Valid
			</div></tr>
		<tr><div class="form-group">
				<button type="submit" class="btn btn-primary btn-block">SignUp</button>
			</div></tr>
	</form:form>
	</table>
	</div>
	<div class="container" style="float: left;">
		<br>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<img src=<c:url value="E:/collaboration all/collabworkspace1/bubblegum/src/main/resources/1.jpg"/> style=" width:400px; height:600px;">
				</div>

				<div class="item">
					<img src=<c:url value="E://collaboration all//collabworkspace1//bubblegum//src//main//resources//2.jpg"/>  style=" width:400px; height:600px;">
				</div>

				<div class="item">
					<img src=<c:url value="/resources/3.jpg"/>  style=" width:400px; height:600px;">
				</div>

				<div class="item">
					<img src=<c:url value="/resources/4.jpg"/>  style=" width:400px; height:600px;">
				</div>



				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
</div>
</div>
	<%@include file="footer.jsp"%>