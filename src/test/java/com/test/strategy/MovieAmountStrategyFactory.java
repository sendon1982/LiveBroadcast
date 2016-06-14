package com.test.strategy;

import com.test.Movie;
import com.test.Rental;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by mjiang on 10/06/16.
 */
public class MovieAmountStrategyFactory {

    private static Map<Integer, MovieAmountStrategy> strategyMap;

    static {
        strategyMap = new LinkedHashMap<>();
        strategyMap.put(Movie.REGULAR, new RegularMoiveAmountStrategy());
        strategyMap.put(Movie.NEW_RELEASE, new NewReleaseMoiveAmountStrategy());
        strategyMap.put(Movie.CHILDREN, new ChildrenMoiveAmountStrategy());
    }

    public static MovieAmountStrategy create(Rental rental) {
        return strategyMap.get(rental.getMovie().getPriceCode());
    }


}
