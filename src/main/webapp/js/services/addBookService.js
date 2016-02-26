(function(){
	angular.module('commonServices')
		.factory('addBookService',['$http',addBookfunction]);
	
	function addBookfunction($http){
		return{
			addBook:addBook
		}
		function addBook(newBook){
			return $http({
				method:'POST',
				url:'books/add',
				data:newBook
			})
			.then(addBookSuccess)
			.catch(addBookFail)
		}
		function addBookSuccess(response){
			return 'Book Added';
		}
		function addBookFail(response){
			return 'Book Not Added ' + response.status;
		}
	}
}());