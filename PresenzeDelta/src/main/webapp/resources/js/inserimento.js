$(function () {
    $('#giornopicker').datetimepicker({
        format: 'L'
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


$.validate({
  form : '#insertPForm'
});


$.validate({
  modules : 'date, security',
  onModulesLoaded : function() {
    alert('All modules loaded!');
  }
});

$.validate({
  borderColorOnError : '#FFF',
  addValidClassOnAll : true
});


$(function () {    
    $("#malattia").change(function () {        
        $("#ferie").prop( "disabled", true );   
        $("#ferie").prop( "checked", false );       
         $("#reset").prop( "checked", false );    
        $("#pausapranzo" ).prop( "disabled", true );
        $("#orepermesso" ).prop( "disabled", true );
        $("#congedoparentale" ).prop( "disabled", true );
        $("#permessomalattafiglio" ).prop( "disabled", true );
        $("#oraentrata" ).prop( "disabled", true );
        $("#orauscita" ).prop( "disabled", true );
    });
});

$(function () {    
    $("#ferie").change(function () {        
        $("#malattia").prop( "disabled", true );   
        $("#malattia").prop( "checked", false );       
        $("#reset").prop( "checked", false );       
        $("#pausapranzo" ).prop( "disabled", true );
        $("#orepermesso" ).prop( "disabled", true );
        $("#congedoparentale" ).prop( "disabled", true );
        $("#permessomalattafiglio" ).prop( "disabled", true );
        $("#oraentrata" ).prop( "disabled", true );
        $("#orauscita" ).prop( "disabled", true );
    });
});

$(function () {    
    $("#reset").change(function () {        
        $("#malattia").prop( "disabled", false );   
        $("#ferie").prop( "disabled", false );   
        $("#malattia").prop( "checked", false );       
        $("#ferie").prop( "checked", false );       
        $("#pausapranzo" ).prop( "disabled", false );
        $("#orepermesso" ).prop( "disabled", false );
        $("#congedoparentale" ).prop( "disabled", false );
        $("#permessomalattafiglio" ).prop( "disabled", false );
        $("#oraentrata" ).prop( "disabled", false );
        $("#orauscita" ).prop( "disabled", false );
    });
});