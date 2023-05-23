import java.util.Scanner;

public class CalcTest {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        char action;
        String[] data;

        if (str.contains("/")) {
            data = str.split("/");
            action = '/';
        } else if (str.contains("*")) {
            data = str.split("\\*");
            action = '*';
        } else if (str.contains("+")) {
            data = str.split("\\+");
            action = '+';
        } else if (str.contains("-")) {
            data = str.split("-");
            action = '-';
        } else {
            throw new Exception("\"Введён неверный знак действия\"");
        }
        for (int i = 0; i < data.length; i++) {
            if (data[i].length() > 11) {
                throw new Exception("\"Вы ввели строку более 10 символов\"");
            }
        }
        if (action == '/' || action == '*') {
            if (data[1].contains("\"")) {
                throw new Exception("\"Делить и умножать можно, только на число\"");
            }
        }

        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
            data[i] = data[i].replace(" ", "");
        }

        if (action == '+') {
            String result = data[0] + data[1];
            printString(result);
        }else if (action == '-') {
            int index = data[0].indexOf(data[1]);
            if (index == -1) {
                System.out.println(data[0]);
            } else {
                String result = data[0].substring(0, index);
                result += data[0].substring(index + data[1].length());
                printString(result);

            }
        } else if (action == '*') {
            int newInt = Integer.parseInt(data[1]);
            if (newInt > 10) {
                throw new Exception("\"Вы ввели число больше 10\"");
            }
            String result = "";
            for (int i = 0; i < newInt; i++) {
                result += data[0];
            }
            printString(result);

        }
        else {
            int newInt = Integer.parseInt(data[1]);
            if (newInt > 10) {
                throw new Exception("\"Вы ввели число больше 10\"");
            }
            int newDiv = data[0].length() / newInt;
            String result = data[0].substring(0, newDiv);
            printString(result);
        }
    }
    static void printString(String result) {
        if (result.length() > 40) {
            result = result.substring(0, 40);
            System.out.println("\"" + result + "..." + "\"");
        } else {
            System.out.println("\"" + result + "\"");
        }
    }
}

