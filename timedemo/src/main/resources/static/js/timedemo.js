angular.module('timeDemoApp', [])
  .controller('home', function($scope, $http) {
    $http.get('/cities/').success(function(data) {
        $scope.names = data;
      })

//      $scope.names = ["Detroit", "Melbourne", "Kuwait"];

      $scope.getTime = function() {
          console.log("I've been pressed!");
          $http.get("http://localhost:8080/time/" + $scope.selectedCity).then(
            function successCallback(response) {
            console.log(response.data);
              $scope.city = response.data;
            },
            function errorCallback(response) {
              console.log("Unable to perform get request");
            }
          );
        };
})