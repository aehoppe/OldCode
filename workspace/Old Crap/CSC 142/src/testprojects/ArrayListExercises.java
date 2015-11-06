package testprojects;

import java.util.ArrayList;

public class ArrayListExercises {

    public static void swapPairs(ArrayList<String> a){
        for(int i = 1; i < a.size(); i += 2){
            String s1 = a.get(i);
            String s2 = a.get(i-1);
            a.set(i, s2);
            a.set(i-1, s1);
        }
    }
    
    public static void main(String[] args){
        ArrayList<String> s = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            s.add("dick");
            s.add("butt");
        }
        System.out.println(s);
        swapPairs(s);
        System.out.println(s);
    }
}
