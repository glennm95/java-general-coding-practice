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

    public static List<Integer> quickSort(List<Integer> inArray){
        if(inArray.size() == 1)
          return inArray;

        // choose last element as pivot
        int pivotPos = inArray.size()-1, pivotElement = inArray.get(pivotPos),
                leftPointer = 0, rightPointer = inArray.size()-2, swap;

        while (leftPointer < rightPointer){
            if(inArray.get(leftPointer) <= pivotElement){
                leftPointer += 1;
                continue;
            }
            if(inArray.get(rightPointer) > pivotElement){
                rightPointer -= 1;
                continue;
            }
            swap = inArray.get(leftPointer);
            inArray.set(leftPointer, inArray.get(rightPointer));
            inArray.set(rightPointer, swap);
        }

        // swap last element/ pivot with left pointer
        if(pivotElement < inArray.get(leftPointer)) {
            inArray.set(inArray.size() - 1, inArray.get(leftPointer));
            inArray.set(leftPointer, pivotElement);
            pivotPos = leftPointer;
        }

        List<Integer> leftSubList, rightSubList, sortedLeft, sortedRight;
        List<Integer> outArray = new ArrayList<>();

        if(pivotPos > 0){
            leftSubList = inArray.subList(0, pivotPos);
            sortedLeft = quickSort(leftSubList);
            outArray.addAll(sortedLeft);
        }

        outArray.add(pivotElement);

        if(pivotPos < inArray.size()-1){
            rightSubList = inArray.subList(pivotPos+1, inArray.size());
            sortedRight = quickSort(rightSubList);
            outArray.addAll(sortedRight);
        }

        return outArray;

    }

//    public static List<Integer> quickSort(List<Integer> inArray){
//        if(inArray.size() == 1 || inArray.size() == 0)
//            return inArray;
//
//        // choose middle element as pivot
//        int pivotPos = inArray.size()/2, pivotEle = inArray.get(pivotPos);
//
//        // swap the last element with the pivot element
//        if(inArray.size() > 2) {
//            inArray.set(pivotPos, inArray.get(inArray.size() - 1));
//            inArray.set(inArray.size()-1, pivotEle);
//        }
//
//        int leftPointer = 0, rightPointer = inArray.size()-2;
//
//        while(leftPointer < rightPointer){
//            if(inArray.get(leftPointer) <= pivotEle){
//                leftPointer += 1;
//                continue;
//            }
//            if(inArray.get(rightPointer) > pivotEle){
//                rightPointer -= 1;
//                continue;
//            }
//
//            // swap leftPointer and rightPointer elements
//            int rightElement = inArray.get(rightPointer);
//            inArray.set(rightPointer, inArray.get(leftPointer));
//            inArray.set(leftPointer, rightElement);
//        }
//
//        // above while loop exits when leftPointer = rightPointer, therefore swap leftPointer with pivot
//        // present at last position of inArray
//
//        inArray.set(inArray.size()-1, inArray.get(leftPointer));
//        inArray.set(leftPointer, pivotEle);
//
//        List<Integer> leftArray = quickSort(inArray.subList(0, leftPointer));
//        List<Integer> rightArray = quickSort(inArray.subList(leftPointer+1, inArray.size()));
//
//        leftArray.add(pivotEle);
//
//        if(inArray.size() > 2){
//            leftArray.addAll(rightArray);
//        }
//
//        return leftArray;
//    }

    public static void main(String[] args) {
        List<Integer> inArray = new ArrayList<>(Arrays.asList(29,25,10,49,99,10,402,19,29));
//        System.out.println(mergeSort(inArray));
        System.out.println(quickSort(inArray));
    }
}
