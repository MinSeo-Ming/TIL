from django.db import models
from django.db.models.base import Model
# Create your models here.


class Todo(models.Model):
    title = models.CharField(max_length=50)
    pub_date = models.DateTimeField('date published')
    content = models.CharField(max_length=200)

    def __str__(self):
        return str(self.title) +" : "+str(self.content)

