package study.java.reflectiondemo;

import java.lang.reflect.Field;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Arrays.stream(Book.class.getAnnotations()).forEach(System.out::println);
    }
}
