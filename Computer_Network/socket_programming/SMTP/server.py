import socket

HOST = "127.0.0.1"
PORT = 2525

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind((HOST, PORT))
server.listen(1)

print("SMTP Server is waiting...")

conn, addr = server.accept()

conn.send("220 SMTP Server Ready\r\n".encode())

while True:

    data = conn.recv(1024).decode().strip()

    if not data:
        break

    print("Client:", data)

    command = data.upper()

    if command.startswith("HELO"):
        reply = "250 Hello"

    elif command.startswith("MAIL FROM"):
        reply = "250 Sender OK"

    elif command.startswith("RCPT TO"):
        reply = "250 Recipient OK"

    elif command == "DATA":
        reply = "354 Start mail input"

    elif command == ".":
        reply = "250 Message accepted"

    elif command == "QUIT":
        reply = "221 Goodbye"
        conn.send((reply + "\r\n").encode())
        break

    else:
        reply = "250 OK"

    conn.send((reply + "\r\n").encode())

conn.close()
server.close()
