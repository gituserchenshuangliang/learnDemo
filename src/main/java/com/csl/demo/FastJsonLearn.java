package com.csl.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
	 阿里巴巴FastJson是一个Json处理工具包，包括“序列化”和“反序列化”两部分，它具备如下特征：
	速度最快，测试表明，fastjson具有极快的性能，超越任其他的Java Json parser。包括自称最快的JackJson；
	功能强大，完全支持Java Bean、集合、Map、日期、Enum，支持范型，支持自省；无依赖，能够直接运行在Java SE 5.0以上版本；支持Android；开源 (Apache 2.0)
	源码地址：https://github.com/alibaba/fastjson
	Fastjson API入口类是com.alibaba.fastjson.JSON，常用的序列化操作都可以在JSON类上的静态方法直接完成。
	public static final Object parse(String text); // 把JSON文本parse为JSONObject或者JSONArray 
	public static final JSONObject parseObject(String text)； // 把JSON文本parse成JSONObject 
	public static final T parseObject(String text, Class clazz); // 把JSON文本parse为JavaBean 
	public static final JSONArray parseArray(String text); // 把JSON文本parse成JSONArray 
	public static final List parseArray(String text, Class clazz); //把JSON文本parse成JavaBean集合 
	public static final String toJSONString(Object object); // 将JavaBean序列化为JSON文本 
	public static final String toJSONString(Object object, boolean prettyFormat); // 将JavaBean序列化为带格式的JSON文本 
	public static final Object toJSON(Object javaObject); 将JavaBean转换为JSONObject或者JSONArray。
 * @author Cherry
 * @date  2019年5月24日
 */
@SuppressWarnings({"unused","rawtypes"})
public class FastJsonLearn {
    private static Logger logger = LoggerFactory.getLogger(FastJsonLearn.class);

	/*
	 * ObjectBean to String
	*/
	@Test
	public void learnA(){
		ArrayList<HashMap> list = new ArrayList<HashMap>(10);
		HashMap<String, Object> map = new HashMap<String, Object>(10);
		for (int f = 0; f < 2; f++) {
			for (int i = 0; i < 2; i++) {
				map.put(UUID.randomUUID().toString().substring(1, 4), i);
			}
			list.add(map);
		}
		String str = JSON.toJSONString(list);
		logger.debug(str);
	}
	
	/*
	 * String to ObjectBean
	 */
	@Test
	public void learnB(){
		/*
		 * JSONArray
		 */
		String list = "[{'id':1,'username':'chen','phone':'13002897342'},{'id':2,'username':'jack','phone':'15302897342'}]";
		JSONArray ja = JSONArray.parseArray(list);
		User ua = ja.getObject(0, User.class);
		User ub = ja.getObject(1, User.class);
		logger.debug(ua.toString());
		
		/*
		 * JSONObject
		 */
		String obj = "{'id':3,'username':'cherry','phone':'18702897342'}";
		User uc = JSONObject.parseObject(obj, User.class);
		logger.debug(uc.toString());
	}
}
