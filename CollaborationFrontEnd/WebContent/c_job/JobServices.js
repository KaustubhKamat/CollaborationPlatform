'use strict';
 
app.service('JobServices', ['$http','$q', '$rootScope', function($http,$q,$rootScope){
	
	console.log("Starting-->JobService")
	
	var BASE_URL='http://localhost:8085/CollaborationPlatform/'
		
    return {
         fetchAllJobs:function(){
        	console.log("Starting--> fetchAllJobs function") 
        	 return $http.get(BASE_URL+'/getAllJobs').then(
        	function(Response){
        		console.log("Ending-->fetchAllJobs Function")
        		return Response.data;	
        	},
        	null
        	 )
         },
         
         fetchAllOpenJobs:function(){
        	 console.log("Starting--> fetchAllOpenJobs function")
        	 return $http.get(BASE_URL+'/getAllOpenJobs').then(
        	function(Response){
        		console.log("Ending-->fetchAllOpenJobs function")
        		return Response.data;
        	}	 
        	 )
         },
            
            createNewJob: function(job){
            	console.log("Starting-->CreateNewJob function")
            	return $http.post(BASE_URL+'/createNewJob').then(
            	function(Response){
            		console.log("Ending-->CreateNewJob Function")
            		return Response.data;
            	},
            	function(errResponse){
            		console.log("The job is not posted. Ending the CreateNewJob function ")
            		return $q.reject(errResponse);
            	}
            	)       	
            },
            
            jobById: function(){
            	console.log("Starting--> jobById Function")
            	return $http.get(BASE_URL+'/getJobById' +id).then(
            			function(Response){
            				console.log("Ending-->jobById function")
            				return Response.data;
            			},
            			function(errResponse){
            				console.log("Ending-->jobById function")
            				return $q.reject(errResponse);
            			}
            			)	
            },
            
            updateJob: function(){
            	console.log("Starting--> updateJob function")
            	return $http.get(BASE_URL+'/UpdateJob',job).then(
            	function(Response){
            		console.log("Ending--> updateJob Function with success")
            		return Response.data;
            	},
            	function(errResponse){
            		console.log("Ending-->updateJob Function with errors")
            		return $sq.reject(errResponse);
            	}
            	)
            },
       
             
            rejectJobApplication: function(userID, jobID){
                    return $http.put(BASE_URL+'/rejectJobApplication/'+userID+ "/" + jobID)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while rejecting job');
                                        return $q.reject(errResponse);
                                    }
                            )
            },
             
            callForInterview: function(userID, jobID){
            	  return $http.put(BASE_URL+'/callForInterview/'+userID, jobID)
                            .then(
                                    function(response){
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Error while call for interview');
                                        return $q.reject(errResponse);
                                    }
                            )
            },
            
     
    }
    
            
           
 
}]);