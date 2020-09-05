package ie.williamswalsh.functional_design.lazy_eval;

public interface MyList<T> {
    T head();
    MyList<T> tail();

    default boolean isEmpty() {
        return true;
    }
}
