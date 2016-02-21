(function(){
	angular.module('commonServices')
		.factory('editBookService',['$http',BookServiceEdit]);
	
	function BookServiceEdit($http){
		return {
			getBookById:getBookById,
			updateBookDetails:updateBookDetails
		}
		function getBookById(bookId){
			return $http({
				method:'GET',
				url:'/books/search/id/' + bookId
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
		
		function updateBookDetails(bookId,bookName,bookAuthor,bookPrice){
			return $http({
				method:'PUT',
				url:'/books/edit/'+bookId+'/'+bookName+'/'+bookAuthor+'/'+bookPrice
			})
			.then(updatedSuccessFullyMethod)
			.catch(updatedFailedMethod);
		}
		
		function updatedSuccessFullyMethod(response){
			return response.data;
		}
		
		function updatedFailedMethod(response){
			console.log('Error updating books (http status : '+response.status+')');
		}
	}
}());