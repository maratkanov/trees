package tree.bypass.depth.stack;

import bypass.Bypass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tree.Node;

import java.util.ArrayList;
import java.util.List;

public class DepthDirectBypassWithStackTest {
    private Node root;
    private List<Object> correctSequence;

    @Before
    public void setUp() throws Exception {
        root = new Node(null, 8);

        root.left = new Node(root, 3);
        root.right = new Node(root, 10);

        root.left.left = new Node(root.left, 1);
        root.left.right = new Node(root.left, 6);
        root.right.right = new Node(root.right, 14);

        root.left.right.left = new Node(root.left.right, 4);
        root.left.right.right = new Node(root.left.right, 7);
        root.right.right.left = new Node(root.right.right, 13);

        correctSequence = new ArrayList<>();
        correctSequence.add(root.getValue());
        correctSequence.add(root.left.getValue());
        correctSequence.add(root.left.left.getValue());
        correctSequence.add(root.left.right.getValue());
        correctSequence.add(root.left.right.left.getValue());
        correctSequence.add(root.left.right.right.getValue());
        correctSequence.add(root.right.getValue());
        correctSequence.add(root.right.right.getValue());
        correctSequence.add(root.right.right.left.getValue());
    }

    @Test
    public void widthBypassTest() throws Exception {
        List<Object> sequence = Bypass.depthDirectBypass(root);
        Assert.assertEquals("Обход в ширину не корректен", correctSequence, sequence);
    }
}
