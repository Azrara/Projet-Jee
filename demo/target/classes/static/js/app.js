var app=angular.module("myApp",[]);
app.controller("ProduitController",function($scope,$http){
    $scope.pageProduits=null;
    $scope.motCle="";
    $scope.pageCourante=0;
    $scope.size=5;
    $scope.pages=[];
	$scope.chercher=function(){
		
        $http.get("http://localhost:8080/chercher?mc="+$scope.motCle+"&page="+$scope.pageCourante+
        "&size="+$scope.size)
			.success(function(data){
                $scope.pageProduits=data;
                $scope.pages=new Array(data.totalPages);
			})
			.error(function(err){
				console.log(err);
			})
    }
    
    $scope.goToPage= function(p){
        $scope.pageCourante=p;
        $scope.chercher();
    }

});

