Task 1 – Depth First Search Trace

Graph adjacency lists:
A: C B D
B: A C E G
C: A B D
D: C A
E: G F B
F: G E
G: F B

Source node: A

DFS follows the adjacency list order.

Detailed trace:

Start at A.
Visit A.

A has neighbors C, B, D.
C is unvisited, so go to C.
Visit C.

C has neighbors A, B, D.
A is already visited.
B is unvisited, so go to B.
Visit B.

B has neighbors A, C, E, G.
A and C are already visited.
E is unvisited, so go to E.
Visit E.

E has neighbors G, F, B.
G is unvisited, so go to G.
Visit G.

G has neighbors F, B.
F is unvisited, so go to F.
Visit F.

F has neighbors G and E.
Both are already visited, so backtrack to G.

G has no more unvisited neighbors, so backtrack to E.
E checks F and B, but both are already visited, so backtrack to B.
B checks G, but it is already visited, so backtrack to C.

C now checks D.
D is unvisited, so go to D.
Visit D.

D has neighbors C and A.
Both are already visited, so backtrack.

DFS is complete.

DFS visiting order:
A -> C -> B -> E -> G -> F -> D