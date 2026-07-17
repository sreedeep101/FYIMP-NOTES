#Import the random library. Generate five random numbers.

import random

array = [random.randint(1,100) for _ in range(5)]
print(array)
