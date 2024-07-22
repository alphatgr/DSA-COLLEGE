public class AVLtree {
    static class Node {
        int data;
        Node left, right;
        int height;
        
        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    // Height of AVL tree
    public static int height(Node n) {
        if (n == null) {
            return 0;
        }
        return n.height;
    }

    // Balance Factor
    public static int getBalance(Node n) {
        if (n == null) {
            return 0;
        }
        return height(n.left) - height(n.right);
    }

    // Right Rotate
    public static Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform Rotation
        x.right = y;
        y.left = T2;

        // Update Heights
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left Rotate
    public static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform Rotation
        y.left = x;
        x.right = T2;

        // Update Heights
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Insert Node
    public static Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        // Perform normal BST insert
        if (key < node.data) {
            node.left = insert(node.left, key);
        } else if (key > node.data) {
            node.right = insert(node.right, key);
        } else {
            // Duplicate keys are not allowed in AVL tree
            return node;
        }

        // Update height of this ancestor node
        node.height = 1 + Math.max(height(node.left), height(node.right));

        // Get the balance factor of this ancestor node to check whether
        // this node became unbalanced
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && key < node.left.data) {
            return rightRotate(node);
        }

        // Right Right Case
        if (balance < -1 && key > node.right.data) {
            return leftRotate(node);
        }

        // Left Right Case
        if (balance > 1 && key > node.left.data) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.data) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the (unchanged) node pointer
        return node;
    }

    // Preorder Traversal of the tree
    public static void preOrder(Node root) {
        if (root != null) {
            System.out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public static void main(String[] args) {
        Node root = null;

        // Insert nodes
        root = insert(root, 10);
        root = insert(root, 20);
        root = insert(root, 30);
        root = insert(root, 40);
        root = insert(root, 50);
        root = insert(root, 25);

        // Print preorder traversal
        System.out.println("Preorder traversal of the constructed AVL tree:");
        preOrder(root);
    }
}
