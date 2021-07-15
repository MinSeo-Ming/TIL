
from django.urls import path
from todos import views

app_name ='todos'

urlpatterns = [
    path('',views.index,name='index'), #todo/
    path('register',views.register,name='register'), #todo/
    path('delete/<int:todo_id>',views.delete,name='delete'), #todo/
    path('update/<int:todo_id>',views.update,name='update'), #todo/
    path('detail/<int:todo_id>',views.detail,name='detail'), #todo/
    path('lists',views.lists,name='lists'), #todo/
]
