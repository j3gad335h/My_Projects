# 2.	There are many ways to order a list of integers from 1 to n. For e.g. if n = 4, the list could be [3 1 2 4].
# Write a program to inverse the list in such a way, that position of integer i is the i-th number in the given list.
# So, in case of above example the inversed list will be [2 3 1 4]

def inverse_list(list_to_inverse):
    print("--Original List--")
    print(list_to_inverse)
    inverse_lis = list_to_inverse
    inverse_lis.insert(0, list_to_inverse[len(list_to_inverse) - 2])
    inverse_lis.pop(len(inverse_lis) - 2)
    print("--Inversed List--")
    print(inverse_lis)


lis = [3, 1, 2, 4]
inverse_list(lis)
lis = [1, 2, 3, 4, 5]
inverse_list(lis)
