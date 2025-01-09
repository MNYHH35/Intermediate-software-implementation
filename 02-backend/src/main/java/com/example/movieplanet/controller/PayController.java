package com.example.movieplanet.controller;

import com.example.movieplanet.bo.PaymentBO;
import com.example.movieplanet.service.PayService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 支付宝支付，控制器
 */
@RestController
@RequestMapping(value = "/pay")
@AllArgsConstructor
public class PayController {

    private final PayService payService;

    /**
     * 下单支付
     */
    @GetMapping(value = "/confirm", produces = {"text/html;charset=UTF-8"})
    public Object pay(@RequestParam String userEmail) throws Exception {
        //这个接口其实应该是post方式的，但是我这里图方便，直接以get方式访问，
        //且返回格式是text/html，这样前端页面就能直接显示支付宝返回的html片段
        //真实场景下由post方式请求，返回code、msg、data那种格式的标准结构，让前端拿到data里的
        //html片段之后自行加载

        //由于我这里并没有真正的传参数，所以象征性的new一下，避免空指针
        PaymentBO bo = new PaymentBO();
        bo.setUserEmail(userEmail);
        return payService.pay(bo);
    }
}
