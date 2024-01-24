bucket_pkts = [384, 256, 512, 768, 128]
sent_pkts = []
n = 1024

def send_pkts(bucket_pkts, n, sent_pkts):
    if (bucket_pkts == []):
        return
    else:
        pkt = bucket_pkts[0]
        print(f"\nAttempting to add pkt {pkt}... \
              Current n value: {n}")
        if pkt <= n:
            # update n value
            n -= pkt
            print(f"{pkt} Packet sent!")
            sent_pkts.append(pkt)
            bucket_pkts.remove(pkt)
            print(f"Remaining packets: {bucket_pkts}")
            print(f"n = {n}")
            send_pkts(bucket_pkts, n, sent_pkts)
        else:
            print("Packet waiting = ", pkt)
            n = 1024
            send_pkts(bucket_pkts, n, sent_pkts)

print("====== Leaky Bucket Algorithm ======")
send_pkts(bucket_pkts, n, sent_pkts)