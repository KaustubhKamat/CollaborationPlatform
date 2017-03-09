'use strict';
 
app.service('UserServices', ['$http','$q', '$rootScope', function($http,$q,$rootScope){
	
	console.log("Starting-->UserServices")
	
	var BASE_URL='http://localhost:8085/CollaborationPlatform/'
		
    return {
         fetchAllUsers:function(){
        	console.log("Starting--> fetchAllUsers function") 
        	 return $http.get(BASE_URL+'/getAllUsers').then(
        	function(Response){
        		console.log("Ending-->fetchAllUsers function")
        		return Response.data;	
        	},
        	null
        	 )
         },
            
            createNewUser: function(user){
            	console.log("Starting-->CreateNewUser function")
            	return $http.post(BASE_URL+'/createNewUser').then(
            	function(Response){
            		console.log("Ending-->CreateNewUser Function")
            		return Response.data;
            	},
            	function(errResponse){
            		console.log("The user is not created. Ending the CreateNewUser function ")
            		return $q.reject(errResponse);
            	}
            	)       	
            },
            
            updateUser: function(){
            	console.log("Starting--> updateUser function")
            	return $http.put(BASE_URL+'/UpdateUser',user).then(
            	function(Response){
            		console.log("Ending--> updateUser Function with success")
            		return Response.data;
            	},
            	function(errResponse){
            		console.log("Ending-->updateUser Function with errors")
            		return $sq.reject(errResponse);
            	}
            	)
            },
       
             
            authenticate: function(user){
            	console.log("Starting-->login function")
                    return $http.post(BASE_URL+'/login',user)
                            .then(
                                    function(response){
                                    	console.log("Ending-->loginUser function with success")
                                        return response.data;
                                    }, 
                                    function(errResponse){
                                        console.error('Ending-->loginUser function with errors');
                                        return $q.reject(errResponse);
                                    }
                            )
            },
             
            logoutUser: function(){
            	console.log("Starting-->logout function")
                    return $http.put(BASE_URL+'/')
                            .then(
                                    function(response){
                                    	console.log("Ending-->loginUser function with success")
                                        return response.data;
                                    }
                                   
                            )
            },
            
     
    }
    
            
           
 
}]);