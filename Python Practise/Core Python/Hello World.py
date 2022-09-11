print("Hello World")
print("Welcome to Python")
print("My name is Jegadeesh")
print("First Python file")

print("\nHello")

print("My name is Jegadeesh and my age is ",26+1)

#Variables
name="Jegadeesh"
age=27
city='Karur' # String Can be given in both single and double quotes
# Most used one is double quotes so that single quote word can be given inside double quotes

print("Hello my name is ",name,"\nMy age is ",age,"\nI live in ",city)

# another way to print variables
print(f"Hello my name is {name}\nmy age is {age}\nI live at {city}")

#String Operation 

print(f"Hi my name is {name.upper()}")
print(f"Hi my name is {name.lower()}")
name="jeGadeesH nalluSamy"
print(f"Hi my name is {name.title()}")
name=name.title()
name=name.replace("Je","Ja")
print(name)
print(f"Length of the string is {len(name)}")