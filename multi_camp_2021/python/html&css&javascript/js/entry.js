function formCheck(){
  id = document.getElementById('id');
  email = document.getElementById('email');
  pw = document.getElementById('pw');
  pw_ck = document.getElementById('pw_ck');

  if( (id.value !=="")&&(email.value !=="")&&
      (pw.value !=="")&&(pw_ck.value !=="")){
        if(pw.value !==pw_ck.value){
          alert("비밀번호와 비밀번호 확인이 같지 않습니다.");
          pw.value="";
          pw_ck.value="";
        }
        else{
          window.location.href="./todo.html";
        }
        
      }
  else{
      id.value="";
      email.value="";
        pw.value="";
        pw_ck.value="";
        alert("아이디, 이메일, 비밀번호, 비밀 번호 확인 전부다 입력해주세요.");
  }
  
}