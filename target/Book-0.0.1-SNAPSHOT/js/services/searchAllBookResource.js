(function(){
	"use strict";
	
	angular
		.module("commonServices")
		.factory("searchAllBookResource",["$resource",searchAllBookfn]);
	
	function searchAllBookfn($resource){
		return $resource("/books/search");
	}
	
	function getBookById(bookId){
		alert(bookId);
		return '';
	}
}());