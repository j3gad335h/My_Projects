# 4.Given a mathematical expression in string format, write a program to evaluate.
# e.g.
# String expr = “12 + ( 3 * ( 5 – 1 ) ) / 4” - once the expr is evaluated, it should answer 15.
# All the tokens in above expr is space separated.

# By using eval method we can directly solve the string expression

def eval_str(str_expr):
    x = 0
    try:
        x = eval(str_expr)
    except:
        print("String has invalid operator")
    return x


expr = "12 + ( 3 * ( 5 - 1 ) ) / 4"
final = eval_str(expr)
print(final)
expr = "(10+(10-1)+5*2)/2"
final = eval_str(expr)
print(final)
