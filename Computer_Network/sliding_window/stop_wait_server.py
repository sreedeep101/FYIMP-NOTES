import socket

server = socket.socket(socket.AF_INET , socket.SOCK_DGRAM)

IP = 'localhost'
PORT = 5000
server.bind((IP,PORT))
print("server is waiting for frames ...")


while True:
    data, addr = server.recvfrom(1024)
    frame = data.decode()
    print("Recieved: ", frame)

    ack = "ACK" + frame.split()[1]

    server.sendto(ack.encode(), addr)

    print("sent:",ack)

