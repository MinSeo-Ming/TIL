from django import forms
from django.shortcuts import get_object_or_404, redirect, render
from django.urls.base import reverse
from .models import Todo
from .forms import TodoWriteForm
from django.http import HttpResponseRedirect


def index(request):
    return render(request,'todos/index.html')


def update(request,todo_id):

    todo = get_object_or_404(Todo,pk=todo_id)
    
    if request.method =="POST":
        form = TodoWriteForm(request.POST)
        
        if form.is_valid():
            form.save()

            last = Todo.objects.last()
            todo.title=last.title
            todo.content=last.content
            todo.pub_date =last.pub_date
            
            last.delete()
            todo.save()
            return render(request,'todos/index.html')
        else:
            return render(request,'todos/index.html')
    else:
        form =TodoWriteForm()
        return render(request,'todos/update.html',{'form':form})
    


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
        return render(request,'todos/register.html',{'form':form})
    


def detail(request,todo_id):
    todo = Todo.objects.get(pk=todo_id)
    context = {'todo':todo}
    return render(request,'todos/detail.html',context)


def lists(request):
    todo_lists =Todo.objects.all().order_by("id")
    context = {"todo_lists":todo_lists}
    return render(request,'todos/lists.html',context)

