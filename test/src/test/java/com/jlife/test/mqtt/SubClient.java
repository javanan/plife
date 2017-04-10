package com.jlife.test.mqtt;


import org.eclipse.paho.client.mqttv3.*;
import org.eclipse.paho.client.mqttv3.internal.wire.MqttWireMessage;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * Created by chen on 2017/3/9.
 * <p>
 * Email 122741482@qq.com
 * <p>
 * Describe:
 */
public class SubClient {
    public static void main(String[] args) {

        String topic = "MQTT java";

        int qos = 2;
        String broker = "tcp://192.168.247.134:1883";
        String clientId = "chenjianansub";
        MemoryPersistence persistence = new MemoryPersistence();

        try {
            IMqttAsyncClient sampleClient = null;
            try {
                sampleClient = new MqttAsyncClient(broker, clientId, persistence);
            } catch (MqttException e) {
                e.printStackTrace();
            }

            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setKeepAliveInterval(10);
            connOpts.setCleanSession(true);




            IMqttToken token =null;
            token=  sampleClient.connect(connOpts, new IMqttActionListener() {
                @Override
                public void onSuccess(IMqttToken iMqttToken) {
                    System.out.println("Message onSuccess");
                    try {
                      iMqttToken.getClient().subscribe(topic,qos);


                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                @Override
                public void onFailure(IMqttToken iMqttToken, Throwable throwable) {
                    System.out.println("Message onFailure");
                }
            });





        } catch (MqttException me) {
            System.out.println("reason " + me.getReasonCode());
            System.out.println("msg " + me.getMessage());
            System.out.println("loc " + me.getLocalizedMessage());
            System.out.println("cause " + me.getCause());
            System.out.println("excep " + me);
            me.printStackTrace();
        }
    }
}
