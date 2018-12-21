app.controller('ISOController', function ($scope, $mdDialog,$mdEditDialog, $mdToast, ISOService, GenericService) {
    $scope.customFullscreen = false;
    $("#ConfirmDialog").hide();
    $("#divLoading").show();
    $scope.selected = [];  
    $scope.per = "5";
    $scope.page = "1";
    var ricerca =
    {     
        per: $scope.per,
        page : $scope.page,
        totale: "0"      
    };

    $scope.showConfirm = function (msg, event) {
        // Appending dialog to document.body to cover sidenav in docs app
        var confirm = $mdDialog.confirm()
              .title('Attenzione')
              .textContent(msg)
              .ariaLabel('Lucky day')
              .targetEvent(event)
              .ok('Ok')
              .cancel('Cancella');

        $mdDialog.show(confirm).then(function () {
            $scope.status = msg;
        }, function () {
            $scope.status = msg;
        });
    };

    var responseISO = ISOService.ISOCodici(ricerca);
    responseISO.then(function (data) {  
            if (data.data.success == "true") {
                $("#divLoading").hide();
                if (data.data.ListaCodiciISO != null) {
                    // this.listesito = data.data.ListEsiti;
                    $scope.getISO = data.data;                   
                }
            } else if (data.data.success == "false") {
                $("#divLoading").hide();
                $scope.msg = "Errore nella ricerca contattare servizio tecnico";
                $scope.showConfirm($scope.msg, $scope.event);
            }      
    });


    $scope.editCode = function ($event,iso) {      
        $mdDialog.show({
            controller: function ($timeout, $q, $scope, $mdDialog) {
                var questList =this;
                $scope.cancel = function($event) {
                    $mdDialog.cancel();
                };
                $scope.finish = function($event) {
                    $mdDialog.hide();
                };
                $scope.codiso = iso.CodiceIso;
                $scope.descriso = iso.DescrizioneIso;
                $scope.oldcodiso = iso.CodiceIso;
                $scope.olddescriso = iso.DescrizioneIso;
                $scope.UpdateISO = function (codiso,descriso) {
                    $("#divLoading").show();
                    var iso = {
                        oldCodISO: $scope.oldcodiso,
                        oldDescrISO: $scope.olddescriso,
                        newCodISO: $scope.codiso,
                        newDescrISO: $scope.descriso
                    };
                    var responseUpdata = ISOService.ModificaISO(iso);
                    responseUpdata.then(function (data) {
                        if (data.data.success == "true") {
                            $("#divLoading").hide();
                            $mdDialog.hide();
                            $scope.msg = "Aggiornamento effettuato";
                            $scope.showConfirm($scope.msg, $scope.event);
                        } else if (data.data.success == "false") {
                            $scope.msg = "Errore nella ricerca contattare servizio tecnico";
                            $("#divLoading").hide();
                            $mdDialog.hide();
                            $scope.showConfirm($scope.msg, $scope.event);
                        }
                    });
                }
            },          
            templateUrl: 'dialog.tmpl.html',
            parent: angular.element(document.body),
            targetEvent: $event,
            clickOutsideToClose:true,
            locals: {parent: $scope},
        })
     .then(function(codiso,desciso) {  
        
         });        
    
        };
     
 

    $scope.pagingISO = function () {
        var ricerca =
   {
       per: $scope.per,
       page: $scope.page,
       totale: "0"
   };       

        var response = ISOService.ISOCodici(ricerca);
        response.then(function (data) {
            if (data.data.success == "true") {
                $("#divLoading").hide();
                if (data.data.ListaCodiciISO != null) {
                    // this.listesito = data.data.ListEsiti;
                    $scope.getISO = data.data;
                }
            } else if (data.data.success == "false") {
                $("#divLoading").hide();
                $scope.msg = "Errore nella ricerca contattare servizio tecnico";
                $scope.showConfirm($scope.msg, $scope.event);
            }
        });
    }

    
});