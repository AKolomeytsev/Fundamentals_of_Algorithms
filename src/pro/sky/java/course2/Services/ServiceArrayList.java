package pro.sky.java.course2.Services;

import pro.sky.java.course2.Exeptions.ArrayElementCannotBeNullException;
import pro.sky.java.course2.Exeptions.IndexesAreIncorrectException;
import pro.sky.java.course2.Exeptions.ListCannotBeEmptyException;
import pro.sky.java.course2.Exeptions.NotFoundElemnetException;
import pro.sky.java.course2.Interfaces.ICustomArrayList;

import java.util.Arrays;

public class ServiceArrayList implements ICustomArrayList {

    static String[] customArrayList;

    public ServiceArrayList(int len) {
        this.customArrayList = new String[len];
    }

    @Override
    public String add(String item) {
        if(item!=null && !item.isEmpty()) {
            int oldLen = customArrayList.length;
            int newIndex = changeDimension();
            if (newIndex > oldLen) {
                customArrayList[newIndex - 1] = item;
            } else {
                for (int i = 0; i < customArrayList.length; i++) {
                    if (customArrayList[i] == null) {
                        customArrayList[i] = item;
                        break;
                    }
                }
            }
        }else{
            throw new ArrayElementCannotBeNullException();
        }

        return item;
    }

    @Override
    public String add(int index, String item) {
        String[] lefArray = new String[0];
        String[] rightArray = new String[0];
        if(index>=0) {
            if(item!=null && !item.isEmpty()) {
                if (index < customArrayList.length) {
                    if (customArrayList[index] == null) {
                        customArrayList[index] = item;
                    } else {
                        if (index == 0) {
                            rightArray = Arrays.copyOf(copyArray(0, customArrayList.length), customArrayList.length);
                            customArrayList = new String[1];
                            customArrayList[0] = item;
                            for (int i = 0; i < rightArray.length; i++) {
                                changeDimension();
                                customArrayList[i + 1] = rightArray[i];
                            }
                        } else {
                            lefArray = Arrays.copyOf(copyArray(0, index), index + 1);
                            rightArray = Arrays.copyOf(copyArray(index, customArrayList.length), customArrayList.length - index);
                            changeDimension();
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
                    }
                } else {
                    if (index > customArrayList.length) {
                        throw new IndexesAreIncorrectException();
                    } else {

                        lefArray = Arrays.copyOf(copyArray(0, customArrayList.length), customArrayList.length);
                        customArrayList = Arrays.copyOf(lefArray, index + 1);
                        customArrayList[index] = item;
                    }
                }
            }else {
                throw new ArrayElementCannotBeNullException();
            }
        }else{
            throw new IndexesAreIncorrectException();
        }
        return item;
    }

    @Override
    public String set(int index, String item) {
        if(index>0 && index<customArrayList.length){
            if(item!=null  && !item.isEmpty()){
                customArrayList[index] = item;
            }else {
                throw new ArrayElementCannotBeNullException();
            }
        }else{
            throw new IndexesAreIncorrectException();
        }
        return item;
    }

    @Override
    public String remove(String item) {
        int index = indexOf(item);
        if(index!=-1){
            String[] lefArray = new String[0];
            String[] rightArray = new String[0];
            if(index == 0){
                rightArray = Arrays.copyOf(copyArray(1, customArrayList.length), customArrayList.length-1);
                customArrayList = Arrays.copyOf(rightArray, rightArray.length);
            }else if(index == customArrayList.length-1){
                lefArray = Arrays.copyOf(copyArray(0, customArrayList.length-1), customArrayList.length-1);
                customArrayList = Arrays.copyOf(lefArray, lefArray.length);
            }else{
                lefArray = Arrays.copyOf(copyArray(0, index), index);
                rightArray = Arrays.copyOf(copyArray(index+1, customArrayList.length), customArrayList.length - index);
                customArrayList = new String[(lefArray.length+rightArray.length)-1];
                for (int i = 0; i < customArrayList.length; i++) {
                    if (i < index) {
                        customArrayList[i] = lefArray[i];
                    } else {
                        customArrayList[i] = rightArray[i-2];
                    }
                }
            }
        }else{
            throw new NotFoundElemnetException();
        }
        return item;
    }

    @Override
    public String remove(int index) {
        String item = "";
        if(index!=-1 && index<customArrayList.length){
            item = customArrayList[index];
            String[] lefArray = new String[0];
            String[] rightArray = new String[0];
            if(index == 0){
                rightArray = Arrays.copyOf(copyArray(1, customArrayList.length), customArrayList.length-1);
                customArrayList = Arrays.copyOf(rightArray, rightArray.length);
            }else if(index == customArrayList.length-1){
                lefArray = Arrays.copyOf(copyArray(0, customArrayList.length-1), customArrayList.length-1);
                customArrayList = Arrays.copyOf(lefArray, lefArray.length);
            }else{
                lefArray = Arrays.copyOf(copyArray(0, index), index);
                rightArray = Arrays.copyOf(copyArray(index+1, customArrayList.length), customArrayList.length - index);
                customArrayList = new String[(lefArray.length+rightArray.length)-1];
                for (int i = 0; i < customArrayList.length; i++) {
                    if (i < index) {
                        customArrayList[i] = lefArray[i];
                    } else {
                        customArrayList[i] = rightArray[i-2];
                    }
                }
            }
        }else{
            throw new IndexesAreIncorrectException();
        }
        return item;
    }

    @Override
    public boolean contains(String item) {
        boolean flag = false;
        for (int i=0;i<customArrayList.length;i++){
            if(customArrayList[i].equals(item))
                flag = true;
        }
        return flag;
    }

    @Override
    public int indexOf(String item) {
        int index = -1;
        for (int i=0;i< customArrayList.length;i++){
            if(customArrayList[i].equals(item)){
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public int lastIndexOf(String item) {
        int index = -1;
        for (int i=customArrayList.length-1;i>=0;i--){
            if(customArrayList[i].equals(item)){
                index = i;
                break;
            }
        }
        return index;
    }

    @Override
    public String get(int index) {
        String item = "";
        if(index>-1 && index<customArrayList.length){
            item = customArrayList[index];
        }else{
            throw new IndexesAreIncorrectException();
        }
        return item;
    }

    @Override
    public boolean equals(String[] otherList) {
        boolean flag = true;
        if(otherList!=null) {
            if (customArrayList.length == otherList.length) {
                for (int i = 0; i < customArrayList.length; i++) {
                    if (customArrayList[i].equals(otherList[i]) == false)
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
        int cnt = 0;
        for (int i=0;i<customArrayList.length;i++){
            if(customArrayList[i]!=null)
                cnt++;
        }
        return cnt;
    }

    @Override
    public boolean isEmpty() {
        return size()==0?true:false;
    }

    @Override
    public void clear() {
        customArrayList = new String[0];
    }

    public String[] toArray() {
        String[] newArray = new String[customArrayList.length];
        for (int i = 0;i<customArrayList.length;i++){
            newArray[i] = customArrayList[i];
        }
        return newArray;
    }

    private int changeDimension(){
        if(customArrayList.length == size()){
            String [] tempArray = copyArray(0,customArrayList.length);
            customArrayList = new String[0];
            customArrayList = Arrays.copyOf(tempArray,tempArray.length+1);
        }
        return customArrayList.length;
    }

    private String[] copyArray(int firstIndex,int lastIndex){
        String[] newArray = new String[lastIndex - firstIndex];
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
}
