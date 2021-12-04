package top.gotoeasy.framework.converter.fun.impl;

import java.sql.Date;

import top.gotoeasy.framework.converter.fun.FunConverter;
import top.gotoeasy.framework.converter.util.Utils;

/**
 * 数据类型转换实现类(Date to String)
 * 
 * @since 2018/01
 * @author 青松
 */
public class ConvertDate2String implements FunConverter<Date, String> {

    /**
     * 类型转换
     * 
     * @param orig 转换前对象
     * @return 转换后对象
     */
    @Override
    public String convert(Date orig) {
        return Utils.formatDate(orig, "yyyy-MM-dd HH:mm:ss.SSS");
    }

}
