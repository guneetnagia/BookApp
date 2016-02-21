(function(){
	angular.module('commonServices')
		.factory('findBookService',['$http','$q',findBookServiceFn]);
	
	function findBookServiceFn($http,$q){
		return{
			findByAll:findByAll
		}
		
		function findByAll(filterItem){
			var title = filterItem.title;
			var author=filterItem.author;
			var priceGreater = filterItem.priceGreater;
			var priceLess = filterItem.priceLess;
			console.log(filterItem);
			
			return $http({
				method:'POST',
				url:'books/search/filter',
				data:filterItem
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
	}
}());