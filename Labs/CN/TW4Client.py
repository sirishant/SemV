import socket

server_address = ('127.0.0.1', 12345)
client_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
client_socket.connect(server_address)
print("Client socket created")

message = "Hello server"
client_socket.send(message.encode('utf-8'))
response = client_socket.recv(1024)
print(f"received response: {response.decode('utf-8')}")
client_socket.close()