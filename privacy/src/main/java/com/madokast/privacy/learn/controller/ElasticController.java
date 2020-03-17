package com.madokast.privacy.learn.controller;

import com.madokast.privacy.learn.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description
 * ElasticController
 * <p>
 * Data
 * 11:24
 *
 * @author zrx
 * @version 1.0
 */

//@RestController
//@RequestMapping("/elastic")
public class ElasticController {

    // 需要存储的数据
//    @Document(indexName = "atguigu", type = "book")//索引(数据库)名，类型(表)名
    public static class Book {
        private Integer id;
        private String name;
        private String author;

        public Book() {
        }

        public Book(Integer id, String name, String author) {
            this.id = id;
            this.name = name;
            this.author = author;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }

//    // 注入
//    private final BookRepository bookRepository;
//
//    public ElasticController(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }
//
//    @GetMapping("/index")
//    public void index() {
//        LOGGER.info("get mapping /index");
//        Book book = new Book(1, "三国演绎", "罗贯中");
//        Book book1 = new Book(2, "四国演绎", "宋贯中");
//        bookRepository.save(book);
//        bookRepository.save(book1);
//    }


    private final Logger LOGGER = LoggerFactory.getLogger(ElasticController.class);

}
