package top.gotoeasy.framework.converter.fun.impl;

import java.util.Date;

import top.gotoeasy.framework.converter.fun.FunConverter;

/**
 * 数据类型转换实现类(Integer to Date)
 * 
 * @since 2018/01
 * @author 青松
 */
public class ConvertInteger2Date implements FunConverter<Integer, Date> {

    /**
     * 类型转换
     * 
     * @param orig 转换前对象
     * @return 转换后对象
     */
    @Override
    public Date convert(Integer orig) {
        return new Date(orig);
    }

}
