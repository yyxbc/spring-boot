package rabbitmq.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.QueueingConsumer;
import rabbitmq.util.ConnectionUtil;

import java.io.IOException;

public class Recv {
    private final static String QUEUE_NAME ="test_queue_work";

    public static  void main(String[] argv) throws IOException, InterruptedException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel =connection.createChannel();
        channel.queueDeclare(QUEUE_NAME,false,false,false,null);

        // 同一时刻服务器只会发一条消息给消费者
        channel.basicQos(1);
        QueueingConsumer consumer = new QueueingConsumer(channel);

        channel.basicConsume(QUEUE_NAME,false,consumer);

        while (true){
            QueueingConsumer.Delivery delivery = consumer.nextDelivery();
            String message = new String(delivery.getBody());
            System.out.println("[x] Received '"+message+"'");
            Thread.sleep(10);
            // 返回确认状态，注释掉表示使用自动确认模式
            channel.basicAck(delivery.getEnvelope().getDeliveryTag(), false);
        }

    }
}
