package Server;

import java.util.ArrayList;
import java.util.List;

public class Server {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        threads.add(new Thread(NormalAnswer::echoServer));
        threads.add(new Thread(AnswerWithAction::addingServer));
        for (Thread thread : threads)
            thread.start();

    }
}