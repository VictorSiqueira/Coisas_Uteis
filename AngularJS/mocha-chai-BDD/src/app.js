var app = angular.module('app',[]);

app.controller('TodoController', function($scope){
   $scope.todos = [];
    
    $scope.addTodo = function (title, completed) {
        $scope.todos.push({
            title: title,
            completed: completed
        });        
    };
});