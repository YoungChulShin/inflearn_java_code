package study.java.reflectiondemo;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class App {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        // 클래스로 인스턴스 생성
        Class<?> bookClass = Class.forName("study.java.reflectiondemo.Book");

        Constructor<?> constructor = bookClass.getConstructor();
        Book book = (Book)constructor.newInstance();
        System.out.println(book);

        // 리플렉션을 이용한 private 값 변경
        Field fieldB = Book.class.getDeclaredField("B");
        fieldB.setAccessible(true);
        System.out.println(fieldB.get(book));
        fieldB.set(book, "BBBBBBBB");
        System.out.println(fieldB.get(book));

        // 리플렉션을 이용한 method 실행
        Method methodC = Book.class.getDeclaredMethod("c");
        methodC.invoke(book);
    }
}
