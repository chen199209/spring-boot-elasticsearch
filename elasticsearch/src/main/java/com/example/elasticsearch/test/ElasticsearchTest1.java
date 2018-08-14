package com.example.elasticsearch.test;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class ElasticsearchTest1 {

    private Logger logger = LoggerFactory.getLogger(ElasticsearchTest1.class);

    public final static String HOST = "127.0.0.1";

    public final static int PORT = 9300;

    @SuppressWarnings("resource")
    @Test
    public void test1() throws UnknownHostException {
        TransportClient client =  new PreBuiltTransportClient(Settings.EMPTY).addTransportAddresses(new InetSocketTransportAddress(InetAddress.getByName(HOST),PORT));
        logger.debug("Elasticsearch connect info:" + client.toString());
        //关闭连接
        client.close();
    }
}
