package org.example.genericrepository;

import org.example.base.BaseClass;

public interface GeneralRepository<T> {
    void add(BaseClass<T> element);
     void printAll();

     T getById(T id);

     void removeByElement(T element);

    int findFirstById(T id);

    boolean contain(T id);


}
