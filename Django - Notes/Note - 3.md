
# snippet

```py

from django.db import models

class Product(models.Model):
    title = models.CharField(max_length=120)
    content = models.TextField(blank=True, null=True)
    price =  models.DecimalField(max_digits=15, decimal_places=2, default=99.99)

    @property
    def salePrice(self):
        return "%.2f" % (self.price * 0.8)

# shell

>>> from products.models import Product
>>> Product.objects.all()
<QuerySet [<Product: Product object (1)>, <Product: Product object (2)>]>

>>> Product.objects.first()
<Product: Product object (1)>

>>> Product.objects.last()
<Product: Product object (2)>

>>> Product.objects.first().salePrice
'2.04'

```

--- 


```py

# Why DRF

# see

from django.db import models

class Product(models.Model):
    title = models.CharField(max_length=120)
    content = models.TextField(blank=True, null=True)
    price =  models.DecimalField(max_digits=15, decimal_places=2, default=99.99)

    @property
    def salePrice(self):
        return "%.2f" % (float(self.price) * 0.8)
    
    def theComment(self):
        return "This is " + self.title

# views.py


from django.http import JsonResponse 

from products.models import Product

from django.forms.models  import model_to_dict 

from rest_framework.response import Response 
from rest_framework.decorators import api_view


@api_view(['GET'])  # you have to clear the allowed methods
def apiHome(request, *args, **kwargs):

    modelData = Product.objects.all().order_by("?").first()

    data = {}

    #data = model_to_dict(modelData)
    data = model_to_dict(modelData, fields=['id', 'title', 'salePrice'])  # can specify fields

    return Response(data)




# the client

import requests 

endPoint = "http://localhost:8000/api/" 

getResponse = requests.get(endPoint)

print(getResponse.json())


# result = {'id': 2, 'title': 'Bag of Rice'}

# note: --> no salePrice is showing
# the more reason why to use serialisers


```


--- 



```py


# client

import requests 

endPoint = "http://localhost:8000/api/" 

getResponse = requests.get(endPoint)

print(getResponse.json())


# serializers.py


from rest_framework import serializers 

from .models import Product 

class ProductSerializer(serializers.ModelSerializer):
    class Meta:
        model = Product 
        fields = ['id', 'price', 'title', 'salePrice', 'theComment']


# models.py

from django.db import models

class Product(models.Model):
    title = models.CharField(max_length=120)
    content = models.TextField(blank=True, null=True)
    price =  models.DecimalField(max_digits=15, decimal_places=2, default=99.99)

    @property
    def salePrice(self):
        return "%.2f" % (float(self.price) * 0.8)
    
    def theComment(self):
        return "This is " + self.title
        

# views.py

from django.http import JsonResponse 

from products.models import Product

from django.forms.models  import model_to_dict 

from rest_framework.response import Response 
from rest_framework.decorators import api_view

from products.serializers import ProductSerializer


@api_view(['GET'])  # you have to clear the allowed methods
def apiHome(request, *args, **kwargs):

    theInstance = Product.objects.all().order_by("?").first()

    theData = ProductSerializer(theInstance).data

    return Response(theData)



# but say, you donot want to use the method name "theComment" itself

# this will make it work


# serialisers.py

from rest_framework import serializers 

from .models import Product 

class ProductSerializer(serializers.ModelSerializer):
    niceComment = serializers.SerializerMethodField(read_only=True)
    class Meta:
        model = Product 
        fields = ['id', 'price', 'title', 'salePrice', 'niceComment']

    def get_niceComment(self, obj):
        return obj.theComment()



```


