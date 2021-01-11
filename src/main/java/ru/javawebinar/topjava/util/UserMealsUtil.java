package ru.javawebinar.topjava.util;

import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class UserMealsUtil {
    public static void main(String[] args) {
        List<UserMeal> meals = Arrays.asList(
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
        );

//        List<UserMealWithExcess> mealsTo = filteredByCycles(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000);
//        mealsTo.forEach(System.out::println);

        System.out.println(filteredByStreams(meals, LocalTime.of(7, 0), LocalTime.of(12, 0), 2000));
    }

    public static List<UserMealWithExcess> filteredByCycles(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO return filtered list with excess. Implement by cycles
        Map<LocalDate, Integer> map = new TreeMap<>();
        for (UserMeal item : meals) {
            if (map.get(item.getDate()) == null) {
                map.put(item.getDate(), item.getCalories());
            } else {
                int count = map.get(item.getDate());
                map.put(item.getDate(), (count + item.getCalories()));
            }
        }
        List<UserMealWithExcess> mealWithExcesses = new ArrayList<>();
        for(UserMeal item : meals) {
            if (item.getTime().isAfter(startTime) &&
                                    item.getTime().isBefore(endTime)) {
                if (map.get(item.getDateTime().toLocalDate()) <= caloriesPerDay) {
                    mealWithExcesses.add(new UserMealWithExcess(item.getDateTime(), item.getDescription(),
                            item.getCalories(), false));
                } else
                    mealWithExcesses.add(new UserMealWithExcess(item.getDateTime(), item.getDescription(),
                            item.getCalories(), true));
            }
        };
        return mealWithExcesses;
    }

    public static List<UserMealWithExcess> filteredByStreams(List<UserMeal> meals, LocalTime startTime, LocalTime endTime, int caloriesPerDay) {
        // TODO Implement by streams
//        Map<LocalDate, Integer> mapStream = meals.stream().collect(Collectors.toMap(s -> s.getDate(), n -> n.getCalories()));
//
//        for (Map.Entry<LocalDate, Integer> m : mapStream.entrySet()) System.out.println(m);

        Map<LocalDate, Integer> map = new TreeMap<>();
        for (UserMeal item : meals) {
            if (map.get(item.getDate()) == null) {
                map.put(item.getDate(), item.getCalories());
            } else {
                int count = map.get(item.getDate());
                map.put(item.getDate(), (count + item.getCalories()));
            }
        }

        return null;
    }
}
