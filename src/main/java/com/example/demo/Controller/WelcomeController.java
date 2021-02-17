package com.example.demo.Controller;

import com.example.demo.Bean.ResultBean;
import com.example.demo.Bean.WelcomeBeanPost;
import com.example.demo.Service.WelcomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

@RestController
public class WelcomeController {

    @Autowired
    WelcomService welcomService;

    Logger logger = LoggerFactory.getLogger(WelcomeController.class);

    @RequestMapping(value = "/welcome", method = RequestMethod.POST)
    @ResponseBody
    public ResultBean postController(@RequestBody WelcomeBeanPost welcomeBeanPost){

        logger.info(String.format("postController\npost => %s", welcomeBeanPost.getPostClient() + "\t" + welcomeBeanPost.getKey()));

        return welcomService.welcomeServicePost(welcomeBeanPost);
    }

    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String welecome(){
        return "Welcome.\n";
    }

    @RequestMapping(value="/welcome/{id}", method = RequestMethod.GET)
    @ResponseBody
    public String welcomeWithPathVariable(@PathVariable("id") int id){
        return "Welcome id => " + id + "\n";
    }

    @RequestMapping(path = "/stonks/{name}/{key}", method = RequestMethod.GET)
    public String welcomeWithPathVariable(@PathVariable String name, @PathVariable String key) {
        return "welcomeWithPathVariable: name => " + name + "    key => " + key;
    }

    @RequestMapping(value="/nonstonks/welcome/RequestParam", method = RequestMethod.GET)
    @ResponseBody
    public String welcomeWithRequestParam(@RequestParam("id") int id){
        return "welceomwithRequestParam: Welcome id => " + id + "\n";
    }

    @RequestMapping(value = "/getWelcome", method = RequestMethod.GET)
    public ResultBean getWelcome(@RequestParam Map<String,String> welcomeBeanGet){
        return welcomService.welcomeServiceGet(welcomeBeanGet);
    }


}
