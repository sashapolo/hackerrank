def invite_max_friends(friend_pairs):
    friend_graph = _create_friend_graph(friend_pairs)
    total_friends = len(friend_graph)
    while True:
        unsuitable_friends = _remove_unsuitable_friends(friend_graph, total_friends)
        if not unsuitable_friends:
            return len(friend_graph)


def _create_friend_graph(friend_pairs):
    def add_edge(vertex1, vertex2):
        friend_graph.setdefault(vertex1, set()).add(vertex2)
        friend_graph.setdefault(vertex2, set()).add(vertex1)

    friend_graph = {}
    for friend1, friend2 in friend_pairs:
        add_edge(friend1, friend2)
    return friend_graph


def _remove_unsuitable_friends(friend_graph, total_friends):
    def delete_vertices(vertices):
        for vertex in vertices:
            del friend_graph[vertex]
        for edges in friend_graph.values():
            edges -= vertices

    # a friend is considered unsuitable if he knows less than 3 people or doesn't know less than 3 people
    unsuitable_friends = {
        friend for friend, edges in friend_graph.items()
        if len(edges) < 3 or len(edges) > total_friends - 3
    }
    if unsuitable_friends:
        delete_vertices(unsuitable_friends)
    return unsuitable_friends
