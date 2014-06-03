package bypass;

import tree.Node;

import java.util.*;

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

    public static List<Object> depthDirectBypassNoStack(Node root) {
        if (root == null)
            return null;
        List<Object> sequence = new ArrayList<>();
        Stack<Node> storage = new Stack<>();

        Node currentNode = root;
        while (currentNode != null || !storage.empty()) {
            if (!storage.empty()) {
                currentNode = storage.pop();
            }
            while (currentNode != null) {
                sequence.add(currentNode.getValue());
                if (currentNode.right != null)
                    storage.push(currentNode.right);
                currentNode = currentNode.left;
            }
        }

        return sequence;
    }

    public static List<Object> depthReverseBypassNoStack(Node root) {
        if (root == null)
            return null;
        List<Object> sequence = new ArrayList<>();
        Stack<Node> storage = new Stack<>();

        Node currentNode = root;
        while (currentNode != null || !storage.empty()) {
            if (!storage.empty()) {
                currentNode = storage.pop();
                sequence.add(currentNode.getValue());
                currentNode = currentNode.right;
            }
            while (currentNode != null) {
                storage.push(currentNode);
                currentNode = currentNode.left;
            }
        }

        return sequence;
    }

    public static List<Object> depthTerminalBypassNoStack(Node root) {
        if (root == null)
            return null;
        List<Object> sequence = new ArrayList<>();
        Stack<Node> storage = new Stack<>();
        Node currentNode = root;
        while (currentNode != null || !storage.empty()) {
            if (!storage.empty()) {
                currentNode = storage.pop();
                if (!storage.empty() && currentNode.right == storage.lastElement()) {
                    currentNode = storage.pop();
                } else {
                    sequence.add(currentNode.getValue());
                    currentNode = null;
                }
            }
            while (currentNode != null) {
                storage.push(currentNode);
                if (currentNode.right != null) {
                    storage.push(currentNode.right);
                    storage.push(currentNode);
                }
                currentNode = currentNode.left;
            }
        }
        return sequence;
    }
}
