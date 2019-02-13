
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


jQuery(document).ready(function ($) {
    var presenzaForm = '#btnSalva';
    // SUBMIT FORM
    $(presenzaForm).click(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
         var isValid = true;
         var isValidSelect = true;
      $('select').each( function() {
         if ($(this).parsley().validate() !== true) isValidSelect = false;
      });   
      $('input').each( function() {
         if ($(this).parsley().validate() !== true) isValid = false;
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
        var formData = $('form[name=insertPForm]').serialize()+ "&presenza.ferie="+ferievalue+ "&presenza.malattia="+malattiavalue;
       /* formData["presenza.malattia"] = $("input[name='malattia']:checked").val();
        formData.push({ name: "presenze.ferie", value: $("input[name='ferie']:checked").val() });
        formData.push({ name: $("input[name='ferie']:checked").name, value: $("input[name='ferie']:checked").val() });
        /*
        var selectUsers = '#selectUsers';
        var userid = '#iduseredit';       
        var permessomalattafiglio = '#permessomalattafiglio';
        var congedoparentale = '#congedoparentale';
        var orepermesso = '#orepermesso';
        var pausapranzo = '#pausapranzo';       
        var malattia = '#malattia';
        var ferie = '#ferie';       
        var formData = {}
        formData["giorno"] =$('#giornopicker').datetimepicker('viewDate').format('L'); 
        formData["id"] = $('idgiorno').val();
        formData["permessomalattafiglio"] = $(permessomalattafiglio).val();
        formData["congedoparentale"] = $(congedoparentale).val();
        formData["orepermesso"] = $(orepermesso).val();
        formData["pausapranzo"] =  $(pausapranzo).val();     
        formData["partialoraingresso"] =  $('#oraentratapicker').datetimepicker('viewDate').format('LT');   
        formData["partialorauscita"] = $('#orauscitapicker').datetimepicker('viewDate').format('LT');  
        formData["oraentrata"] = null;
        formData["orauscita"] = null;
        if($('#iduseredit').length === 0)
        {
            formData["userid"] = $(selectUsers).val();
        }
        else 
        {
            formData["userid"] = $(userid).val();
        }
        if($(malattia).is(':checked')) 
        {
            formData["malattia"] = "S";
        }
        else{
             formData["malattia"] = "N";
        }
        if($(ferie).is(':checked')) 
        {
            formData["ferie"] = "S";
        }
        else
        {
              formData["ferie"] = "N";
        }   */
            // DO POST
            $.post({
                type: "POST",
               // contentType: "application/json",
                url: '/PresenzeDelta/presenze/add',
               // data: JSON.stringify(formData),
               data: formData
               // dataType: 'json'
              })
                    .done(function (data) {
                        try {
                            if (data.validated) {
                                $(mdisplay).text("Presenza inserita correttamente");                               
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

                    })
                    .fail(function (e) {
                        $(errorDisplay).text("errore di connessione dettagli " + e);
                        $(errorcontainer).modal('show');                    
                    });

    }
})

