package top.gotoeasy.framework.converter.fun.impl;

import top.gotoeasy.framework.converter.fun.FunConverter;

/**
 * 数据类型转换实现类(Integer to Boolean)
 * 
 * @since 2018/01
 * @author 青松
 */
public class ConvertInteger2Boolean implements FunConverter<Integer, Boolean> {

    /**
     * 类型转换
     * 
     * @param orig 转换前对象
     * @return 转换后对象
     */
    @Override
    public Boolean convert(Integer orig) {
        return orig != 0;
    }

}
