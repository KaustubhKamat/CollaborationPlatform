app.controller('BlogController', [ 'BlogServices', '$http', '$rootscope',
		'$location', '$scope',
		function(BlogServices, $http, $rootscope, $location, $scope) {

			$scope.message = "Message from Blog Controller"
			console.log("Starting-->BlogController")

			var self = this;
			self.blog = {
				id : '',
				title : '',
				emailId :'',
			    description : '',
				date_time : '',
				status :'',
				reason : ''			
			}

			self.blogs = [];
			
			
			var currentUser=$rootscope.currentUser;
			
			//to get all the blogs
			self.fetchAllBlogs=function(){
	        	console.log("BlogController-->Starting fetchAllBlogs function")
	        
	        	BlogServices.fetchAllBlogs().then
	        	(
	        	function(Response)
	        	{
	        		console.log("BlogController-->Ending fetchAllBlogs function")
	        		self.blogs=Response;
	        	},
	        	function(errResponse)
	        	{
	        		console.log("BlogController-->Ending fetchAllJobs function")
	        		console.log("BlogController-->The jobs are not fetched successfully")
	        	}
	        	)
			
			},
			
			//to get blog with id
			self.blogById=function(){
	        	console.log("BlogController-->Starting blogById function")
	        
	        	BlogServices.blogById(id).then
	        	(
	        	function(d)
	        	{
	        		console.log("BlogController-->Ending blogById function")
	        		self.blog=d;
	        	},
	        	function(errResponse)
	        	{
	        		console.log("BlogController-->Ending blogById function")
	        		console.log("BlogController-->The blog with id is not fetched successfully")
	        	}
	        	)
			
			},
			
			
			//to create new blog
			self.SaveNewBlog=function(){
				console.log("BlogController-->Starting SaveNewJob function")
				
				BlogServices.SaveNewBlog(blog).then(
				function(d)
				{
					console.log("BlogController-->Ending CreateNewJob function")
					alert("The Blog is posted successfully")
				},
				
				function(errResponse)
				{
					alert("The Blog was not posted. Please try again after sometime")
					console.log("jobController ==> Ending createNewJob function()")

					console.log("Error while posting job,, please try again after sometime")
				}
				)
				
			},
			
			self.submit =function()
			{
				console.log("BlogController ==> Starting submit function()")

				self.SaveNewBlog(self.blog);
				self.reset();
				console.log("BlogController ==> Ending submit function()")

		};
			
			

		} ])/**
 * 
 */