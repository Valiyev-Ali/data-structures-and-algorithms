import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

    public static void main (String[] args) {
        Graph<Character> myGraph = new Graph<Character>();

        Vertex<Character> temp1 = new Vertex<Character>("A");
        Vertex<Character> temp2 = new Vertex<Character>("B");
        myGraph.addEdge(temp1, temp2);

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


    }
}
