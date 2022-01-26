package pro.sky.java.course2.Services;

import pro.sky.java.course2.Exeptions.ArrayElementCannotBeNullException;
import pro.sky.java.course2.Exeptions.IndexesAreIncorrectException;
import pro.sky.java.course2.Exeptions.ListCannotBeEmptyException;
import pro.sky.java.course2.Exeptions.NotFoundElemnetException;
import pro.sky.java.course2.Interfaces.ICustomArrayList;

import java.util.Arrays;

public class ServiceArrayList implements ICustomArrayList {

    private int[] customArrayList;

    public ServiceArrayList(int len) {
        this.customArrayList = new int[len];
    }

    @Override
    public int add(int item) {
        if(item!=0) {
            if(customArrayList.length==0){
                changeDimension();
            }else if(customArrayList[customArrayList.length-1]!=0){
                changeDimension();
            }
            //int oldLen = customArrayList.length;
            //int newIndex = changeDimension();
            //if (newIndex > oldLen) {
                //customArrayList[newIndex - 1] = item;
            //} else {
                for (int i = 0; i < customArrayList.length; i++) {
                    if (customArrayList[i] == 0) {
                        customArrayList[i] = item;
                        break;
                    }
                }
           //}
        }else{
            throw new ArrayElementCannotBeNullException();
        }

        return item;
    }

    @Override
    public int add(int index, int item) {
        int[] lefArray = new int[0];
        int[] rightArray = new int[0];
        if(index>=0) {
            //if(item!=null && !item.isEmpty()) {

                if (index < customArrayList.length) {
                        if (index == 0) {
                            rightArray = Arrays.copyOf(copyArray(0, customArrayList.length), customArrayList.length);
                            customArrayList = new int[1];
                            customArrayList[0] = item;
                            for (int i = 0; i < rightArray.length; i++) {
                                if(customArrayList.length==0){
                                    changeDimension();
                                }else if(customArrayList[customArrayList.length-1]!=0){
                                    changeDimension();
                                }
                                if(i<rightArray.length-1) {
                                    customArrayList[i + 1] = rightArray[i];
                                }
                            }
                        } else {
                            lefArray = Arrays.copyOf(copyArray(0, index), index + 1);
                            rightArray = Arrays.copyOf(copyArray(index, customArrayList.length), customArrayList.length - index);
                            if(customArrayList.length==0){
                                changeDimension();
                            }else if(customArrayList[customArrayList.length-1]!=0){
                                changeDimension();
                            }
                            for (int i = 0; i < customArrayList.length; i++) {
                                if (i < index) {
                                    customArrayList[i] = lefArray[i];
                                } else if (i > index) {
                                    customArrayList[i] = rightArray[(i - (index + 1))];
                                } else {
                                    customArrayList[index] = item;
                                }
                            }
                        }
                } /*else {
                    if (index > customArrayList.length) {
                        throw new IndexesAreIncorrectException();
                    } else {

                        lefArray = Arrays.copyOf(copyArray(0, customArrayList.length), customArrayList.length);
                        customArrayList = Arrays.copyOf(lefArray, index + 1);
                        customArrayList[index] = item;
                    }
                }*/
            //}else {
            //    throw new ArrayElementCannotBeNullException();
            //}
        }else{
            throw new IndexesAreIncorrectException();
        }
        return item;
    }

    @Override
    public int set(int index, int item) {
        if(index>0 && index<customArrayList.length){
            //if(item!=null  && !item.isEmpty()){
                customArrayList[index] = item;
            //}else {
            //    throw new ArrayElementCannotBeNullException();
            //}
        }else{
            throw new IndexesAreIncorrectException();
        }
        return item;
    }

    @Override
    public int removeItem(int item) {
        int index = indexOf((int) item);
        if(index!=-1){
            int[] lefArray = new int[0];
            int[] rightArray = new int[0];
            if(index == 0){
                rightArray = Arrays.copyOf(copyArray(1, customArrayList.length), customArrayList.length-1);
                customArrayList = Arrays.copyOf(rightArray, rightArray.length);
                resize();
            }else if(index == customArrayList.length-1){
                lefArray = Arrays.copyOf(copyArray(0, customArrayList.length-1), customArrayList.length-1);
                customArrayList = Arrays.copyOf(lefArray, lefArray.length);
                resize();
            }else{
                lefArray = Arrays.copyOf(copyArray(0, index), index);
                rightArray = Arrays.copyOf(copyArray(index+1, customArrayList.length), customArrayList.length - (index+1));
                customArrayList = new int[(lefArray.length+rightArray.length)];
                int j =0;
                for (int i = 0; i < customArrayList.length; i++) {
                    if (i < index) {
                        customArrayList[i] = lefArray[i];
                    } else {
                        customArrayList[i] = rightArray[j];
                        j++;
                    }
                }
                resize();
            }
        }else{
            throw new NotFoundElemnetException();
        }
        return item;
    }

    @Override
    public int remove(int index) {
        int item = 0;
        if(index!=-1 && index<customArrayList.length){
            item = customArrayList[index];
            int[] lefArray = new int[0];
            int[] rightArray = new int[0];
            if(index == 0){
                rightArray = Arrays.copyOf(copyArray(1, customArrayList.length), customArrayList.length-1);
                customArrayList = Arrays.copyOf(rightArray, rightArray.length);
                resize();
            }else if(index == customArrayList.length-1){
                lefArray = Arrays.copyOf(copyArray(0, customArrayList.length-1), customArrayList.length-1);
                customArrayList = Arrays.copyOf(lefArray, lefArray.length);
                resize();
            }else{
                lefArray = Arrays.copyOf(copyArray(0, index), index);
                rightArray = Arrays.copyOf(copyArray(index+1, customArrayList.length), customArrayList.length - index);
                customArrayList = new int[(lefArray.length+rightArray.length)-1];
                int j = 0;
                for (int i = 0; i < customArrayList.length; i++) {
                    if (i < index) {
                        customArrayList[i] = lefArray[i];
                    } else {
                        customArrayList[i] = rightArray[j];
                        j++;
                    }
                }
                resize();
            }
        }else{
            throw new IndexesAreIncorrectException();
        }
        return item;
    }


    private boolean containsLinear(int item) {
        boolean flag = false;
        for (int i=0;i<customArrayList.length;i++){
            if(customArrayList[i] == item )
                flag = true;
        }
        return flag;
    }

    private boolean containsBinary(int item) {
        sort("sortInsertion");
        int min = 0;
        int max = customArrayList.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (item == customArrayList[mid]) {
                return true;
            }

            if (item < customArrayList[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return false;
    }

    @Override
    public boolean contains(String method,int item){
        boolean flag = false;
        switch (method){
            case "containsLinear":
                flag = containsLinear(item);
                break;
            case "containsBinary":
                flag = containsBinary(item);
                break;
        }
        return flag;
    }

    @Override
    public int indexOf(int item) {
        int index = -1;
        for (int i=0;i< customArrayList.length;i++){
            if(customArrayList[i] == item){
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(int item) {
        int index = -1;
        for (int i=customArrayList.length-1;i>=0;i--){
            if(customArrayList[i]==item){
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int get(int index) {
        int item = 0;
        if(index>-1 && index<customArrayList.length){
            item = customArrayList[index];
        }else{
            throw new IndexesAreIncorrectException();
        }
        return item;
    }

    @Override
    public boolean equals(int[] otherList) {
        boolean flag = true;
        if(otherList!=null) {
            if (customArrayList.length == otherList.length) {
                for (int i = 0; i < customArrayList.length; i++) {
                    if (customArrayList[i]!=otherList[i])
                        flag = false;
                }
            } else {
                flag = false;
            }
        }else{
            throw new ListCannotBeEmptyException();
        }
        return flag;
    }

    @Override
    public int size() {
        int i = 0;
        while (customArrayList.length>i && customArrayList[i]!=0)
            i++;
        return i;
    }

    @Override
    public boolean isEmpty() {
        return size()==0?true:false;
    }

    @Override
    public void clear() {
        customArrayList = new int[0];
    }

    public int[] toArray() {
        int[] newArray = new int[customArrayList.length];
        for (int i = 0;i<customArrayList.length;i++){
            newArray[i] = customArrayList[i];
        }
        return newArray;
    }


    private void sortBubble(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swapElements(arr, j, j + 1);
                }
            }
        }
    }

    private void sortSelection(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minElementIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minElementIndex]) {
                    minElementIndex = j;
                }
            }
            swapElements(arr, i, minElementIndex);
        }
    }

    private void sortInsertion(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j - 1] >= temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }
    }

    @Override
    public void sort(String method){
        switch (method){
            case "sortBubble":
                sortBubble(customArrayList);
                break;
            case "sortSelection":
                sortSelection(customArrayList);
                break;
            case "quickSort":
                quickSort(customArrayList,0,size()-1);
            default:
                sortInsertion(customArrayList);
        }
    }

    private void swapElements(int[] arr, int j, int i) {
        arr[j] = arr[j]+arr[i];
        arr[i] = arr[j]-arr[i];
        arr[j] = arr[j]-arr[i];
    }

    private int changeDimension(){
        if(customArrayList.length == size() && size()!=0){
            int[] tempArray = copyArray(0,customArrayList.length);
            customArrayList = new int[0];
            customArrayList = Arrays.copyOf(tempArray,tempArray.length+grow(tempArray));
        }else{
            customArrayList = new int[1];
        }
        return customArrayList.length;
    }

    private int grow(int[] arr){
        double cnt = arr.length*1.5;
        Math.ceil(cnt);
        return (int) cnt;
    }
    private void resize(){
        if(customArrayList.length/size()>=2){
            int[] rightArray = Arrays.copyOf(copyArray(0, size()), size());
            customArrayList = Arrays.copyOf(rightArray, (int) (customArrayList.length - (Math.ceil(customArrayList.length*.3))));
        }
    }
    private int[] copyArray(int firstIndex,int lastIndex){
        int[] newArray = new int[lastIndex - firstIndex];
        int newIndex = 0;
        if (firstIndex<lastIndex) {
            for (int i = firstIndex;i<lastIndex;i++){
                newArray[newIndex] = customArrayList[i];
                newIndex++;
            }
        }else{
            throw new IndexesAreIncorrectException();
        }
        return newArray;
    }

    public void printCustomList(){

        System.out.println(Arrays.toString(customArrayList));
    }

    public void generateRandomArray() {
        java.util.Random random = new java.util.Random();
        clear();
        int[] arr = new int[1300];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(100_000) + 100_000;
        }
        customArrayList = Arrays.copyOf(arr,arr.length);
    }

    public void quickSort(int[] arr,int begin,int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, 0, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, size());
        }
    }

    private int partition(int[] arr, int begin, int end) {
        int pivot = arr[end];
        int i = (begin - 1);

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                swapElements(arr, i, j);
            }
        }

        swapElements(arr, i + 1, end);
        return i + 1;
    }
}
