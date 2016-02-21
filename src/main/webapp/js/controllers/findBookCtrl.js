(function(){
	angular.module('bookApp')
		.controller('findBookCtrl',['findBookService','$location','$stateParams',findBookfn]);
	
	function findBookfn(findBookService,$location,$stateParams){
		var vm=this;
		vm.filterItem={};
		vm.searchFilter=function(){
			findBookService.findByAll(vm.filterItem);
		}
	}
}());