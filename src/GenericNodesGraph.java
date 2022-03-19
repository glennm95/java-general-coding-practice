import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GenericNodesGraph<T> {
    List<GenericNode<T>> graphNodes;

    public GenericNodesGraph(){
        graphNodes = new ArrayList<>();
    }

    public void addUnDirectedConnection(GenericNode<T> n1, GenericNode<T> n2){
        if(graphNodes.contains(n1) && graphNodes.contains(n2)) {
            n1.neighbors.add(n2);
            n2.neighbors.add(n1);
        }
    }

    public void addDirectedConnection(GenericNode<T> n1, GenericNode<T> n2){
        if(graphNodes.contains(n1))
            n1.neighbors.add(n2);
    }

    public ArrayList<GenericNode<T>> DepthFirstSearchTraversal(){
        GenericNode<T> firstNode = graphNodes.get(0);
        ArrayList<GenericNode<T>> visitedNodes = new ArrayList<>();
        Stack<GenericNode<T>> DFSStack = new Stack<>();

        DFSStack.push(firstNode);
        visitedNodes.add(firstNode);
        boolean ifEntered;

        while(!DFSStack.isEmpty()){
            GenericNode<T> topOfStack = DFSStack.peek();
            ifEntered = false;

            for(GenericNode<T> neighbor: topOfStack.neighbors){
                if(!visitedNodes.contains(neighbor)){
                    ifEntered = true;
                    DFSStack.push(neighbor);
                    visitedNodes.add(neighbor);
                    break;
                }
            }

            if(!ifEntered)
                DFSStack.pop();
        }

        return visitedNodes;
    }

    public boolean DepthFirstSearch(GenericNode<T> nodeToSearch){
        GenericNode<T> firstNode = graphNodes.get(0);

        if(nodeToSearch.data.equals(firstNode.data))
            return true;

        ArrayList<GenericNode<T>> visitedNodes = new ArrayList<>();
        Stack<GenericNode<T>> DFSStack = new Stack<>();

        DFSStack.push(firstNode);
        visitedNodes.add(firstNode);
        boolean ifEntered;

        while(!DFSStack.isEmpty()){
            GenericNode<T> topOfStack = DFSStack.peek();
            ifEntered = false;

            for(GenericNode<T> neighbor: topOfStack.neighbors){
                if(!visitedNodes.contains(neighbor)){
                    ifEntered = true;
                    DFSStack.push(neighbor);
                    visitedNodes.add(neighbor);

                    if(neighbor.data.equals(nodeToSearch.data))
                        return true;

                    break;
                }
            }

            if(!ifEntered)
                DFSStack.pop();
        }

        return false;
    }

    public Stack<GenericNode<T>> DepthFirstSearchPath(GenericNode<T> nodeToSearch){
        GenericNode<T> firstNode = graphNodes.get(0);

        ArrayList<GenericNode<T>> visitedNodes = new ArrayList<>();
        Stack<GenericNode<T>> DFSStack = new Stack<>();

        DFSStack.push(firstNode);
        visitedNodes.add(firstNode);

        if(nodeToSearch.data.equals(firstNode.data))
            return DFSStack;

        boolean ifEntered;

        while(!DFSStack.isEmpty()){
            GenericNode<T> topOfStack = DFSStack.peek();
            ifEntered = false;

            for(GenericNode<T> neighbor: topOfStack.neighbors){
                if(!visitedNodes.contains(neighbor)){
                    ifEntered = true;
                    DFSStack.push(neighbor);
                    visitedNodes.add(neighbor);

                    if(neighbor.data.equals(nodeToSearch.data))
                        return DFSStack;

                    break;
                }
            }

            if(!ifEntered)
                DFSStack.pop();
        }

        return null;
    }

    public boolean recursiveDepthFirstSearch(GenericNode<T> current, GenericNode<T> nodeToSearch){
        if(current.data.equals(nodeToSearch.data))
            return true;

        current.visited = true;

        for(GenericNode<T> neighbor:current.neighbors){
            if(!neighbor.visited){
                if (recursiveDepthFirstSearch(neighbor, nodeToSearch))
                    return true;
            }
        }

        return false;
    }


    public GenericNode<T> lowestCommonAncestor(GenericNode<T> n1, GenericNode<T> n2){
        GenericNode<T> lCA;
        Stack<GenericNode<T>> st1 = DepthFirstSearchPath(n1);
        Stack<GenericNode<T>> st2 = DepthFirstSearchPath(n2);

        int i = 0;
        while(st1.get(i).data.equals(st2.get(i).data)){
            i += 1;
        }

        lCA = st1.get(i-1);

        return lCA;
    }

    public StringBuilder breadthFirstSearch(){
        StringBuilder bfsString = new StringBuilder();
        LinkedList<GenericNode<T>> bfsQueue = new LinkedList<>();
        GenericNode<T> currentWorkingNode;

        bfsQueue.addLast(graphNodes.get(0));
        bfsString.append(graphNodes.get(0).data);

        while (!bfsQueue.isEmpty()){
            currentWorkingNode = bfsQueue.poll();

            for(GenericNode<T> neighbor: currentWorkingNode.neighbors){
                bfsQueue.addLast(neighbor);
                bfsString.append(neighbor.data);
            }
        }

        return bfsString;
    }

}
