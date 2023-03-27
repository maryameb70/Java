package ir.mapsa.timecomplexity;

import java.util.Collection;

public class Records {

    public void create(Collection<Integer> list) {
        for (int i = 0; i < 5000000; i++) {
            list.add(i);
        }
    }
}
