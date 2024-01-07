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
    public String helloWithQueryParam(@RequestParam String name, @RequestParam String language){
        return languageSelector(language) + name + "!";

    }


    public String languageSelector(String language){
        if (language.equals("english")){
            return "Hello, ";
        } else if (language.equals("spanish")){
            return "Hola, ";
        } else if (language.equals("french")){
            return "Bonjour, ";
        } else if (language.equals("german")){
            return "Hallo, ";
        }else {
            return "Witam, ";
        }

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
                "<select name= 'language'>" +
                "<option value=''>* Select One *</option>" +
                "<option value='english'>English</option>" +
                "<option value='spanish'>Spanish</option>" +
                "<option value='french'>French</option>" +
                "<option value='german'>German</option>" +
                "<option value='polish'>Polish</option>" +
                "<input type= 'submit' value= 'Greet Me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
