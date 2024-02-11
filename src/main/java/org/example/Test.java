package org.example;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<String>();
        names.add("Rohit");
        names.add("Rahul");
        names.add("Sandeep");
        names.add("Suraj");
        names.add("Sushil");
        names.add("Ronnie");
        names.add("Robin");
        long pNames = names.stream().filter(s->s.startsWith("S")).count();
        //System.out.println(pNames);
       // names.stream().filter(s->s.length()>5).forEach(s-> System.out.println(s));
        List<String> li = Stream.of("Inky","Pinky","Ponky","Chonky","Monky").filter(s->s.startsWith("P")).collect(Collectors.toList());
        System.out.println(li.get(1));
        //distinct()-> to find the unique
        //map()-> to do functions and operations
        //count()-> it is terminal operation of stream()
        //.concat()-> it can concat 2 list or arraylists etc by first converting them to stream() of its type..
        //..then concat() method and then finally taking them in new list or arraylist by using collect() terminal operation.


    }
}
