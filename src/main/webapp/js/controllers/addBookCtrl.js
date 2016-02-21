(function(){
	"use strict";
	angular.module("bookApp")
		.controller('addBookCtrl',['$location','addBookService',addBookfunction]);
	
	function addBookfunction($location,addBookService){
		var vm=this;
		vm.newBook = {};
		vm.addNewBook = function(){
			addBookService.addBook(vm.newBook)
				.then(addBookSuccess)
				.catch(addBookError);
		};
		function addBookSuccess(message){
			$location.path("/");
		}
		function addBookError(errorMessage){
			console.log('error while adding new book' + errorMessage);
		}
	}
}());