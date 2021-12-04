package top.gotoeasy.framework.converter.fun.impl;

import java.math.BigDecimal;

import top.gotoeasy.framework.converter.fun.FunConverter;

/**
 * 数据类型转换实现类(BigDecimal to String)
 * 
 * @since 2018/01
 * @author 青松
 */
public class ConvertBigDecimal2String implements FunConverter<BigDecimal, String> {

    /**
     * 类型转换
     * 
     * @param orig 转换前对象
     * @return 转换后对象
     */
    @Override
    public String convert(BigDecimal orig) {
        return orig.toPlainString();
    }

}
