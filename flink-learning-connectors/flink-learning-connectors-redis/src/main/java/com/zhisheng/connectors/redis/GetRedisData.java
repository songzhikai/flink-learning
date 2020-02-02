package com.zhisheng.connectors.redis;

import com.zhisheng.common.utils.GsonUtil;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

public class GetRedisData {
    public static void main(String[] args) { //获取
        Jedis jedis=new Jedis("127.0.0.1");
        System.out.println(jedis.get("kevin1"));
    }

    public static void main2(String[] args) { //删除
        Jedis jedis=new Jedis("127.0.0.1");
        jedis.del("top");
        System.out.println(jedis.get("top"));;
    }

    public static void main1(String[] args) { //存储
        Jedis jedis=new Jedis("127.0.0.1");
//        System.out.println("Server is running: " + jedis.ping());
//        System.out.println("result:"+jedis.hgetAll("kevin"));
        Map map = new HashMap();
        map.put("t0", "1");
        jedis.set("map_key", GsonUtil.toJson(map));
        System.out.println(jedis.get("map_key"));;
//        System.out.println("result:"+jedis.get("sys:dict:dictData"));
    }
}
