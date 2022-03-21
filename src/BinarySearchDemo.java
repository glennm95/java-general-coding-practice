import java.util.ArrayList;
import java.util.List;

public class BinarySearchDemo {
    public static boolean binarySearch(List<Integer> inArray, int elementToSearch){
        int mid = inArray.get(inArray.size()/2);
        if(elementToSearch == mid)
            return true;
        if(inArray.size() == 1)
            return false;
        if(elementToSearch < mid)
            // return left half of inArray if element < midElement
            return binarySearch(inArray.subList(0, inArray.size()/2), elementToSearch);
        else
            // return right half of inArray if element > midElement
            return binarySearch(inArray.subList(inArray.size()/2, inArray.size()), elementToSearch);
    }

    public static void main(String[] args) {
        List<Integer> inArray = new ArrayList<>();

        inArray.add(32);
        inArray.add(72);
        inArray.add(86);
        inArray.add(65);
        inArray.add(12);
        inArray.add(99);
        inArray.add(38);

        inArray.sort(null);

        System.out.println(binarySearch(inArray, 65));
    }
}