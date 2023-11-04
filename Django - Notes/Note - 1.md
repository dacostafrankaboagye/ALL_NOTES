

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

- Django provides a test Client to simulate a user interacting with the code at the view level - use it in the test.py or shell

- check out https://djangopackages.org/ 
 - A Python package provides a way of grouping related Python code for easy reuse
 - it must contain a special file __init__.py, even if this file is empty.
- Python packaging refers to preparing your app in a specific format that can be easily installed and used

- Django and many Django-compatible apps are distributed under the BSD license; however, you’re free to pick your own license. Just be aware that your licensing choice will affect who is able to use your code
 
 - Only Python modules and packages are included in the package by default. To include additional files, we’ll need
to create a MANIFEST.in file


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

- django.contrib.staticfiles is for: it collects static files from each of your applications (and any
other places you specify) into a single location that can easily be served in production.

- Django offers a tabular way of displaying inline related objects;


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

    # where the Django source files are located on your system
    > python -c "import django; print(django.__path__)"

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
        - admin  
            # admin.site.register(modelName)
            # class Something(admin.ModelAdmin)
            # class Something(admin.StackedInline)
            # class Something(admin.TabularInline)


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

    from django.test import ... 
        - TestCase 
        - Client 

    from django.test.utils import ... 
        -  setup_test_environment

    from django.forms.models  import ...
        - model_to_dict





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
```py

    admin.site.register(models.Article)
```
---

```py
    urlpatterns = [ path('articles/<int:year>/', views.year_archive),]
    urlpatterns = [
        path('polls/', include('polls.urls')),
        path('admin/', admin.site.urls),
    ]

```
---

```py

    INSTALLED_APPS = ['theAppName.apps.TheappnameConfig',]

```

---

```py
# column header
# You can click on the column headers to sort by those values
# note that - sorting by the output of an arbitrary method is not supported


class Question(models.Model):
    question_text = models.CharField(max_length=200)
    pub_date = models.DateTimeField('date published')

    def __str__(self):
        return self.question_text
    
    def was_published_recently(self):
        now = timezone.now()
        return now - datetime.timedelta(days=1) <= self.pub_date <= now
        # return self.pub_date >= timezone.now() - datetime.timedelta(days=1)  -- old

    was_published_recently.admin_order_field = 'pub_date'
    # was_published_recently.boolean = True 
    was_published_recently.short_description = 'Published recently?'

```

---

```py

 Product.objects.all().order_by("?").first()

```


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


---

# Helpful

```django
response.status_code
reponse.context['something here']
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



# Test 
- in the test.py
- the testing system will automatically find tests in any file whose name begins with test
samples

```py
from django.test import TestCase
from django.utils import timezone
import datetime 
from .models import Question 

class QuestionModelTest(TestCase):

    def test_was_published_recently_with_future_question(self):
        '''     
            was_published_recently() returns False for questions whose pub_date
            is in the future.
        '''
        time = timezone.now() + datetime.timedelta(days=30)
        future_question = Question(pub_date=time)
        self.assertIs(future_question.was_published_recently(), False)
        

# in shell 
#python manage.py test polls  
# 
'''
- looks for test in polls' app
- found a subclass of the django.test.TestCase
- creates/created a special database for testing 
- looks for methods - starting with test
'''

class QuestionModelTest(TestCase):

    def test_was_published_recently_with_future_question(self):
        '''     
            was_published_recently() returns False for questions whose pub_date
            is in the future.
        '''
        time = timezone.now() + datetime.timedelta(days=30)
        future_question = Question(pub_date=time)
        self.assertIs(future_question.was_published_recently(), False)

    def test_was_published_recently_with_old_question(self):
        '''
            was_published_recently() returns False for questions whose pub_date
            is older than 1 day.
        '''
        time = timezone.now() - datetime.timedelta(days=1, seconds=1)
        old_question = Question(pub_date = time) 
        self.assertIs(old_question.was_published_recently(), False)

    def test_was_published_recently_with_recent_question(self):
        '''
        was_published_recently() returns True for questions whose pub_date
        is within the last day.
        '''
        time = timezone.now() - datetime.timedelta(hours=23, minutes=59, seconds=59)
        recent_question = Question(pub_date=time)
        self.assertIs(recent_question.was_published_recently(), True)


```


```py
# in shell

>>from django.test.utils import setup_test_environment
>>setup_test_environment()
>>from django.test import Client
>> # create an instance of the client for our use
>> client = Client()
>>> # get a response from '/'
>>> response = client.get('/')  
>>> response.status_code  # 404
>>> # on the other hand we should expect to find something at '/polls/'
>>> # we'll use 'reverse()' rather than a hardcoded URL
>>> from django.urls import reverse
>>> response = client.get(reverse('polls:index'))
>>> response.status_code  # 200 
>>> response.content
>>> response.context
'''
[{'True': True, 'False': False, 'None': None}, {'csrf_token': <SimpleLazyObject: <function csrf.<locals>._get_val at 0x0000012D6CF231F0>>, 'request': <WSGIRequest: GET '/polls/'>, 'user': <SimpleLazyObject: <function AuthenticationMiddleware.process_request.<locals>.<lambda> at 0x0000012D6CF23160>>, 'perms': PermWrapper(<SimpleLazyObject: <function AuthenticationMiddleware.process_request.<locals>.<lambda> at 0x0000012D6CF23160>>), 'messages': <FallbackStorage: request=<WSGIRequest: GET '/polls/'>>, 'DEFAULT_MESSAGE_LEVELS': {'DEBUG': 10, 'INFO': 20, 'SUCCESS': 25, 'WARNING': 30, 'ERROR': 40}}, {}, {'paginator': None, 'page_obj': None, 'is_paginated': False, 'object_list': <QuerySet [<Question: What's up?>]>, 'latest_question_list': <QuerySet [<Question: What's up?>]>, 'view': <polls.views.IndexView object at 0x0000012D6CE8DD60>}]
'''
>>> response.context['latest_question_list']
'''
<QuerySet [<Question: What's up?>]>
'''




'''
setup_test_environment() installs a template renderer which will allow us to examine some additional attributes
on responses such as response.context that otherwise wouldn’t be available.
that this method does not setup
a test database, so it will be run against the existing database
'''


```

- django.test.TestCase class provides some additional assertion methods. E.g. assertContains() and assertQuerysetEqual()

- The database is reset for each test method
- in testing redundancy is a good thing
• a separate TestClass for each model or view
• a separate test method for each set of conditions you want to test
• test method names that describe their function

- you can use an “in-browser” framework such as Selenium to test the way your HTML actually renders in a browser.
- Django includes LiveServerTestCase to facilitate integration with tools like Selenium








# Comment - static

-  “static files”  = e.g. images, JavaScript, or CSS
- create a directory called static in your app's directory
- Django’s STATICFILES_FINDERS setting contains a list of finders that know how to discover static files from various sources
- note e.g. 
    - polls/static/polls/style.css
    -  Because of how the AppDirectoriesFinder staticfile finder works, you can refer to this static file in Django simply as polls/style.css,  similar to how you reference the path for templates
- We need to be able to point Django at the right one, and the easiest way to ensure this is by namespacing them. That is, by putting those static files inside another directory named for the application itself

- The {% static %} template tag generates the absolute URL of static files
- You should always use relative paths to link your static files between each other

# Comment - admin

-  tell Django the options you want when you register the object.
- You’ll follow this pattern – create a model admin class, then pass it as the second argument to admin.site.
register() – any time you need to change the admin options for a model.
- Django displays the str() of each object

```py
class QuestionAdmin(admin.ModelAdmin):
    fields = ['pub_date', 'question_text']

admin.site.register(Question, QuestionAdmin)

# you might want to split the form up into fieldsets:
# The first element of each tuple in fieldsets 
# is the title of the fieldset. 

class QuestionAdmin(admin.ModelAdmin):
    fieldsets = [
        (None, {'fields': ['question_text']}),
        ('Date information', {'fields': ['pub_date']})
    ]

admin.site.register(Question, QuestionAdmin)




'''
It’d be better if you could add a bunch of
Choices directly when you create the Question object

This tells Django: “Choice objects are edited on the Question admin page. By default, provide enough fields for 3
choices.”


'''

class ChoiceInline(admin.StackedInline):
    model = Choice 
    extra = 3

class QuestionAdmin(admin.ModelAdmin):
    fieldsets = [
        (None, {
            'fields': ['question_text']
            }
        ),
        ('Date information', {
            'fields': ['pub_date'],
            'classes': ['collapse']
            }
        )
    ]
    inlines = [ChoiceInline]

admin.site.register(Question, QuestionAdmin)
'''
It works like this: There are three slots for related Choices – as specified by extra – and each time you come back to
the “Change” page for an already-created object, you get another three extra slots

'''


class QuestionAdmin(admin.ModelAdmin):
    # ...
    list_display = ('question_text', 'pub_date')  # a tuple
    inlines = [ChoiceInline]
    list_display = ('question_text', 'pub_date','was_published_recently')
    list_filter = ['pub_date']  # That adds a “Filter” sidebar that lets people filter the change list by the pub_date field

    #  some search capability
    search_fields = ['question_text']

    '''
        When somebody enters search terms, Django will search the
        question_text field.
    '''




```

- The Django admin is powered by Django itself, and its interfaces use Django’s own template system
    - Create a templates directory in your project directory (the one that contains manage.py)
    - add to the DIRS
        TEMPLATES = [
            {
                ...
                'DIRS': [os.path.join(BASE_DIR, 'templates')],
                ...
    - create a directory called admin inside templates,
    - Now create a directory called admin inside templates, and copy the template admin/base_site.html from within the default Django admin template directory in the source code of Django itself (django/contrib/admin/templates) into that directory.
    -  just edit the file and replace {{ site_header|default:_('Django administration') }}
        - but note: In an actual project, you would probably use the django.contrib.admin.AdminSite.site_header attribute to more easily make this particular customization.

- any of Django’s default admin templates can be overridden - To override a template, just do the same thing you did with base_site.html – copy it from the default directory into your custom directory, and make changes

- since APP_DIRS is set to True, Django automatically looks for a templates/ subdirectory within each
application package, for use as a fallback (don’t forget that django.contrib.admin is an application).

- The template to customize is admin/index.html. (Do the same as with admin/base_site.html in the previous
section – copy it from the default directory to your custom template directory). Edit the file, and you’ll see it uses a
template variable called app_list. That variable contains every installed Django app. Instead of using that, you can
hard-code links to object-specific admin pages in whatever way you think is best.


# Packaging
- create a parent directory for the app, outside of your Django project
- Move the app directory into the newly created directory
- Create a file parentDIR/README.rst
- Create a parentDIR/LICENSE file
- create parentDIR/setup.cfg and parentDIR/setup.py files
- To include additional files, we’ll need to create a MANIFEST.in file

```py
python setup.py sdist  # from inside the dir
pip install --user parentDir/dist/theName-0.1.tar.gz  # an example
pip uninstall theName  # to uninstall


```
---
---


# Models 
- each model maps to a single database table
- each model is a Python class that subclasses django.db.models.Model
- each model - has attribute - which is a databse field

e.g.
```py
from django.db import models

class Musician(models.Model):
    first_name = models.CharField(max_length=50)

class Album(models.Model):
    artist = models.ForeignKey(Musician, on_delete=models.CASCADE)
    release_date = models.DateField()
    num_stars = models.IntegerField()


```
- a set of **common** arguments available to all field types. All are optional
 - **null**    === If True, Django will store empty values as NULL in the database. Default is False.
 - **blank**   === If True, the field is allowed to be blank. Default is False. If a field has blank=False, the field will be required.
 - **choices**  ===  A sequence of 2-tuples to use as choices for this field
 - **default** === The default value for the field. This can be a value or a callable object
 - **help_text**  ===  Extra “help” text to be displayed with the form widget. (documentation...etc)
 - **primary_key** ===  If True, this field is the primary key for the model. # read only
 - **unique** === If True, this field must be unique throughout the table.
- e.g. 
```py
YEAR_IN_SCHOOL_CHOICES = [
    ('FR', 'Freshman'),
    ('SO', 'Sophomore'),
    ('JR', 'Junior'),
    ('SR', 'Senior'),
    ('GR', 'Graduate'),
]
# Note that: first value = stored in the database, second value = what will be displayed

# e.g 2

class Person(models.Model):
    SHIRT_SIZES = (
        ('S', 'Small'),
        ('M', 'Medium'),
        ('L', 'Large'),
    )
    name = models.CharField(max_length=60)
    shirt_size = models.CharField(max_length=1, choices=SHIRT_SIZES)

# note 
p = Person(name="Fred Flintstone", shirt_size="L")
p.save()
p.shirt_size  # result = 'L'
p.get_shirt_size_display() # result = 'Large'

'''
the display value for a field with choices can be accessed using the get_FOO_display() method.
(replace FOO with the choice name)
'''


# see
'''
If you change the value of the primary key on an existing object and then
save it, a new object will be created alongside the old one
'''
class Fruit(models.Model):
    name = models.CharField(max_length=100, primary_key=True)
>>> fruit = Fruit.objects.create(name='Apple')
>>> fruit.name = 'Pear'
>>> fruit.save()
>>> Fruit.objects.values_list('name', flat=True)  # this <<<-----
# <QuerySet ['Apple', 'Pear']>



```


- Note: Django will automatically add an IntegerField to hold the primary key, so you don’t need to set primary_key=True on any of your fields
unless you want to override the default primary-key behavior. If Django sees you’ve explicitly set Field.primary_key, it won’t add the automatic id column.

---

# Verbose Name 

- Each field type, except for **ForeignKey**, **ManyToManyField** and **OneToOneField**, takes an optional first positional argument – a verbose name
- Django will automatically create it though using the field’s attribute name, converting underscores to spaces.
- ForeignKey, ManyToManyField and OneToOneField require the first argument to be a model class,
- e.g 

    ```py
    first_name = models.CharField("person's first name", max_length=30)

    # verbose name is "first name"


    poll = models.ForeignKey( Poll, on_delete=models.CASCADE, verbose_name="the related poll",)
    sites = models.ManyToManyField(Site, verbose_name="list of sites")
    place = models.OneToOneField(Place, on_delete=models.CASCADE, verbose_name="related place",)

    # The convention is not to capitalize the first letter of the verbose_name

    ```


# Relationship 

- Django offers ways to define the three most common types of database relationships: many-to-one, many-to-many and one-to-one.

# Many-to-one relationships
- e.g = Manufacturer makes multiple cars but each Car only has one Manufacturer

    ```py
    from django.db import models
    class Manufacturer(models.Model):
        # ...
        pass
    class Car(models.Model):
        manufacturer = models.ForeignKey(Manufacturer, on_delete=models.CASCADE)
        # ...
    ```


# Many-to-many relationships
- Generally, ManyToManyField instances should go in the object that’s going to be edited on a form.
- e.g  = toppings is in Pizza

    ```py
    from django.db import models
    class Topping(models.Model):
        # ...
        pass
    class Pizza(models.Model):
        # ...
        toppings = models.ManyToManyField(Topping)


    ```
