from django.shortcuts import render
from django.views.generic.base import TemplateView
from django.views.generic.list import ListView
from django.views.generic.detail import DetailView
from books import models

from books.models import Author, Book, Publisher
# Create your views here.

class BooksModelView(TemplateView):
    template_name = "books/index.html"

    def get_context_data(self, **kwargs):
        context = super().get_context_data(**kwargs)
        context['model_list'] = ['Book','Author',"Publisher"]
        return context


class BookList(ListView):
    model = Book
    #object_list = Book.ojects.all()
    #context = {"object_list : object_list"}
    #return render (request,"books/book_list.html",context)


class BookDetail(DetailView):
    model = Book
    #object = Book.object.get(pkk id)
    #context ={"object":object}
    # return render(request,"book/book_detail.html",context)

class AuthorList(ListView):
    model =Author


class AuthorDetail(DetailView):
    model = Author


class PublisherList(ListView):
    model = Publisher


class PublisherDetail(DetailView):
    model = Publisher

