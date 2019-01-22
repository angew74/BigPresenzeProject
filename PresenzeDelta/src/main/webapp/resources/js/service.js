
//var LoginService = angular.module('LoginService', [])
//.service('UserLogin', function (User) {
//    var response = $http({
//        method: "post",
//        url: "api/Login/dologin",
//        data: JSON.stringify(User),
//        dataType: "json"
//    });
//    return response;

//});

//var myApp = angular.module('INAApp', []);

app.service('ISOService',function($http)
{
    this.ISOCodici = function (ricerca) {
        var response = $http({
            method: "post",
            data: JSON.stringify(ricerca),
            url: "/INASAIAMVC/api/ISO/getCodici",          
            dataType: "json"
        });
        return response;
    }

    this.ModificaISO = function (iso) {
        var response = $http({
            method: "post",
            data: JSON.stringify(iso),
            url: "/INASAIAMVC/api/ISO/editISO",
            dataType: "json"
        });
        return response;
    }
})

app.service('LoginService', function ($http) {
    this.UserLogin = function (User) {
        var response = $http({
            method: "post",
            url: "/INASAIAMVC/api/Login/dologin",
            data: JSON.stringify(User),
            dataType: "json"
        });
        return response;
    }
});

app.service("GenericService", function ($http) {
    this.getCodici = function () {
        var response = $http
          ({
              method: "get",
              url: "/INASAIAMVC/api/Evento/GetCodici",
              dataType: "json"
          });
        return response;
    }
});

app.service("RicercaService", function ($http) {

    this.RicercaEvento = function (ricerca) {
        var response = $http
        ({
            method: "post",
            url: "/INASAIAMVC/api/Evento/Ricerca",
            data: JSON.stringify(ricerca),
            dataType: "json"
        });
        return response;
    };

    this.RicercaEventoTarPat = function (ricerca) {
        var response = $http
        ({
            method: "post",
            url: "/INASAIAMVC/api/Evento/RicercaTarPat",
            data: JSON.stringify(ricerca),
            dataType: "json"
        });
        return response;
    };

    this.RicercaEventoNegativo = function (ricerca) {
        var response = $http
        ({
            method: "post",
            url: "/INASAIAMVC/api/Evento/RicercaNegative",
            data: JSON.stringify(ricerca),
            dataType: "json"
        });
        return response;
    };

    this.Vana = function (codind) {
        var response = $http
       ({
           method: "get",
           url: "/INASAIAMVC/api/Evento/Vana?codiceIndividuale=" + codind,
           dataType: "json"
       });
        return response;
    };


    this.RicercaComunicazione = function (idflusso) {
        var response = $http
       ({
           method: "get",
           url: "/INASAIAMVC/api/Evento/RicercaComunicazione?idflusso=" + idflusso,
           dataType: "json"
       });
        return response;
    }

    this.SaveEvento = function (codiceindividuale) {
        var response = $http
  ({
      method: "get",
      url: "/INASAIAMVC/api/Evento/SaveEvento?codiceindividuale=" + codiceindividuale,
      dataType: "json"
  });
        return response;
    }

    this.RicercaMessaggio = function (idflusso)
    {
        var response = $http
 ({
     method: "get",
     url: "/INASAIAMVC/api/Evento/RicercaMessaggio?idflusso=" + idflusso,
     dataType: "json"
 });
        return response;
    }
    

    this.RicercaCodiceIndividuale = function (codiceindividuale) {
        var response = $http
     ({
         method: "get",
         url: "/INASAIAMVC/api/Evento/RicercaCodiceIndividuale?codiceindividuale=" + codiceindividuale,
         dataType: "json"
     });
        return response;
    }
});




//app.service('MenuService', function ($http) {
//    this.MenuItems = function()
//    {
//        var response = $http({
//            method: "get",
//            url: "/INASAIAMVC/api/Menu/GetItems",
//            dataType: "json"
//        });
//        return response;
//    }
//});

//app.service("LoginService", function ($http) {

//    this.UserLogin = function (User) {
//        var response = $http({
//            method: "post",
//            url: "api/Login/dologin",
//            data: JSON.stringify(User),
//            dataType: "json"
//        });
//        return response;
//    }

//});