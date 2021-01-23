import java.util.Scanner;

public class LowestCommonAncestor {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Node root = createTree();
        Node lca = lowestCommonAncestor(root, 10, 11);
        System.out.println("Lowest common ancestor is: ");
        System.out.println(lca.data);
    }

    static Node lowestCommonAncestor(Node root, int p, int q) {
        if (root == null)
            return root;
        if (root.data == p || root.data == q)
            return root;
        Node leftLCA = lowestCommonAncestor(root.left, p, q);
        Node rightLCA = lowestCommonAncestor(root.right, p, q);
        if (leftLCA != null && rightLCA != null)
            return root;
        if (leftLCA != null)
            return leftLCA;
        else
            return rightLCA;
    }

    static Node createTree() {
        Node root = null;

        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if (data == -1)
            return root;

        root = new Node(data);
        System.out.println("Left subtree data for " + data + ": ");
        root.left = createTree();

        System.out.println("Right subtree data for " + data + ": ");
        root.right = createTree();

        return root;
    }
}
