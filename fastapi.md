
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
