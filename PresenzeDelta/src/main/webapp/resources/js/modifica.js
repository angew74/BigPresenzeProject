$(function () {
    $('#giornopicker').datetimepicker({
        format: 'L'
                //defaultDate: moment()
    });
});

$('#giornopicker').datetimepicker('maxDate', moment());

$(function () {
    $('#oraentratapicker').datetimepicker({
        format: 'LT'
    });
});

$(function () {
    $('#orauscitapicker').datetimepicker({
        format: 'LT'
    });
});

function getGiornoDetails(id)
{
    var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: '/PresenzeDelta/pdati/giorno/' + id,
        dataType: 'json'
    })
            .done(function (data) {
                try {
                    if (data != null) {
                        $("#presenzaEditModal").show();
                        $("#username").val(data.user.username);
                        $("#userid").val(data.user.id);
                        $("#idgiorno").val(data.id);
                        var g = data.giorno.dayOfMonth + "/" + pad(data.giorno.monthValue,2) + "/" + data.giorno.year;
                        $("#giorno").val(g);
                        $("#oraentrata").val(data.oraentrata);
                        $("#orauscita").val(data.orauscita);
                        $("#pausapranzo").val(data.pausapranzo);
                        $("#orepermesso").val(data.orepermesso);
                        $("#congedoparentale").val(data.congedoparentale);
                        $("#permessomalattafiglio").val(data.permessomalattiafiglio);
                        if (data.malattia == "S")
                        {
                            $("#malattia").prop('checked', true);

                        }
                        if (data.ferie == "S")
                        {
                            $("#ferie").prop('checked', true);
                        }

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

$(function () {
    $("#malattia").change(function () {
        resetParsley();
        resetValues();
        $("#ferie").prop("disabled", true);
        $("#ferie").prop("checked", false);
        $("#reset").prop("checked", false);
        $("#pausapranzo").prop("disabled", true);
        $("#orepermesso").prop("disabled", true);
        $("#congedoparentale").prop("disabled", true);
        $("#permessomalattafiglio").prop("disabled", true);
        $("#oraentrata").prop("disabled", true);
        $("#orauscita").prop("disabled", true);
        $("#oraentrata").prop("required", false);

    });
});

function resetParsley() {
    $("#pausapranzo").parsley().reset();
    $("#oraentrata").parsley().reset();
    $("#orauscita").parsley().reset();
    $("#pausapranzo").parsley().reset();
    $("#orepermesso").parsley().reset();
    $("#congedoparentale").parsley().reset();
    $("#permessomalattafiglio").parsley().reset();
}

function resetValues() {
    $("#pausapranzo").val("0");
    $("#orepermesso").val("0");
    $("#congedoparentale").val("0");
    $("#permessomalattafiglio").val("0");
    $("#oraentrata").val("");
    $("#orauscita").val("");
}

$(function () {
    $("#ferie").change(function () {
        resetParsley();
        resetValues();
        $("#malattia").prop("disabled", true);
        $("#malattia").prop("checked", false);
        $("#reset").prop("checked", false);
        $("#pausapranzo").prop("disabled", true);
        $("#orepermesso").prop("disabled", true);
        $("#congedoparentale").prop("disabled", true);
        $("#permessomalattafiglio").prop("disabled", true);
        $("#oraentrata").prop("disabled", true);
        $("#orauscita").prop("disabled", true);
        $("#oraentrata").prop("required", false);
    });
});

$(function () {
    $("#reset").change(function () {
        resetParsley();
        resetParsley();
        $("#congedoparentale").parsley().reset();
        $("#permessomalattafiglio").parsley().reset();
        $("#malattia").prop("disabled", false);
        $("#ferie").prop("disabled", false);
        $("#malattia").prop("checked", false);
        $("#ferie").prop("checked", false);
        $("#pausapranzo").prop("disabled", false);
        $("#orepermesso").prop("disabled", false);
        $("#congedoparentale").prop("disabled", false);
        $("#permessomalattafiglio").prop("disabled", false);
        $("#oraentrata").prop("disabled", false);
        $("#orauscita").prop("disabled", false);
        $("#oraentrata").prop("required", true);
    });
});

pad = function(num, length){
    num = num.toString();
    while (num.length < length){
        num = "0" + num;
    }
    return num;
};

jQuery(document).ready(function ($) {
    var presenzaForm = '#btnSalva';
    // SUBMIT FORM
    $(presenzaForm).click(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
        var isValid = true;
        var isValidSelect = true;
        $('select').each(function () {
            if ($(this).parsley().validate() !== true)
                isValidSelect = false;
        });
        $('input').each(function () {
            if ($(this).parsley().validate() !== true)
                isValid = false;
        });
        if (isValid && isValidSelect) {
            ajaxPost();
        }
    });


    function ajaxPost() {
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var mdisplay = "#messagesuccess";
        var successcontainer = '#successModal';
        var ferievalue = $("input[name='ferie']:checked").val();
        var malattiavalue = $("input[name='malattia']:checked").val();
        var id = $("#idgiorno").val();
        var formData = $('form[name=presenzaEditForm]').serialize() + "&ferie=" + ferievalue + "&malattia=" + malattiavalue;
        $.ajax({
            type: "POST",
            url: '/PresenzeDelta/presenze/modifica',
            data: formData,
            success: function (data) {
                try {
                    if (data.validated) {
                        $(mdisplay).text("Presenza modificata correttamente");
                        $(successcontainer).modal('show');
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

            }
            , error: function (e) {
                $(errorDisplay).text("errore di connessione dettagli " + e);
                $(errorcontainer).modal('show');
            }
        });
    }
})
