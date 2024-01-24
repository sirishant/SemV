import socket

server_address = ('127.0.0.1', 12345)
server_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_socket.bind(server_address)

server_socket.listen(40)
print("Server is listening for incoming connections..")

client_socket, client_address = server_socket.accept()
print(f"Received conn from {client_address}")

data = client_socket.recv(1024)
print(f"Received data: {data.decode('utf-8')}")

response = "Hello Client"
client_socket.send(response.encode('utf-8'))
client_socket.close()
server_socket.close()