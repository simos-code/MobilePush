package com.simos.mqtt;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;

/**
 * Created by l2h on 18-4-15.
 * Desc:mqtt configuration
 * @author l2h
 */
@Configuration
@EnableConfigurationProperties(MqttProperties.class)
public class MqttConfiguration {
   private MqttProperties mqttProperties;
    public MqttConfiguration( MqttProperties mqttProperties){
        this.mqttProperties = mqttProperties;
    }
    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        factory.setServerURIs(mqttProperties.getServerUri());
        factory.setUserName(mqttProperties.getUserName());
        factory.setPassword(mqttProperties.getPassword());
        return factory;
    }
    @Bean(name = "mqttOutboundChannel")
    public MessageChannel mqttOutboundChannel() {
        return new DirectChannel();
    }
    @Bean
    public IntegrationFlow mqttOutFlow() {
        return IntegrationFlows.from(mqttOutboundChannel())
                .handle(mqttOutboundMessageHandler())
                .get();
    }

    @Bean
    public MessageHandler mqttOutboundMessageHandler() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("server", mqttClientFactory());
        messageHandler.setAsync(true);
        return messageHandler;
    }
}
