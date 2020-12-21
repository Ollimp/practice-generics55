package org.itstep.step03;

import org.itstep.step02.Pair;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

/**
 * Итерируемая коллекция объектов Pair.
 *
 * @author Michael S. Kirkpatrick and Nathan Sprague
 * @version V1, 8/2017
 */
public class Pairs<K, V> implements Iterable<Pair<K, V>> {

    /* TODO: Объявить массив фиксированного размера (максимум 10 элементов) объектов Pair */

    /**
     * Создайте коллекцию, в которой будут храниться элементы, добавленные парами.
     */
    private int size;
    private int position;
    private boolean nextExecuted;

    Pair<K, V>[] pairs;
    public Pairs() {
        pairs = new Pair[10];
        size = 0;
        position = 0;
    }

    /**
     * TODO: Создайте новую пару и добавьте ее в коллекцию, если есть место.
     *
     * @param first  Первый объект
     * @param second Второй объект
     * @return true - если пара была добавлена, false - в противном случае
     */
    public boolean addPair(K first, V second) {
        if (size < 10){
            pairs[size] = new Pair<>(first, second);
            size++;
            return true;
        } else return false;
    }


    @Override
    public Iterator<Pair<K, V>> iterator() {
        return new PairIterator();
    }

    /*
     * TODO: Реализуйте итератор здесь на основе документации API по адресу
     * https://docs.oracle.com/javase/10/docs/api/java/util/Iterator.html Throw the exceptions as
     * specified
     */
    private class PairIterator implements Iterator<Pair<K, V>> {

        /**
         * TODO: Проверить наличие следующего элемента в итераторе
         */
        @Override
        public boolean hasNext() {
            return position < size;
        }

        /**
         * TODO: Вернуть следующую пару в итератор.
         * @throws NoSuchElementException - если больше нет элементов для итерации
         */
        @Override
        public Pair<K, V> next() {
            if (!this.hasNext()){
                throw new NoSuchElementException();
            } else {
                Pair<K, V> element = pairs[position];
                position++;
                nextExecuted = true;
                return element;
            }
        }

        /**
         * TODO: Удалите предыдущую пару, возвращенную функцией next()
         */
        @Override
        public void remove() {
            if(!nextExecuted){
                throw new IllegalStateException();
            } else {
                size--;
                if (size - position > 0)
                    System.arraycopy(pairs, position + 1, pairs, position, size - position);
                position--;
                nextExecuted = false;
            }
        }

        @Override
        public void forEachRemaining(Consumer<? super Pair<K, V>> action) {
            int prevPosition = position;
            position = 0;
            while (hasNext())
                action.accept(next());
            // position = prevPosition;
        }
    }
}
