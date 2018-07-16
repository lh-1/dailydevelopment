package info.mjy.consul;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author msh11535
 */
@RestController
public class ConsulController {

    @RequestMapping(path = "/name", method = RequestMethod.GET)
    public String test() {
        return "服务端-测试consul可用性";
    }

    @RequestMapping(path = "/diffname", method = RequestMethod.GET)
    public String diff() {
        return "服务端-不同名服务名称的测试！";
    }

    @RequestMapping(path = "/param", method = RequestMethod.GET)
    public String param(@RequestParam(value = "param") Integer param) {
        return "服务端-测试参数" + param;
    }

}
