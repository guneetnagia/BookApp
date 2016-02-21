(function(){
	angular
		.module("bookApp")
		.controller("DeleteBookCtrl",['$location','$stateParams','deleteBookService',DeleteBookfn]);
			function DeleteBookfn($location,$stateParams,deleteBookService){
				var vm=this;
				vm.bookId = $stateParams.bookId;
				
				deleteBookService.deleteById(vm.bookId)
					.then(deleteSuccessFunction)
					.catch(deleteErrorFunction)
					.finally(deleteFinallyFunction)
					
					function deleteSuccessFunction(message){
						console.log('successfully deleted '+ message);
						$location.path('/');
					}
					function deleteErrorFunction(){
						console.log('Error inside DeleteFunction controller')
					}
					function deleteFinallyFunction(){
						console.log('finally method inside DeleteFunction controller');
					}
			}
}());