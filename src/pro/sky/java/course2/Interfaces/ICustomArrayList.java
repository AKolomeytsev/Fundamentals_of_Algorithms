package pro.sky.java.course2.Interfaces;

public interface ICustomArrayList {

        int add(int item);
        int add(int index, int item);
        int set(int index, int item);
        int removeItem(int item);
        int remove(int index);
        boolean contains(String method,int item);
        int indexOf(int item);
        int lastIndexOf(int item);
        int get(int index);
        boolean equals(int[] otherList);
        int size();
        boolean isEmpty();
        void clear();
        int[] toArray();

        void sort(String method);

}
