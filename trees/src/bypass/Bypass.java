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

    public static List<Object> depthDirectBypass(Node root) {
        if (root == null)
            return null;
        List<Object> sequence = new ArrayList<>();
        sequence.add(root.getValue());
        if (root.left != null)
            sequence.addAll(depthDirectBypass(root.left));
        if (root.right != null)
            sequence.addAll(depthDirectBypass(root.right));

        return sequence;
    }

    public static List<Object> depthReverseBypass(Node root) {
        if (root == null)
            return null;
        List<Object> sequence = new ArrayList<>();
        if (root.left != null)
            sequence.addAll(depthReverseBypass(root.left));
        sequence.add(root.getValue());
        if (root.right != null)
            sequence.addAll(depthReverseBypass(root.right));

        return sequence;
    }

    public static List<Object> depthTerminalBypass(Node root) {
        if (root == null)
            return null;
        List<Object> sequence = new ArrayList<>();
        if (root.left != null)
            sequence.addAll(depthTerminalBypass(root.left));
        if (root.right != null) {
            sequence.addAll(depthTerminalBypass(root.right));
        }
        sequence.add(root.getValue());

        return sequence;
    }
}
