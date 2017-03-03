app.controller('UserController', [ '$scope', 'UserServices', '$location',
		'$rootscope', '$http', '$cookieStore',
		function($scope, UserServices, $location, $http, $cookieStore) {

			$scope.message("Message from User controller")
			console.log("Starting UserController")

			var self = this;

			self.user = {
				username : '',
				emailId : '',
				password : '',
				role : '',
				mobile : '',
				gender : '',
				status : '',
				reason : '',
				isOnline : '',
				errorCode:'',
				errorMessage:''
			}

			self.users=[];
			self.friendusers=[];
			
			self.fetchAllUsers=function(){
	        	console.log("UserController-->Starting fetchAllUsers function")
	        
	        	UserServices.fetchAllUsers().then
	        	(
	        	function(d)
	        	{
	        		console.log("UserController-->Ending fetchAllUsers function")
	        		self.jobs=d;
	        	},
	        	function(errResponse)
	        	{
	        		console.log("UserController-->Ending fetchAllJobs function")
	        		console.log("UserController-->The jobs are not fetched successfully")
	        	}
	        	)
			
			},
			
			
			self.jobById=function(){
	        	console.log("jobController-->Starting jobById function")
	        
	        	JobServices.jobById(id).then
	        	(
	        	function(d)
	        	{
	        		console.log("jobController-->Ending jobById function")
	        		self.jobs=d;
	        	},
	        	function(errResponse)
	        	{
	        		console.log("jobController-->Ending jobById function")
	        		console.log("jobController-->The job with id is not fetched successfully")
	        	}
	        	)
			
			},
			
			
			self.createNewUser=function(){
				console.log("UserController-->Starting CreateNewUser function")
				
				UserServices.createNewUser(user).then(
				function(d)
				{
					console.log("UserController-->Ending CreateNewUser function")
					alert("Thanks for your Registration.You have registered successfully")
				},
				
				function(errResponse)
				{
					console.log("UserController ==> Ending createNewUser function()")

					console.log("Error while creating user, please try again after sometime")
				}
				)
				
			},
			
			self.submit =function()
			{
				console.log("jobController ==> Starting submit function()")

				self.createNewJob(self.job);
				self.reset();
				console.log("jobController ==> Ending submit function()")

		};
			
			self.updateUser=function(){
				console.log("UserController-->Starting UpdateUser function")
				
				UserServices.updateUser(user).then(
				function(d)
				{
					console.log("UserController-->Ending updateJob function")
					alert("The User is updated successfully with id " +id)
				},
				
				function(errResponse)
				{
					console.log("UserController ==> Ending updateUser function()")

					console.log("Error while updating user, please try again after sometime")
				}
				)
				
			};
			
			self.login = function(user)
			{
				console.log("UserController ==> Starting createUser function()")
				UserServices.login(user).then
				(
						function(d)
						{
							self.user = d;
							if(self.user.errorCode =="404")
								{
									alert(self.user.errorMessage)
									self.emailId=''
									self.password=''
										console.log("UserController ==> Ending createUser function()")
									
								}
							else
								{
									$rootScope.currentUser = self.user
									$cookieStore.put("currentUser",self.user)
									$rootScope.username = self.user.username
									console.log("Logging in with Email :- "+$rootScope.currentUser.emailId)
									$rootScope.IsLoggedIn="true"
									if($rootScope.currentUser.role==='admin')
										{
												$rootScope.isAdmin="true"
												console.log("UserController ==> Login as "+$rootScope.currentUser.role)
												console.log("UserController ==> Ending createUser function()")
												$location.path('/adminhome')
										}
									else
										{
												$rootScope.showProfile="true"
													
												console.log("UserController ==> Login as "+$rootScope.currentUser.role)
												console.log("UserController ==> Ending createUser function()")
												$location.path('/userhome')	
										}
								}
						}
				)
}
			
				}])