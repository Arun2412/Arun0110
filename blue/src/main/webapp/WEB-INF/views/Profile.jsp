<%@include file="Header2.jsp"%>
<nav class="navbar navbar-default" role="navigation"
	Style="width: 200px; float: left;">
	<div class="container-fluid">
	<ul class="nav navbar-nav">
		<li><a href="toEditProfile?id=${ClientKey.clientid}">Edit Profile</a></li>
		<li><a href="#">View Friends</a></li>
	</ul>
	</div>
</nav>
<div class="container">
	<div ng-app="myApp" ng-controller="dataCtrl">
		<hr></hr>
		<table class="table table-striped">
			<tr>
				<th>Image</th>
				<th>Details</th>
			</tr>
			<tr>Client${ClientKey.clientid}.jpg
				<td><img src="resources/images/Client${ClientKey.clientid}.jpg" style="width: 400px; height: 400px"></td>
				<td><h3><b>Name:</b>${ClientKey.name}</h3>
					<br>
				<br><h3><b>Address:</b>${ClientKey.address}</h3>
					<br>
				<br><h3><b>Email:</b>${ClientKey.emailid}</h3>
					<br>
				<br><h3><b>Date Of Birth:</b>${ClientKey.dob}</h3></td>
			</tr>
		</table>
	</div>
</div>
<script>
	angular.module('myApp', []).controller('dataCtrl', function($scope) {

		$scope.names = $
		{
			ClientKey
		}
		;
		$scope.orderByMe = function(x) {
			$scope.myOrderBy = x;
		}
	});
</script>
<%@include file="footer.jsp"%>