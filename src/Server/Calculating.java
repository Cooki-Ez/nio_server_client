package Server;



public interface Calculating {
    static int calculate(String str) {
        String tmp;
        int number1;
        int number2;
        int answer = 0;
        tmp = str.replaceAll("\\d", "").replaceAll("\\s", "");
        String[] arr = str.replaceAll(" ", "").split("\\D");
        number1 = Integer.parseInt(arr[0]);
        number2 = Integer.parseInt(arr[1]);


        switch (tmp) {
            case "+" -> answer = number1 + number2;
            case "-" -> answer = number1 - number2;
            case "*" -> answer = number1 * number2;
            case "/" -> answer = number1 / number2;
        }


        return answer;
    }

}