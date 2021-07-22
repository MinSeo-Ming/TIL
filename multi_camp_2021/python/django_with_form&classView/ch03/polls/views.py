from django import forms
from django.forms.fields import DateTimeField
from django.shortcuts import get_object_or_404, render
from django.http import  HttpResponse,HttpResponseRedirect
from django.urls import reverse
from .models import Choice, Question
from django.views.generic.list import ListView
from django.views.generic import detail

from polls import models
#/polls/요청시 
#latest_question_list에 Qution의 모든 select all해서 저장
# templates - index.htmlm select (latest_question_list 전달)


class IndexView(ListView):
    #object_list mode.lowercaser_list.html로 응답
    template_name = 'polls/index.html'
    context_object_name = 'latest_question_list' # 이걸 안쓰고 싶음 indexhtml을 바꿔야 함 원래는 그대로 써도 되는데 이렇게 만들어서 씀
    #default는  object_list임 그래서 우리는 overriding해서 사용해야함
    def get_queryset(self): #QuerySet -custom
        return Question.objects.all().order_by('pub_date')


class DetailView(detail.DetailView):
    model =Question 
    #context_object_name : 'object' tempalte_name ='polls/quesiotn_detail.html' 이거로 사용할거 아님 재정의가 필요함
    context_object_name = 'question'
    template_name = 'polls/detail.html'


class ResultView(detail.DetailView):
    model = Question
    template_name = 'polls/results.html'
    context_object_name ="question"



# polls/id/vote 호출시 id의 vote add한후 결과 페이지로  redirect
def vote(request, question_id):
    #id입력 값 검증 shortcut이용 존재하지 않음 404 error
    #business 로직 호출 : question_id의 Question 객체 select 
    question = get_object_or_404(Question, pk=question_id)
    
    #error인 경우는 detail.html로 question과  error_message 저장
    try:
        selected_choice = question.choice_set.get(pk=request.POST['choice'])
    except (KeyError, Choice.DoesNotExist):
        return render(request, 'polls/detail.html', {
            'question': question,
            'error_message': "You didn't select a choice.",
        })
        #request로 들어온 choice_id에 해당하는 vote 조회 - 증가 - update 수정
    else:
        selected_choice.votes += 1
        selected_choice.save()
        #direct로 result.html template 선택로 보내야해서 redirect 메소드를 사용한다.
        return HttpResponseRedirect(reverse('polls:results', args=(question.id,)))
