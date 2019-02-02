
$(document).ready(function () {
    var usercontainer = '#userDetailsModal';
    $(usercontainer).modal('hide');
}
);
function viewService(id) {
    /*  Submit form using Ajax */  
    var usernamediv = '#username';
    var usercontainer = '#userDetailsModal';
    var maildiv = '#mail';
    var rolediv = '#roles';
    var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    //Remove all errors
    // $(idbutton).next().remove();

    $.post({
        url: '/PresenzeDelta/users/view',
        data: {id: id},
        success: function (res) {
            try {
                 $(rolediv).text('');
                if (res.validated) {
                    //Set response
                    $(usercontainer).modal('show');
                    $(usernamediv).text(res.user.username);
                    $(maildiv).text(res.user.mailaziendale);
                    $.each(res.user.authorities, function (index,obj) {
                        $(rolediv).append(obj.authority + "<br />");
                    });

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



