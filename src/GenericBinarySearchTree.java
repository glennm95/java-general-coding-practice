import java.util.ArrayList;
import java.util.Objects;

class GenericBSTNode<T extends Comparable<T>>{
    GenericBSTNode<T> left=null, right=null;
    T data;

    public GenericBSTNode(T data){
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

public class GenericBinarySearchTree<T extends Comparable<T>> {
    GenericBSTNode<T> root = null;

    public void insertIntoGBST(GenericBSTNode<T> n) {
        if (root == null) {
            root = n;
            return;
        }

        GenericBSTNode<T> current = root;

        while (current.left != null || current.right != null) {
            if (n.data.compareTo(current.data)<=0 && current.left != null) {
                current = current.left;
            } else if (n.data.compareTo(current.data)>0 && current.right != null) {
                current = current.right;
            } else break;
        }
        if (n.data.compareTo(current.data) <= 0)
            current.left = n;
        else
            current.right = n;
    }

    public void preOrderTraversal(GenericBSTNode<T> startNode){
        System.out.print(startNode + " ");
        if (startNode.left != null)
            preOrderTraversal(startNode.left);
        if (startNode.right != null)
            preOrderTraversal(startNode.right);
    }

    public void inOrderTraversal(GenericBSTNode<T> startNode){
        if (startNode.left != null)
            inOrderTraversal(startNode.left);
        System.out.print(startNode + " ");
        if (startNode.right != null)
            inOrderTraversal(startNode.right);
    }

    public void postOrderTraversal(GenericBSTNode<T> startNode){
        if (startNode.left != null)
            postOrderTraversal(startNode.left);
        if (startNode.right != null)
            postOrderTraversal(startNode.right);
        System.out.print(startNode + " ");
    }

    public boolean search(T value, GenericBSTNode<T> startPoint){
        if (root == null)
            return false;

        if (value.equals(startPoint.data))
            return true;
        else if (value.compareTo(startPoint.data) <= 0){
            if (startPoint.left == null)
                return false;
            else
                return search(value, startPoint.left);
        }
        else{
            if (startPoint.right == null){
                return false;
            }
            else
                return search(value, startPoint.right);
        }
    }

    public ArrayList<T> searchWithPath(T value, GenericBSTNode<T> startPoint, ArrayList<T> path){
        if (root == null)
            return null;

        if (value.equals(startPoint.data)) {
            path.add(startPoint.data);
            return path;
        }

        else if (value.compareTo(startPoint.data) <= 0){
            if (startPoint.left == null)
                return null;
            else {
                path.add(startPoint.data);
                return searchWithPath(value, startPoint.left, path);
            }
        }
        else{
            if (startPoint.right == null){
                return null;
            }
            else {
                path.add(startPoint.data);
                return searchWithPath(value, startPoint.right, path);
            }
        }
    }

    public T lowestCommonAncestor(GenericBSTNode<T> startNode, T first, T second){
        ArrayList<T> pathOne = new ArrayList<>();
        ArrayList<T> pathTwo = new ArrayList<>();
        T lCA;
        searchWithPath(first, startNode, pathOne);
        searchWithPath(second, startNode, pathTwo);
        int i = 0;
        while(Objects.equals(pathOne.get(i), pathTwo.get(i))){
            i += 1;
        }
        lCA = pathOne.get(i-1);
        return lCA;
    }


    public void testTree(){
        if(root == null)
            return;
        GenericBSTNode<T> current = root;
        System.out.println(current.data);
        System.out.println(current.left.data);
        System.out.println(current.right.data);
        System.out.println(current.left.left.data);
        System.out.println(current.left.right.data);
        System.out.println(current.right.left.data);
        System.out.println(current.right.right.data);

    }




}
