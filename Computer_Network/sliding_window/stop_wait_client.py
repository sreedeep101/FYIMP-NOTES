import socket

client = socket.socket(socket.AF_INET , socket.SOCK_DGRAM)

server_address = ("localhost", 5000)

frames = ["Frame 1","Frame 2","Frame 3","Frame 4","Frame 5"]

client.settimeout(3)

for frame in frames:
     
    while True:
        print("\nSending : ", frame)

        client.sendto(frame.encode(),server_address)

        try:
            data, address = client.recvfrom(1024)
            ack = data.decode()
            print("Received : " , ack)
            break

        except socket.timeout:
            print("Timeout! Resending", frame)

print("\nAll frames sent successfully!")
client.close()




