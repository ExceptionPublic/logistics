$(function() {
    $("#btn_login").click(function(){
        $.ajax({
            url:"personnel/emp/EmpLogin",
            data:{
                username:getValue("#username"),
                pwd:getValue("#pwd")
            },
            dataType:"json",
            type:"post",
            success:function(data){
                if(data.success)
                    location.href="index.jsp";
                else
                    msg(data.message);
            }
        });
    });
});