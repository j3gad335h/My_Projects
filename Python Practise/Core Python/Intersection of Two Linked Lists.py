# Intersection of Two Linked Lists
listA = [4,1,8,4,5]
listB = [5,6,1,8,4,5]

for i in range(len(listA)-1,0,-1):
    
    for j in range(len(listB)-1,0,-1):
        if(listA[i]==listB[j]):
            print(listB[j])
            break