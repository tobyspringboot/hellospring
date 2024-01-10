package tobyspring.hellospring;

import java.util.List;

public class Sort {
    public List<String> sortByLength(List<String> list) {
        list.sort((o1, o2) -> o1.length() - o2.length());
        return list;
    }
}
