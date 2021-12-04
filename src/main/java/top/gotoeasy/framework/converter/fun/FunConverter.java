package top.gotoeasy.framework.converter.fun;

/**
 * 数据类型转换接口
 * 
 * @since 2018/01
 * @author 青松
 */
public interface FunConverter<F, T> {

    /**
     * 类型转换
     * 
     * @param orig 转换前对象
     * @return 转换后对象
     */
    public T convert(F orig);

}
