var app = angular.module('storeApp', []);

app.controller('StoreController', function($scope, $http) {
    const apiUrl = '/public/rest/stores';

    $scope.getStores = function() {
        $http.get(apiUrl)
            .then(function(response) {
                $scope.stores = response.data;
            }, function(error) {
                console.error('Ошибка при получении магазинов:', error);
            });
    };

    $scope.addStore = function() {
        if ($scope.newStoreName) {
            $http.post(apiUrl + '?name=' + encodeURIComponent($scope.newStoreName))
                .then(function(response) {
                    if (response.status === 200) {
                        $scope.getStores();
                        $scope.newStoreName = '';
                    } else {
                        console.error('Ошибка при добавлении магазина:', response);
                    }
                }, function(error) {
                    console.error('Ошибка при добавлении магазина:', error);
                });
        }
    };

    $scope.deleteStore = function(id) {
        if (confirm('Вы уверены, что хотите удалить этот магазин?')) {
            $http.delete(apiUrl + '/' + id)
                .then(function(response) {
                    $scope.getStores();
                }, function(error) {
                    console.error('Ошибка при удалении магазина:', error);
                });
        }
    };

    $scope.getStores();
});