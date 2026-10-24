import socket 
import time

TOTAL_FRAMES = 5
WINDOW_SIZE = 3
TIMEOUT = 1.0

client = socket.socket(socket.AF_INET , socket.SOCK_DGRAM)
client.settimeout(0.1)

server = ("localhost", 5002)

base = 1
next_frame = 1

pending = {}
acknowledged = set()

print("Selective Repeat client started")

while base <= TOTAL_FRAMES:
    while (next_frame <= TOTAL_FRAMES and next_frame < base + WINDOW_SIZE):
        print(f"Sending Frame {next_frame}")

        client.sendto(f"FRAME:{next_frame}".encode(), server)

        pending[next_frame] = time.time()
        next_frame += 1

    try:
        data, _ = client.recvfrom(1024)
        message = data.decode()

        if message.startswith("ACK:"):
            frame = int(message.split(":")[1])

            if frame in pending:
                print(f"Received ACK for Frame {frame}")
                acknowledged.add(frame)
                del pending[frame]

            while base in acknowledged:
                base += 1

    except socket.timeout:
        pass

    current_time = time.time()

    for frame in list(pending.keys()):
        if current_time - pending[frame] >= TIMEOUT:
            print(f"Timeout! Retransmitting Frame {frame}")
            client.sendto(f"FRAME:{frame}".encode(), server)

            pending[frame] = time.time()

print("\nAll frames acknowledged successfully.")

client.sendto(b"END", server)
client.close()

