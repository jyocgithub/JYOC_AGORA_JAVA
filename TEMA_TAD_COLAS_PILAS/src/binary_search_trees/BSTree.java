package binary_search_trees;

import java.util.InputMismatchException;

public class BSTree {
    public BSTNode root;

    public BSTree(BSTNode root) {
        this.root = root;
    }

    public BSTree() {
        this.root = null;
    }


    // el tamaño de un nodo es el tamaño del arbol que cuelga de el como si fuera el raiz
    public int getSize() {
        return getSize(root);
    }

    public int getSize(BSTNode node) {
        if (node == null) return 0;
        else return 1 + getSize(node.left) + getSize(node.right);
    }

    // la altura de un nodo es la longitud de la rama mas larga,
    // incluido el propio nodo raiz usado como referencia
    public int getHeight() {
        return getHeight(root);
    }

    public int getHeight(BSTNode node) {
        if (node == null) return 0;
        else return 1 + Math.max(getHeight(node.left), getHeight(node.right));
    }

    // la profundidad es el numero de predecesores que tiene un nodo, incluyendo la raiz del arbol
    public int getDepth() {
        return getDepth(root);
    }

    public int getDepth(BSTNode node) {
        int depth = 0;
        BSTNode nodeaux = node.parent;
        while (nodeaux != null) {
            depth++;
            nodeaux = nodeaux.parent;
        }
        return depth;
    }

    // mostrar IN-ORDER significa mostrar rama-izda + nodo-actual + rama-dcha
    public void showInOrder() {
        showInOrder(root);
        System.out.println();
    }

    public void showInOrder(BSTNode node) {
        if (node != null) {
            showInOrder(node.left);
            System.out.println(node.key + "." + node.elem);
            showInOrder(node.right);
        }
    }

    // mostrar PRE-ORDER significa mostrar  nodo-actual + rama-izda + rama-dcha
    public void showPreOrder() {
        showInOrder(root);
        System.out.println();
    }

    public void showPreOrder(BSTNode node) {
        if (node != null) {
            System.out.println(node.key + "." + node.elem);
            showPreOrder(node.left);
            showPreOrder(node.right);
        }
    }

    // mostrar POST-ORDER significa mostrar  rama-izda + rama-dcha +  nodo-actual
    public void showPostOrder() {
        showPostOrder(root);
        System.out.println();
    }

    public void showPostOrder(BSTNode node) {
        if (node != null) {
            showPostOrder(node.left);
            showPostOrder(node.right);
            System.out.println(node.key + "." + node.elem);
        }
    }

    // buscar el contenido de un nodo sabiendo su clave
    public String find(Integer key) {
        return find(root, key);
    }

    public String find(BSTNode node, Integer key) {
        String res = null;
        if (node != null) {
            int comparacion = key.compareTo(node.key);
            if (comparacion == 0) {
                return node.elem;
            } else if (comparacion < 0) {
                find(node.left, key);
            } else {
                find(node.right, key);
            }
        }
        return res;
    }


    // insert hace una insercion binario en el arbol
    public void insert(Integer key, String elem) {
        BSTNode newnode = new BSTNode(key, elem);
        if (root == null) {
            root = newnode;
        } else {
            insert(newnode, root);
        }
    }

    public void insert(BSTNode newnode, BSTNode currentNode) {
        if (newnode.key == currentNode.key) {
            System.out.println("La clave ya existe, no se inserta nada");
            return;
        } else if (newnode.key < currentNode.key) {
            if (currentNode.left == null) {
                currentNode.left = newnode;
                newnode.parent = currentNode;
            } else {
                insert(newnode, currentNode.left);
            }
        } else {
            if (currentNode.right == null) {
                currentNode.right = newnode;
                newnode.parent = currentNode;
            } else {
                insert(newnode, currentNode.right);
            }
        }
    }

    public void remove(int key) {
        if (root == null) {
            System.out.println("No se puede borrar nada pues el arbol esta vacio");
        } else {
            // borrar el raiz.  Es un caso especial que se trata aqui
            if (root.key == key) {
                // si la raiz no tiene hijos, para borrarla, simplemente la ponemos a null
                if (root.left == null && root.right == null) {
                    root = null;
                } else if (root.left == null && root.right != null) {
                    root = root.right;
                    root.parent = null;
                } else if (root.left != null && root.right == null) {
                    root = root.left;
                    root.parent = null;
                } else {
                    remove(key, root);
                }
            } else {
                // borrar un nodo no raiz.
                remove(key, root);
            }
        }
    }

    public boolean remove(int key, BSTNode currentNode) {
        // Primero buscamos el nodo a borrar con llamadas recursivas a este metodo remove
        // Si encontramos un nodo null es que la clave buscada no existe
        if (currentNode == null) {
            System.out.println("La clave buscada no existe");
            return false;
        } else if (key < currentNode.key) {
            return remove(key, currentNode.left);
        } else if (key > currentNode.key) {
            return remove(key, currentNode.right);
        }

        // Si se llega hasta aqui es que se ha encontrado el nodo......
        // 3 casos a probar

        // caso 1; el nodo a borrar es un nodo hoja (sin descendientes)
        // se ha de decir al padre que su hijo no existe, pero cuidado, el padre tiene dos hijos, hay que eliminar solo el que conviene
        if (currentNode.left == null && currentNode.right == null) {
            BSTNode father = currentNode.parent;
            if (father.left == currentNode) { // el nodo a eliminar es un hijo izdo
                father.left = null;
            } else {                          // el nodo a eliminar es un hijo dcho
                father.right = null;
            }
            return true;
        }

        // caso 2; el nodo a borrar tiene un unico hijo
        // se conecta el hijo del nodo a borrar al padre del nodo a borrar
        if (currentNode.left == null || currentNode.right == null) {  // no pueden ser los dos null, eso ya se trato antes
            BSTNode sonOfCurrentNode;
            if (currentNode.right == null) {                // solo tiene hijo izdo
                sonOfCurrentNode = currentNode.left;
            } else {                                        // solo tiene hijo dcho
                sonOfCurrentNode = currentNode.right;

            }
            // ponemos al hjo del nodo actual como hijo del padre del nodo actual
            BSTNode father = currentNode.parent;
            if (father.left == currentNode) { // el nodo a eliminar es un hijo izdo
                father.left = sonOfCurrentNode;
            } else {                                           // el nodo a eliminar es un hijo dcho
                father.right = sonOfCurrentNode;
            }
            return true;


        }
        // caso 3; el nodo a borrar tiene dos hijos
        // hay que buscar, en la rama de su hijo derecho,  el nodo con la key mas pequeña (llamemosle candidato)
        BSTNode candidateNode = currentNode.right;  // elegimos la rama derecha del nodo actual
        while (candidateNode.left != null) {            // buscamos el valor minimo, que es ir "cayendo" hacia la izda hasta un nodo hoja
            candidateNode = candidateNode.left;
        }
        // y luego se sustituyen los valores del nodo a borrar por los del candidato, y se borra el candidado de su padre
        // como no movemos nada, solo cambiamos los valores de currentNode, el padre del currentNode no hay que tocarlo
        currentNode.elem = candidateNode.elem;
        currentNode.key = candidateNode.key;

        remove(candidateNode.key, currentNode.right);
//        candidateNode.parent.left=null;    // otra version del remove de la linea anterior
        return true;
    }

}
