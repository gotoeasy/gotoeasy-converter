package top.gotoeasy.framework.converter;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import top.gotoeasy.framework.converter.fun.FunConverter;
import top.gotoeasy.framework.converter.util.ClsUtil;

/**
 * 数据类型转换工具类
 * 
 * @since 2018/01
 * @author 青松
 */
@Slf4j
public class Converter {

    public static void main(String... args) {
        System.err.println(Converter.fromTo("True", Boolean.class));
        System.err.println(Converter.fromTo(0, Boolean.class));
        System.err.println(Converter.fromTo(new BigDecimal("12345.678"), int.class));
    }

    /**
     * 类型转换
     * 
     * @param orig    转换前值对象
     * @param toClass 转换目标类
     * @param <T>     目标类
     * @return 转换结果
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static <T> T fromTo(Object orig, Class<T> toClass) {

        if (orig == null) {
            return null;
        }

        if (toClass.isInstance(orig)) {
            return (T)orig;
        }

        Class<?> toClas = toClass;
        if (mapTypeClass.containsKey(toClass)) {
            toClas = mapTypeClass.get(toClass);
        }
        FunConverter converter = mapConverter.get(getConvertKey(orig, toClas));
        if (converter != null) {
            return (T)converter.convert(orig);
        }

        throw new UnsupportedOperationException("不支持从[" + orig.getClass() + "]转换到[" + toClass + "]");
    }

    private static String getConvertKey(FunConverter<?, ?> converter) {
        Type[] genType = converter.getClass().getGenericInterfaces();
        Type[] params = ((ParameterizedType)genType[0]).getActualTypeArguments();
        return params[0] + "#" + params[1];
    }

    private static String getConvertKey(Object orig, Class<?> toClass) {
        return orig == null ? "" : (orig.getClass() + "#" + toClass);
    }

    private static void addConverter(FunConverter<?, ?> converter) {
        String key = getConvertKey(converter);
        if (mapConverter.containsKey(key)) {
            log.warn("转换器重复，[{}]被覆盖为[{}]", mapConverter.get(key).getClass(), converter.getClass());
        }
        mapConverter.put(getConvertKey(converter), converter);
    }

    private static Map<String, FunConverter<?, ?>> mapConverter = new HashMap<>();
    private static Map<Class<?>, Class<?>> mapTypeClass = new HashMap<>();

    static {
        mapTypeClass.put(byte.class, Byte.class);
        mapTypeClass.put(int.class, Integer.class);
        mapTypeClass.put(long.class, Long.class);
        mapTypeClass.put(short.class, Short.class);
        mapTypeClass.put(float.class, Float.class);
        mapTypeClass.put(double.class, Double.class);
        mapTypeClass.put(boolean.class, Boolean.class);
        mapTypeClass.put(char.class, Character.class);

        List<Class<?>> list = ClsUtil.getClasses(FunConverter.class.getPackage().getName());
        for (Class<?> claz : list) {
            if (!claz.isInterface()) {
                try {
                    Object obj = claz.newInstance();
                    if (obj instanceof FunConverter) {
                        log.trace("添加转换器[{}]", claz);
                        addConverter((FunConverter<?, ?>)obj);
                    }
                } catch (Exception e) {
                    log.error("转换器[{}]初始化失败", claz, e);
                }
            }
        }
    }

}
