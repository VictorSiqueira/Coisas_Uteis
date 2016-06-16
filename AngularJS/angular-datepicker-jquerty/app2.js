var app = angular.module('app', ['720kb.datepicker']);


app.controller('TesteController', function($scope){
	$scope.some = false;

	window.setTimeout(function () {
		$scope.some = true;
	}, 3000);
});

