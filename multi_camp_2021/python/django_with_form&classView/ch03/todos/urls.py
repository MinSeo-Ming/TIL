
from django.urls import path
from todos.views import *

app_name ='todos'

urlpatterns = [
    path('',IndexView.as_view(),name='index'), #todo/
    path('register',register,name='todo_register'), #todo/
    path('delete/<int:todo_id>',delete,name='todo_delete'), #todo/
    path('update/<int:todo_id>',update,name='todo_update'), #todo/
    path('detail/<int:pk>',TodoDetail.as_view(),name='todo_detail'), #todo/
    path('list',TodoList.as_view(),name='todo_list'), #todo/
]
