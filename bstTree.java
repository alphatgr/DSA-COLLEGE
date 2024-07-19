public class bstTree {
   static class Node {
       int data;
       Node left, right;

       Node(int d) {
           data = d;
           left = right = null;
       }
   }

   // Method to insert a new value into the BST
   static Node insert(Node root, int data) {
       if (root == null) {
           root = new Node(data);
           return root;
       }

       if (data < root.data) {
           root.left = insert(root.left, data);
       } else if (data > root.data) {
           root.right = insert(root.right, data);
       }

       return root;
   }
   public static void preOrder(Node root) {
      if (root != null) {
          System.out.print(root.data + " ");
          preOrder(root.left);
          preOrder(root.right);
      }
  }
   // Method to perform in-order traversal of the BST
   static void inOrder(Node root) {
       if (root != null) {
           inOrder(root.left);
           System.out.print(root.data + " ");
           inOrder(root.right);
       }
   }

   public static void main(String[] args) {
       Node root = null;
       root = insert(root, 5);
       insert(root, 3);
       insert(root, 2);
       insert(root, 4);
       insert(root, 7);
       insert(root, 6);
       insert(root, 9);

       // Print the BST in in-order traversal
       System.out.print("In-order traversal of the BST: ");
       inOrder(root);
       System.out.println();
       System.out.print("Pre-order traversal of the BST: ");
       preOrder(root);
       System.out.println();
   }
}
