angular.module('app', []).controller('cartController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadCart = function () {
        $http.get(contextPath + '/cartList')
            .then(function (response) {
                $scope.productList = response.data;
                $http.get(contextPath + '/cart_price')
                    .then(function (response) {
                        $scope.cartSum = response.data;
                    });
            });
    };

    $scope.fromCart = function (productId){
        $http({
            url: contextPath + '/deleteFromCart',
            method: 'GET',
            params: {
                id: productId,
            }
        }).then(function (response){
            $scope.loadCart();
        });
    };

    $scope.AllFromCart = function (productId){
        $http({
            url: contextPath + '/deleteAllFromCart',
            method: 'GET',
            params: {
                id: productId,
            }
        }).then(function (response){
            $scope.loadCart();
        });
    };

    $scope.addToCart = function (productId){
        $http({
            url: contextPath + '/toCart',
            method: 'GET',
            params: {
                id: productId,
            }
        }).then(function (response){
            $scope.loadCart();
        });
    };

    $scope.loadCart();
});