public class GenericLinkedListNode<T> {
    T value;
    GenericLinkedListNode<T> next = null;

    public GenericLinkedListNode(T value){
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }
}




