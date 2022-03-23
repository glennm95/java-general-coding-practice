import java.util.Arrays;
import java.util.LinkedList;

public class GenericHeap<T extends Comparable<T>> {
    LinkedList<GenericBTNode<T>> heapList;

    public GenericHeap(){
        heapList = new LinkedList<>();
        heapList.add(null);
    }

    public void insertMinHeap(GenericBTNode<T> nodeToInsert){
        if(heapList.get(0) == null){
            heapList.set(0, nodeToInsert);
            heapList.addAll(Arrays.asList(null, null));
            return;
        }

        int i=0, insertPos, leftChild, rightChild, parentPos;
        GenericBTNode<T> child;

        while(true){
            leftChild = i*2+1;
            rightChild = i*2+2;
            if(heapList.get(leftChild) == null){
                heapList.set(leftChild, nodeToInsert);
                insertPos = leftChild;
                heapList.addAll(Arrays.asList(null, null));     // extend heapList by 2 (one position for each child)
                break;
            }
            else if(heapList.get(rightChild) ==  null){
                heapList.set(rightChild, nodeToInsert);
                insertPos = rightChild;
                heapList.addAll(Arrays.asList(null, null));
                break;
            }
            else
                i+=1;
        }

        while(heapList.get(insertPos).data.compareTo(heapList.get((insertPos-1)/2).data) < 0 && insertPos > 0){
            parentPos = (insertPos-1)/2;
            child = heapList.get(insertPos);
            heapList.set(insertPos, heapList.get(parentPos));
            heapList.set(parentPos, child);
            insertPos = (insertPos - 1)/2;
        }
    }

    public GenericBTNode<T> removeMinHeap(){
        if(heapList.get(0) ==  null)
            return null;

        GenericBTNode<T> root = heapList.get(0);

        int i=0;

        while(heapList.get(i) != null){
            i += 1;
        }

        GenericBTNode<T> lastElement = heapList.get(i-1);

        heapList.set(0, lastElement);
        heapList.set(i-1, null);

        heapList.removeLast();
        heapList.removeLast();

        if(heapList.get(0) == null)
            return root;

        int parentPos = 0, leftChildPos, rightChildPos, smallerChildPos;
        GenericBTNode<T> swap;

        while(!whileConditionCheck(parentPos)){
            leftChildPos = parentPos*2+1;
            rightChildPos = parentPos*2+2;

            if(heapList.get(parentPos).data.compareTo(heapList.get(leftChildPos).data) < 0 &&
                    heapList.get(parentPos).data.compareTo(heapList.get(rightChildPos).data) < 0)
                return root;

            if(heapList.get(rightChildPos) == null)
                smallerChildPos = leftChildPos;
            else if(heapList.get(leftChildPos).data.compareTo(heapList.get(rightChildPos).data) < 0)
                smallerChildPos = leftChildPos;
            else
                smallerChildPos = rightChildPos;

            swap = heapList.get(smallerChildPos);
            heapList.set(smallerChildPos, heapList.get(parentPos));
            heapList.set(parentPos, swap);

            parentPos = smallerChildPos;
        }

        return root;
    }

    private boolean whileConditionCheck(int parentPos){
        int leftChildPos = parentPos*2+1, rightChildPos = parentPos*2+2;
        T parentData = heapList.get(parentPos).data, leftChildData, rightChildData;

        if(heapList.get(leftChildPos) == null)
            return true;

        leftChildData = heapList.get(leftChildPos).data;

        if(heapList.get(rightChildPos) == null){
            return parentData.compareTo(leftChildData) < 0;
        }

        rightChildData = heapList.get(rightChildPos).data;
        return parentData.compareTo(leftChildData) < 0 && parentData.compareTo(rightChildData) < 0;

    }

    @Override
    public String toString() {
        return heapList.toString();
    }



    public static void main(String[] args) {
        GenericHeap<Integer> heap = new GenericHeap<>();
        heap.insertMinHeap(new GenericBTNode<>(48932));
        heap.insertMinHeap(new GenericBTNode<>(29282));
        heap.insertMinHeap(new GenericBTNode<>(93282));
        heap.insertMinHeap(new GenericBTNode<>(30228));
        heap.insertMinHeap(new GenericBTNode<>(92747));
        heap.insertMinHeap(new GenericBTNode<>(18289));
        heap.insertMinHeap(new GenericBTNode<>(71291));

        System.out.println(heap);
        System.out.println(heap.removeMinHeap());
        System.out.println(heap);
        System.out.println(heap.removeMinHeap());
        System.out.println(heap);
        System.out.println(heap.removeMinHeap());
        System.out.println(heap);
        System.out.println(heap.removeMinHeap());
        System.out.println(heap);
        System.out.println(heap.removeMinHeap());
        System.out.println(heap);
        System.out.println(heap.removeMinHeap());
        System.out.println(heap);
        System.out.println(heap.removeMinHeap());
        System.out.println(heap);
        System.out.println(heap.removeMinHeap());
        System.out.println(heap);

    }
}
