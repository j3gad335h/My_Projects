# String Swap
from re import S


s1 = "p"
s2 = "p"

s=[i for i in s2]
print(s)


for i in range(0,len(s)):
    # s[i]=k,a,n,b
    if(len(s)==1):
        if(s1==s2):
            print('True')
            break
    for j in range(0,len(s)-1):
       d=[k for k in s2]
       dummy=d[j+1]
       d[j+1]=s[i]
       d[i]=dummy
       s3=""
       s3=s3.join(d)
       if(s3==s1):
           print("True")
           break
    else:
        continue
    break
    
       
           
       
        
        