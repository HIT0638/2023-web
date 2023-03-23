$(document).ready(function () {
    let result = "";
    $.ajax({
        url: "student-servlet",
        data: {
            action : "getAll"
        },
        dataType: "json",
        type: "GET",
        success : function (data){
            for(let i = 0; i < data.length; i ++){
                result += "<tr>" +
                    "<td>" + data[i].sid +"</td>" +
                    "<td>" + data[i].sname + "</td>" +
                    "<td>" + data[i].age +"</td>" +
                    "<td>" + data[i].gender +"</td>" +
                    "<td>" + data[i].mid +"</td>" +
                    "<td>" + data[i].birthday +"</td>" +
                    "</tr>"
            }

            result = "<table border='1' id='showStuTable'><tr>" +
                "<td>学号</td><td>姓名</td><td>年龄</td><td>性别</td><td>专业</td><td>生日</td>" +
                "</tr>" + result + "</table>";

            $(".showStuBox").html(result);
        },
        error : function (){
            alert("error")
        }
    })
})

document.getElementById("check").innerHTML = xmlHttp.readyState;
document.getElementById("check").innerHTML = xmlHttp.status;

$(function () {
    $("#submitButton").bind('click',function (){
        if($("#sid").val().length==0) {
            alert('学号不能为空');
            return;
        }
        if($("#sname").val().length==0) {
            alert('姓名不能为空');
            return;
        }
        if($(".gender").val().length==0) {
            alert('性别不能为空');
            return;
        }
        if($("#age").val().length==0) {
            alert('年龄不能为空');
            return;
        }
        if($("#birthday").val().length==0) {
            alert('生日不能为空');
            return;
        }
        if($("#major").val() == "0") {
            alert('专业不能为空');
            return;
        }
        $.ajax({
            url: "student-servlet",
            data: {
                action: "add",
                sid: $("#sid").val(),
                sname: $("#sname").val(),
                gender: $(".gender").val(),
                age: $("#age").val(),
                birthday: $("#birthday").val(),
                mid: $("#major").val()
            },
            dataType: "json",
            type: "GET",
            success: function (res) {
                let result = "";
                console.log(res);
                if(res == "exist")
                    alert('该学号已存在，请重新输入');
                else {
                    alert('添加成功');
                    $.ajax({
                        url : "student-servlet",
                        data : {
                            action: "getAll"
                        },
                        dataType : 'json',
                        type: 'get',
                        success: function (data) {
                            for(let i = 0; i < data.length; i ++){
                                result += "<tr>" +
                                    "<td>" + data[i].sid +"</td>" +
                                    "<td>" + data[i].sname + "</td>" +
                                    "<td>" + data[i].age +"</td>" +
                                    "<td>" + data[i].gender +"</td>" +
                                    "<td>" + data[i].mid +"</td>" +
                                    "<td>" + data[i].birthday +"</td>" +
                                    "</tr>"
                            }

                            result = "<table border='1' id='showStuTable'><tr>" +
                                "<td>学号</td><td>姓名</td><td>年龄</td><td>性别</td><td>专业</td><td>生日</td>" +
                                "</tr>" + result + "</table>";

                            $(".showStuBox").html(result);
                        },
                        error: function () {
                            alert('error2');
                        },
                    });
                }
            },

        })
    })
});

function ChangeTo(ch) {
    if(ch == 'm')
        return "男";
    else
        return "女";
}