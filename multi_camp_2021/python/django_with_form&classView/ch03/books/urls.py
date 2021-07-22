from django.contrib import admin
from django.urls import path
from books.views import *

app_name ='books'

urlpatterns = [
    path('',BooksModelView.as_view(),name='index'), #books/
    path('book/',BookList.as_view(),name='book_list'), #books/book
    path('book/<int:pk>',BookDetail.as_view(),name='book_detail'), #books/book/3/

    path('author/',AuthorList.as_view(),name='author_list'), #books/author
    path('author/<int:pk>',AuthorDetail.as_view(),name='author_detail'), #books/author/3

    path('publisher/',PublisherList.as_view(),name='publisher_list'), #books/publisher
    path('publisher/<int:pk>',PublisherDetail.as_view(),name='publisher_detail'), #books/publisher/3
]
