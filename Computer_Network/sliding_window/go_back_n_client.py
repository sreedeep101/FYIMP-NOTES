import socket

client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

server_address = ("localhost", 9999)

total_frames = 10
window_size = 3

base = 1
next_frame = 1

client.settimeout(3)

while base <= total_frames:

    # Send frames that fit inside the window
    while next_frame <= total_frames and next_frame < base + window_size:

        print("Sending: Frame", next_frame)

        message = f"Frame {next_frame}"

        client.sendto(message.encode(), server_address)

        next_frame += 1

    try:

        data, address = client.recvfrom(1024)

        ack = data.decode()

        print("Received:", ack)

        ack_number = int(ack.split()[1])

        # Slide the window
        if ack_number >= base:

            base = ack_number + 1

            print("Window moved.")
            print("New base:", base)

    except socket.timeout:

        print("\nTIMEOUT!")
        print("Going back to Frame", base)

        # Go back to the first unacknowledged frame
        next_frame = base

print("\nAll frames transmitted successfully!")

client.close()
