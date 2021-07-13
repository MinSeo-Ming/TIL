
# from ch03.polls.views import *
from django.contrib import admin
from django.urls import path,include

urlpatterns = [
    path('admin/', admin.site.urls),
    path('polls/',include('polls.urls')),
    path('todos/',include('todos.urls')),


]
