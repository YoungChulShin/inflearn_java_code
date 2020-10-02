package study.java.reflectiondemo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import static org.junit.Assert.*;

@SpringBootTest
public class BookServiceTest {

    @Autowired BookService bookService;

    @Test
    public void di() {
        Assert.notNull(bookService, "book service");
        Assert.notNull(bookService.bookRepository, "book repository");
    }
}