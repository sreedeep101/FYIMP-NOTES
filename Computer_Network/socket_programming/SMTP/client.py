import socket

HOST = "127.0.0.1"
PORT = 2525

client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client.connect((HOST, PORT))

print("Server:", client.recv(1024).decode().strip())


def send_command(command):

    print("Client:", command)

    client.send((command + "\r\n").encode())

    response = client.recv(1024).decode().strip()

    print("Server:", response)


send_command("HELO localhost")

send_command("MAIL FROM:<alice@gmail.com>")

send_command("RCPT TO:<bob@gmail.com>")

send_command("DATA")

send_command("Hello Bob")

send_command(".")

send_command("QUIT")

client.close()
