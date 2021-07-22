from django import forms
from django.forms import fields
from .models import Choice, Question

class QuestionForm(forms.Form):
    class Meta : 
        model = Question #사용할 모델
        fields =['questioin_text'] #Question Form에서  사용할 Qutsionn 모델 속성


class ChoiceForm(forms.Form):
    class Meta:
        model = Choice
        fields =['choice_text','question'] #ChoiceForm에서 사용할 Choice 모델 속성
