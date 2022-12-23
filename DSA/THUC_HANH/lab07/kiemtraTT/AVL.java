public class AVL {
    Node root;
    public AVL() {
        root = null;
    }
    private Node insert(Node x ,Integer key) {
        if(x == null) {
            return new Node(key);
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0) {
            x.left = insert(x.left, key);
        } else if(cmp > 0) {
            x.right = insert(x.right, key);
        } else {
            x.key = key;
        }
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return balance(x);
    } 
    public void insert(Integer key) {
        root = insert(root, key);
    }  
    private Node min(Node x) {
        if(x.left == null) {
            return x;
        }
        return min(x.left);
    }
    public Node min() {
        if(root != null)
            return min(root);
        else return null;
    }
    private Node deleteMin(Node x) {
        if(x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        return balance(x);
    }

    private Node deleteMax(Node x) {
        if(x.right == null) {
            return x.left;
        }
        x.right = deleteMax(x.right);
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return balance(x);
    }

    private Node delete(Node x, Integer key) {
        if(x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0) {
            x.left = delete(x.left, key);
        } else if(cmp > 0) {
            x.right = delete(x.right, key);
        } else {
            if(x.left == null) {
                return x.right;
            }
            if(x.right == null) {
                return x.left;
            }
            x.key = min(x.right).key;
            x.right = deleteMin(x.right);
        }
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        
        return balance(x);
    }
    public void delete(Integer key) {
        if(root != null) {
            root = delete(root, key);
        }
    }

    
    public void deleteMax() {
        if(root != null) 
            root = deleteMax(root);
    }
    private Node delete_pre(Node x, Integer key) {
        if(x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0) {
            x.left = delete_pre(x.left, key);
        } else if(cmp > 0) {
            x.right = delete_pre(x.right, key);
        } else {
            if(x.left == null) {
                return x.right;
            }
            if(x.right == null) {
                return x.left;
            }
            x.key = max(x.left).key;
            Node dele = deleteMax(x.left);

   

            x.left = dele;
        }
        // if(x == null){
        //     return x;   
        // }
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return balance(x);
    }
    public void delete_pre(Integer key) {
        if(root != null) {
            root = delete_pre(root, key);
        }
    }

    public int height(Node x) {
        if(x == null) {
            return -1;
        }
        return x.height;
    }
    private int checkBalance(Node x) {
        return height(x.left) - height(x.right);
    }
    private Node rotateLeft(Node x) {
        Node y = x.right;
        x.right = y.left;
        y.left = x;
        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;
        return y;
    }
    private Node rotateRight(Node x) {
        Node y = x.left;
        x.left = y.right;
        y.right = x;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return y;
    }
    private Node balance(Node x) {
        if(checkBalance(x) < -1) {
            if(checkBalance(x.right) > 0) {
                x.right = rotateRight(x.right);
            }
            x = rotateLeft(x);
        } else if(checkBalance(x) > 1) {
            if(checkBalance(x.left) < 0) {
                x.left = rotateLeft(x.left);
            }
            x = rotateRight(x);
        }
        return x;
    } 
    private void NLR(Node x) {
        if(x != null) {
            
            NLR(x.left);
            System.out.print(x.key + " ");
            NLR(x.right);
        }
    }
    public void NLR() {
        NLR(root);
        System.out.println();
    }
    private Node search(Node x, Integer key) {
        if(x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if(cmp < 0) {
            return search(x.left, key);
        } else if(cmp > 0) {
            return search(x.right, key);
        } else {
            return x;
        }
    }
    public Node search(Integer key) {
        return search(root, key);
    }
    private Node max(Node x) {
        if(x.right == null) {
            return x;
        }
        return max(x.right);
    }
    public Node max() {
        if(root != null) {
            return max(root);
        } else return null;
    }
    public boolean contains(Integer key) {
        return search(key) != null ? true : false;
    }
    
}
