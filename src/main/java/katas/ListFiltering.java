package katas;

import java.util.ArrayList;
import java.util.List;

// In this kata you will create a function that takes a list of non-negative integers and strings
// and returns a new list with the strings filtered out.
public class ListFiltering {

    public static List<Object> filterList(final List<Object> list) {
        List<Object> newList = new ArrayList<>();
        for (Object item:list) {
            if (item instanceof Integer){
                newList.add(item);
            }
        }
        return newList;
    }


}