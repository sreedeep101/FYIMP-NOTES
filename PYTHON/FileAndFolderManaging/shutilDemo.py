import os
import shutil

# Original folder
source = "my_project"

# Backup folder
backup = "my_project_backup"

# 1. Create project folder
if not os.path.exists(source):
    os.mkdir(source)

# 2. Create some files
with open(os.path.join(source, "file1.txt"), "w") as f:
    f.write("This is file 1.")

with open(os.path.join(source, "file2.txt"), "w") as f:
    f.write("This is file 2.")

with open(os.path.join(source, "notes.txt"), "w") as f:
    f.write("These are my notes.")

print("Project folder created.")

# 3. Remove old backup if it exists
if os.path.exists(backup):
    shutil.rmtree(backup)
    print("Old backup removed.")

# 4. Copy entire folder
shutil.copytree(source, backup)

print("Backup created successfully.")

# 5. Display backup contents
print("\nBackup contents:")

for item in os.listdir(backup):
    print(item)

# 6. Copy one additional file
with open("extra.txt", "w") as f:
    f.write("This is an extra file.")

shutil.copy("extra.txt", backup)

print("\nExtra file copied to backup.")

# 7. Move extra file
shutil.move("extra.txt", source)

print("Extra file moved to project folder.")

# 8. Show disk information
total, used, free = shutil.disk_usage(".")

print("\nDisk information:")
print("Total:", total, "bytes")
print("Used :", used, "bytes")
print("Free :", free, "bytes")

print("\nBackup completed!")
