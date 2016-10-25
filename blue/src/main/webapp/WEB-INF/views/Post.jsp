<%@include file="Header2.jsp"%>
<nav class="navbar navbar-default" role="navigation" style="float: left;">
  <div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">View Posts</a></li>
      <li><a href="toAddPost">Add Post</a></li>
    </ul>
  </div>
</nav>
<div class="container">
  <div ng-app="myApp" ng-controller="dataCtrl">
Enter Name/Id: <input type="text"  ng-model="search">&nbsp&nbsp<span class="glyphicon glyphicon-search"></span>
    <hr></hr>
    <table class="table table-striped">
        <tr ng-repeat="resource in names | filter:search">
        <td><img src="resources/images/Post{{resource.postId}}.jpg" style="width:400px; height:400px"></td>
            <td><h2>{{resource.postSubject}}</h2>
            <p>{{resource.postDescription}}</p></td>
            <td><a href="toDeletePost?id={{resource.postId}}"><span class="glyphicon glyphicon-trash"></span> Delete</a></td>
            <td><a href="toEditPost?id={{resource.postId}}"><span class="glyphicon glyphicon-edit"></span> Edit</a></td>
        </tr>
    </table>
</div>
</div>
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
	
		$scope.names=${PostListKey};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>
<%@include file="footer.jsp"%>