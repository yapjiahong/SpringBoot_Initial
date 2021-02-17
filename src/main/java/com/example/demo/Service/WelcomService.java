package com.example.demo.Service;

import com.example.demo.Bean.ResultBean;
import com.example.demo.Bean.WelcomeBeanPost;
import com.example.demo.Controller.WelcomeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

@Service
public class WelcomService {

    @Value("${static.post.message}")
    private String STATIC_POST_MESSAGE;

    @Value("${static.get.messages}") //using on application.properties
//    @Value("${static.get.messages}")
    private List<String> getMessages;

    @Value("#{${invalid.tokens}}")
    private List<String> listInvalidTokens;

    @Value("#{${valid.tokens}}")
    private List<String> listValidTokens;

    Logger logger = LoggerFactory.getLogger(WelcomService.class);

    public ResultBean welcomeServicePost(WelcomeBeanPost welcomeBeanPost){

        logger.info("welcomeServicePost =>\t" + welcomeBeanPost.getPostClient() + "\t" + welcomeBeanPost.getKey());

        ResultBean resultBean = new ResultBean();

        resultBean.setMethod("post");
        resultBean.setReturnCode(200);
        resultBean.setMsg(STATIC_POST_MESSAGE + "\t" + welcomeBeanPost.getPostClient() + "\t" + welcomeBeanPost.getKey());

        return resultBean;
    }

    public ResultBean welcomeServiceGet(Map<String,String> welcomeBeanGet){
        ResultBean resultBean = new ResultBean();

        StringBuilder sb = new StringBuilder();

        getMessages.forEach(msg -> sb.append(msg).append(" @@@ "));

        resultBean.setMethod("get");
        resultBean.setReturnCode(200);
        resultBean.setMsg(
                "getClient = " + welcomeBeanGet.get("getClient") + "\t" +
                "key = " + welcomeBeanGet.get("key") + "\t" +
                "get msg list => " + sb + "\t"
        );

        return resultBean;
    }

}
