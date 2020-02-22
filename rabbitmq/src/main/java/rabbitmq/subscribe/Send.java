package rabbitmq.subscribe;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import rabbitmq.util.ConnectionUtil;

import java.util.ArrayList;
import java.util.Random;

public class Send {
   // private final static String EXCHANGE_NAME = "test_exchange_fanout";
    private final static String EXCHANGE_NAME = "test_exchange_direct";
    public static void main(String[] argv) throws Exception {
        // 获取到连接以及mq通道
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();

        // 声明exchange
        channel.exchangeDeclare(EXCHANGE_NAME, "direct");
        for (int i = 0; i < 100; i++) {
            ArrayList a = new ArrayList();
            a.add(0,"insert");
            a.add(1,"delete");
            a.add(2,"update");
        // 消息内容
            Random r =new Random();
            Object b = a.get((Integer)(r.nextInt(3)));
        String message = b+"商品!";
        channel.basicPublish(EXCHANGE_NAME, (String)b, null, message.getBytes());
        System.out.println(" [x] Sent '" +i+ message + "'");
            Thread.sleep(i * 10);
        }
        channel.close();
        connection.close();
    }
}
