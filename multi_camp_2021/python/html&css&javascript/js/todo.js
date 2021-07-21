function todoHandler(){
  title = document.getElementById('title').value;
  content = document.getElementById('content').value;
  date = document.getElementById('date').value;

  console.log(title,content,date);

  document.getElementById("todo").innerHTML = 
  "제목 : "+title+`<br/><br/>`+"일정 : " +content+`<br/><br/>`+"날짜 : "+date;
}