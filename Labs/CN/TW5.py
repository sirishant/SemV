import sys

class Network:
    def __init__(self, nodes):
        self.nodes = nodes
        self.graph = {node: {} for node in nodes}
        self.dist_vector = {node: {dest: 0 if dest == node else sys.maxsize for dest in nodes} for node in nodes}

    def add_link(self, node1, node2, cost):
        self.graph[node1][node2] = cost
        self.graph[node2][node1] = cost

    def update_dist_vector(self, node):
        for dest in self.nodes:
            if dest != node:
                self.dist_vector[node][dest] = min(
                    self.dist_vector[node][dest],
                    min(self.dist_vector[neighbor][dest] + self.graph[node][neighbor] for neighbor in self.graph[node])
                )

    def print_route_table(self, node):
        print(f"Routing table for node {node}: ")
        print("Destination\tCost")
        for dest, cost in self.dist_vector[node].items():
            if dest != node:
                print(f"{dest}\t\t{cost}")
        print()

if __name__ == '__main__':
    nodes = [1, 2, 3, 4, 5]
    network = Network(nodes)
    network.add_link(1, 2, 2)
    network.add_link(1, 3, 2)
    network.add_link(1, 4, 1)
    network.add_link(2, 3, 1)
    network.add_link(2, 5, 2)  # Corrected link to connect 1 and 5
    network.add_link(3, 4, 1)
    network.add_link(3, 5, 1)

    for _ in range(6):
        for node in nodes:
            network.update_dist_vector(node)

    for node in nodes:
        network.print_route_table(node)
