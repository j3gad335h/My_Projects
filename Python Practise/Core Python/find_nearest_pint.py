# You are given two integers, x and y, which represent your current location on a Cartesian grid: (x, y). 
# You are also given an array points where each points[i] = [ai, bi] represents that a point exists at (ai, bi).
# A point is valid if it shares the same x-coordinate or the same y-coordinate as your location.
# Return the index (0-indexed) of the valid point with the smallest Manhattan distance from your current location.
# If there are multiple, return the valid point with the smallest index. 
# If there are no valid points, return -1.
# The Manhattan distance between two points (x1, y1) and (x2, y2) is abs(x1 - x2) + abs(y1 - y2).

x = 3
y = 4
points = [[2,3]]
distance=[]

print('--Valid Points--')   
for point in points:
    if point[0]==x or point[1]==y:
        m1=abs(x-point[0])  
        m2=abs(y-point[1])
        m=m1+m2
        distance.append(m)
    else:
        distance.append(-1)

print(distance)
try:
    print(distance.index(min(i for i in distance if i>=0)))
except:
    print(-1)

