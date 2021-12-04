package top.gotoeasy.framework.converter.fun.impl;

import java.math.BigDecimal;

import top.gotoeasy.framework.converter.fun.FunConverter;

/**
 * 数据类型转换实现类(Long to BigDecimal)
 * 
 * @since 2018/01
 * @author 青松
 */
public class ConvertLong2BigDecimal implements FunConverter<Long, BigDecimal> {

    /**
     * 类型转换
     * 
     * @param orig 转换前对象
     * @return 转换后对象
     */
    @Override
    public BigDecimal convert(Long orig) {
        if (orig == null) {
            return null;
        }
        return new BigDecimal(orig);
    }

}
