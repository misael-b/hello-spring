package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller

//@RequestMapping("hello") all mapping at /hello
public class HelloController {
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello(){
//        return "Hello, Spring!";
//
//    }

    @GetMapping("goodbye")
    @ResponseBody
    public String goodBye(){
        return "Goodbye, Spring!";

    }

    //dynamic responses /hello?name=LaunchCode (Query Parameter)
    @RequestMapping(method= {RequestMethod.GET, RequestMethod.POST}, value= "hello")
    public String hello(@RequestParam String name, Model model){
        String theGreeting = "Hello, " + name + "!";
        model.addAttribute("greeting", theGreeting);
        return "hello";

    }

    // handles request in th form /hello/LaunchCode (part of path)
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name){
        return "Hello, " + name +"!";
    }


    @GetMapping("/form")
    public String helloForm(){
        return "form";
    }
    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("name1");
        names.add("name2");
        names.add("name2");
        model.addAttribute("names", names);
        return "hello-list";
    }



}
