public class GenericLinkedList<T> {
    GenericLinkedListNode<T> head = null;

    public void addBeg(GenericLinkedListNode<T> n){
        if(head == null) {
            head = n;
            return;
        }

        n.next = head;
        head = n;
    }

    public void addMid(GenericLinkedListNode<T> n, int pos){
        if (head == null || pos == 1)
            this.addBeg(n);
        else if (pos == this.getSize()+1)
            this.addEnd(n);
        else if (pos <= this.getSize()) {
            GenericLinkedListNode<T> current = head, previous = null;

            int count = 0;
            while (current.next != null){
                count += 1;
                if (count == pos)
                    break;
                previous = current;
                current = current.next;
            }

            n.next = current;
            assert previous != null;
            previous.next = n;
        }

    }

    public void addEnd(GenericLinkedListNode<T> n) {
        if (head == null) {
            head = n;
            return;
        }

        GenericLinkedListNode<T> current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = n;
    }

    public T deleteBeg(){
        if(head == null)
            return null;
        T deletedItem = head.value;
        GenericLinkedListNode<T> current = head;
        head = head.next;
        current.next = null;
        return deletedItem;
    }

    public T deleteEnd(){
        if(head == null)
            return null;

        if(this.getSize() == 1)
            return deleteBeg();

        GenericLinkedListNode<T> previous = null, current = head;

        while(current.next != null){
            previous = current;
            current = current.next;
        }
        assert previous != null;
        previous.next = null;
        return current.value;
    }

    public T deleteMid(int pos){
        T deletedItem = null;

        if(head == null)
            return null;

        if(this.getSize() == 1 || pos == 1)
            return deleteBeg();

        if(pos == this.getSize())
            return deleteEnd();

        /*add code to delete mid element*/

        return deletedItem;
    }


    public int getSize(){
        GenericLinkedListNode<T> current = head;
        int size = 0;

        if(head == null)
            return 0;

        while(current.next != null){
            size += 1;
            current = current.next;
        }

        return size + 1;
    }


    @Override
    public String toString() {
        GenericLinkedListNode<T> current = head;
        StringBuilder sb = new StringBuilder("[");

        while(current.next != null){
            sb.append(current.value.toString()).append(", ");
            current = current.next;
        }

        sb.append(current.value.toString()).append("]");

        return sb.toString();
    }

    public GenericLinkedList<T> reverseLinkedList(){
        if(head == null)
            return null;

        if(head.next == null)
            return this;

        GenericLinkedListNode<T> previous = head.next, current = previous.next;

        head.next = null;

        while(current != null){
            previous.next = head;
            head = previous;
            previous = current;
            current = current.next;
        }

        previous.next = head;
        head = previous;
//        previous = null;

        return this;
    }
}

