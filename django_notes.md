

# Know These

- Django automatically creates a professional, production ready administrative interface a website that lets authenticated users add, change and delete objects. 

- The path strings use parameter tags to “capture” values from the URLs

- Paths are compiled into regular expressions at load time

- Generally, a view (Retrieves-Load-Render) retrieves data according to the parameters, loads a template and renders the template with the retrieved data

- Django uses the concept of “template inheritance”. That’s what the {% extends "base.html" %} does

- By default, the runserver command starts the development server on the internal IP at port 8000.

- some actions like adding files don’t trigger a restart, so you’ll have to
restart the server in these cases.

- Django comes
with a utility that automatically generates the basic directory structure of an app, so you can focus on writing code
rather than creating directories.

-  A project can contain multiple apps. An app can be in multiple projects.

- say, requesting this page “/polls/34/”, 

    ```py
    urlpatterns = [
        path('', views.index, name='index'),
        path('<int:question_id>/', views.detail, name='detail'),
        ]
    ```
    - Django will load yourProject.urls, (in this case, mysite.urls) -  because it’s pointed to by the ROOT_URLCONF setting
    - finds the variable named urlpatterns and traverses
    the patterns in order
    -  After finding 'polls/', it strips off the matching text ("polls/")
    - sends the remaining text – "34/"  to the ‘polls.urls’ URLconf for further processing
    - There it matches '<int:question_id>/', then it calls the detail() view like so: detail(request=<HttpRequest object>, question_id=34)

- Each view does two things: 
    - returning an HttpResponse object 
    - or raise an exception such as Http404. 
    (The rest is up to you)
 


# About 

- To call the view, we need to map it to a URL - so we need a URLconf
- The include() function allows referencing other URLconfs
- A URLconf maps URL patterns to views
- By default, the configuration uses SQLite
- The migrate command will only run migrations for apps in INSTALLED_APPS.
- For models, - Django follows the DRY Principle
---
- Table names are automatically generated - theAppName_lowercase of the model (e..g polls_question) - you can override it
- Primary keys (IDs) are added automatically. (You can override this, too.)
- The sqlmigrate command doesn’t actually run the migration on your database - it just prints it to the screen so
that you can see what SQL Django thinks is required
---
- By convention DjangoTemplates
looks for a “templates” subdirectory in each of the INSTALLED_APPS
    - Note:  put templates inside  directory named for the application itself

- say, {{something in a template}} e.g. {{question}} - Django does a "dictionary lookup" on the object question. Failing that, it tries an "attribute
lookup" – which works, in this case. If attribute lookup had failed, it would’ve tried a "list-index" lookup.
- Whenever you create a form that alters data server-side, use method="post". This tip
isn’t specific to Django; it’s just good Web development practice.
-  In short, all POST forms that are targeted at internal URLs should use the
{% csrf_token %} template tag.
- Always return an HttpResponseRedirect after successfully dealing with POST data. This prevents data from being posted twice if a user hits the Back button.


# Lesson One

    > django-admin startproject theProjectName
    > python manage.py startapp theAppName
    > python manage.py makemigrations
    > python manage.py makemigrations theAppName
    > python manage.py sqlmigrate theAppName 0001
    > python manage.py migrate ==> will apply the changes to you database
    > python manage.py shell
    > python manage.py runserver

    > python manage.py check ==> checks for any problems in your project without making migrations/ touching the database

    > python manage.py createsuperuser

# Change of port

    > python manage.py runserver 8080

    change the server’s IP, pass it along with the port
    > python manage.py runserver 0:8000
    0 is a shortcut for 0.0.0.0





 

# Imports

from django.db import models 

    from django.shortcuts import ...
        - render 
        - redirect
        - get_object_or_404
        - get_list_or_404
        - resolve_url
        
    from django.db import ...
        - models
        - Http404
        - HttpResponse
        - HttpResponsePermanentRedirect
        - HttpResponseRedirect
    
    from django.contrib import ...
        - admin  # admin.site.register(modelName)

    from django.urls import ...
        - path
        - include
        - reverse  # reverse(viewname=,args= )

    from django.http import ...
        - HttpResponse
        - HttpResponseNotAllowed
        - HttpRequest
        - Http404   # Http404('text here')
        - HttpResponseRedirect
    
    from django.utils import ...
        - timezone   # timezone.now() , timezone.now().year

    from django.template import ... 
        - loader   
            # template = loader.get_template()
            # HttpResponse(
                template.render(context, request)
            )

    fom django.views import ... 
        - generic



# Internals

models.

    Aggregate, AutoField, Avg, 
    BaseConstraint, BaseManager, BigAutoField, BigIntegerField, BinaryField, BooleanField, 
    Case, CharField, CheckConstraint, Col, Combinable, CombinedExpression, Count, 
    DateField, DateTimeField, Deferable, DurationField, 
    EmailField, Exists, Expression, ExpressionList, ExpressionWraper,
    Field, FieldDoesNotExit, FieldFile, FileDescriptor, FileField, FilePathField, FilteredRealtion, FloatField,ForeignKey, ForeignObject, ForeignObjectRel, Func,
    GenericIPAddressField,
    ImageField, Index, IntegerChoices, IntegerField, IPAddressField,
    JSONField, 
    Lookup,
    Manager, ManyToManyField, ManayToManyRel, Max, Min, Model, 
    NOT_PROVIDED, OneToOneField, OneToOneRel, OrderBy, OrderWrt, OuterRef, 
    PositiveBigIntegerField, PositiveIntegerField, PositiveSmallIntegerField,Prefetch,
    Q,
    QuerySet,
    RawQuerySet, RawSQL, Ref, RestrictedError, RwaRange, 
    SlugFiled, SmallAutoField, SmallIntegerField, StdDev, Subquery, Sum, 
    TextChoices. TextField, TimeField, Transform,
    UniqueConstraint, URLField, UUIDField, 
    Value, ValueRange, Variance,
    When, Windows, WindowFrame


- Examples:
```py
    class Question(models.Model):
        question_text = models.CharField(max_length=200)
        pub_date = models.DateTimeField('date published')  # pub_date=timezone.now()
        def __str__(self):
            return self.question_text


    class Choice(models.Model):
        question = models.ForeignKey(Question, on_delete=models.CASCADE)
        choice_text = models.CharField(max_length=200)
        votes = models.IntegerField(default=0)

    # q.choice_set.all()
    # q.choice_set.create(choice_text='Not much', votes=0)
    # q.choice_set.count()
    # Choice.objects.filter(question__pub_date__year=current_year)
    # c = q.choice_set.filter(choice_text__startswith='Just hacking')
    # c.delete()
    # 
    # 
```
-  Each model is represented by a class that subclasses django.db.models.Model.
- . CharField, for example, requires that you give it a max_length.
---
# path(route=, view=)

The path() function  = four arguments
 -  two required: route and view, e.g. path(route='/', view=include('a.urls'))
    - route  = string that contains a URL pattern
    - View =  this is a function called When Django finds a matching pattern. 
        - first argument = HttpRequest object as  
        -  keyword arguments = any “captured” values from the route
 -  two optional: kwargs, and name.
    - Arbitrary keyword arguments can be passed in a dictionary to the target view 

For example, in a request to https://www.example.com/myapp/, the URLconf will look for myapp/.
In a request to https://www.example.com/myapp/?page=3, the URLconf will also look for myapp/


---

# Code

    reporter = models.ForeignKey(Reporter, on_delete=models.CASCADE)

    > Reporter.objects.all()

            # create a new Reporter
    > newReporter = Reporter(full_name='nameHere')

            # save it
    > newReporter.save()

            # now it has been given an id 
    > newReporter.id

            # lookup
    > Reporter.objects.get(id=1)
    > Reporter.objects.get(full_name__startswith='John')
    > Reporter.objects.get(full_name__contains='mith')
    > Article.objects.filter(reporter__full_name__startswith='John')
    year = '2000'
    > Article.objects.filter(pub_date__year=year)

            # delete
    > newReporter.delete()

```py
'''
displays the latest 5 poll questions in the system, separated by commas, according to publication date
'''

latest_question_list = Question.objects.order_by('-pub_date')[:5]
```
---

# some shortcuts

```py
#============================

    context = {...}
    # this
    template  = loader.get_template('polls/index.html')
    return HttpResponse(template.render(context, request))
    # or 
    return render(
            request=request, 
            template_name='polls/index.html',
            context=context,
        )


#============================

    # this

    try:
        question = Question.objects.get(pk=question_id)
    except Question.DoesNotExist:
        raise Http404('Question does not exit ooo')

    # or 

    question = get_object_or_404(Question, pk=question_id)  
```


# Others

    from datetime import date
    dt = date.today()

# Snippet

    admin.site.register(models.Article)
---

    urlpatterns = [ path('articles/<int:year>/', views.year_archive),]
    urlpatterns = [
        path('polls/', include('polls.urls')),
        path('admin/', admin.site.urls),
    ]

---

    INSTALLED_APPS = ['theAppName.apps.TheappnameConfig',]


#  quick api

```py
#----------------------------
class Question(models.Model):
    question_text = models.CharField(max_length=200)
    pub_date = models.DateTimeField('date published')

    def __str__(self):
        return self.question_text
    
    def was_published_recently(self):
        return self.pub_date >= timezone.now() - datetime.timedelta(days=1)


class Choice(models.Model):
    question = models.ForeignKey(Question, on_delete=models.CASCADE)
    choice_text = models.CharField(max_length=200)
    votes = models.IntegerField(default=0)


    def __str__(self):
        return self.choice_text

#---------------------------
Question.objects.filter(id=1)

Question.objects.filter(question_text__startswith='What')

current_year = timezone.now().year

Question.objects.get(pub_date__year=current_year)

Question.objects.get(pk=1)  = similar to = Question.objects.get(id=1)

q = Question.objects.get(pk=1)
q.choice_set.all()   # note that Choice is a model, that has a question as a Foreign Key
q.choice_set.count()
q.choice_set.create(choice_text='Not much', votes=0)
c = q.choice_set.create(choice_text='Just Hacking again', votes=0)
c.question, c.choice_text, e.t.c
# Use double underscores to separate relationships.
# This works as many levels deep as you want; there's no limit.
# Find all Choices for any question whose pub_date is in this year
Choice.objects.filter(question__pub_date__year=current_year)
c = q.choice_set.filter(choice_text__startswith='Just hacking')
c.delete()

#--------------------
from django. contrib. auth. models import User
User. objects. filter(is_superuser=True)


#----------------------------

Question.objects.order_by('-pub_date')[:5]  #  order by the date, take the first 5

```



# render(request=, template=, context=) 
The render() function takes:
- first argument = request
- second argument = template
- third argument = context dictionary (optional)

It returns an HttpResponse object of the given template rendered with the given context.




# Generic Views

- ListView, DetailView

```py

# From 

        def index(request):
            latest_question_list = Question.objects.order_by('-pub_date')[:5]
            context = {
                'latest_question_list':latest_question_list,
            }
            
            return render(
                request=request, 
                template_name='polls/index.html',
                context=context,
            )

# To

            class IndexView(generic.ListView):
                template_name='polls/index.html'
                context_object_name = 'latest_question_list'

                def get_queryset(self):
                    '''
                    returns the last five published questions
                    '''
                    return Question.objects.order_by('-pub_date')[:5]



```

```py
# From 

                def results(request, question_id):
                    question = get_object_or_404(Question,pk=question_id)
                    return render(
                        request=request,
                        template_name='polls/results.html',
                        context={
                            'question':question,
                        }
                    )



#To

        class ResultsView(generic.DetailView):
            model = Question 
            template_name='polls/results.html'
            context_object_name = 'question'  # it is provided by default from the model name


```

```py

# From 
                def detail(request, question_id):
                    question = get_object_or_404(Question, pk=question_id)
                    context = {
                        'question': question,
                    }
                    return render(
                        request=request,
                        template_name='polls/detail.html',
                        context=context,
                    )


# To

            class DetailView(generic.DetailView):
                model = Question 
                template_name='polls/detail.html'

                #the  context_object_name is 'question' -> so you can use it in the template

```




---
# Namespacing URL names
In real Django projects, there might be five, ten, twenty apps or more. They are have sme names in the 
- path('somePath', view.something, name='theName-which could be the same in other apps'),
```py
# in your app-urls.py ;  do this
app_name = 'theappname'
```
---
The above will help django  - after, do this 
```django
<a href="{% url 'polls:detail' question.id %}">{{question.question_text}}</a>
```
the 'polls:detail' make django aware the it is from the polls app, you want the name=details
    
# Templates
```django

#-----------------

    {% extends "base.html" %}

#-----------------

    {{ article.pub_date|date:"F j, Y" }}  # date Filter

    <li>
        <a href="{% url 'detail' question.id %}">
            {{ question.question_text }}
        </a>
    </li>

#-----------------

<form action="{% url 'polls:vote' question.id %}" method="post">
    {% csrf_token %}
    {% for choice in question.choice_set.all %}
        <input type="radio" name="choice" id="choice{{ forloop.counter }}" value="choice.id">
        <label for="choice{{ forloop.counter }}">{{choice.choice_text}}</label>
        <br>
    {% endfor %}
    <input type="submit" value="Vote">
</form>
```


# Others - Trival

- Any Model has this exception with it.. 
    - say, model name, Question, Choice, e.t.c, you can raise an exception with
        - Question.DoesNotExist 
        - Choice.DoesNotExist


# Others - To know
   - “large” database engine like PostgreSQL, MySQL, or Oracle

    > import django
    > django.get_version()
    > python -m django --verison

    - production server – e.g. Apache

    


# Theory

- manage.py: A command-line utility that lets you interact with this Django project in various ways
- \_init__.py: An empty file that tells Python that this directory should be considered a Python package
- urls.py: The URL declarations for this Django project; a “table of contents” of your Django-powered
site.






# Note - Important 

-  race condition
