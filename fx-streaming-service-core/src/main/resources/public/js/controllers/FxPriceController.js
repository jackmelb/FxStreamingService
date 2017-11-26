'use strict';

fxApp.controller('fxPriceController',
    function FxPriceController($scope, streamingPrice,$log) {

     /*   streamingPrice.getPrice()
            .then(function(price) {$scope.fxPrice = price.data; });
          /!*  .error(function(data, status, headers, config){
                $log.warn(data, status, headers, config);
            });*!/*/
       /* $scope.streamingPrice = function($scope) {
            streamingPrice.getPrice()
                .then(function(price) {
                    $scope.fxPrice = price.data;
                    $scope.streamingPrice();
                });
            /!*  .error(function(data, status, headers, config){
             $log.warn(data, status, headers, config);
             });*!/
        }*/

        $scope.fxPrice = streamingPrice.poll();

        var Repeater = function () {
            $scope.$apply(function () {
                $scope.fxPrice = streamingPrice.poll();
            });
        };
        var timer = setInterval(Repeater, 1000);

    }
);
