import java.util.ArrayList;
import java.util.List;

public class GenericNode<T> {
    final T data;
    boolean visited;
    List<GenericNode<T>> neighbors;

    public GenericNode(T data){
        this.data = data;
        visited = false;
        neighbors = new ArrayList<>();
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
