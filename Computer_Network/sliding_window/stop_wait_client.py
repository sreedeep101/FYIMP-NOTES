import socket
import time

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect(("localhost", 5000))

frames = ["Frame 1", "Frame 2", "Frame 3"]

for frame in frames:
    print("Sending:", frame)
    client.send(frame.encode())

    ack = client.recv(1024).decode()
    print("Received:", ack)

    time.sleep(1)

client.send("END".encode())
client.close()
