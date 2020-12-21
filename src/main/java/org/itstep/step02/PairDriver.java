package org.itstep.step02;

import org.itstep.step01.ObjectPair;

public class PairDriver {
    public static void main(String[] args) {

        Pair<?, ?>[] stadiums = new Pair[3];
        stadiums[0] = new Pair<>("Bridgeforth Stadium", 25000);
        stadiums[1] = new Pair<>("Michigan Stadium", 109901);
        stadiums[2] = new Pair<>("Lane Stadium", "66233");

        System.out.println(stadiums[0]);
        System.out.println(stadiums[1]);
        System.out.println(stadiums[2]);

        System.out.println(largestStadium(stadiums));
    }

    /**
     * Возвращает название стадиона с наибольшей вместимостью.
     *
     * @param stadiums Массив ObjectPairs, где каждая пара содержит название стадиона, за которым следует целое число
     * @return Название стадиона с наибольшей вместимостью
     */
    public static String largestStadium(Pair<?, ?>[] stadiums) {
        int largestNumber = 0;
        String largestName = "";
        for (Pair<?, ?> stadium : stadiums){
            if (Integer.parseInt(stadium.getSecond().toString()) > largestNumber){
                largestNumber = Integer.parseInt(stadium.getSecond().toString());
                largestName = stadium.getFirst().toString();
            }
        }
        return largestName;
    }
}