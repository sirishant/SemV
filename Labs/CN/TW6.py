count = 1000
packets = [200, 500, 600, 700, 450, 400, 200]

length = len(packets)
index = length-1

while (index<length and index>0):
    while(count>packets[index]):
        print("Packet moved out of queue is: ", packets[index])
        count = count-packets[index]
        index = index-1
    print("Count is lesss than the packet value:")
    count = 1000

print("All packets are moved out of the queue successfully.")

# bucket_pkts = [384, 256, 512, 768, 128]
# sent_pkts = []
# n = 1024

# def send_pkts(bucket_pkts, n, sent_pkts):
#     if (bucket_pkts == []):
#         return
#     else:
#         pkt = bucket_pkts[0]
#         print(f"\nAttempting to add pkt {pkt}... \
#               Current n value: {n}")
#         if pkt <= n:
#             # update n value
#             n -= pkt
#             print(f"{pkt} Packet sent!")
#             sent_pkts.append(pkt)
#             bucket_pkts.remove(pkt)
#             print(f"Remaining packets: {bucket_pkts}")
#             print(f"n = {n}")
#             send_pkts(bucket_pkts, n, sent_pkts)
#         else:
#             print("Packet waiting = ", pkt)
#             n = 1024
#             send_pkts(bucket_pkts, n, sent_pkts)

# print("====== Leaky Bucket Algorithm ======")
# send_pkts(bucket_pkts, n, sent_pkts)