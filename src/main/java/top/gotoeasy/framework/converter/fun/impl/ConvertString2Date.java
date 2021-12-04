package top.gotoeasy.framework.converter.fun.impl;

import java.util.Date;

import top.gotoeasy.framework.converter.fun.FunConverter;
import top.gotoeasy.framework.converter.util.Utils;

/**
 * 数据类型转换实现类(String to Date)
 * 
 * @since 2018/01
 * @author 青松
 */
public class ConvertString2Date implements FunConverter<String, Date> {

    /**
     * 类型转换
     * 
     * @param orig 转换前对象
     * @return 转换后对象
     */
    @Override
    public Date convert(String orig) {
        if (!Utils.hasText(orig)) {
            return null;
        }
        return Utils.toDate(orig);
    }

}
