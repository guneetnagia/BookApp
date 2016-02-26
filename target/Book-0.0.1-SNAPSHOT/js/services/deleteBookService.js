(function(){
	angular.module('commonServices')
		.factory('deleteBookService',['$http',deleteBookFunction]);
	
		function deleteBookFunction($http){
			return{
				deleteById:deleteById
			}
		
		function deleteById(bookId){
			return $http({
				method:'Delete',
				url:'/books/delete/' + bookId
			})
			.then(sendResponseData)
			.catch(sendGetBooksError);
		}
		
		function sendResponseData(response){
			return response.data;
		}
		function sendGetBooksError(response){
			return console.log('Error retrieving books (http status : '+response.status+')');
		}
	}
}());