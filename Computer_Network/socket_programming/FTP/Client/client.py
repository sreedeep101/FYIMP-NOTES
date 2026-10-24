import socket
import os

HOST = "127.0.0.1"
PORT = 5002

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)

client.connect((HOST, PORT))

print("Connected to FTP Server")

while True:

    command = input("ftp> ")
    
    # LIST
    if command == "LIST":

        client.send(command.encode())

        data = client.recv(4096).decode()

        print("\nFiles on server:")
        print(data)

    # GET
    elif command.startswith("GET "):

        filename = command[4:]

        client.send(command.encode())

        response = client.recv(1024).decode()

        if response.startswith("OK"):

            filesize = int(response.split()[1])

            print("File size:", filesize, "bytes")

            client.send(b"READY")

            received = 0

            with open("downloaded_" + filename, "wb") as file:

                while received < filesize:

                    data = client.recv(
                        min(1024, filesize - received)
                    )

                    if not data:
                        break

                    file.write(data)

                    received += len(data)

            print("File downloaded successfully.")
            print("Saved as:", "downloaded_" + filename)

        else:

            print(response)

    # PUT
    elif command.startswith("PUT "):

        filename = command[4:]

        if not os.path.exists(filename):

            print("File does not exist.")

            continue

        client.send(command.encode())

        response = client.recv(1024).decode()

        if response == "READY":

            filesize = os.path.getsize(filename)

            client.send(str(filesize).encode())

            client.recv(1024)

            with open(filename, "rb") as file:

                while True:

                    data = file.read(1024)

                    if not data:
                        break

                    client.sendall(data)

            response = client.recv(1024).decode()

            print(response)

    # QUIT
    elif command == "QUIT":

        client.send(command.encode())

        print("Server:", client.recv(1024).decode())

        break

    else:

        print("Commands:")
        print("LIST")
        print("GET <filename>")
        print("PUT <filename>")
        print("QUIT")


client.close()
