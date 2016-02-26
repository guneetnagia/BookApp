(function(){
	angular.module("bookApp")
		.controller(searchBookCtrl,['$stateParams','searchBookService',searchBookCtrlfn]);
	
	function searchBookCtrlfn($stateParams,searchBookService){
		var vm=this;
		vm.filterData={};
		vm.filterSearchData=function(){
			searchBookService.searchFilter(vm.filterData)
			.then(filterBookSuccess)
			.catch(filterBookError);
		}
		function filterBookSuccess(message){
			$location.path("/");
		}
		function filterBookError(errorMessage){
			console.log('error while filtering book' + errorMessage);
		}
	}
}());