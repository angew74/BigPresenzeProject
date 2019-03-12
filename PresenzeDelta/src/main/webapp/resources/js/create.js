$(document).ready(function () {
    $(document).on('focusout', '#username', function () {
        var item = $agents.find('#username').val();
        // errorUserName
    })
})


function checkUsername(user) {
    $.ajax({
        type: "GET",
        contentType: "application/json",
        url: '/PresenzeDelta/pdati/checkuser/' + user,
        dataType: 'json'
    })
            .done(function (data) {
                try {
                    if (data !== null) {
                        
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
