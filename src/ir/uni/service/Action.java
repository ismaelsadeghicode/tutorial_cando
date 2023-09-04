package ir.uni.service;

import java.util.Set;

public interface Action<U> {

    void create(U u);

    void delete(U u);

    void update(U u);

    Set<U> read();

}
