package ir.uni.service;

import java.util.Set;

public interface Action<A> {

    void create(A a);

    void delete(A a);

    void update(A a);

    Set<A> read();

}
