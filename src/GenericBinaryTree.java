import java.util.LinkedList;

class GenericBTNode<T extends Comparable<T>>{
    T data;
    GenericBTNode<T> left = null, right = null;

    public GenericBTNode(T data){
        this.data = data;
    }

    @Override
    public String toString() {
        return data.toString();
    }
}

public class GenericBinaryTree<T extends Comparable<T>> {
    GenericBTNode<T> root = null;

    public void insert(GenericBTNode<T> nodeToInsert){
        if (root == null){
            root = nodeToInsert;
            return;
        }

        GenericBTNode<T> movingPointer = root;

        while(movingPointer.left != null || movingPointer.right != null){   // exits if a lead node is reached
            if(nodeToInsert.data.compareTo(movingPointer.data) <= 0 && movingPointer.left != null)
                movingPointer = movingPointer.left;
            else if (nodeToInsert.data.compareTo(movingPointer.data) > 0 && movingPointer.right != null)
                movingPointer = movingPointer.right;
            else
                break;
        }

        if(nodeToInsert.data.compareTo(movingPointer.data) <= 0)
            movingPointer.left = nodeToInsert;
        else
            movingPointer.right = nodeToInsert;

    }

    public void preOrderTraversal(GenericBTNode<T> startNode){
        System.out.print(startNode + " ");
        if(startNode.left != null)
            preOrderTraversal(startNode.left);
        if(startNode.right != null)
            preOrderTraversal(startNode.right);
    }

    public GenericBinaryTree<T> invertTree(GenericBTNode<T> startNode){
        GenericBTNode<T> movingPointer = startNode, leftChild = movingPointer.left, rightChild = movingPointer.right;

        if(leftChild != null || rightChild != null){
            if (leftChild != null) {
                movingPointer = leftChild;
                invertTree(movingPointer);
            }
            if (rightChild != null) {
                movingPointer = rightChild;
                invertTree(movingPointer);
            }
        }
        else{
            return this;
        }

        movingPointer = startNode;
        leftChild = movingPointer.left;
        movingPointer.left = movingPointer.right;
        movingPointer.right = leftChild;

        return this;
    }

    public StringBuilder breadthFirstSearch(){
        StringBuilder bfsString = new StringBuilder();
        LinkedList<GenericBTNode<T>> bfsQueue = new LinkedList<>();
        GenericBTNode<T> currentWorkingNode;

        bfsQueue.addLast(root);
        bfsString.append(root.data).append(" ");

        while (!bfsQueue.isEmpty()){
            currentWorkingNode = bfsQueue.poll();

            if(currentWorkingNode.left != null){
                bfsQueue.addLast(currentWorkingNode.left);
                bfsString.append(currentWorkingNode.left.data).append(" ");
            }

            if(currentWorkingNode.right != null){
                bfsQueue.addLast(currentWorkingNode.right);
                bfsString.append(currentWorkingNode.right.data).append(" ");
            }

        }

        return bfsString;
    }


}
