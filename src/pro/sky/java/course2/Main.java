package pro.sky.java.course2;

import pro.sky.java.course2.Services.ServiceArrayList;

import java.util.Arrays;

public class Main {
    static ServiceArrayList myArrayList = new ServiceArrayList(1);
    public static void main(String[] args) {


        System.out.println(myArrayList.add("qw"));
        myArrayList.printCustomList();
        System.out.println(myArrayList.add("er"));
        myArrayList.printCustomList();
        System.out.println(myArrayList.add("ty"));
        myArrayList.printCustomList();
        System.out.println(myArrayList.add("qw1"));
        myArrayList.printCustomList();
        System.out.println(myArrayList.add("er2"));
        myArrayList.printCustomList();
        System.out.println(myArrayList.add("ty3"));
        myArrayList.printCustomList();

        System.out.println(myArrayList.add(0,"ty3"));
        myArrayList.printCustomList();
        System.out.println(myArrayList.add(7,"qw1"));
        myArrayList.printCustomList();
        System.out.println(myArrayList.add(8,"ty8"));
        myArrayList.printCustomList();
        System.out.println(myArrayList.add(4,"ty"));
        myArrayList.printCustomList();

        System.out.println(myArrayList.set(1,"90"));
        myArrayList.printCustomList();

        System.out.println(myArrayList.indexOf("90"));
        System.out.println(myArrayList.lastIndexOf("ty"));

        System.out.println(myArrayList.remove("ty8"));
        myArrayList.printCustomList();
        System.out.println(myArrayList.remove("ty3"));
        myArrayList.printCustomList();
        System.out.println(myArrayList.remove("ty"));
        myArrayList.printCustomList();

        System.out.println(myArrayList.remove(0));
        myArrayList.printCustomList();
        System.out.println(myArrayList.remove(5));
        myArrayList.printCustomList();
        System.out.println(myArrayList.remove(myArrayList.size()-1));
        myArrayList.printCustomList();

        System.out.println(myArrayList.contains("qw1"));

        System.out.println(myArrayList.contains("qw145"));

        System.out.println(myArrayList.get(2));

        String[] list1 = new String[]  {"er", "ty", "qw1"};
        System.out.println(myArrayList.equals(list1));
        String[] list2 = new String[]  {"er", "ty", "qw1", "er2"};
        System.out.println(myArrayList.equals(list2));
        String[] list3 = new String[]  {"er", "ty", "qw1", "er2", "er2"};
        System.out.println(myArrayList.equals(list3));

        System.out.println(myArrayList.isEmpty());

        System.out.println(Arrays.toString(myArrayList.toArray()));

        myArrayList.clear();
        System.out.println(myArrayList.isEmpty());

        System.out.println(myArrayList.size());



    }
}
