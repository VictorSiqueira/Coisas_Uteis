var app = angular.module('app', ['app2']);

app.controller('CalculatorController', function ($scope, MathService) {

    $scope.doSquare = function () {
        $scope.answer = MathService.multiply($scope.number, $scope.number);
        console.log("ta puxando do externo");
    };

    $scope.doCube = function () {
        $scope.answer = MathService.multiply($scope.number, MathService.multiply($scope.number, $scope.number));
    };
});