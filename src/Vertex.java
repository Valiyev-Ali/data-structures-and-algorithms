public class Vertex <D> {

    private D data;

    public Vertex(D vertexData) {
        data = vertexData;
    }

    public D getData() {
        return data;
    }

    @Override
    public String toString() {
        return data == null? "null" : super.toString();
    }
}
