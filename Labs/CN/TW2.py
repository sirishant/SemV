import random
import math

def is_prime(num):
    return num > 1 and all(num % i != 0 for i in range(2, int(math.sqrt(num)) + 1))

def generate_prime(bits):
    while True:
        num = random.getrandbits(bits)
        if is_prime(num):
            return num

def gcd(a, b):
    while b:
        a, b = b, a % b
    return a

def mod_inverse(a, m):
    m0, x0, x1 = m, 0, 1
    while a > 1:
        q = a // m
        m, a = a % m, m
        x0, x1 = x1 - q * x0, x0
    return x1 + m0 if x1 < 0 else x1

def generate_key_pair(bits):
    p, q = generate_prime(bits), generate_prime(bits)
    n, phi = p * q, (p - 1) * (q - 1)
    
    e = random.randint(2, phi - 1)
    while gcd(e, phi) != 1:
        e = random.randint(2, phi - 1)

    d = mod_inverse(e, phi)
    
    public_key, private_key = (n, e), (n, d)
    return public_key, private_key

def encrypt(public_key, message):
    n, e = public_key
    return [pow(ord(char), e, n) for char in message]

def decrypt(private_key, cipher_text):
    n, d = private_key
    return ''.join([chr(pow(char, d, n)) for char in cipher_text])

if __name__ == '__main__':
    print("RUNNING PROGRAM ...")
    bits = 8
    public_key, private_key = generate_key_pair(bits)
    print(f'Generated public key: {public_key}\nGenerated private key: {private_key}')
    
    message = input("Enter message to be encrypted: ")
    print("Original Message: ", message)
    
    encrypted_message = encrypt(public_key, message)
    print("Encrypted message: ", encrypted_message)
    
    decrypted_message = decrypt(private_key, encrypted_message)
    print("Decrypted message: ", decrypted_message)
