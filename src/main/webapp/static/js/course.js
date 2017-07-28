
$(function(){
    function init() {
        $.ajax({
            type: "get",
            url: "/demo3/course",
            data: null,
            success: function(msg){
                $("#courseBody").empty();
                if(msg){
                    $.each(msg,function(key,value){
                        var tmp = "<tr><td>"+value.className+"</td><td>"+value.studentName+"</td><td>"+value.subject+"</td><td>"+value.score+"</td></tr>"
                        $("#courseBody").append(tmp);
                    })
                }
            }
        })
    }
    init();

    $("#select").click(function(){
        var name;
        if($("#name").val()=="className") {
            name = "class.name";
        }
        if($("#name").val()=="studentName") {
            name = "student.name"
        }
        if($("#name").val()=="subject") {
            name = "course.subject"
        }
        if($("#name").val()=="score") {
            name = "course.score"
        }
        var value = $("#value").val();
        $.ajax({
            type: "post",
            url: "/demo3/course/selectCourseLike/"+name+"/"+value,
            success: function(msg){
                $("#courseBody").empty();
                if(msg){
                    $.each(msg,function(key,value){
                        var tmp = "<tr><td>"+value.className+"</td><td>"+value.studentName+"</td><td>"+value.subject+"</td><td>"+value.score+"</td></tr>"
                        $("#courseBody").append(tmp);
                    })
                }
            }
        })
    })

})