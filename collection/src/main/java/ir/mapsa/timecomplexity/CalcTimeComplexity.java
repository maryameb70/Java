package ir.mapsa.timecomplexity;

import java.util.Collection;

public class CalcTimeComplexity {
    private long beforeTime;
    private long afterTime;
    private static final Integer element = 5100000;
    private Collection<Integer> collection;

    public CalcTimeComplexity(Collection<Integer> collection) {
        this.collection = collection;
    }
    public CalcTimeComplexity() {
    }
    public Collection<Integer> getCollection() {
        return collection;
    }

    public void setCollection(Collection<Integer> collection) {
        this.collection = collection;
    }

    public void create() {
        Records records=new Records();
        records.create(collection);
    }

    public long compareAddTime(Collection<Integer> collection) {
        beforeTime = System.currentTimeMillis();
        collection.add(element);
        afterTime = System.currentTimeMillis();
        return afterTime - beforeTime;
    }

    public long compareRemoveTime(Collection<Integer> collection) {
        beforeTime = System.currentTimeMillis();
        collection.remove(element);
        afterTime = System.currentTimeMillis();
        return afterTime - beforeTime;
    }

    public long compareContainsTime(Collection<Integer> collection) {
        beforeTime = System.currentTimeMillis();
        collection.contains(element);
        afterTime = System.currentTimeMillis();
        return afterTime - beforeTime;
    }
}
