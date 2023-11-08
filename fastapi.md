
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
