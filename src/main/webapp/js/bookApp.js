(function(){
	"use strict";
	var myApp = angular.module("bookApp",["commonServices","ui.router"]); 
	myApp.config(["$stateProvider","$urlRouterProvider",
	              	function($stateProvider,$urlRouterProvider){
		
		$urlRouterProvider.otherwise("/");
		
		$stateProvider
			.state('beerbreak',{
				url:"/break",
				templateUrl:"../views/break.html"
			})
			.state('home',{
				url:"/",
				templateUrl:"../views/welcomeView.html",
				controller:"welcomeViewCtrl as vm"
			})
			.state('addBook',{
				url:"/addBook",
				templateUrl:"../views/addBook.html",
				controller:"addBookCtrl as addBook"
			})
			.state('editBook',{
				url:"/editBook/:bookId",
				templateUrl:"../views/editBook.html",
				controller:"editBookCtrl as editCtrl"
			})
			.state('searchBook',{
				url:"/searchBook",
				templateUrl:"../views/findBook.html",
				controller:"findBookCtrl as findCtrl"
			})
			.state('deleteBook',{
				url:"/deleteBook/:bookId",
				templateUrl:"../views/deleteBook.html",
				controller:"DeleteBookCtrl as delvm"
			})
			.state('about',{
				url:"/aboutme",
				templateUrl:"../views/about.html"
			})
	}]);
}());