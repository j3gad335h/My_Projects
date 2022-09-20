# The __init__ method is similar to constructors in C++ and Java. Constructors are used to initialize the object’s state
# It runs as soon as an object of a class is instantiated. The method is useful to do any initialization you want to do with your object.
class animal:
    def __init__(self, name) -> None:
        self.name = name

    def dog(self):
        print("I am a " + self.name)


p = animal("pug")
p.dog()


# Python program to illustrate
# selection statement
  
num1 = 34
if(num1>12):
    print("Num1 is good")
elif(num1>35):
    print("Num2 is not gooooo....")
else:
    print("Num2 is great")