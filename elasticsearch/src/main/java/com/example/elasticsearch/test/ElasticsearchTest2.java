package com.example.elasticsearch.test;

import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Date;

public class ElasticsearchTest2 {

    private Logger logger = LoggerFactory.getLogger(ElasticsearchTest2.class);

    public final static String HOST = "127.0.0.1";

    public final static int PORT = 9300;

    private TransportClient client = null;

    @SuppressWarnings({ "resource", "unchecked" })
    @Before
    public void getConnect() throws UnknownHostException {
        client = new PreBuiltTransportClient(Settings.EMPTY).addTransportAddresses(new InetSocketTransportAddress(InetAddress.getByName(HOST),PORT));
        logger.info("连接信息:" + client.toString());
    }

    @After
    public void closeConnect(){
        if(client!=null){
            logger.info("执行关闭连接操作...");
            client.close();
        }
    }

    @Test
    public void addIndex1() throws IOException {
        IndexResponse response = client.prepareIndex("msg","tweet","1").
                setSource(XContentFactory.jsonBuilder().startObject().field("userName", "张三")
                        .field("sendDate", new Date())
                        .field("msg", "你好李四").endObject()).get();
        logger.info("索引名称:" + response.getIndex() + "\n类型:" + response.getType()
                + "\n文档ID:" + response.getId() + "\n当前实例状态:" + response.status());
    }
}
