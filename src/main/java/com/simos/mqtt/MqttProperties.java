package com.simos.mqtt;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * Created by l2h on 18-4-15.
 * Desc:rabbit mqtt属性配置
 * @author l2h
 */
@ConfigurationProperties(prefix = "spring.rabbitmq.mqtt")
public class MqttProperties {
    /**
     * 服务器地址
     */
    private String serverUri;
    /**
     * 登陆帐号
     */
    private String userName;
    /**
     * 登陆密码
     */
    private String password;
    /**
     *
     */
    private String topic;

    public String getServerUri() {
        return serverUri;
    }

    public void setServerUri(String serverUri) {
        this.serverUri = serverUri;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }
}
