package Client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class AnswerWithAction {
    final static int PORT = 2552;
    static ByteBuffer buffer = ByteBuffer.allocate(4096);
    static int response;

    public static void action(String host, String message) {
        try {
            InetSocketAddress socketAddress = new InetSocketAddress(host, PORT);
            SocketChannel client = SocketChannel.open(socketAddress);
            buffer = ByteBuffer.wrap(message.getBytes());
            System.out.println("Client sent:" + message);
            client.write(buffer);
            buffer.clear();
            buffer.limit(4);
            client.read(buffer);
            buffer.rewind();
            response = buffer.getInt();
            System.out.println("Server responded: " + response);
            buffer.clear();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}