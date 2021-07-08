class Todo():

    def __init__(self,id,title,contents,date,done):
        self.id=str(id)
        self.title =title
        self.contents =contents
        self.date =date
        self.done =done
    
    def info(self):
        return "아이디 : "+self.id+"  날짜 : "+self.date+ "  제목 : "+self.title+"\n내용 : "+ self.contents+"\n성공유무 : "+self.done

