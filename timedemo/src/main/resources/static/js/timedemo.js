angular.module('timeDemoApp', [])
  .controller('home', function($scope, $http) {
    $http.get('/cities/').success(function(data) {
        $scope.names = data;
        $scope.names2 = data;
        $scope.names3 = data;
      })

//      $scope.names = ["Detroit", "Melbourne", "Kuwait"];

      $scope.getTime = function() {
          console.log("I've been pressed!");
          $http.get("http://localhost:8080/time/" + $scope.selectedCity).then(
            function successCallback(response) {
              $scope.city = response.data;
              if(response.data.available == true) {
                $scope.city.backgroundCol = "green";
              } else {
                $scope.city.backgroundCol = "red";
              }
            },
            function errorCallback(response) {
              console.log("Unable to perform get request");
            }
          );
        };

        $scope.getTime2 = function() {
                  console.log("I've been pressed!");
                  $http.get("http://localhost:8080/time/" + $scope.selectedCity2).then(
                    function successCallback(response) {
                      $scope.city2 = response.data;
                      if(response.data.available == true) {
                        $scope.city2.backgroundCol = "green";
                      } else {
                        $scope.city2.backgroundCol = "red";
                      }
                    },
                    function errorCallback(response) {
                      console.log("Unable to perform get request");
                    }
                  );
                };

       $scope.getTime3 = function() {
                 console.log("I've been pressed!");
                 $http.get("http://localhost:8080/time/" + $scope.selectedCity3).then(
                   function successCallback(response) {
                     $scope.city3 = response.data;
                     if(response.data.available == true) {
                       $scope.city3.backgroundCol = "green";
                     } else {
                       $scope.city3.backgroundCol = "red";
                     }
                   },
                   function errorCallback(response) {
                     console.log("Unable to perform get request");
                   }
                 );
               };
})
