package info.mjy.consulclient.feign;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("consul-server-demo1")
public interface FeignDemoClient {

    /**
     * value的值就是服务端定义的接口的名字
     * method也是服务端定义的方法请求的类型
     * String test1()这个方法名称的名字无所谓
     *
     * @return
     */
    @RequestMapping(method = RequestMethod.GET, value = "/name")
    String test1();


    @RequestMapping(method = RequestMethod.GET, value = "/diffname")
    String diffname();


    @RequestMapping(method = RequestMethod.GET, value = "/param")
    String paramname(@RequestParam(value = "param") Integer param);

}
