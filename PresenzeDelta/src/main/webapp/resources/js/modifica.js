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
                        var g = pad(data.giorno.dayOfMonth, 2) + "/" + pad(data.giorno.monthValue, 2) + "/" + data.giorno.year;
                        $("#giorno").val(g);
                        $("#oraentrata").val(data.oraentrata);
                        $("#orauscita").val(data.orauscita);
                        $("#pausapranzo").val(data.pausapranzo);
                        $("#orepermesso").val(data.orepermesso);
                        $("#congedoparentale").val(data.congedoparentale);
                        $("#permessomalattafiglio").val(data.permessomalattiafiglio);
                        if (data.malattia === "S")
                        {
                            $("#malattia").prop('checked', true);

                        }
                        if (data.ferie === "S")
                        {
                            $("#ferie").prop('checked', true);
                        }
                        if (data.verified === 1)
                        {
                            $("#verified").prop('checked', true);
                            $("#verified").val(1);
                            disableValues();
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
        $("#orauscita").prop("required", false);

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
        if (!($('#verified').prop('checked')))
        {
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
            $("#giorno").prop("readonly", false);
            $("#oraentrata").prop("disabled", false);
            $("#orauscita").prop("disabled", false);
            $("#oraentrata").prop("required", true);
        } else {
            $("#reset").prop("checked", false);
        }
    });
});

pad = function (num, length) {
    num = num.toString();
    while (num.length < length) {
        num = "0" + num;
    }
    return num;
};

$(function () {
    $("#verified").change(function () {
        resetParsley();
        if (!($('#verified').prop('checked')))
        {
            $("#pausapranzo").prop("disabled", false);
            $("#orepermesso").prop("disabled", false);
            $("#congedoparentale").prop("disabled", false);
            $("#permessomalattafiglio").prop("disabled", false);
            $("#oraentrata").prop("disabled", false);
            $("#orauscita").prop("disabled", false);
            $("#giorno").prop("readonly", false);
            $("#malattia").prop("disabled", false);
            $("#ferie").prop("disabled", false);
        }
        else {
             $("#pausapranzo").prop("disabled", true);
            $("#orepermesso").prop("disabled", true);
            $("#congedoparentale").prop("disabled", true);
            $("#permessomalattafiglio").prop("disabled", true);
            $("#oraentrata").prop("disabled", true);
            $("#orauscita").prop("disabled", true);
            $("#giorno").prop("readonly", true);
            $("#malattia").prop("disabled", true);
            $("#ferie").prop("disabled", true);
        }
    });
});


function disableValues()
{
    $("#pausapranzo").prop("disabled", true);
    $("#orepermesso").prop("disabled", true);
    $("#congedoparentale").prop("disabled", true);
    $("#permessomalattafiglio").prop("disabled", true);
    $("#oraentrata").prop("disabled", true);
    $("#orauscita").prop("disabled", true);
    $("#giorno").prop("readonly", true);

}

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
        var ferievalue = 'N';
        var malattiavalue = 'N';
        var verifiedvalue = 0;
        if ($('#ferie').prop('checked'))
        {
            ferievalue = 'S';
        }
        if ($('#malattia').prop('checked'))
        {
            malattiavalue = 'S';
        }
        if ($('#verified').prop('checked'))
        {
            verifiedvalue = 1;
        }
        var formData = $('form[name=presenzaEditForm]').serialize() + "&ferie=" + ferievalue + "&malattia=" + malattiavalue + "&verified=" + verifiedvalue;

        $.ajax({
            type: "POST",
            url: '/PresenzeDelta/presenze/modifica',
            data: formData,
            success: function (data) {
                try {
                    if (data.validated) {
                        $(mdisplay).text("Presenza modificata correttamente");
                        $("#presenzaEditModal").hide();
                        $(successcontainer).modal('show');
                    } else {
                        //Set error messages
                        $.each(data.errorMessages, function (key, value) {
                            $(errorDisplay).text(value);
                        });
                        $("#presenzaEditModal").hide();
                        $(errorcontainer).modal('show');
                    }
                } catch (err)
                {
                    $(errorDisplay).text(err);
                    $(errorcontainer).modal('show');
                    $("#presenzaEditModal").hide();
                }

            }
            , error: function (e) {
                $(errorDisplay).text("errore di connessione dettagli " + e);
                $(errorcontainer).modal('show');
                $("#presenzaEditModal").hide();
            }
        });
    }
})
