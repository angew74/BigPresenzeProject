/*
 jQuery(document).ready(function ($) {
 $("#selectUsers").change(function(e) {
 e.preventDefault();
 });
 
 });*/
jQuery(document).ready(function ($) {
    //  var presenzaForm = '#riepilogoButton';
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
    var id = $('#IdUserValue').val();
    var isValidSelect = true;
    $('#MeseSelect').each(function () {
        if ($(this).parsley().validate() !== true)
            isValidSelect = false;
    });
    if (isValidSelect) {
        var mese = $("#MeseSelect").val();
        $.ajax({
            type: "GET",
            contentType: "application/json",
            url: '/PresenzeDelta/pdati/giorni/' + id + '/' + mese,
            dataType: 'json'
        })
                .done(function (data) {
                    try {
                        if (data !== null) {
                            $("#divGiorni").show();
                            var totale = data.length;
                            $("#Totale").show();
                            $("#TotaleText").val(totale);
                            $.each(data, function (key, value) {
                                var tr = $("<tr>");
                                tr.append($("<td>").text(value.username));
                                tr.append($("</td>"));
                                var m = switchMonth(value.datagiorno.monthValue);
                                var dateString = switchDay(value.datagiorno.dayOfWeek) + " " + value.datagiorno.dayOfMonth + " " + m + " " + value.datagiorno.year;
                                tr.append($("<td>").text(dateString));
                                tr.append($("</td>"));
                                tr.append($("<td><a href='#' onclick='getGiornoDetails(" + value.idgiorno + ");return false' title='Giorno'><span class='icon'><i class='fas fa-check-circle'></i></span></a>"));
                                tr.append($("</tr>"));
                                var rowIds = $("#tableGiorni tr").map(function () {
                                    return $(this).text();
                                }).get();
                                if (jQuery.inArray(tr[0].innerText, rowIds) === -1)
                                {
                                    $("#tableGiorni").append(tr);
                                }
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
}

function ajaxPostMesi() {
    var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    var anno = $("#annoselect").val();
    var isValidSelect = true;
    let dropdown = $('#MeseSelect');
    var id = $('#selectUsers').val();
    $('#selectUsers').each(function () {
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
                        dropdown.empty();
                        dropdown.append('<option selected="true" disabled>Scegliere Mese</option>');
                        dropdown.prop('selectedIndex', 0);
                        if (data !== null) {
                            $("#Mese").show();
                            $.each(data, function (key, value) {
                                dropdown.append($('<option></option>').attr('value', value.mese).text(switchMonth(value.mese)));
                                $("#IdUserValue").val(value.idUser);
                            });
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