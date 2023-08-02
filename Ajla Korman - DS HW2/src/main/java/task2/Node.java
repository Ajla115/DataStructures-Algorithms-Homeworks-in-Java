package task2;
import task1.Student;

public class Node<Key extends Comparable<Key>, Value> {
    public Key key;
    public Value value;
    public Node<Key, Value> left, right;
    public int size = 1;
    public boolean color; // color of the link from the parent node

    //Constructor
    public Node(Key key, Value value, boolean color){
        this.key = key;
        this.value = value;
        this.color = color;
    }

}

/* Red-black tree is a BST structure, therefore we implement here two different generic classes: the comparable Key and
a Value. The BSTs are generally used for fast searching and
database indexing and one BST node is usually observed as a key-value pair. The key is an attribute used to construct the
e tree, place the node in the correct hierarchy in the tree and enable fast searching of nodes. We can also define values
which are stored in the node to which the kez points to.  For example, in a “university BST”, the key might be the
student’s ID, whereas the value could be the contents of the Student object (name, surname, GPA, ..) for that particular ID.
When accessing the tree, you would  use the “student ID key” to quickly  locate the students we are interested in.
Once located, we would access the “student value” to get the relevant information.
 */
