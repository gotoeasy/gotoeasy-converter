package top.gotoeasy.framework.converter.fun.impl;

import java.math.BigDecimal;

import top.gotoeasy.framework.converter.fun.FunConverter;

/**
 * 数据类型转换实现类(Double to String)
 * 
 * @since 2018/01
 * @author 青松
 */
public class ConvertDouble2String implements FunConverter<Double, String> {

    /**
     * 类型转换
     * 
     * @param orig 转换前对象
     * @return 转换后对象
     */
    @Override
    public String convert(Double orig) {
        return new BigDecimal(orig).toPlainString();
    }

}
