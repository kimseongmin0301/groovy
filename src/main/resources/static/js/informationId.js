import {regEmail} from "./module.js";

$(function(){
    $('#info-id').addClass("active");
    $('#info-pw').removeClass("active");

    const receiveMail = () => {
        $('#receive-auth').off().on('click', () => {
            if(regEmail($("#email").val())){
                $.ajax({
                    url:`/groovy/api/authId`,
                    type:`post`,
                    data:JSON.stringify({
                        "email":$("#email").val()
                    }),
                    contentType:`application/json`,
                    success:e => {
                        alert("메일이 발송되었습니다. 메일이 오지 않으면 입력하신 정보가 회원정보와 일치하는지 확인해 주세요.")
                        findInformationId(e);
                    }
                })
            }else{
                $("#my-name").html("이메일을 올바르게 입력하세요");
            }
        })
    }

    const findInformationId = (e) => {
        $('#check-auth').off().on('click', () => {
            if($('#auth').val() === e){
                $('#receive-auth').attr("disabled",true);
                $.ajax({
                    url:`/groovy/api/lostId`,
                    type:`post`,
                    data:JSON.stringify({
                        "userName":$('#name').val(),
                        "userEmail":$('#email').val()
                    }),
                    contentType:`application/json`,
                    success:(response) => {
                        console.log(response);
                        if(response.result.id === null){
                            alert("일치하는 정보가 없습니다")
                            location.reload();
                        }else{
                            $("#my-name").html(`아이디 : `+ response.result.id.userId + `<a href="/groovy/findPw"><button>비밀번호 찾기</button></a>`);
                        }
                    }
                })
            } else{
                $("#my-name").html("인증번호를 다시 확인해주세요");
            }
        })
    }

    receiveMail();
})