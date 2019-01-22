app.controller('MenuController', function ($scope,$http)
{
    var response =  $http.get('/INASAIAMVC/api/Menu/GetItems').then(function(data)
    {
        $scope.pages = data.data.ListItems;
        this.tree = data.data.ListItems;
    });
    this.awesomeCallback = function (node, tree) {
        // Do something with node or tree
    };

    this.otherAwesomeCallback = function (node, isSelected, tree) {
        // Do soemthing with node or tree based on isSelected
    }
    

    $scope.toggleItems = function (item) {
        if (item.items) {
            if (A.isArray(item.items)) {
                item.expanded = !item.expanded;
            } else {
                $timeout(function () {
                    item.items = createItems(Math.floor(Math.random(4)) + 3);
                    item.expanded = true;
                }, 500);
            }
        }
    };

       
});