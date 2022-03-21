import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortingAlgorithms {
    public static List<Integer> mergeSort(List<Integer> inArray){
        if(inArray.size() == 1)
            return inArray;

        int mid = inArray.size()/2;
        List<Integer> leftArray = mergeSort(inArray.subList(0, mid));
        List<Integer> rightArray = mergeSort(inArray.subList(mid, inArray.size()));

        return merge(leftArray, rightArray);
    }

    public static List<Integer> merge(List<Integer> left, List<Integer> right){
        int i=0, j=0, currentLeft, currentRight;
        List<Integer> outArray = new ArrayList<>();

        while(i < left.size() && j < right.size()){
            currentLeft = left.get(i);
            currentRight = right.get(j);

            if(currentLeft <= currentRight){
                outArray.add(currentLeft);
                i += 1;
            }
            else{
                outArray.add(currentRight);
                j += 1;
            }
        }

        if(i < left.size())
            outArray.addAll(left.subList(i, left.size()));
        else if(j < right.size())
            outArray.addAll(right.subList(j, right.size()));

        return outArray;
    }

    public static void main(String[] args) {
        List<Integer> inArray = new ArrayList<>(Arrays.asList(10, 9, 8, 7, 7, 5, 4, 0));
        System.out.println(mergeSort(inArray));
    }
}
