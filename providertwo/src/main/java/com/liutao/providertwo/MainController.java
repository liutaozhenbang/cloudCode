package com.liutao.providertwo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * .
 * Created by liutao20 on 2020/7/16
 */
@RestController
public class MainController {

    @Value("${server.port}")
    private String port;

    @GetMapping("hi")
    public String hi () {
        System.out.println("two");
        return "刘涛真棒为您服务，服务端口号： " + port;
    }

    @GetMapping("getMap")
    public Person getMap (@RequestParam("name") String name) {
        Person person = new Person(name, 28);
        return person;
    }

    @PostMapping("postLocation")
    public URL postLocation (@RequestBody Person person, HttpServletResponse response) throws Exception {
        String name = person.getName();
        URL url = new URL("https://www.baidu.com/s?ie=UTF-8&wd=" + name);
        response.addHeader("Location", url.toString());
        return url;
    }

    @GetMapping("getTestReget")
    public String getTestReget() {
        try {
            String s = "huaide " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
            System.out.println(s);
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "liutaozhenbang";
    }

}
