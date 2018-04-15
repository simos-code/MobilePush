package com.simos.service;

import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by l2h on 18-4-15.
 * Desc: mqtt 推送业务处理类
 * @author l2h
 */
@Service
public class MqttPushService {
    @Resource(name = "mqttOutboundChannel")
    private MessageChannel mqttOutboundChannel;

    /**
     * 消息推送
     * @param msg　推送的业务数据，根据业务需要约定格式
     * @param user　推送的用户．本人实际使用中，推送给android登陆用户．因此用户登陆时要求上报登陆设备的型号，设备序列号（设备唯一标识）
     * @return 成功返回true,错误返回false
     */
    public boolean push(String msg,String user){
        return mqttOutboundChannel.send(MessageBuilder.withPayload(msg).setHeader(MqttHeaders.TOPIC,user).build());
    }
}
