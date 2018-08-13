package info.mjy.boottest.test.controller;

import com.alibaba.fastjson.JSONObject;
import info.mjy.boottest.test.ResponseVO;
import info.mjy.boottest.test.model.ImportSoDTO;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/first")
public class FirstController {

    @RequestMapping(value = "/importSo", method = RequestMethod.POST)
    @ApiOperation(value = "销售订单支付完成接入标准接口", notes = "销售订单支付完成接入标准接口")
    public Object importSo(@RequestBody @Valid ImportSoDTO importSoDTO) {

        System.err.println(JSONObject.toJSONString(importSoDTO));
        return ResponseVO.success(JSONObject.toJSONString(importSoDTO));
    }

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello";
    }

}
