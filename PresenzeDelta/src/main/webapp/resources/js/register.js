$(function() {
   $('button[type=submit]').click(function(e) {
    var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    var successcontainer= '#successModal';
      //Prevent default submission of form
      e.preventDefault();
      //Remove all errors
      $('input').next().remove();
      $.post({
         url: '/PresenzeDelta/users/add',
         data: $('form[name=userForm]').serialize(),
         success : function(res) {
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
           
});
})

