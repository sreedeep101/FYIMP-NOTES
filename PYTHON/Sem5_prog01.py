#Import the math library and calculate: square root, power, and factorial.

import math

a = int(input("enter a number to find squar root , power , and factorial : "))
b = int(input("enter a exponent to find powerof "))

print("square root of " ,a, " = " ,math.sqrt(a))
print( a," ^ ",b ," = ",math.pow(a,b))
print("factorial of " , a ," : " ,math.factorial(a));
