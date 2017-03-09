var app = angular.module('myApp', [ 'ngRoute','ngCookies']);
app.config(function($routeProvider) {
	$routeProvider

	.when('/', {
		templateUrl : 'c_common/Home.html'
		
	})
	
	.when('/login', {
		templateUrl : 'c_user/login.html',
			controller : 'UserController'
			
		
	})
	.when('/Register',{
		templateUrl :'c_user/Register.html',
			controller : 'UserController'
	})
	
	.when('/adminhome',{
		templateUrl:'c_admin/adminHome.html'
	})
	
	.when('/Home', {
		redirectTo :'/'
		
	})
	
	
	
	
	
	
	
	
	
		});