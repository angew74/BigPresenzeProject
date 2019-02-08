
$(function () {
    $('#giornopicker').datetimepicker({
        format: 'L',
        defaultDate: moment()
    });
});



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





$('#insertPForm').parsley();



/*
 *  if ($("selectUsers") !== null)
 {
 if ($("selectUsers").value() === '')
 {
 $("errorSelectUsers").val = "Selezione utente obbligatoria";
 }
 }
 */


$("#btnSalva").on('click', function () {
    $('#insertPForm').parsley().validate();
    if ($('#insertPForm').parsley().isValid()) {

    } else {

    }
});


$(function () {
    $("#malattia").change(function () {
        $("#ferie").prop("disabled", true);
        $("#ferie").prop("checked", false);
        $("#reset").prop("checked", false);
        $("#pausapranzo").prop("disabled", true);
        $("#orepermesso").prop("disabled", true);
        $("#congedoparentale").prop("disabled", true);
        $("#permessomalattafiglio").prop("disabled", true);
        $("#oraentrata").prop("disabled", true);
        $("#orauscita").prop("disabled", true);
        $("#pausapranzo").val("");
        $("#orepermesso").val("");
        $("#congedoparentale").val("");
        $("#permessomalattafiglio").val("");
        $("#oraentrata").val("");
        $("#orauscita").val("");
        $("#oraentrata").prop("required", false);
        $('#insertPForm').parsley().reset();
    });
});

$(function () {
    $("#ferie").change(function () {
        $("#malattia").prop("disabled", true);
        $("#malattia").prop("checked", false);
        $("#reset").prop("checked", false);
        $("#pausapranzo").prop("disabled", true);
        $("#orepermesso").prop("disabled", true);
        $("#congedoparentale").prop("disabled", true);
        $("#permessomalattafiglio").prop("disabled", true);
        $("#oraentrata").prop("disabled", true);
        $("#orauscita").prop("disabled", true);
        $("#pausapranzo").val("");
        $("#orepermesso").val("");
        $("#congedoparentale").val("");
        $("#permessomalattafiglio").val("");
        $("#oraentrata").val("");
        $("#orauscita").val("");
        $("#oraentrata").prop("required", false);
        $('#insertPForm').parsley().reset();
    });
});

$(function () {
    $("#reset").change(function () {
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
        $("#pausapranzo").val("");
        $("#orepermesso").val("");
        $("#congedoparentale").val("");
        $("#permessomalattafiglio").val("");
        $("#oraentrata").val("");
        $("#orauscita").val("");
        $("#oraentrata").prop("required", true);
        $('#insertPForm').parsley().reset();

    });
});


$(function () {
    /*  Submit form using Ajax */
    $('button[type=submit]').click(function (e) {
        $('#insertPForm').parsley().validate();
        if ($('#insertPForm').parsley().isValid()) {
            var errorcontainer = '#errorModal';
            var errorDisplay = '#errorDisplay';
            var successcontainer = '#successModal';
            //Prevent default submission of form
            e.preventDefault();
            //Remove all errors
            $('input').next().remove();
            $.post({
                url: '/PresenzeDelta/presenze/add',
                data: $('form[name=insertPForm]').serialize(),
                success: function (res) {
                    try {
                        if (res.validated) {
                            //Set response
                            $(successcontainer).modal('show');
                        } else {
                            //Set error messages
                            $.each(res.errorMessages, function (key, value) {
                                $(errorDisplay).text(value);
                                $(errorcontainer).modal('show');
                            });
                        }
                    } catch (err)
                    {
                        $(errorDisplay).value(err);
                        $(errorcontainer).modal('show');
                    }
                },
                error: function () {
                    $(errorDisplay).text("errore di connessione");
                    $(errorcontainer).modal('show');
                }
            });

        } else {

        }
    });
})