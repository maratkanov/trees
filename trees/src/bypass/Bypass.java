package bypass;

import tree.Node;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Bypass {

    public static List<Object> widthBypass(Node root) {
        if (root == null)
            return null;

        List<Object> sequence = new ArrayList<>();

        Deque<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.pollFirst();
            sequence.add(node.getValue());
            if (node.left != null) {
                queue.addLast(node.left);
            }
            if (node.right != null) {
                queue.addLast(node.right);
            }
        }
        return sequence;
    }
}
