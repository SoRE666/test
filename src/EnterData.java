import java.util.Scanner;

public class EnterData {
    public static void main(String[] args) {
        Converter converter = new Converter();
        String[] simvol = {"+", "-", "/", "*"};
        String[] regSimvol = {"\\+", "-", "/", "\\*"};
        Scanner scan = new Scanner(System.in); //ввод инфы
        System.out.println("Введите свое выражение");
        String ent = scan.nextLine();

        // ввел пользаватель

        int regSim = -1;// определение знака
        for (int i = 0; i < simvol.length; i++) {
            if (ent.contains(simvol[i])) {
                regSim = i;
                break;
            }
        }
        if (regSim == -1) {
            System.out.println(" Отсутсвует символ операции ");
            return;
        }
        String[] info = ent.split(regSimvol[regSim]);//  деление строки по знаку
        String s1 = info[0].trim();
        String s2 = info[1].trim();
        int a;
        int b;
        if (converter.isRoman(s1) == converter.isRoman(s2)) {

            if (converter.isRoman(s1) && converter.isRoman(s2)) {// определение формата чиселVV
                a = converter.romanToInt(s1);
                b = converter.romanToInt(s2);
                if (a > 10 || b > 10) {
                    throw new IllegalArgumentException(" Числа должны быть не более 10!");
                }

                //boolean isRoman = converter.isRoman(s1);

            } else {
                a = Integer.parseInt(s1);
                b = Integer.parseInt(s2);
                if (a > 10 || b > 10) {
                    throw new IllegalArgumentException(" Числа должны быть не более 10!");
                }
            }
        } else {
            throw new NumberFormatException("Числа в разном формате, повторите попытку");
        }


        // Операции
        int result;
        switch (simvol[regSim]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            default:
                result = a / b;
                break;
        }
        if (converter.isRoman(s1)) {
            System.out.println(converter.intToRoman(result));
        } else {
            System.out.println(result);
        }
    }
}
