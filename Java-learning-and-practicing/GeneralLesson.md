- Number Variables Store numbers . Object Variables store references

- You can convert from a class type to an interface type, provided the class implements the interface

older versions

- An inner class can access surrounding local variables only if they are declared as final.

  - Keep in mind that an object variable is final when the variable
    always refers to the same object. The state of the object can change,
    but the variable can’t refer to a different object

- An inner class can also access instance variables of the surrounding class,
  again with a restriction. The instance variable must belong to the object
  that constructed the inner class object. If the inner class object was created inside a static method, it can only access static variables.

- A subclass has no access to the private instance variables of the superclass
- A subclass method overrides a superclass method if it has the same name and parameter types as a superclass method