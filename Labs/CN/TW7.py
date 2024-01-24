# CRC

def crc_remainder(input_bitstring, polynomial):
    # Append zeros to input bitstring (equal to the degree of the polynomial)
    dividend = input_bitstring + '0' * (len(polynomial) - 1)
    dividend = list(dividend)
    polynomial = list(polynomial)

    for i in range(len(input_bitstring)):
        if dividend[i] == '1':
            for j in range(len(polynomial)):
                dividend[i + j] = str(int(dividend[i + j]) ^ int(polynomial[j]))

    # Get remainder (checksum)
    remainder = ''.join(dividend)[-len(polynomial) + 1:]
    # Append the remainder to the original message
    codeword = input_bitstring + remainder

    return remainder, codeword


def crc_check(codeword, polynomial):
    # Calculate the remainder using teh received codeword and same polynomial
    remainder, _ = crc_remainder(codeword, polynomial, '0' * (len(polynomial) -1))
    return remainder == '0' * (len(polynomial) - 1)

if __name__ == '__main__':
    message = input("Enter the message in bit format: ")
    polynomial = input("Enter the polynomial divisor in bit format: ")

    remainder, codeword = crc_remainder(message, polynomial)
    print("Original message: ", message)
    print("Polynomial: ", polynomial)
    print("Transmitted codeword: ", codeword)
    print("Remainder: ", remainder)

    print("Enter the choice \n 1. Error Free Transmission \n 2. Simulate Error : ")
    choice = int(input("Choice..? :"))

    if choice == 1:
        is_valid = crc_check(codeword, polynomial)
    else:
        error_position = int(input("Enter the bit position to introduce error: "))
        codeword = codeword[:error_position] + ('1' if codeword[error_position] == '0' else '0') + codeword[error_position+1:]
        print("Received codeword with error: ", codeword)
        is_valid = crc_check(codeword, polynomial)

    if is_valid:
        print("No error detected. The message is valid and the message is :", codeword)
    else:
        print("Error detected. The message is invalid and the message is : ", codeword)
