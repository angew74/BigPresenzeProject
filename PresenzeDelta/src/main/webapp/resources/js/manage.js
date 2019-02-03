
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
    var enabledDisplay = '#displayendisabled';
    //Remove all errors
    // $(idbutton).next().remove();
    var iconenabled = "fa fa-toggle-on";
    var spandisabled = "#icondisabled";
    var icondisabled = "fa fa-toggle-off";

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
                    if (res.user.enabled)
                    {
                        $(enabledDisplay).text('Abilitato');
                        $(spandisabled).removeClass(icondisabled);
                        $(spandisabled).addClass(iconenabled);

                    }
                    $.each(res.user.authorities, function (index, obj) {
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



function editService(id) {
    /*  Submit form using Ajax */
    var usernamediv = '#usernameedit';
    var usercontainer = '#userEditModal';
    var maildiv = '#mailedit';
    var rolediv = '#rolesedit';
    var errorcontainer = '#errorModal';
    var errorDisplay = '#errorDisplay';
    var enabledDisplay = '#displayendisabled';
    var iduseredit = '#iduseredit';
    var able = '#able';
    var disable = '#disable';
    //Remove all errors
    // $(idbutton).next().remove();
    var iconenabled = "fa fa-toggle-on";
    var spandisabled = "#icondisabled";
    var icondisabled = "fa fa-toggle-off";

    $.post({
        url: '/PresenzeDelta/users/view',
        data: {id: id},
        success: function (res) {
            try {
                if (res.validated) {
                    //Set response                  
                    $(usercontainer).modal('show');
                    $(usernamediv).val(res.user.username);
                    $(maildiv).val(res.user.mailaziendale);
                    $(iduseredit).val(res.user.id);
                    if (res.user.enabled)
                    {
                        $(able).prop('checked', true);
                        $(disable).prop('checked', false);
                        //  $(enabledDisplay).text('Abilitato');
                        // $(spandisabled).removeClass(icondisabled);
                        //  $(spandisabled).addClass(iconenabled);

                    }
                    var v;
                    $.each(res.user.authorities, function (index, obj) {
                        v += obj.authority + ",";
                    });
                    $(rolediv).val(v);
                } else {
                    //Set error messages
                    $.each(res.errorMessages, function (key, value) {
                        $(errorDisplay).text(value);
                        $(errorcontainer).modal('show');
                    });
                }
            } catch (err)
            {
                $(errorDisplay).text(err);
                $(errorcontainer).modal('show');
            }
        },
        error: function () {
            $(errorDisplay).text("errore di connessione");
            $(errorcontainer).modal('show');
        }
    });
    // EditUserCreation();
    //EditMailCreation();
    // EditRolesCreation();
}


$(function () {
    /*  Submit form using Ajax */
    $("#userEditForm").submit(function (event) {

        var idbutton = '#submitEditUser';
        var errorcontainer = '#errorModal';
        var errorDisplay = '#errorDisplay';
        var successcontainer = '#successModal';
        //Prevent default submission of form
        e.preventDefault();

        //Remove all errors
        $('input').next().remove();

        $.post({
            url: '/PresenzeDelta/users/add',
            data: $('form[name=userEditForm]').serialize(),
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

    });
});


