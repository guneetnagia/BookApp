(function(){ 
	angular.module('commonServices')
		.factory('dataService',['$q','$http',dataService]);
	
	function dataService($q,$http){
		return {
			getAllBooks : getAllBooks,
			getExample : getExample
		};
		
		function getAllBooks(){
			return $http({
				method:'GET',
				url:'/books/search'
			})
			.then(sendResponseData)
			.catch(sendGetBooksError);
		}
		
		function sendResponseData(response){
			return response.data;
		}
		function sendGetBooksError(response){
			return $q.reject('Error retrieving books (http status : '+response.status+')');
		}
		
		function getExample(){
			return '';
		}
	}
}());