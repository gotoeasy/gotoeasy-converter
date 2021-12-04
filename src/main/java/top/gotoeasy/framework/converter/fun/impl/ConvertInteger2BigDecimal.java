package top.gotoeasy.framework.converter.fun.impl;

import java.math.BigDecimal;

import top.gotoeasy.framework.converter.fun.FunConverter;

/**
 * 数据类型转换实现类(Integer to BigDecimal)
 * 
 * @since 2018/01
 * @author 青松
 */
public class ConvertInteger2BigDecimal implements FunConverter<Integer, BigDecimal> {

    /**
     * 类型转换
     * 
     * @param orig 转换前对象
     * @return 转换后对象
     */
    @Override
    public BigDecimal convert(Integer orig) {
        if (orig == null) {
            return null;
        }
        return new BigDecimal(orig);
    }

}
