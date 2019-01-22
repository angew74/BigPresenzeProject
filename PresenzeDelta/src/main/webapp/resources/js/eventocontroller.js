app.controller('EventoController', function ($scope, $mdDialog, $mdToast, RicercaService, GenericService) {
   
    $scope.status = '  ';
    $scope.customFullscreen = false;
    $("#ConfirmDialog").hide();
    $scope.selected = [];
    $scope.page = "1";
    $scope.pagesize = "5";
    this.myDate = new Date();

    this.minDate = new Date(
     2010,
      12,
      this.myDate.getDate()
    );

    this.maxDate = new Date(
      this.myDate.getFullYear(),
      this.myDate.getMonth(),
      this.myDate.getDate()
    );
   

    $scope.showProtocolloEsito = function(prot) {
        $mdToast.show(
           $mdToast.simple()
            .textContent("Protocollo: "+ prot)
           .hideDelay(3000)
           .position('bottom-right')
           )        
    };

    $scope.closeToast = function() {
        if (isDlgOpen) return;

        $mdToast
          .hide()
          .then(function() {
              isDlgOpen = false;
          });
    };
  
    
    var responsecodici = GenericService.getCodici();
    responsecodici.then(function (data) {
        if (data.data.success == "true") {
            $scope.codiceeventi = data.data.ListaCodiciEvento;
        }
    });

    function success(data) {
        if (data.data.success == "true") {
            $("#divLoading").hide();
            if (data.data.ListEsiti != null) {
                this.listesito = data.data.ListEsiti;
                $("#ListaEsiti").show();
                $("#inaEventi").show();
                $("#ListaComunicazioni").hide();
                $("#inaComunicazioni").hide();
            }            
        } else if (data.data.success == "false") {
            $("#divLoading").hide();
            $("#ListaEsiti").hide();
            $("#ListaComunicazioni").hide();
            $("#inaComunicazioni").hide();
            $("#inaEventi").show();
            $scope.msg = "Errore nella ricerca contattare servizio tecnico";
            $scope.showConfirm($scope.msg, $scope.event);
        }
    };

    $scope.showMessage = function (ev,text) {    
        $mdDialog.show(
          $mdDialog.alert()
            .parent(angular.element(document.querySelector('#popupContainer')))
            .clickOutsideToClose(true)
            .title('Messaggio Presa In Carico')
            .textContent(text)
            .ariaLabel('Alert Dialog Demo')
            .ok('Chiudi')
            .targetEvent(ev)
        );
    };

    $scope.Save = function(codiceIndividuale) {
        $("#divLoading").show();
        var response = RicercaService.SaveEvento(codiceIndividuale);
        response.then(function (data) {
            if (data.data.success == "true") {
                $("#divLoading").hide();
                $scope.msg = "Salvataggio effettuato";
                $scope.showConfirm($scope.msg, $scope.event);
            }
            else if (data.data.success == "false") {
                $scope.msg = "Errore nel salvataggio contattare servizio tecnico";
                $scope.showConfirm($scope.msg, $scope.event);
            }
      
        })
        };

    $scope.FindVana = function()
    {
        var ricerca =
       {
           codiceindividuale: $scope.codiceindividuale,
         
       };
        $("#divLoading").show();
        var response = RicercaService.RicercaCodiceIndividuale(ricerca.codiceindividuale);
        response.then(function (data) {
            if (data.data.success == "true") {
                $("#divLoading").hide();
                if (data.data.ListaCittadini != null) {
                    $scope.getCittadini = data.data;                  
                    $("#Verifica").show();
                    $("#inaVerifica").show();
                    $("#buttonSave").show();
                }
            } else if (data.data.success == "false") {
                $("#divLoading").hide();
                $("#Verifica").hide();
                $("#inaVerifica").hide();
                $("#buttonSave").hide();
                $scope.msg = "Errore nella ricerca contattare servizio tecnico";
                $scope.showConfirm($scope.msg, $scope.event);

            }
        });
    }

    $scope.showVana = function (ev, codind) {
        $("#divLoading").show();
        var response = RicercaService.Vana(codind);
        response.then(function (data) {
            if (data.data.success == "true") {
                $("#divLoading").hide();
                $mdDialog.show(
                  $mdDialog.alert()
                    .parent(angular.element(document.querySelector('#popupContainer')))
                    .clickOutsideToClose(true)
                    .title('Verifica Anagrafica')
                    .ariaLabel('Alert Dialog Demo')
                    .ok('Chiudi')
                    .htmlContent(data.data.HTML)
                    .targetEvent(ev)
                );
            }
        })
        $("#divLoading").hide();
    };

    $scope.showEsito = function(ev,idflusso)
    {
        $("#divLoading").show();
        var response = RicercaService.RicercaMessaggio(idflusso);
        response.then(function (data) {
            if (data.data.success == "true") {
                $("#divLoading").hide();
                var display = "<div>Messaggio: " + data.data.HTML + "</div>";
                display += "<br /><div>Protocollo: " + data.data.Protocollo + "</div>";
                $mdDialog.show(
                  $mdDialog.alert()
                    .parent(angular.element(document.querySelector('#popupContainer')))
                    .clickOutsideToClose(true)
                    .title('Messaggio INA-SAIA')
                    .ariaLabel('Alert Dialog Demo')
                    .ok('Chiudi')
                    .htmlContent(display)
                    .targetEvent(ev)
                );
            }
        })
        $("#divLoading").hide();
    }

    $scope.showComunicazione = function (ev, idflusso) {
        $("#divLoading").show();
        var response = RicercaService.RicercaComunicazione(idflusso);
        response.then(function (data) {
            if (data.data.success == "true") {
                $("#divLoading").hide();
                $mdDialog.show(
                  $mdDialog.alert()
                    .parent(angular.element(document.querySelector('#popupContainer')))
                    .clickOutsideToClose(true)
                    .title('Comunicazione INA-SAIA')
                    .ariaLabel('Alert Dialog Demo')
                    .ok('Chiudi')
                    .htmlContent(data.data.HTML)
                    .targetEvent(ev)
                );
            }
        })
        $("#divLoading").hide();
    };

    $scope.FindCodiceIndividuale = function () {

        var pageIndividuale = 1;
        var pagesizeIndividuale = 5;
        if ($scope.page != null & $scope.page != undefined)
        { pageIndividuale = $scope.page; }
        if ($scope.pagesize != null & $scope.pagesize != undefined)
        { pagesizeIndividuale = $scope.pagesize; }
        var ricerca =
        {
            codiceindividuale: $scope.codiceindividuale,
            motivocomunicazione: '',
            tipoesito: '',
            datainizio: '',
            datafine: '',
            page: pageIndividuale,
            pagesize: pagesizeIndividuale,
            totale : "0",
            order: 'datainzio'
        };
        $("#divLoading").show();
        var response = RicercaService.RicercaEvento(ricerca);
        response.then(function (data) {
            if (data.data.success == "true") {
                $("#divLoading").hide();
                if (data.data.ListEsiti != null) {
                   // this.listesito = data.data.ListEsiti;
                    $scope.getEsiti = data.data;
                    $("#ListaEsiti").show();
                    $("#ListaComunicazioni").hide();
                    $("#inaComunicazioni").hide();
                    $("#inaEventi").show();
                }               
            } else if (data.data.success == "false") {
                $("#divLoading").hide();
                $("#ListaEsiti").hide();
                $("#ListaComunicazioni").hide();
                $("#inaComunicazioni").hide();
                $("#inaEventi").hide();
                $scope.msg = "Errore nella ricerca contattare servizio tecnico";
                $scope.showConfirm($scope.msg, $scope.event);
                
            } 
        });
    }

    $scope.FindCodiceIndividualeTarPat = function () {

        var pageIndividuale = 1;
        var pagesizeIndividuale = 5;
        if ($scope.page != null & $scope.page != undefined)
        { pageIndividuale = $scope.page; }
        if ($scope.pagesize != null & $scope.pagesize != undefined)
        { pagesizeIndividuale = $scope.pagesize; }
        var ricerca =
        {
            codiceindividuale: $scope.codiceindividuale,
            motivocomunicazione: '',
            tipoesito: '',
            datainizio: '',
            datafine: '',
            page: pageIndividuale,
            pagesize: pagesizeIndividuale,
            totale: "0",
            order: 'datainzio'
        };
        $("#divLoading").show();
        var response = RicercaService.RicercaEventoTarPat(ricerca);
        response.then(function (data) {
            if (data.data.success == "true") {
                $("#divLoading").hide();
                if (data.data.ListEsiti != null) {
                    // this.listesito = data.data.ListEsiti;
                    $scope.getEsiti = data.data;
                    $("#ListaEsiti").show();                  
                    $("#inaEventi").show();
                }
            } else if (data.data.success == "false") {
                $("#divLoading").hide();
                $("#ListaEsiti").hide();              
                $("#inaEventi").hide();
                $scope.msg = "Errore nella ricerca contattare servizio tecnico";
                $scope.showConfirm($scope.msg, $scope.event);

            }
        });
    }

    $scope.FindEvento = function () {

        var pageEvento = 1;
        var pagesizeEvent = 5;
        if ($scope.page != null & $scope.page != undefined)
        { pageEvento = $scope.page; }
        if ($scope.pagesize != null & $scope.pagesize != undefined)
        { pagesizeEvento = $scope.pagesize; }
        var datafineev = "";
        var datainizioev = "";
        if ($scope.datainizio != null & $scope.datainizio != undefined)
        { datainizioev = $scope.datainizio.toLocaleDateString(); }
        if ($scope.datafine != null & $scope.datafine != undefined)
        { datafineev = $scope.datafine.toLocaleDateString(); }
        var ricerca =
       {
           codiceindividuale: '',
           motivocomunicazione: $scope.motivocomunicazione,
           tipoesito: $scope.tipoesito,
           datainizio: datainizioev,
           datafine: datafineev,
           page: pageEvento,
           pagesize: pagesizeEvento,
           totale: "0",
           order: 'datainzio'
       };

        var response = RicercaService.RicercaEvento(ricerca);
        response.then(function (data) {
            if (data.data.success == "true") {
                $("#divLoading").hide();
                if (data.data.ListComunicazioni != null) {
                    // this.listesito = data.data.ListEsiti;
                    $scope.getComunicazioni = data.data;
                    $("#ListaEsiti").hide();
                    $("#ListaComunicazioni").show();
                    $("#inaComunicazioni").show();
                    $("#inaEventi").hide();
                }                
            } else if (data.data.success == "false") {
                $("#divLoading").hide();
                $scope.msg = "Errore nella ricerca contattare servizio tecnico";
                $scope.showConfirm($scope.msg, $scope.event);

            }
        });
    }

    $scope.FindEventoTarPat = function () {

        var pageEvento = 1;
        var pagesizeEvent = 5;
        if ($scope.page != null & $scope.page != undefined)
        { pageEvento = $scope.page; }
        if ($scope.pagesize != null & $scope.pagesize != undefined)
        { pagesizeEvento = $scope.pagesize; }
        var datafineev = "";
        var datainizioev = "";
        if ($scope.datainizio != null & $scope.datainizio != undefined)
        { datainizioev = $scope.datainizio.toLocaleDateString(); }
        if ($scope.datafine != null & $scope.datafine != undefined)
        { datafineev = $scope.datafine.toLocaleDateString(); }
        var ricerca =
       {
           codiceindividuale: '',
           entecomunicazione: $scope.entecomunicazione,
           tipoesito: $scope.tipoesito,
           datainizio: datainizioev,
           datafine: datafineev,
           page: pageEvento,
           pagesize: pagesizeEvento,
           totale: "0",
           order: 'datainzio'
       };

        var response = RicercaService.RicercaEventoTarPat(ricerca);
        response.then(function (data) {
            if (data.data.success == "true") {
                $("#divLoading").hide();
                if (data.data.ListEsiti != null) {
                    // this.listesito = data.data.ListEsiti;
                    $scope.getEsiti = data.data;
                    $("#ListaEsiti").hide();  
                    $("#inaEventi").hide();
                }
            } else if (data.data.success == "false") {
                $("#divLoading").hide();
                $scope.msg = "Errore nella ricerca contattare servizio tecnico";
                $scope.showConfirm($scope.msg, $scope.event);

            }
        });
    }

    $scope.FindCodiceIndividualeNegative = function()
    {
        var pageIndividuale = 1;
        var pagesizeIndividuale = 5;
        if ($scope.page != null & $scope.page != undefined)
        { pageIndividuale = $scope.page; }
        if ($scope.pagesize != null & $scope.pagesize != undefined)
        { pagesizeIndividuale = $scope.pagesize; }
        var ricerca =
        {
            codiceindividuale: $scope.codiceindividuale,
            motivocomunicazione: '',
            tipoesito: '',
            datainizio: '',
            datafine: '',
            page: pageIndividuale,
            pagesize: pagesizeIndividuale,
            totale: "0",
            order: 'datainzio'
        };
        $("#divLoading").show();
        var response = RicercaService.RicercaEventoNegativo(ricerca);
        response.then(function (data) {
            if (data.data.success == "true") {
                $("#divLoading").hide();
                if (data.data.ListEsiti != null) {
                    // this.listesito = data.data.ListEsiti;
                    $scope.getEsiti = data.data;
                    $("#ListaEsiti").show();                  
                    $("#inaEventi").show();
                }
            } else if (data.data.success == "false") {
                $("#divLoading").hide();
                $("#ListaEsiti").hide();               
                $("#inaEventi").hide();
                $scope.msg = "Errore nella ricerca contattare servizio tecnico";
                $scope.showConfirm($scope.msg, $scope.event);

            }
        });
    }

    $scope.FindEventoNegative = function()
    {
        var pageEvento = 1;
        var pagesizeEvent = 5;
        if ($scope.page != null & $scope.page != undefined)
        { pageEvento = $scope.page; }
        if ($scope.pagesize != null & $scope.pagesize != undefined)
        { pagesizeEvento = $scope.pagesize; }
        var datafineev = "";
        var datainizioev = "";
        if ($scope.datainizio != null & $scope.datainizio != undefined)
        { datainizioev = $scope.datainizio.toLocaleDateString(); }
        if ($scope.datafine != null & $scope.datafine != undefined)
        { datafineev = $scope.datafine.toLocaleDateString(); }
        var ricerca =
       {
           codiceindividuale: '',
           entecomunicazione: $scope.entecomunicazione,          
           datainizio: datainizioev,
           datafine: datafineev,
           page: pageEvento,
           pagesize: pagesizeEvento,
           totale: "0",
           order: 'datainzio'
       };

        var response = RicercaService.RicercaEventoNegativo(ricerca);
        response.then(function (data) {
            if (data.data.success == "true") {
                $("#divLoading").hide();
                if (data.data.ListEsiti != null) {
                    // this.listesito = data.data.ListEsiti;
                    $scope.getEsiti = data.data;
                    $("#ListaEsiti").show();                 
                    $("#inaEventi").show();
                }
            } else if (data.data.success == "false") {
                $("#divLoading").hide();
                $scope.msg = "Errore nella ricerca contattare servizio tecnico";
                $scope.showConfirm($scope.msg, $scope.event);

            }
        });
    }

    $scope.showConfirm = function (msg, event) {
        // Appending dialog to document.body to cover sidenav in docs app
        var confirm = $mdDialog.confirm()
              .title('Ricerca non effettuata')
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

    function clearFields() {
        $scope.codiceindividuale = "";
        $scope.motivocomunicazione = "";
        $scope.tipoesito = "";
        $scope.datainizio = "";
        $scope.datafine = "";
        $scope.RicercaForm.$setPristine();
    }


})