package info.mjy.consulclient.controller;

import info.mjy.consulclient.feign.FeignDemoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConsulClientController {

    @Autowired
    private FeignDemoClient feignDemoClient;

    @RequestMapping(method = RequestMethod.GET, value = "/name")
    public String test1() {
        return feignDemoClient.test1();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/diffname")
    public String diffname() {
        return feignDemoClient.diffname();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/paramname/{param}")
    public String paramname(@RequestParam(value = "param") Integer param) {
        return feignDemoClient.paramname(param);
    }

}
