#Draw a line chart using Matplotlib.

import matplotlib.pyplot as plt

x = [1,3,5,7,9,11]
y = [2,4,6,8,10,5]

plt.plot(x,y)
plt.title("simple line chart")
plt.xlabel("x axis")
plt.ylabel("y axis")
plt.show()
