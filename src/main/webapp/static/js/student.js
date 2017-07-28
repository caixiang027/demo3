
$(function(){
    function init() {
        $.ajax({
            type: "get",
            url: "/demo3/getStudentDetail",
            data: null,
            success: function(msg){
                $("#studentBody").empty();
                if(msg){
                    $.each(msg,function(key,value){
                        var tmp = "<tr><td>"+value.className+"</td><td>"+value.studentName+"</td><td>"+value.sex+"</td><td>"+value.age+"</td><td>"+value.address+"</td><td><button id='update' data-id='"+value.id+"'>修改</button><button id='delete' data-id='"+value.id+"'>删除</button></td></tr>"
                        $("#studentBody").append(tmp);
                    })
                }
            }
        })
    }
    $.ajax({
        type: "post",
        url: "/demo3/class",
        data: null,
        success: function(msg){
            $("#className").empty();
            if(msg){
                $.each(msg,function(key,value){
                    var tmp = "<option value="+value.id+">"+value.name+"</option>"
                    $("#className").append(tmp);
                })
            }
        }
    });
    init();
    $("#studentBody").on("click","#update",function () {
        var student = {};
        student.id = $(this).data("id");
        student.cid = $("#className").val();
        student.name = $("#studentName").val();
        student.sex = $("#sex").val();
        student.age = $("#age").val();
        student.address = $("#address").val();
        $.ajax({
            type: "put",
            url:"/demo3/updateStudent",
            data: JSON.stringify(student),
            contentType:"application/json",
            success: function(msg){
                init();
            }
        })
    });
    $("#add").click(function(){
        var student = {};
        student.cid = $("#className").val();
        student.name = $("#studentName").val();
        student.sex = $("#sex").val();
        student.age = $("#age").val();
        student.address = $("#address").val();
        $.ajax({
            type: "post",
            url: "/demo3/addStudent",
            data: JSON.stringify(student),
            contentType:"application/json",
            success: function(msg){
                init();
            }
        })
    });
    $("#studentBody").on("click","#delete",function () {
        $.ajax({
            type: "post",
            url: "/demo3/deleteStudent/"+$(this).data("id"),
            success: function(msg){
                init();
            }
        })
    })
})

