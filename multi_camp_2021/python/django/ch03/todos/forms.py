from django import forms
from .models import Todo


class TodoWriteForm(forms.ModelForm):
    class Meta :
        model =Todo
        fields=[

            'title',
            'content',
            'pub_date'
        ]
        