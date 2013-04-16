var loggedIn = false;

$(document).ready(function() {
    var isUp = true;
    
    loggedIn = document.getElementById("hidden_login_field:is_user_logged_in").value === "true";
    wrongPassword = document.getElementById("hidden_login_field:last_login_failed").value === "true";
    
    if(wrongPassword) {
        $("#top_bar_span_login").show();
        $("#site_opaque").show();
    } else {
        $("#top_bar_span_login").hide();
        $("#site_opaque").hide();
    }

    $("#top_bar_span_login_always_show").click(function() {
        
        if (!loggedIn) {
            // Starting animation of drop down and white overlay.
            $("#site_opaque").fadeToggle('slow');
            $("#top_bar_span_login").slideToggle('slow');

            // Enabling/disabling overflow (scroll bars)
            if (isUp) {
                //$("body").css("overflow", "hidden");
                isUp = false;
            } else {
                $("#top_bar_span_login").promise().done(function() {
                    //$("body").css("overflow", "auto").fadeIn('slow');
                    isUp = true;
                });
            }
        }

    }).children().click(function(e) {
        return false;
    });
    
    /*$(".control_panel_header").click(function() {
     $(".control_panel_button_section").slideToggle('slow');
     });*/
});