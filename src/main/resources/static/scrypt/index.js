angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadCatalog = function () {
        $http.get(contextPath + '/catalog')
            .then(function (response) {
                $scope.productList = response.data;
                $http.get(contextPath + '/cartcount')
                    .then(function (response) {
                        $scope.cartCount = response.data;
                    });
            });
    };

    $scope.toCart = function (productId) {
        $http({
            url: contextPath + '/toCart',
            method: 'GET',
            params: {
                id: productId,
            }
        }).then(function (response) {
            $scope.loadCatalog();
        });
    };

    $scope.loadCatalog();
});