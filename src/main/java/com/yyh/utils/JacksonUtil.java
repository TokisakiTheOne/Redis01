package com.yyh.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * json格式工具类
 *
 * @author YanYuHang
 * @create 2019-12-20-11:07
 */
public class JacksonUtil {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    static {
        //时间格式  json转换
        OBJECT_MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        OBJECT_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }
    /**
     * 把java对象装换为json字符串
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String toJSON(T obj) {
        try {
            String json = OBJECT_MAPPER.writeValueAsString(obj);
            return json;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static <T> T toJava(String json, Class<T> type) {
        try {
            T t = OBJECT_MAPPER.readValue(json, type);
            return t;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
