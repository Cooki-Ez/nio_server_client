package Client;

import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String answer;
        System.out.println("Enter \'echo <serverIP> <message>\'");
        System.out.println("OR");
        System.out.println("Enter \'action <serverIP> <number> <sign> <number>\'");
        while (true) {
            answer = scan.nextLine();
            String[] tmp = answer.split(" ");
            if (tmp[0].equals("echo")) {
                StringBuilder message = new StringBuilder();
                for (int i = 2; i < tmp.length; i++)
                    if(i==2)message.append(" ").append(tmp[i]);
                    else message.append(tmp[i]);
                NormalAnswer.echo(tmp[1], message.toString());
            } else if (tmp[0].equals("action")) {
                StringBuilder message = new StringBuilder();
                for (int i = 2; i < tmp.length; i++)
                    message.append(" ").append(tmp[i]);
                AnswerWithAction.action(tmp[1], message.toString());
            } else {
                System.out.println("Unknown command");
            }
            
        }
    }
}

