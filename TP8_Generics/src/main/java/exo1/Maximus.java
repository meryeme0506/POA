package exo1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Maximus {

    public int myMax(int... args) {
        if(args.length==0)
            throw new IllegalArgumentException("One argument is required");
        int m=0;
        for( int i : args){
            if(i>m)
                m=i;
        }
        return m;
    }

    public <T extends Comparable<T>> T myMax(T... args)  {
        if(args.length==0)
            throw new IllegalArgumentException("One argument is required");
        T max= args[0];
        for( T i : args){
            if(i.compareTo(max)>0)
                max=i;
        }
        return max;
    }

    public  static void print(List<? > list){
        list.forEach(e -> System.out.println(e));
    }

    public static void printLength(List<? extends CharSequence> list){
        list.forEach(e -> System.out.println(e + " "+ e.length()));
    }

    public static <T> List<T> listLength(List l) {
        ArrayList length = new ArrayList<>();
        for (int i = 0; i < l.size(); i++) {
            CharSequence seq = (CharSequence) l.get(i);
            length.add(seq.length());
        }
        return length;
    }

    public static <T> List<T> fusion(List<? extends  T> list1, List<? extends T> list2) throws Exception {
        if(list1.isEmpty() || list2.isEmpty())
            throw new Exception("The lists are empty !! ");
        if(list1.size()!=list2.size())
            throw new Exception("The lists must have the same size");

        List<T> list= new ArrayList<>();
        for(int i=0; i<list1.size();i++)
            if(i%2==0)
                list.add(list1.get(i));
            else
                list.add(list2.get(i));
        return list;
    }

    public static <T> void echange(List<T> list, int i, int j) {
        T a = list.get(i);
        list.set(i, list.get(j));
        list.set(j, a);
    }

    public static <T> void echange(List<T> l) {
        /**int size = list.size();
        Random random = new Random();
        random.nextInt();
        T tmp = null;
        for (int i = size-1; i < size; i++) {
            int change = i + random.nextInt(size - i);
            tmp = list.get(i);
            list.set(i,list.get(change));
            list.set(change,tmp);
        }*/
        T[] array=(T[]) l.toArray();
        T[] e = array;
        Random random = new Random();
        for (int i =(l.size() -1); i > 0; i--) {
            int j = random.nextInt();
            swap(e,i,j);
            l=Arrays.asList(e);
        }
    }
    private static <T> void swap(T[] l,int i,int j){
        T temp = l[i];
        l[i]=l[j];
        l[j]=temp;
    }

    public static void main(String[] args) throws Exception {
        List<String> list = Arrays.asList("foo","toto","sara");
        List<Integer> list2 = Arrays.asList(1,2,3);
        print(list);
        printLength(list);
        listLength(list).forEach(e -> System.out.println(e));
        List<?> list3 = Maximus.fusion(list,list2);
        print(list3);
        Maximus.echange(list);
        print(list);


    }
}
