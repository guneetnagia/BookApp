(function(){
	angular.module("commonServices")
		.factory('searchBookService',['$http',searchBookServiceFn]);
	
	function searchBookServiceFn($http){
		return{
			searchFilter:searchFilter
		}
		function searchFilter(filterData){
			return $http({
				method:'POST',
				url:'/books/filterSearch',
				data:filterData
			})
			.then(findBookSuccess)
			.catch(findBookFail);
		}
		function findBookSuccess(response){
			return 'Book Search Success';
		}
		function findBookFail(response){
			return 'Book Search Fail ' + response.status;
		}
	}
}());