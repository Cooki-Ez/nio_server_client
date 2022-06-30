package Client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public abstract class NormalAnswer {
    final static int PORT = 3993;
    static ByteBuffer buffer = ByteBuffer.allocate(4096);
    static String response;

    public static void echo(String host, String message) {
        try {
            InetSocketAddress socketAddress = new InetSocketAddress(host, PORT);
            SocketChannel client = SocketChannel.open(socketAddress);
            buffer = ByteBuffer.wrap(message.getBytes());
            System.out.println("Client sent: " + message);
            client.write(ByteBuffer.wrap(message.getBytes()));
            buffer.clear();
            client.read(buffer);
            buffer.flip();
            response = new String(buffer.array());
            System.out.println("Server responded: " + response);
            buffer.clear();
            client.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}