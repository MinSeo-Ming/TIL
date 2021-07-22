
# from ch03.polls.views import *
from django.contrib import admin
from django.urls import path,include
from polls import views
from books import views
from mysite.views import HomeView
urlpatterns = [
    path('admin/', admin.site.urls),
    path('polls/',include('polls.urls')),
    path('todos/',include('todos.urls')),
    path('books/',include('books.urls')),
    path('',HomeView.as_view(),name="home"),


]
