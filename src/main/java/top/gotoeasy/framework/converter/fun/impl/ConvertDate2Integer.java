package top.gotoeasy.framework.converter.fun.impl;

import java.math.BigDecimal;
import java.util.Date;

import top.gotoeasy.framework.converter.fun.FunConverter;

/**
 * 数据类型转换实现类(Date to Integer)
 * 
 * @since 2018/01
 * @author 青松
 */
public class ConvertDate2Integer implements FunConverter<Date, Integer> {

    /**
     * 类型转换
     * 
     * @param orig 转换前对象
     * @return 转换后对象
     */
    @Override
    public Integer convert(Date orig) {
        return new BigDecimal(orig.getTime()).intValue();
    }

}
