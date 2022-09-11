from tokenize import String


num1=int(input("Enter first number: "))
num2=int(input("Enter second number: "))
ope=str(input("Enter Operator: "))

if ope=='+':
    print("The addition of two numbers is ",num1+num2)
elif ope=='-':
    print("The subtraction of two numbers is ",num1-num2)
elif ope=='x':
    print("The multiplication of two numbers is ",num1*num2)
elif ope=='/':
    print("The division of two numbers is ",num1/num2)
else:
    print("Invalid Operator")