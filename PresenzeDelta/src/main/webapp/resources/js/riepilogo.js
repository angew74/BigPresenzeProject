/*
 jQuery(document).ready(function ($) {
 $("#selectUsers").change(function(e) {
 e.preventDefault();
 });
 
 });*/
jQuery(document).ready(function ($) {
    var presenzaForm = '#riepilogoButton';
    $('#Mese').on('click', ajaxPostGiorni);
    $('#Utente').on('click', ajaxPostMesi);
    /*
    $(presenzaForm).click(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPostMesi();
    });*/
});

function ajaxPostGiorni() {
    var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    var mese = $("#MeseValue").val();
    var id = $('#IdUserValue').val();
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: '/PresenzeDelta/pdati/giorni/' + id + '/' + mese,
        dataType: 'json'
    })
            .done(function (data) {
                try {
                    if (data != null) {
                        $("#divGiorni").show();
                        $.each(data, function (key, value) {
                            var tr = $("<tr>");                     
                            tr.append($("<td>").text(value.username));
                            var dateString = switchDay(value.datagiorno.dayOfWeek) +" " + value.datagiorno.dayOfMonth + " " + switchMonth(value.datagiorno.monthValue) + " " + value.datagiorno.year;
                            tr.append($("<td><a href=getGiornoDetails("+ value.idgiorno + ")>").text(dateString));
                            tr.append($("</tr>"));
                            $("#tableGiorni").append(tr);
                        });                        
                    } else {                        
                       $(errorDisplay).text("Errore nella richiesta");                      
                       $(errorcontainer).modal('show');
                    }
                } catch (err)
                {
                    $(errorDisplay).text(err);
                    $(errorcontainer).modal('show');
                }

            })
            .fail(function (e) {
                $(errorDisplay).text("errore di connessione dettagli " + e);
                $(errorcontainer).modal('show');
            });
}

function ajaxPostMesi() {
    var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    var anno = $("#annoselect").val();
    var isValidSelect = true;
    var id = $('#selectUsers').val();
    $('select').each(function () {
        if ($(this).parsley().validate() !== true)
            isValidSelect = false;
    });
    if (isValidSelect) {
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: '/PresenzeDelta/pdati/mesi/' + id + '/' + anno,
            dataType: 'json'
        })
                .done(function (data) {
                    try {
                        if (data.validated) {
                            $("#Mese").show();
                            $("#Totale").show();
                            $("#MeseValue").val(data["mese"]);
                            $("#MeseText").val(switchMonth(data["mese"]));
                            $("#TotaleText").val(data["totale"]);
                            $("#IdUserValue").val(data["idUser"]);
                        } else {
                            //Set error messages
                            $.each(data.errorMessages, function (key, value) {
                                $(errorDisplay).text(value);
                            });
                            $(errorcontainer).modal('show');
                        }
                    } catch (err)
                    {
                        $(errorDisplay).text(err);
                        $(errorcontainer).modal('show');
                    }

                })
                .fail(function (e) {
                    $(errorDisplay).text("errore di connessione dettagli " + e);
                    $(errorcontainer).modal('show');
                });
    }
}

function getGiornoDetails(id)
{
    
}

function switchMonth(v)
{
    var mese = "";
    switch (v)
    {
        case 1:
            mese = "Gennaio";
            break;
         case 2:
            mese = "Febbraio";
            break;
          case 3:
            mese = "Marzo";
            break;
          case 4:
            mese = "Aprile";
            break;
          case 5:
            mese = "Maggio";
            break;
          case 6:
            mese = "Giugno";
            break;
          case 7:
            mese = "Luglio";
            break;
          case 8:
            mese = "Agosto";
            break;
          case 9:
            mese = "Settembre";
            break;
          case 10:
            mese = "Ottobre";
            break;
          case 11:
            mese = "Novembre";
            break;
          case 12:
            mese = "Dicembre";
            break;
    }
    return mese;
}


function switchDay(v)
{
    var giorno = "";
    switch (v)
    {
        case "MONDAY":
            giorno = "Lunedi";
            break;
         case "TUESDAY":
            giorno = "Martedi";
            break;
          case "WEDNESDAY":
            giorno = "Mercoledi";
            break;
          case "THURSDAY":
            giorno = "Giovedi";
            break;
          case "FRIDAY":
            giorno = "Venerdi";
            break;
          case "SATURDAY":
            giorno = "Sabato";
            break;
          case "SUNDAY":
            giorno = "Domenica";
            break;         
    }
    return giorno;
}