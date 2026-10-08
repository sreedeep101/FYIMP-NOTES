import os

print("Current Directory:")
print(os.getcwd())

folder = "os_demo"

if not os.path.exists(folder):
    os.mkdir(folder)
    print("\nFolder created: ",folder)
else:
    print("\nFolder already exists :", folder)
    
    
file1 = os.path.join(folder, "hello.txt")
file2 = os.path.join(folder, "python.txt")

with open(file1, "w") as f:
    f.write("Learning the os Library.")
    
with open(file2, "w") as f:
    f.write("hello from python")
    
print("\nFiles created.")

# 4. List files and folders
print("\nContents of current directory:")

for item in os.listdir("."):
    print(item)

# 5. Check the files
print("\nChecking files:")

for file in os.listdir(folder):
    path = os.path.join(folder, file)

    if os.path.isfile(path):
        print(file, "is a file")
        print("Size:", os.path.getsize(path), "bytes")

    elif os.path.isdir(path):
        print(file, "is a folder")

# 6. Rename a file
old_name = os.path.join(folder, "hello.txt")
new_name = os.path.join(folder, "welcome.txt")

os.rename(old_name, new_name)

print("\nFile renamed:")
print("hello.txt -> welcome.txt")

# 7. Show absolute path
print("\nAbsolute path:")
print(os.path.abspath(folder))

# 8. Show final contents
print("\nFinal contents:")

for item in os.listdir(folder):
    print(item)

print("\nProgram finished.")



