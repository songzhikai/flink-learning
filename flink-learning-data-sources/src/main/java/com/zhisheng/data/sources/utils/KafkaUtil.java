package com.zhisheng.data.sources.utils;

import com.zhisheng.common.model.MetricEvent;
import com.zhisheng.common.utils.GsonUtil;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Desc: 往kafka中写数据,可以使用这个main函数进行测试
 * Created by zhisheng on 2019-02-17
 * Blog: http://www.54tianzhisheng.cn/tags/Flink/
 */
public class KafkaUtil {
//    public static final String broker_list = "192.168.1.2:9092";
    public static final String broker_list = "cdh00:9092";
    public static final String topic = "metric5";  // kafka topic，Flink 程序中需要和这个统一


    public static void writeToKafka() throws InterruptedException {
        Properties props = new Properties();
        props.put("bootstrap.servers", broker_list);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer"); //key 序列化
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer"); //value 序列化
        KafkaProducer producer = new KafkaProducer<String, String>(props);

        ProducerRecord record = new ProducerRecord<String, String>(topic, "userName", "lc");
        producer.send(record);

        producer.flush();

    }


    public static void main(String[] args) throws InterruptedException {
        while (true) {
            Thread.sleep(5000);
            writeToKafka();
        }
    }
}
