import java.util.*;

public class Graph <D> {

    private HashMap<Vertex<D>, ArrayList<Vertex<D>>> internalGraph;

    public Graph() {
        internalGraph = new HashMap<Vertex<D>, ArrayList<Vertex<D>>>();
    }

    public boolean addEdge(Vertex<D> firstVertex, Vertex<D> secondVertex) {
        if (firstVertex == null || secondVertex == null) {
            return false;
        }
        internalGraph.putIfAbsent(firstVertex, new ArrayList<Vertex<D>>());
        internalGraph.putIfAbsent(secondVertex, new ArrayList<Vertex<D>>());

        if (!internalGraph.get(firstVertex).contains(secondVertex)) {
            internalGraph.get(firstVertex).add(secondVertex);
        }
        if (!internalGraph.get(secondVertex).contains(firstVertex)) {
            internalGraph.get(secondVertex).add(firstVertex);
        }
        return true;
    }

    public void breadthFirst(Vertex<D> startVertex) {
        if ((startVertex == null) || !internalGraph.containsKey(startVertex)) {
            return;
        }
        Queue<Vertex<D>> explorationQueue = new LinkedList<Vertex<D>>();
        List<Vertex<D>> visited = new ArrayList<Vertex<D>>();
        Vertex<D> currVertex;
        explorationQueue.offer(startVertex);
        visited.addLast(startVertex);

        while (!explorationQueue.isEmpty()) {
            currVertex = explorationQueue.poll();
            System.out.println(" " + currVertex.toString());
            for(Vertex<D> nextVertex : internalGraph.get(currVertex)) {
                if (visited.contains(nextVertex)) {
                    continue;
                }
                explorationQueue.offer(nextVertex);
                visited.addLast(nextVertex);
            }

        }
    }

    public static void main (String[] args) {
        Graph<Character> myGraph = new Graph<Character>();

        Vertex<Character> vertexA = new Vertex<Character>('A');
        Vertex<Character> vertexB = new Vertex<Character>('A');
        Vertex<Character> vertexC = new Vertex<Character>('A');
        Vertex<Character> vertexD = new Vertex<Character>('A');
        Vertex<Character> vertexE = new Vertex<Character>('A');
        Vertex<Character> vertexF = new Vertex<Character>('A');

        myGraph.addEdge(vertexA, vertexB);

        temp2 = new Vertex<Character>("D");
        myGraph.addEdge(temp1, temp2);

        temp1 = new Vertex<Character>("B");
        temp2 = new Vertex<Character>("E");
        myGraph.addEdge(temp1, temp2);

        temp2 = new Vertex<Character>("F");
        myGraph.addEdge(temp1, temp2);

        temp1 = new Vertex<Character>("E");
        myGraph.addEdge(temp1, temp2);

        temp1 = new Vertex<Character>("C");
        myGraph.addEdge(temp1, temp2);

        System.out.print("Breadth First: ");
        myGraph.breadthFirst(vertexF);
        System.out.println();

    }
}
