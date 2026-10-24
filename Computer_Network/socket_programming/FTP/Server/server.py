import socket
import os

HOST = "127.0.0.1"
PORT = 5002

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((HOST, PORT))
server.listen(1)

print("FTP Server started...")
print("Waiting for client connection...")

conn, addr = server.accept()

print("Client connected:", addr)

while True:

    command = conn.recv(1024).decode()

    if not command:
        break

    command = command.strip()

    # LIST command
    if command == "LIST":

        files = os.listdir(".")

        file_list = "\n".join(files)

        conn.send(file_list.encode())

    # GET command - Client downloads file
    elif command.startswith("GET "):

        filename = command[4:]

        if os.path.exists(filename):

            filesize = os.path.getsize(filename)

            conn.send(f"OK {filesize}".encode())

            # Wait for client READY
            conn.recv(1024)

            with open(filename, "rb") as file:

                while True:

                    data = file.read(1024)

                    if not data:
                        break

                    conn.sendall(data)

            print("File sent:", filename)

        else:

            conn.send(b"ERROR File not found")

    # PUT command - Client uploads file
    elif command.startswith("PUT "):

        filename = command[4:]

        conn.send(b"READY")

        # Receive file size
        data = conn.recv(1024).decode()

        filesize = int(data)

        conn.send(b"READY")

        received = 0

        with open("uploaded_" + filename, "wb") as file:

            while received < filesize:

                data = conn.recv(min(1024, filesize - received))

                if not data:
                    break

                file.write(data)

                received += len(data)

        print("File received:", filename)

        conn.send(b"UPLOAD SUCCESS")

    # QUIT command
    elif command == "QUIT":

        conn.send(b"Goodbye")

        break

    else:

        conn.send(b"Invalid command")


conn.close()
server.close()

print("FTP Server stopped.")
