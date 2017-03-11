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
	
	.when('/Logout', {
		templateUrl : 'c_common/Home.html',
			controller : 'UserController'		
	})
	
	.when('/Register',{
		templateUrl :'c_user/Register.html',
			controller : 'UserController'
	})
	
	
	//admin related mapping
	.when('/adminhome',{
		templateUrl:'c_admin/adminHome.html',
			controller : 'UserController'
	})
	
	//user related mapping
	.when('/UserList',{
		templateUrl:'c_admin/UserList.html',
			controller : 'UserController'
	})
	
	.when('/userHome',{
		templateUrl:'c_user/userHome.html'
	})
	
	.when('/myProfile',{
		templateUrl:'c_user/MyProfile.html',
			controller : 'UserController'
	})
	
	.when('/Home', {
		redirectTo :'/'
		
	})
	
	
	
	
	
	
	
	
	
		});