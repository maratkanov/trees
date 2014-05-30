package tree;

public class Node {
    public Node left;
    public Node right;
    public Node parent;
    private Object value;

    public Node(Node parent, Object value) {
        this.parent = parent;
        this.value = value;
    }

    public Object getValue() {
        return value;
    }
}
