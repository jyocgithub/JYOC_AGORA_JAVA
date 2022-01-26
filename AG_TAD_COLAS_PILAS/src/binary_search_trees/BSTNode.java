package binary_search_trees;

public class BSTNode {
    Integer key;
    String elem;

    BSTNode parent;
    BSTNode left;
    BSTNode right;

    BSTNode(Integer key, String elem) {
        this.key = key;
        this.elem = elem;
        right = null;
        left = null;
    }

}


