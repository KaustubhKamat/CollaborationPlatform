var app = angular.module('myApp', ['ngRoute']);
app.config(function($routeProvider) {
	$routeProvider

	.when('/', {
		templateUrl : 'Home.html'
		
	})
	
	.when('/login', {
		templateUrl : 'c_user/login.html',
			controller : 'UserController'
			
		
	})
	
	
	
	
	
	
	
	
	
	
	
		});