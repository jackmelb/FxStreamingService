fxApp.factory('streamingPrice', function($http){
   /* return {
        getPrice: function() {
          return  $http({ method : 'GET', url: '/home/fxprice' });
        }
    };*/

    return {
        poll: function () {
            var deferred = $q.defer();
            $http.get('/home/fxprice').then(function (response) {
                deferred.resolve(response.data);
            });
            return deferred.promise;
        }
    }
    });

