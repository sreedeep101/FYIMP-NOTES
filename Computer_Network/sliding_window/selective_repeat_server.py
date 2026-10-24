import socket 

server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
server.bind(('localhost',5002))
print("Selective Repeate server started")
print("Waiting for frames...")

WINDOW_SIZE = 3

expected = 1
received = set()
lost_frame_3 = False

while True:
    data, addr = server.recvfrom(1024)
    message = data.decode()

    if message == "END":
        print("\nAll frames received successfully.")
        break

    frame = int(message.split(":")[1])

    if frame == 3 and not lost_frame_3:
        lost_frame_3 = True
        print("Frame 3 lost! No ACK sent.")
        continue

    server.sendto(f"ACK:{frame}".encode(), addr)
    print(f"Received: Frame {frame}")
    print(f"ACK sent Frame {frame}")

    if expected <=frame < expected + WINDOW_SIZE:
        received.add(frame)

        while expected in received:
            print(f"Frame {expected} delivered to application")
            received.remove(expected)
            expected += 1
    elif frame < expected:
        print(f"Duplicate Frame {frame} acknowledged")

server.close()


