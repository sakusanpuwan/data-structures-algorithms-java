package striversA2Z;

import java.util.List;

public class LinkedList {
    public static Integer findMiddleElement(List<Integer> list) {
        int mid = list.size() / 2;
        return list.get(mid);
    }
}
