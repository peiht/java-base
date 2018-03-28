package learning.java8;

import java.util.function.Supplier;

public interface DefaultFactory {

    static Person create(Supplier< Person > supplier) {
        return supplier.get();
        
    }
}
