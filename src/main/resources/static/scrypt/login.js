angular.module('app', []).controller('cartController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.ready(function() {
        $("#btn").click(
            function(){
                sendAjaxForm('result_form', 'ajax_form', '/auth');
                return false;
            }
        );
    });

    function sendAjaxForm(result_form, ajax_form, url) {
        $http({
            url: contextPath + url,
            method: 'GET',
            params: {
                login: ajax_form.login,
                password: ajax_form.password,
            }
        }).then(function (response){
                $scope.user = response.data;
        });
    }
});