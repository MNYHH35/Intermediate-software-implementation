package com.example.movieplanet.service;

import com.alipay.easysdk.factory.Factory;
import com.alipay.easysdk.payment.page.models.AlipayTradePagePayResponse;
import com.example.movieplanet.bo.PaymentBO;
import com.example.movieplanet.dao.UserRepository;
import com.example.movieplanet.utils.OrderUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * 支付宝支付，业务实现
 */
@Service
public class PayService {

    private final UserRepository userRepository;

    public PayService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //支付成功后要跳转的页面
    @Value("${alipay.returnUrl}")
    private String returnUrl;

    /**
     * 下单支付
     */
    public Object pay(PaymentBO bo) throws Exception {
        //从存储介质(如MySQL、Redis)查询商品信息、总金额等敏感信息

        //…………省略相关代码，这里直接赋值…………

        bo.setSubject("Movie-Planet一年VIP(365天)");
        bo.setTotal(new BigDecimal(188.00));

        //调用sdk，发起支付
        AlipayTradePagePayResponse response = Factory.Payment
                //选择网页支付平台
                .Page()
                //调用支付方法，设置订单名称、我们自己系统中的订单号、金额、回调页面
                .pay(bo.getSubject(), OrderUtil.getOrderNo(), bo.getTotal().toString(), returnUrl);

        //支付成功后更新用户角色为VIP
        userRepository.findByUserEmail(bo.getUserEmail()).ifPresent(user -> {
            user.setRole("VIP");
            userRepository.save(user);
        });

        //这里的response.body，就是一个可以直接加载的html片段，
        // 这里为了简单我直接返回这个片段，前端直接
        return response.body;
    }
}
