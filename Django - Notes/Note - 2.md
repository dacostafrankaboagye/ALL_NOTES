

# General
 - If you want to use Django on a production site, use Apache with mod_wsgi
 - By default, Django gives each model the following field:
    ```py

    id = models.AutoField(primary_key=True) # auto-incrementing primary key

    # If you’d like to specify a custom primary key, just specify primary_key=True on one of your fields

    ```
- Each field type, except for ForeignKey, ManyToManyField and OneToOneField, takes an optional first positional argument – a verbose name - but django automatically creates it if not specified - using this format -  field’s attribute name, converting underscores to spaces.
```py

# verbose name = "person's first name"
first_name = models.CharField("person's first name", max_length=30)

# verbose name =  "first name"
first_name = models.CharField(max_length=30)

```
- ForeignKey, ManyToManyField and OneToOneField require the first argument to be a model class, so use the verbose_name keyword argument
```py
poll  = models.ForeignKey(Poll, on_delete=models.CASCADE, verbose_name="the related poll",)

sites = models.ManyToManyField(Site, verbose_name="list of sites")

place = models.OneToOneField(Place, on_delete=models.CASCADE, verbose_name="related place",)

# convention  = do not to capitalize the first letter of the verbose_name

```
- The most important attribute of a model is the Manager. If no custom Manager is defined, the default name is objects. 
- The model instance reference has a complete list of methods automatically given to each model. You can override most of these
```py

# but there are a couple that you’ll almost always want to define

__str__() 
get_absolute_url() 

```
    
# Take Note

```py

from django.db import models
class Person(models.Model):
    SHIRT_SIZES = (
        ('S', 'Small'),
        ('M', 'Medium'),
        ('L', 'Large'),
    )
    name = models.CharField(max_length=60)
    shirt_size = models.CharField(max_length=1, choices=SHIRT_SIZES)


>>> p = Person(name="Fred Flintstone", shirt_size="L")
>>> p.save()
>>> p.shirt_size
'L'
>>> p.get_shirt_size_display()
'Large'


```

# Relationships
 - Many-to-one relationships
    - Analogy:
        - a Manufacturer makes multiple cars but each Car only has one Manufacturer
    ```py 
    from django.db import models
    class Manufacturer(models.Model):
        # ...
        pass
    class Car(models.Model):
        # for the variable it is suggested that 'use lower case name for the ForeignKeyField' - but is it not required
        manufacturer = models.ForeignKey(Manufacturer, on_delete=models.CASCADE)  

    ```
 - Many-to-many relationships
    - Analogy: 
        - a Topping can be on multiple pizzas and each Pizza has multiple toppings
    ```py
    from django.db import models
        class Topping(models.Model):
        # ...
        pass
    class Pizza(models.Model):
        # ...
        toppings = models.ManyToManyField(Topping)

    ```
    - It doesn’t matter which model has the ManyToManyField, but you should only put it in one of the models – not both

 - One-to-one relationships


# Models across files
 -  import the related model at the top of the file where your model is defined. Then, just refer to the other model class wherever needed

# Meta options
 - optional
 - metadata is “anything that’s not a field”, such as :
    - ordering options (ordering)
    - database table name (db_table)
    - human-readable singular and plural names (verbose_name and verbose_name_plural)
    ```py
    from django.db import models

    class Ox(models.Model):
        horn_length = models.IntegerField()

        class Meta:
            ordering = ["horn_length"]
            verbose_name_plural = "oxen"
    
    ```
