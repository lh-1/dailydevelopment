package com.mjy.daily.demo;

import com.alibaba.fastjson.JSONObject;
import com.mjy.daily.demo.mongo.MongoDB;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.List;
import java.util.regex.Pattern;

public class MongoDBTest {


    @Before
    public void before(){
        MongoDB.connect("root", "userEntity", "10.8.108.115", 27018);
    }

    @Test
    public void connect() {
        String path = "C:\\Users\\msh11535\\Desktop\\文档6_27\\accounts.json";
        Document document = new Document();
        Document bson = new Document();
        document.append("fileName", "accounts.json").append("data", new File(path));
        MongoDB.insert(document);
    }

    @Test
    public void insert() {
        Document document = new Document();
        document.append("name", "zhao").append("gender", "female").append("age", 21);
        MongoDB.insert(document);
        document = new Document();
        document.append("name", "zhao").append("gender", "male").append("age", 23);
        MongoDB.insert(document);

        document = new Document();
        document.append("name", "li").append("gender", "male").append("age", 20);
        MongoDB.insert(document);

        document = new Document();
        document.append("name", "li").append("gender", "female").append("age", 19);
        MongoDB.insert(document);
    }

    @Test
    public void findAll() {
        List<Document> results = MongoDB.findAll();
        System.err.println(JSONObject.toJSONString(results));
    }

    @Test
    public void findBy() {
        /*Document filter = new Document();
        filter.append("value", "123");
        List<Document> results = MongoDB.findBy(filter);
        for(Document doc : results){
            System.out.println(doc.toJson());
        }*/

        Pattern pattern = Pattern.compile("^.*z.*$", Pattern.CASE_INSENSITIVE);
        Document filter = new Document();
        filter.append("name", pattern);
        List<Document> results = MongoDB.findBy(filter);
        System.err.println(JSONObject.toJSONString(results));
    }

    @Test
    public void updateOne() {
        Document filter = new Document();
        filter.append("name", "wang");

        //注意update文档里要包含"$set"字段
        Document update = new Document();
        update.append("$set", new Document("age", 26));
        UpdateResult result = MongoDB.updateOne(filter, update);
        System.out.println("matched count = " + result.getMatchedCount());
    }

    @Test
    public void updateMany() {
        Document filter = new Document();
        filter.append("name", "wang");

        //注意update文档里要包含"$set"字段
        Document update = new Document();
        update.append("$set", new Document("age", 26));
        UpdateResult result = MongoDB.updateMany(filter, update);
        System.out.println("matched count = " + result.getMatchedCount());
    }

    @Test
    public void replace() {
        Document filter = new Document();
        filter.append("value", 123);

        //注意：更新文档时，不需要使用"$set"
        Document replacement = new Document();
        replacement.append("name", "zhang").append("gender", "female").append("age", 18);
        MongoDB.replaceAll(filter, replacement);
    }

    @Test
    public void deleteOne() {
        Document filter = new Document();
        filter.append("value", "123");
        MongoDB.deleteOne(filter);
    }

    @Test
    public void deleteMany() {
        Document filter = new Document();
        filter.append("value", "123");
        MongoDB.deleteMany(filter);
    }
}