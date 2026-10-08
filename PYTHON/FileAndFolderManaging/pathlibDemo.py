from pathlib import Path

# Main folder
main_folder = Path("file_organizer")

# 1. Create main folder
main_folder.mkdir(exist_ok=True)

print("Main folder:", main_folder)

# 2. Create files
files = {
    "photo.jpg": "This is a photo.",
    "image.png": "This is an image.",
    "document.txt": "This is a text document.",
    "notes.txt": "These are notes.",
    "program.py": "print('Hello Python')",
    "script.py": "print('Python script')"
}

for filename, content in files.items():
    file_path = main_folder / filename
    file_path.write_text(content)

print("\nFiles created.")

# 3. Display all files
print("\nFiles in folder:")

for item in main_folder.iterdir():
    print(item.name)

# 4. Display information about each file
print("\nFile information:")

for item in main_folder.iterdir():

    if item.is_file():

        print("\nName:", item.name)
        print("Extension:", item.suffix)
        print("Name without extension:", item.stem)
        print("Size:", item.stat().st_size, "bytes")
        print("Parent:", item.parent)

# 5. Create folders for different file types
images = main_folder / "images"
text_files = main_folder / "text"
python_files = main_folder / "python"

images.mkdir(exist_ok=True)
text_files.mkdir(exist_ok=True)
python_files.mkdir(exist_ok=True)

# 6. Move files according to their extension
for item in main_folder.iterdir():

    if item.is_file():

        if item.suffix in [".jpg", ".png"]:
            item.rename(images / item.name)

        elif item.suffix == ".txt":
            item.rename(text_files / item.name)

        elif item.suffix == ".py":
            item.rename(python_files / item.name)

print("\nFiles organized.")

# 7. Display final structure
print("\nFinal folder structure:")

for item in main_folder.rglob("*"):
    print(item)

# 8. Read a text file
text_file = text_files / "document.txt"

if text_file.exists():
    content = text_file.read_text()

    print("\nContent of document.txt:")
    print(content)

print("\nProgram finished.")
