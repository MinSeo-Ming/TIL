function todoHandler(){
  title = document.getElementById('title').value;
  content = document.getElementById('content').value;
  date = document.getElementById('date').value;

  if (localStorage.length!=0){
    for(let i =0; i<localStorage.length; i++){ 
      key = localStorage.key(i);
      console.log(key+" : "+ localStorage.getItem(key))
    }
  }
  
  document.getElementById("todo").innerHTML = 
  "제목 : "+title+`<br/><br/>`+"일정 : " +content+`<br/><br/>`+"날짜 : "+date;
}