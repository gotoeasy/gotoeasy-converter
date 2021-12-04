package top.gotoeasy.framework.converter.fun.impl;

import java.sql.Date;

import top.gotoeasy.framework.converter.fun.FunConverter;

/**
 * 数据类型转换实现类(java.sql.Date to Long)
 * 
 * @since 2018/01
 * @author 青松
 */
public class ConvertSqlDate2Long implements FunConverter<Date, Long> {

    /**
     * 类型转换
     * 
     * @param orig 转换前对象
     * @return 转换后对象
     */
    @Override
    public Long convert(Date orig) {
        return orig.getTime();
    }

}
