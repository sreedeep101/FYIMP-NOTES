import socket

server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

server.bind(("localhost", 9999))

print("Go-Back-N Server started...")
print("Waiting for frames...\n")

expected_frame = 1

while True:
    data, address = server.recvfrom(1024)

    frame = data.decode()
    frame_number = int(frame.split()[1])

    print("Received:", frame)

    if frame_number == expected_frame:
        print("Frame accepted")

        ack = f"ACK {frame_number}"
        server.sendto(ack.encode(), address)

        print("Sent:", ack)

        expected_frame += 1

    else:
        print("Frame out of order")

        ack = f"ACK {expected_frame - 1}"
        server.sendto(ack.encode(), address)

        print("Sent:", ack)

    print()
