package com.yechangqing.demo.java.springboot.redis.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.yechangqing.demo.java.springboot.redis.entity.Student;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

public class ValueSerializer implements RedisSerializer {

  @Override
  public byte[] serialize(Object o) throws SerializationException {
    return JSON.toJSONBytes(o);
  }

  @Override
  public Object deserialize(byte[] bytes) throws SerializationException {
    return JSONObject.parseObject(bytes, Student.class);
  }
}
