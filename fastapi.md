
```py
  
  from fastapi import FastAPI, HTTPException, Path
  from models import User, Gender, Role
  from typing import List
  from uuid import UUID
  
  app = FastAPI() 
  
  db : List[User] = [
      User(
          id=UUID("973d71a3-83df-43e5-aadf-8a4fa65713fe"), 
          firstName="Frank",
          lastName="Aboagye",
          middleName="Kwabena",
          gender= Gender.male,
          role =[Role.admin,Role.user]
      ),
      User(
          id=UUID("ae64a505-7920-4da0-8203-f90b606b78ad"), 
          firstName="Priscilla",
          lastName="Aboagye",
          middleName="Abena",
          gender= Gender.female,
          role =[Role.student]
      ),
      User(
          id=UUID("ae84a505-7920-4da0-9203-f90b606b78ad"), 
          firstName="anem",
          lastName="Aboagye",
          middleName="kkl",
          gender= Gender.female,
          role =[Role.student]
      ),
  ]
  
  @app.get("/")
  async def root():
      return {
          "message": "Frank"
      }
  
  
  @app.get("/theUsers/")
  async def fetchUsers():
      return db
  
  @app.post("/theUsers/")
  async def registerUser(user: User):
      db.append(user)
      return {
          "the User Id": user.id ,
      }
      
  
  @app.delete("/theUser/{user_id}/")
  async def deleteUser(user_id:UUID):
      for user in db:
          if user.id == user_id:
              db.remove(user)
              return 
  
      raise HTTPException(
          status_code = 404,
          detail = "User does not exist",
      ) 
  
  @app.get("/allUsers")
  async def getAllUsers(theUsers: int = Path(None, description="This gets the users", gt=0)):
      return {
          "all users": "all users"
      }
  
  
  
 # you can specify with Path
  
  #gt = must be greater than this value 
 # lt 

```



---

```py


from typing import Optional
from fastapi import FastAPI

app = FastAPI() 


# query paramater

@app.get("/users/")
async def theFunc(theName: Optional[str] = None):
    if theName:
        
        return {
            "name" : theName
        }

    else:
        return {
            "name" : "no data"
        }

```


---


# optional argument - required argument 

```py
'''
python does not allow optional argumen before required argument
you can by pass that with  *
'''



from typing import Optional
from fastapi import FastAPI

app = FastAPI() 


# query paramater

@app.get("/users/")
async def theFunc(*, theName: Optional[str] = None, theSchool: str):
    if theName and theSchool:
        
        return {
            "name" : theName,
            "theSchol": theSchool,
        }
    elif theName:
        return {
            "name" : theName,
        }
    

    else:
        return {
            "name" : "no data"
        }
        

```


# request body

```py


from typing import Optional
from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI() 



# request body


class Student(BaseModel):
    name :str 
    school: str 
    year : int 

allStudents = {
    1: {
        "name" : "Frank",
        "school" : "GH",
        "year" : 2009,
    },
    2: {
        "name" : "kwabrna",
        "school" : "Ho",
        "year" : 2901,
    }

}

@app.get("/")
async def working():
    return {
        "message" : "working"
    }


@app.post("/createUser/{studentID}")
async def createUser(studentID: int, theStudent: Student):
    if studentID in allStudents:
        return {
            "messsage" : "student already exist",
        }
    allStudents[studentID] = theStudent
    return allStudents




```


# updating  - put
      -  make the the fiels optional so that user can update some of them 

```py


from typing import Optional
from fastapi import FastAPI
from pydantic import BaseModel

app = FastAPI() 



# request body


class Student(BaseModel):
    name :str 
    school: str 
    year : int 

class UpdateStudent(BaseModel):
    name :Optional[str] 
    school: Optional[str] 
    year : Optional[int]


allStudents = {
    1: {
        "name" : "Frank",
        "school" : "GH",
        "year" : 2009,
    },
    2: {
        "name" : "kwabrna",
        "school" : "Ho",
        "year" : 2901,
    }

}

@app.get("/")
async def working():
    return {
        "message" : "working"
    }

@app.get("/getStudents/")
async def getStudents():
    return allStudents

@app.post("/createUser/{studentID}/")
async def createUser(studentID: int, theStudent: Student):
    if studentID in allStudents:
        return {
            "messsage" : "student already exist",
        }
    allStudents[studentID] = theStudent
    return allStudents


@app.put("/updateStudent/{studentID}/")
async def UpdateStudent(studentID: int, theStudent: UpdateStudent):
    if studentID not in allStudents:
        return {
            "message" : "Student Not found"
        }
    allStudents[studentID] = theStudent 
    return allStudents


```


# SQL model

- SQLModel is a tool to help you with SQL Databases.

- Blog ::  https://bugbytes.io/posts/setting-up-sqlmodel/

- - pip install sqlmodel

-- sql lite explorer - extension

- With SQLModel, instead of writing SQL statements directly, you use Python classes and objects to interact with the database.

- - https://sqlmodel.tiangolo.com/tutorial/create-db-and-table/

```py

# database.db

from typing import Optional

from sqlmodel import Field, SQLModel


from sqlmodel import Field, SQLModel, create_engine

# There should be one engine for the entire application
DB_FILE = 'db.sqlite3'
engine = create_engine(f"sqlite:///{DB_FILE}", echo=True)
'''
 echo=True.

It will make the engine print all the SQL statements it execute
'''


class Hero(SQLModel, table=True):
    id: Optional[int] = Field(default=None, primary_key=True)
    name: str
    secret_name: str
    age: Optional[int] = None


def create_tables():
    """Create the tables registered with SQLModel.metadata (i.e classes with table=True).
    More info: https://sqlmodel.tiangolo.com/tutorial/create-db-and-table/#sqlmodel-metadata
    """
    SQLModel.metadata.create_all(engine)

if __name__ == '__main__':
    # creates the table if this file is run independently, as a script
    create_tables()


```
---

```py

# main app

#sample


from typing import Optional

from sqlmodel import Field, Session, SQLModel, create_engine


class Hero(SQLModel, table=True):
    id: Optional[int] = Field(default=None, primary_key=True)
    name: str
    secret_name: str
    age: Optional[int] = None


hero_1 = Hero(name="Deadpond", secret_name="Dive Wilson")
hero_2 = Hero(name="Spider-Boy", secret_name="Pedro Parqueador")
hero_3 = Hero(name="Rusty-Man", secret_name="Tommy Sharp", age=48)


engine = create_engine("sqlite:///database.db")


SQLModel.metadata.create_all(engine)

with Session(engine) as session:
    session.add(hero_1)
    session.add(hero_2)
    session.add(hero_3)
    session.commit()



# selecting



engine = create_engine("sqlite:///database.db")

with Session(engine) as session:
    statement = select(Hero).where(Hero.name == "Spider-Boy")
    hero = session.exec(statement).first()
    print(hero)



```

---


# samples

```py

user_id = input("Type the user ID: ")

session.exec(
    select(Hero).where(Hero.id == user_id)
).all()



database.execute(
    select(Hero).where(Hero.secret_name == "Dive Wilson")
).all()



```



# sqlite
- https://sqlitebrowser.org/

- Each supported database has it's own URL type. For example, for SQLite it is sqlite:/// followed by the file path. For example:

sqlite:///database.db
sqlite:///databases/local/application.db
sqlite:///db.sqlite


- note :: https://docs.sqlalchemy.org/en/14/core/engines.html

```py

# default
engine = create_engine("postgresql://scott:tiger@localhost/mydatabase")

# psycopg2
engine = create_engine("postgresql+psycopg2://scott:tiger@localhost/mydatabase")

# pg8000
engine = create_engine("postgresql+pg8000://scott:tiger@localhost/mydatabase")

```


```py

Each supported database has it's own URL type. For example, for SQLite it is sqlite:/// followed by the file path. For example:

sqlite:///database.db
sqlite:///databases/local/application.db
sqlite:///db.sqlite

```


 But in production, you would probably want to remove echo=True

---

if you import the models before calling SQLModel.metadata.create_all(), it will work:

```py
from sqlmodel import SQLModel

from . import models
from .db import engine

SQLModel.metadata.create_all(engine)


```

# you can do this

```py

# db.py
from sqlmodel import SQLModel, create_engine
from . import models


sqlite_file_name = "database.db"
sqlite_url = f"sqlite:///{sqlite_file_name}"

engine = create_engine(sqlite_url


# app.py
from .db import engine, SQLModel

SQLModel.metadata.create_all(engine)


```


# example - another

```py

from typing import Optional

from sqlmodel import Field, SQLModel, create_engine


class Hero(SQLModel, table=True):
    id: Optional[int] = Field(default=None, primary_key=True)
    name: str
    secret_name: str
    age: Optional[int] = None


sqlite_file_name = "database.db"
sqlite_url = f"sqlite:///{sqlite_file_name}"

engine = create_engine(sqlite_url, echo=True)


def create_db_and_tables():
    SQLModel.metadata.create_all(engine)


if __name__ == "__main__":
    create_db_and_tables()

```


# inserting

```py

from typing import Optional

from sqlmodel import Field, Session, SQLModel, create_engine


class Hero(SQLModel, table=True):
    id: Optional[int] = Field(default=None, primary_key=True)
    name: str
    secret_name: str
    age: Optional[int] = None


sqlite_file_name = "database.db"
sqlite_url = f"sqlite:///{sqlite_file_name}"

engine = create_engine(sqlite_url, echo=True)


def create_db_and_tables():
    SQLModel.metadata.create_all(engine)


def create_heroes():
    hero_1 = Hero(name="Deadpond", secret_name="Dive Wilson")
    hero_2 = Hero(name="Spider-Boy", secret_name="Pedro Parqueador")
    hero_3 = Hero(name="Rusty-Man", secret_name="Tommy Sharp", age=48)

    with Session(engine) as session:
        session.add(hero_1)
        session.add(hero_2)
        session.add(hero_3)

        session.commit()


def main():
    create_db_and_tables()
    create_heroes()


if __name__ == "__main__":
    main()


```


---


In contrast to the engine that is one for the whole application, we create a new session for each group of operations with the database that belong together.


- the session needs and uses an engine.

- -  if we have a web application, we would normally have a single session per request
  -  - But for each request, we would create and use a new session
   
---

# session

```py


from typing import Optional

from sqlmodel import Field, Session, SQLModel, create_engine


class Hero(SQLModel, table=True):
    id: Optional[int] = Field(default=None, primary_key=True)
    name: str
    secret_name: str
    age: Optional[int] = None


sqlite_file_name = "database.db"
sqlite_url = f"sqlite:///{sqlite_file_name}"

engine = create_engine(sqlite_url, echo=True)


def create_db_and_tables():
    SQLModel.metadata.create_all(engine)


def create_heroes():
    hero_1 = Hero(name="Deadpond", secret_name="Dive Wilson")
    hero_2 = Hero(name="Spider-Boy", secret_name="Pedro Parqueador")
    hero_3 = Hero(name="Rusty-Man", secret_name="Tommy Sharp", age=48)

    session = Session(engine)

    session.add(hero_1)
    session.add(hero_2)
    session.add(hero_3)

    session.commit()

    session.close()


def main():
    create_db_and_tables()
    create_heroes()


if __name__ == "__main__":
    main()


```

---


