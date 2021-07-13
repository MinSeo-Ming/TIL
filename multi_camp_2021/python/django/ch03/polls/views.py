from django.shortcuts import get_object_or_404, render
from django.http import  HttpResponse,HttpResponseRedirect
from django.urls import reverse
from .models import Choice, Question

# Create your views here.
#/polls/요청시 
#latest_question_list에 Qution의 모든 select all해서 저장
# templates - index.htmlm select (latest_question_list 전달)
def index(request):
    #입력값 검증
    #business method 호출 question 목록 가져오기
    # select * from polls_question order by desc pu_date
    latest_question_list =Question.objects.all().order_by('pub_date')
    #일정범위에 data저장
    context = {'latest_question_list':latest_question_list}
    return render(request,'polls/index.html',context)


# /polls/id 요청시 id에 해당하는choice 항목 출력후
# vote 버튼 출력
def detail(request, question_id):
    #입력값 검증 : question_id
    #business method 호출 question_id에 해당하는 Question 값 
    #try:
    # question = Question.objects.get(pk = question_id)
    #except Question.DoesNotExist:
    #   raise Http404("Question does not exist")
    question = get_object_or_404(Question,pk=question_id)

    # 일정 범위에 데이터 저장 -question
    #template select - polls/detail.html
    context = {'question':question}
    return render(request,"polls/detail.html",context)


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


#/polls/id/results/ 요청시 id에 해당한느 vote 결과 출력
def results(request, question_id):
    #id입력 값 검증 shortcut이용 존재하지 않음 404 error
    #business 로직 호출 : question_id의 Question 객체 select 
    question = get_object_or_404(Question, pk=question_id)
    #일점 범위내에  데이터 저장 template select
    context ={'question':question}

    return render(request,'polls/result.html',context)