from django import forms
from django.db import models
from django.shortcuts import get_object_or_404, redirect, render
from django.urls.base import reverse
from django.views.generic.base import TemplateView
from django.views.generic.list import ListView

from django.views.generic.detail import DetailView
from .models import Todo
from .forms import TodoWriteForm
from django.http import HttpResponseRedirect


class IndexView(TemplateView):
    template_name = "todos/index.html"


class TodoDetail(DetailView):
    model = Todo


class TodoList(ListView):
    model =Todo


def update(request,todo_id):

    todo = get_object_or_404(Todo,pk=todo_id)
    
    # todo.save()
    # return render(request,'todos/index.html')
    if request.method =="POST":
        form = TodoWriteForm(request.POST)
        
        if form.is_valid():
            form.fields['pk']=todo_id
            todo.delete()
            form.save()
            return render(request,'todos/index.html')
        else:
            return render(request,'todos/index.html')
    else:
        form =TodoWriteForm()
        return render(request,'todos/todo_update.html',{'form':form})
    
    


def delete(request,todo_id):

    todo_delete = get_object_or_404(Todo,pk=todo_id)
    todo_delete.delete()
    
    return render(request,'todos/index.html')


def register(request):
    
    if request.method =="POST":
        form = TodoWriteForm(request.POST)
        if form.is_valid():
            form.save()
            return render(request,'todos/index.html')
        else:
            return render(request,'todos/index.html')
    else:
        form =TodoWriteForm()
        return render(request,'todos/todo_register.html',{'form':form})
    

