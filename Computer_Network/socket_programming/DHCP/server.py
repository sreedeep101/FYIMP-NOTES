import socket

HOST = "127.0.0.1"
PORT = 6767

server = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
server.bind((HOST, PORT))

print("DHCP Server is running...")

ip_pool = [
    "192.168.1.100",
    "192.168.1.101",
    "192.168.1.102"
]

leases = {}

while True:

    data, address = server.recvfrom(1024)

    message = data.decode()
    print("Received:", message)

    parts = message.split()

    if parts[0] == "DISCOVER":

        client_id = parts[1]

        if client_id not in leases:

            for ip in ip_pool:

                if ip not in leases.values():

                    leases[client_id] = ip
                    break

        ip = leases[client_id]

        response = "OFFER " + ip

        server.sendto(response.encode(), address)

    elif parts[0] == "REQUEST":

        client_id = parts[1]
        requested_ip = parts[2]

        if leases.get(client_id) == requested_ip:

            response = "ACK " + requested_ip

        else:

            response = "NAK"

        server.sendto(response.encode(), address)

    elif message == "QUIT":

        break

server.close()
