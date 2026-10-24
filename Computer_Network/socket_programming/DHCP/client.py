import socket

SERVER = ("127.0.0.1", 6767)

client = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

client_id = "CLIENT01"

# DHCP DISCOVER
client.sendto(
    ("DISCOVER " + client_id).encode(),
    SERVER
)

data, address = client.recvfrom(1024)

print("Server:", data.decode())

parts = data.decode().split()

if parts[0] == "OFFER":

    offered_ip = parts[1]

    # DHCP REQUEST
    client.sendto(
        ("REQUEST " + client_id + " " + offered_ip).encode(),
        SERVER
    )

    data, address = client.recvfrom(1024)

    print("Server:", data.decode())

client.close()
