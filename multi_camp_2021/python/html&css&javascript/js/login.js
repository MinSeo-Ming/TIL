function loginCheck(){
  id_input = document.getElementById("login_id");
  pw_input = document.getElementById("login_pw");
  if(id_input.value==="cloud_msa"&&
  pw_input.value==="cloud_msa" ){
    window.location.href ="./todo.html";   
  }
  else{
    alert("아이디, 비밀번호 확인");
    id_input.value = "";
    pw_input.value = "";
  }
}