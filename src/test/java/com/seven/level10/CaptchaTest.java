package com.seven.level10;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.LineCaptcha;
import cn.hutool.captcha.ShearCaptcha;
import cn.hutool.captcha.generator.MathGenerator;
import cn.hutool.core.lang.Console;
import org.junit.Test;

/**
 * @author QH
 * @date 2020/5/11
 * @description 验证码测试
 */
public class CaptchaTest {

    @Test
    public void create() {
        ShearCaptcha captcha = CaptchaUtil.createShearCaptcha(200, 45, 4, 4);
// 自定义验证码内容为四则运算方式
        captcha.setGenerator(new MathGenerator());
// 重新生成code
        captcha.createCode();
        captcha.write("d:/line.png");


    }
}
