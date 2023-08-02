package task2;
import task1.Student;

public class RedBlackTree <Key extends Comparable<Key>, Value> {
    private Node<Key, Value> root; //the root node is the first node from which the traversal starts
    private static final boolean RED = true;
    private static final boolean BLACK = false;
    public int numSteps = 0;


    //this method returns a value associated with the given key
    public Value get(Key key) {
        numSteps = 0;
        Node<Key, Value> x = root;
        while (x != null) {  //this is the traversal process, which starts from root node
            numSteps++;
            int cmp = key.compareTo(x.key);
            if (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else return x.value;
        }
        return null; //null will only be returned when the sought key cannot be found in the red-black tree
    }

    //this method is used to rotate the temporarily right-red leaning link to lean left
    //it will rotate an input node h and places its right child x at h’s position.
    private Node<Key, Value> rotateLeft(Node<Key, Value> h){
        Node<Key, Value> x = h.right; //we define a node x which is the right child of node h.
        h.right = x.left;   //also, the left child of x becomes the right child of the node h.
        x.left = h; //Afterwards, node h becomes the new left child of node x.
        x.color = h.color;
        h.color = RED;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    //this method is used to rotate the left-leaning red link to (temporarily) lean right.
    private Node<Key, Value> rotateRight(Node<Key, Value> h){
        Node<Key, Value> x = h.left;  //we define a node x which is the left child of node h.
        h.left = x.right;  //right child of x becomes the left child of the node h.
        x.right = h;
        x.color = h.color;
        h.color = RED;
        h.size = 1 + size(h.left) + size(h.right);
        return x;
    }

    //this method will add a value to the given key
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    //private put method
    private Node<Key, Value> put(Node<Key, Value> h, Key key, Value value) {
        if (h == null)
            return new Node<Key, Value>(key, value, RED);

        int cmp = key.compareTo(h.key);
        if (cmp < 0) {

            h.left = put(h.left, key, value);

        } else if (cmp > 0) {

            h.right = put(h.right, key, value);
        } else {
            h.value = value;
        }

        //here, the color balancing is done
        if (isRed(h.right) && !isRed(h.left))
            h = rotateLeft(h);
        if (isRed(h.left) && isRed(h.left.left))
            h = rotateRight(h);
        if (isRed(h.left) && isRed(h.right))
            flipColors(h);

        h.size = 1 + size(h.left) + size(h.right);
        return h;
    }

    //this is a public function which is used to call the private function which will count the number of red links
    public int countRedLinks() {
        return countRedLinks(root);
    }

    private int countRedLinks(Node<Key, Value> x) {
        if (x == null) return 0;
        int left = countRedLinks(x.left);
        int right = countRedLinks(x.right);
        int num = left + right;
        if (x.color == RED) num++;
        return num;
    }

    //this method will return the size of a subtree that is rooted at the node x,
    // if there is no subtree, it will return 0
    private int size(Node<Key, Value> x) {
        if (x == null) return 0; //if there are no subtrees in this node, return 0
        return x.size;
    }

    //this helper method returns information about whether a node’s link is red or black.
    private boolean isRed(Node<Key, Value> x) {
        if (x == null) return false;
        return x.color == RED;
    }

    // This method is used to change the color of children links to black, and pass up the red link to the parent node.
    private void flipColors(Node<Key, Value> h) {
        h.color = RED;
        h.right.color = BLACK;
        h.left.color = BLACK;
    }

}
