var scotchApp = angular.module('scotchApp', ['ngRoute']);

    // configure our routes
    scotchApp.config(function($routeProvider) {
        $routeProvider

            // route for the home page
            .when('/', {
                templateUrl : 'pages/home.html',
                controller  : 'MainController'
            })
            // route for the about page
            .when('/about', {
                templateUrl : 'pages/about.html',
                controller  : 'AboutController'
            })
            // route for the contact page
            .when('/contact', {
                templateUrl : 'pages/contact.html',
                controller  : 'ContactController'
            })
            .otherwise({
                redirectTo: '/login'
            });
    });
    scotchApp.run(function ($rootScope, $location) {
        $rootScope.$on("$routeChangeStart", function (event, next, current) {
            console.log("não sei pra que serve");
        });
    });


    // create the controller and inject Angular's $scope
    scotchApp.controller('MainController', function($scope) {
        // create a message to display in our view
        console.log("entrou no main");
        $scope.message = 'Everyone come and see how good I look!';
    });

    scotchApp.controller('AboutController', function($scope) {
        console.log("entrou no about");
        $scope.message = 'Look! I am an about page.';
    });

    scotchApp.controller('ContactController', function($scope) {
        console.log("entrou no contact");
        $scope.message = 'Contact us! JK. This is just a demo.';
    });