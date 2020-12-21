package org.itstep.step02;

public class Pair<T, L> {
    private final T first;
    private final L second;

    /**
     * Создаем объект ObjectTuple на базе двух объектов.
     *
     * @param first первый объект
     * @param second второй объект
     */
    public Pair(T first, L second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public L getSecond() {
        return second;
    }

    @Override
    public String toString() {
        return "<" + first.toString() + ", " + second.toString() + ">";
    }
}