package pro.sky.java.course2;

import pro.sky.java.course2.Services.ServiceArrayList;

import java.util.Arrays;

public class Main {
    static ServiceArrayList myArrayList = new ServiceArrayList(0);
    public static void main(String[] args) {


        System.out.println(myArrayList.add(10));
        myArrayList.printCustomList();
        System.out.println(myArrayList.add(15));
        myArrayList.printCustomList();
        System.out.println(myArrayList.add(-190));
        myArrayList.printCustomList();
        System.out.println(myArrayList.add(98));
        myArrayList.printCustomList();
        System.out.println(myArrayList.add(240));
        myArrayList.printCustomList();
        System.out.println(myArrayList.add(-123));
        myArrayList.printCustomList();

        System.out.println(myArrayList.add(0,12));
        myArrayList.printCustomList();
        System.out.println(myArrayList.add(7,7));
        myArrayList.printCustomList();
        System.out.println(myArrayList.add(8,54));
        myArrayList.printCustomList();
        System.out.println(myArrayList.add(4,43));
        myArrayList.printCustomList();

        System.out.println(myArrayList.set(1,90));
        myArrayList.printCustomList();

        System.out.println(myArrayList.indexOf(89));
        System.out.println(myArrayList.lastIndexOf(43));

        System.out.println(myArrayList.removeItem(12));
        myArrayList.printCustomList();
        System.out.println(myArrayList.removeItem(7));
        myArrayList.printCustomList();
        System.out.println(myArrayList.removeItem(54));
        myArrayList.printCustomList();

        System.out.println(myArrayList.remove(0));
        myArrayList.printCustomList();
        System.out.println(myArrayList.remove(5));
        myArrayList.printCustomList();
        System.out.println(myArrayList.remove(myArrayList.size()-1));
        myArrayList.printCustomList();

        System.out.println(myArrayList.contains("containsLinear",10));

        System.out.println(myArrayList.contains("containsLinear",43));

        System.out.println(myArrayList.get(2));

        int[] list1 = new int[]  {1, 2, 3};
        System.out.println(myArrayList.equals(list1));
        int[] list2 = new int[]  {15, -190, 43,98};
        System.out.println(myArrayList.equals(list2));
        int[] list3 = new int[]  {15, -190, 43,98,15};
        System.out.println(myArrayList.equals(list3));


        System.out.println(myArrayList.isEmpty());

        System.out.println(Arrays.toString(myArrayList.toArray()));

        myArrayList.clear();
        System.out.println(myArrayList.isEmpty());

        System.out.println(myArrayList.size());

        long start = 0;
        myArrayList.generateRandomArray();
        System.out.println(Arrays.toString(myArrayList.toArray()));
        start = System.currentTimeMillis();
        myArrayList.sort("sortBubble");
        System.out.println(Arrays.toString(myArrayList.toArray()));
        System.out.println(System.currentTimeMillis() - start);

        myArrayList.generateRandomArray();
        System.out.println(Arrays.toString(myArrayList.toArray()));
        start = System.currentTimeMillis();
        myArrayList.sort("sortSelection");
        System.out.println(Arrays.toString(myArrayList.toArray()));
        System.out.println(System.currentTimeMillis() - start);

        myArrayList.generateRandomArray();
        System.out.println(Arrays.toString(myArrayList.toArray()));
        start = System.currentTimeMillis();
        myArrayList.sort("sortInsertion");
        System.out.println(Arrays.toString(myArrayList.toArray()));
        System.out.println(System.currentTimeMillis() - start);

        myArrayList.generateRandomArray();
        System.out.println(myArrayList.contains("containsBinary",125233));

        myArrayList.generateRandomArray();
        myArrayList.set(1,555);
        System.out.println(myArrayList.contains("containsBinary",555));



    }
}
