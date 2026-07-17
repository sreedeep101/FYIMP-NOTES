#create a Pandas DataFrame with Name, Age, and Department columns. Display the table.

import pandas as pd

data = {
    "name" : ["Arjun","Arun","Hari","Appu"],
    "Age"  : [24,26,20,18],
    "Department" : ["Information Technology" ,"Psychology" ,"Physical Education","Information Technology"]
}

data_table = pd.DataFrame(data)

print(data_table)
