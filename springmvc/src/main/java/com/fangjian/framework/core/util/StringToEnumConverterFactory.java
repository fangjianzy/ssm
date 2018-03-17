package com.fangjian.framework.core.util;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.converter.ConverterFactory;


/**   
 * 类名称：StringToEnumConverterFactory   </br>
 * 类描述：   </br>
 * 创建人：fangjian </br>
 * 创建时间：2016年1月20日 上午10:18:40   </br>
 * 修改人：fangjian </br>
 * 修改时间：2016年1月20日 上午10:18:40   </br>
 * 修改备注：   </br>
 * @version    </br>
 */
final class StringToEnumConverterFactory implements ConverterFactory<String, Enum> {

    public <T extends Enum> Converter<String, T> getConverter(Class<T> targetType) {
    	  return new StringToEnumConverter(targetType);
    }

    private final class StringToEnumConverter<T extends Enum> implements Converter<String, T> {
    	private Class<T> enumType;

        public StringToEnumConverter(Class<T> enumType) {
            this.enumType = enumType;
        }

        public T convert(String source) {
        	try{
        		return (T) Enum.valueOf(this.enumType, source.trim());
        	}catch(Exception ex){
        		return null;
        	}
        }
    }
}

