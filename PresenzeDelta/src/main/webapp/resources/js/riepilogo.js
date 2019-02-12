/*
 jQuery(document).ready(function ($) {
 $("#selectUsers").change(function(e) {
 e.preventDefault();
 });
 
 });*/
jQuery(document).ready(function ($) {
    var presenzaForm = '#riepilogoButton';
    $('#Mese').on('click', ajaxPostGiorni);
    $(presenzaForm).click(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        ajaxPostMesi();
    });
});

function ajaxPostGiorni() {
    var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    var mese = $("#MeseText").val();
    var id = $('#selectUsers').val();
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: '/PresenzeDelta/pdati/giorni/' + id + '/' + mese,
        dataType: 'json'
    })
            .done(function (data) {
                try {
                    if (data.validated) {
                        $.each(data, function (key, value) {
                            var tr = $("<tr>");
                            tr.append($("<td>").text(value.username));
                            tr.append($("<td>").text(value.datagiorno));
                            tr.append($("</tr>"));
                            $("#tableGiorni").append(tr);
                        });
                        $("#divGiorni").show();
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
                            $("#MeseText").val(data["mese"]);
                            $("#TotaleText").val(data["totale"]);
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
