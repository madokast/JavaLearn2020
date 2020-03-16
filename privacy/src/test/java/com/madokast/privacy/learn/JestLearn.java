package com.madokast.privacy.learn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description
 * JestLearn
 * <p>
 * Data
 * 9:42
 *
 * @author zrx
 * @version 1.0
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class JestLearn {
    private final Logger LOGGER = LoggerFactory.getLogger(JestLearn.class);

//    @Autowired
//    private JestClient jestClient;
//
////    @Test
//    public void index()throws Exception{
//        // 索引文档 （保存到表）
//        Article article = new Article(1, "zhangsan", "好消息", "hello, world!");
//
//        // 构建索引
//        Index index = new Index.Builder(article).index("atguigu").type("news").build();
//
//        // 执行
//        jestClient.execute(index);
//
//        //成功索引文档 http://192.168.2.3:9200/atguigu/news/1
//        //{
//        //    "_index": "atguigu",
//        //    "_type": "news",
//        //    "_id": "1",
//        //    "_version": 1,
//        //    "found": true,
//        //    "_source": {
//        //        "id": 1,
//        //        "author": "zhangsan",
//        //        "title": "好消息",
//        //        "content": "hello, world!"
//        //    }
//        //}
//    }
//
//    @Test
//    public void search() throws Exception{
//        String json = "{\n" +
//                "    \"query\" : {\n" +
//                "        \"match\" : {\n" +
//                "            \"title\" : \"好消息\"\n" +
//                "        }\n" +
//                "    }\n" +
//                "}";
//
//        Search search = new Search.Builder(json).addIndex("atguigu").addType("news").build();
//
//        SearchResult searchResult = jestClient.execute(search);
//
//        LOGGER.info("searchResult.getJsonString() = {}", searchResult.getJsonString());
//        //{
//        //    "took": 5,
//        //    "timed_out": false,
//        //    "_shards": {
//        //        "total": 5,
//        //        "successful": 5,
//        //        "skipped": 0,
//        //        "failed": 0
//        //    },
//        //    "hits": {
//        //        "total": 1,
//        //        "max_score": 0.7594807,
//        //        "hits": [
//        //            {
//        //                "_index": "atguigu",
//        //                "_type": "news",
//        //                "_id": "1",
//        //                "_score": 0.7594807,
//        //                "_source": {
//        //                    "id": 1,
//        //                    "author": "zhangsan",
//        //                    "title": "好消息",
//        //                    "content": "hello, world!"
//        //                }
//        //            }
//        //        ]
//        //    }
//        //}
//    }


    private static class Article{
//        @JestId
        private Integer id;
        private String author;
        private String title;
        private String content;

        public Article(Integer id, String author, String title, String content) {
            this.id = id;
            this.author = author;
            this.title = title;
            this.content = content;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        @Override
        public String toString() {
            return "Article{" +
                    "id=" + id +
                    ", author='" + author + '\'' +
                    ", title='" + title + '\'' +
                    ", content='" + content + '\'' +
                    '}';
        }
    }
}
