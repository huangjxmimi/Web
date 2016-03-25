$(document).ready(function()
{
    $("#register").hide();
    $("#li_reg").click(function()
    {
        $("#login").hide();
        $("#register").show();
        $("#li_login").removeClass("active")
        $(this).addClass("active");
    })
    $("#li_login").click(function()
    {
        $("#login").show();
        $("#register").hide();
        $("#li_reg").removeClass("active")
        $(this).addClass("active");
    })
    $("#username").keyup(function()
    {
            var text=$(this).val();
            $("#warn_uname").text(text);
    })
});
/**
 * Created by xingli on 2016/3/25.
 */
