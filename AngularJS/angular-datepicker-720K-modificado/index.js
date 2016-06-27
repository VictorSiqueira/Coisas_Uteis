/*global angular*/


var app = angular.module('720kb', ['ngRoute','720kb.datepicker']);

app.controller('TesteController', function($scope){
    $scope.data = "a";
	$scope.some = false;

	window.setTimeout(function () {
		$scope.some = true;
	}, 3000);
});

$("#datepicker").datepicker({
    beforeShow: function (input, inst) {
        setTimeout(function () {
            inst.dpDiv.css({
                top: 100,
                left: 200
            });
        }, 0);
    }
});