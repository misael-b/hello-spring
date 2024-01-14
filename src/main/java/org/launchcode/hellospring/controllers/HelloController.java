package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
//@RequestMapping("hello") all mapping at /hello
public class HelloController {
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//
//    }

    @GetMapping("goodbye")
    public String goodBye(){
        return "Goodbye, Spring!";

    }

    //dynamic responses /hello?name=LaunchCode (Query Parameter)
    @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST}, value= "hello")
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, " + name + "!";

    }

    // handles request in th form /hello/LaunchCode (part of path)
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name +"!";
    }


    @GetMapping("/form")
    public String helloForm(){
        return"<html>" +
                "<body>" +
                "<form action= 'hello' method= 'post'>" + //submit request to /hello
                "<input type= 'text' name= 'name'>" +
                "<input type= 'submit' value= 'Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }


}
