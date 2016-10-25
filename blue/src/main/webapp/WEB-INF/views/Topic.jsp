<%@include file="Header2.jsp"%>
<nav class="navbar navbar-default" role="navigation" style="float: left;">
  <div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav">
      <li class="active"><a href="#">View Topic</a></li>
      <li><a href="toAddTopic">Add Topic</a></li>
    </ul>
  </div>
</nav>
<div class="container">
  <div ng-app="myApp" ng-controller="dataCtrl">
Enter Name/Id: <input type="text"  ng-model="search">&nbsp&nbsp<span class="glyphicon glyphicon-search"></span>
    <hr></hr>
    <table class="table table-striped">
        <tr ng-repeat="resource in names | filter:search">
        <td><img src="resources/images/Topic{{resource.topicId}}.jpg" style="width:400px; height:400px"></td>
            <td><h2>{{resource.topicSubject}}</h2>
            <p>{{resource.topicDescription}}</p></td>
            <td><a href="toDeleteTopic?id={{resource.topicId}}"><span class="glyphicon glyphicon-trash"></span> Delete</a></td>
            <td><a href="toEditTopic?id={{resource.topicId}}"><span class="glyphicon glyphicon-edit"></span> Edit</a></td>
        </tr>    
    </table>
    
</div>
</div>
<script>
angular.module('myApp',[]).controller('dataCtrl',function($scope)
		{
	
		$scope.names=${TopicListKey};
		$scope.orderByMe=function(x)
		{
			$scope.myOrderBy=x;
			}
		});
</script>
<%@include file="footer.jsp"%>