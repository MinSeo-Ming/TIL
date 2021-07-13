
from django.urls import path
from polls import views

app_name ='polls'

urlpatterns = [
    path('',views.index,name='index'), #polls/
    path('<int:question_id>/',views.detail,name ='detail'), #polls/2
    path('<int:question_id>/result',views.results,name ='results'), #polls/2/result
    path('<int:question_id>/vote',views.vote,name ='vote'), #polls/2/vote


]
