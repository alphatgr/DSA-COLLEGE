public class AVLtree {
    static class Node{
        int data;
        Node left,right;
        int height;
        public Node(int data){
            this.left= null;
            this.right = null;
            this.data = data;
            this.height=1;
        }
    }

    //Height of avl tree
    public static int height(Node n){
        if (n == null)
        {
            return 0;
        }
        return n.height;
    }

    //Balance Factor
    public static int getBalance(Node n){
        if(n == null){
            return 0;
        }
        else{
            return height(n.left) - height(n.right);
        }
    }


    //Right Rotate
    public static Node rightRotate(Node y){
        Node x =y.left;
        Node T2 =x.right;

        //Perform Rotation
        x.right = y;
        y.left = T2;

        //Update Heights
        y.height= Math.max(height(y.left),height(y.right)) +1;
        x.height= Math.max(height(x.left),height(x.right)) +1;

        //Return new root
        return x;
    }
    // Left Rotate
    public static Node leftRotate(Node x) {
    Node y = x.right; // y is the right child of x
    Node T2 = y.left; // T2 is the left child of y

    // Perform Rotation
    y.left = x;
    x.right = T2;

    // Update Heights
    x.height = Math.max(height(x.left), height(x.right)) + 1;
    y.height = Math.max(height(y.left), height(y.right)) + 1;

    // Return new root
    return y;
    }
    
}
