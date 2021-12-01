package binary_search_trees;

import binary_search_trees.BSTree;

public class BSTPruebas {

    public static void main(String[] args) {
        BSTNode nodo = new BSTNode(23, "23");
        BSTree tree = new BSTree(nodo);

        tree.insert(1,"1");
        tree.insert(9,"1");
        tree.insert(3,"1");
        tree.insert(65,"1");
        tree.insert(12,"1");
        tree.insert(22,"1");
        tree.insert(32,"1");
        tree.insert(42,"1");
        tree.insert(3,"1");
        tree.insert(11,"1");

        tree.showInOrder();

    }
}
