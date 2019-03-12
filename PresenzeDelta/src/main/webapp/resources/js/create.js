$(document).ready(function () {
    $(document).on('focusout', '#username', function () {
        var user = $('#username').val();
         $("#username").parsley().reset();
         $('#errorUserName').text("");
         checkUsername(user);          
        // errorUserName
    })
})

$(function () {
    $('#giornopicker').datetimepicker({
        format: 'L'
                //defaultDate: moment()
    });
});

jQuery(document).ready(function ($) {
    var presenzaForm = '#btnSalva';
      $(presenzaForm).click(function (event) {
        // Prevent the form from submitting via the browser.
        event.preventDefault();
         ajaxPost();
    })
});

  function ajaxPost() {
        var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    var successcontainer= '#successModal';
    var mdisplay = "#messagesuccess";
      e.preventDefault();
      //Remove all errors
      $('input').next().remove();
      $.post({
         url: '/PresenzeDelta/anagrafica/add',
         data: $('form[name=anagraficaForm]').serialize(),
         success : function(res) {
         try {             
                if (res.validated) {
                    //Set response
                    $(mdisplay).text("Aangrafica registratq correttamente");               
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
  }

function checkUsername(user) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: '/PresenzeDelta/pdati/checkuser/' + user,
        dataType: 'json'
    })
            .done(function (data) {
                try {
                    if (data !== null && data.id !== null) {
                    $('#iduser').prop('readonly',false);
                     $('#iduser').text(data.id);
                     $('#iduser').val(data.id);
                    $('#iduser').prop('readonly',true);
                    } else {
                        $('#errorUserName').text("Username non esistente");                     
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
