package study.java.reflectiondemo;

import java.lang.reflect.Field;
import java.util.Arrays;

public class App {

    public static void main(String[] args) {
        Class<Book> bookClass = Book.class;

        // public 한 것만 가져온다
        System.out.println("======public======");
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);

        // 모두 다
        System.out.println("======모두다======");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);

        // 값을 함께 가져오는 법
        System.out.println("======모두다 값 포함======");
        Book book = new Book();
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true);
                System.out.printf("%s %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        // 메서드 가져오기
        System.out.println("======메서드======");
        Arrays.stream(Book.class.getMethods()).forEach(System.out::println);

        System.out.println("======모든 메서드======");
        Arrays.stream(Book.class.getDeclaredMethods()).forEach(System.out::println);
    }
}
