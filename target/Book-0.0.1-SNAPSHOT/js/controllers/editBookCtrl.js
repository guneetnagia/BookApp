(function(){
	"use strict";
	angular.module("bookApp")
		.controller("editBookCtrl",['$location','$stateParams','editBookService',editBookfn]);
	
	function editBookfn($location,$stateParams,editBookService){
		var vm=this;
		vm.bookId=$stateParams.bookId;
		
		
			editBookService.getBookById(vm.bookId)
				.then(getBookByIdSuccess)
				.catch(getBookByIdCatch)
				.finally(getBookByIdFinally)
				
				function getBookByIdSuccess(data){
					console.log(data);
					vm.EditBookProduct=data;
				}
				function getBookByIdCatch(){
					console.log('Error in getBookByIdFinally');
				}
				function getBookByIdFinally(){
					console.log('Finally in getBookByIdFinally');
				}
				
				
			vm.saveBook = function(newBookId,newBookName,newBookAuthor,newBookPrice){
				vm.newBookName=newBookName;
				vm.newBookAuthor=newBookAuthor;
				vm.newBookPrice=newBookPrice;
				editBookService.updateBookDetails(vm.bookId,vm.newBookName,vm.newBookAuthor,vm.newBookPrice)
					.then(updateBookSuccess)
					.catch(updateBookError);
			}
			
			function updateBookSuccess(message){
				console.log('successfully updated' + message);
				$location.path('/');
			}
			function updateBookError(errorMessage){
				console.log('Error Message' + errorMessage);
			}
	}
}());