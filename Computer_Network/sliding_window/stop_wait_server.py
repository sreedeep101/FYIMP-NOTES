import socket

server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server.bind(("localhost", 5000))
server.listen(1)

print("Server waiting for connection...")
conn, addr = server.accept()
print("Connected to:", addr)

while True:
    data = conn.recv(1024).decode()

    if not data or data == "END":
        break

    print("Received:", data)
    conn.send("ACK".encode())
    print("Acknowledgement sent")

conn.close()
server.close()
