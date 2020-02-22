package rabbitmq.util;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;

public class ConnectionUtil {
    public static Connection getConnection() throws IOException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.81.110");
        factory.setPort(5672);
        factory.setVirtualHost("testhost");
        factory.setUsername("xbc");
        factory.setPassword("981209");
        Connection connection = factory.newConnection();
        return connection;
    }
}
