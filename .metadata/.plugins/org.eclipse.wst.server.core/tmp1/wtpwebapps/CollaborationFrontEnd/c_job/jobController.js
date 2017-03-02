app.controller('JobController', [ 'JobServices', '$http', '$rootscope',
		'$location', '$scope',
		function(JobServices, $http, $rootscope, $location, $scope) {

			$scope.message = "Message from Job Controller"
			console.log("Starting-->JobController")

			var self = this;
			self.job = {
				id : '',
				title : '',
				qualification : '',
				description : '',
				status : '',
				date_time : ''
			}

			self.jobs = [];
			self.jobApplied = {
				id : '',
				username : '',
				jobId : '',
				date_applied : '',
				status : ''
			}
			
			var currentUser=$rootscope.currentUser;
			
			self.fetchAllJobs=function(){
	        	console.log("jobController-->Starting fetchAllJobs function")
	        
	        	JobServices.fetchAllJobs().then
	        	(
	        	function(Response)
	        	{
	        		console.log("jobController-->Ending fetchAllJobs function")
	        		self.jobs=Response;
	        	},
	        	function(errResponse)
	        	{
	        		console.log("jobController-->Ending fetchAllJobs function")
	        		console.log("jobController-->The jobs are not fetched successfully")
	        	}
	        	)
			
			},
			
			self.fetchAllOpenJobs=function(){
	        	console.log("jobController-->Starting fetchAllOpenJobs function")
	        
	        	JobServices.fetchAllOpenJobs().then
	        	(
	        	function(d)
	        	{
	        		console.log("jobController-->Ending fetchAllOpenJobs function")
	        		self.jobs=d;
	        	},
	        	function(errResponse)
	        	{
	        		console.log("jobController-->Ending fetchAllOpenJobs function")
	        		console.log("jobController-->The open jobs are not fetched successfully")
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
			
			
			self.createNewJob=function(){
				console.log("jobController-->Starting CreateNewJob function")
				
				JobServices.createNewJob(job).then(
				function(d)
				{
					console.log("jobController-->Ending CreateNewJob function")
					alert("The Job is posted successfully")
				},
				
				function(errResponse)
				{
					console.log("jobController ==> Ending createNewJob function()")

					console.log("Error while posting job,, please try again after sometime")
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
			
			self.updateJob=function(){
				console.log("jobController-->Starting UpdateJob function")
				
				JobServices.updateJob(job).then(
				function(d)
				{
					console.log("jobController-->Ending updateJob function")
					alert("The Job is updated successfully with id " +id)
				},
				
				function(errResponse)
				{
					console.log("jobController ==> Ending updateJob function()")

					console.log("Error while updating job,, please try again after sometime")
				}
				)
				
			};

		} ])