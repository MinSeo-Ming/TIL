
from django.urls import path
from polls.views import *

app_name ='polls'

# urlpatterns = [
#     path('',views.index,name='index'), #polls/
#     path('<int:question_id>/',views.detail,name ='detail'), #polls/2
#     path('<int:question_id>/result',views.results,name ='results'), #polls/2/result
#     path('<int:question_id>/vote',views.vote,name ='vote'), #polls/2/vote
#     path('register',views.questionCreate,name="register"),
#     path('<int:question_id>/choiceinput',views.choiceInput,name="choiceinput"),
#     path('choicesace',views.choiceCreate,name="choicecreate"),

# ]
urlpatterns = [
    path('',IndexView.as_view(),name='index'), #polls/
    path('<int:pk>/',DetailView.as_view(),name ='detail'), #polls/2
    path('<int:pk>/result',ResultView.as_view(),name ='results'), #polls/2/result
    path('<int:question_id>/vote',vote,name ='vote'), #polls/2/vote
]
