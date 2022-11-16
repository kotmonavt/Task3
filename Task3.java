public class Task3 {
    public static void main (String[] args) {
        // 1 Количество корней уравнения
        System.out.println("1. solution: " + solution(1,0,0));
        // 2 zip
        System.out.println("2. findZip: " + findZip("zip files are zipped"));
        // 3 совершенное число
        System.out.println("3. checkPerfect: " + checkPerfect(12));
        // 4 замена строк
        System.out.println("4. flipEndChars: " + flipEndChars("Cat, dog, and mouse."));
        // 5 допустимый код
        System.out.println("5. isValidHexCode: " + isValidHexCode("#bD5C5C"));
        // 6 уникальные элементы
        System.out.println("6. same: " + same(new int[] {9,8,7,6}, new int[] {4,4,3,1}));
        // 7 число Капрекара
        System.out.println("7. isKaprekar: " + isKaprekar(5));
        // 8 самая длинна последовательность нулей
        System.out.println("8. longestZero: " + longestZero("101100100011"));
        // 9 простое число
        System.out.println("9. nextPrime: " + nextPrime(40));
        // 10 прямоугольный треугольник
        System.out.println("10. rightTriangle: " + rightTriangle(13, 12, 5));
    }

    // 1. Метод, который вычисляет количество корней квадратного уравнения
    public static int solution(int a, int b, int c) {
        if (b*b-4*a*c > 0) {
            return 2;
        } else if (b*b-4*a*c == 0) {
            return 1;
        } else {
            return 0;
        }
    }

    // 2. Метод, который проверяет число вхождений строки zip в строку
    public static int findZip(String zipp) {
        zipp = zipp.toLowerCase();
        if (zipp.indexOf("zip") != -1 && zipp.indexOf("zip") != zipp.lastIndexOf("zip")) {
            String zipp2 = zipp.substring(zipp.indexOf("zip")+3);
            return zipp2.indexOf("zip")+zipp.indexOf("zip")+3;
        }
        return -1;
    }

    // 3. Метод, который проверяет, является ли число совершенным
    public static boolean checkPerfect(int number) {
        int summ = 1;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                summ += i;
            }
        }
        return (summ == number);
    }

    // 4. Метод, который заменяет строку с условием
    public static String flipEndChars(String line) {
        if (line.length() > 2) {
            if (line.charAt(0) == line.charAt(line.length()-1)) {
                return "Two's a pair.";
            } else {
                return line.substring(line.length()-1) + line.substring(1,line.length()-1) + line.substring(0,1);
            }
        }
        return "Incompatible.";
    }

    // 5 Метод, который определяет, является ли строка допустимым кодом
    public static boolean isValidHexCode(String hexC) {
        if (hexC.charAt(0) == '#') {
            if (hexC.length() == 7) {
                boolean flag = true;
                for (int i = 1; i <= hexC.length()+1; i++)
                {
                    if (!(((int)hexC.charAt(i)>=48 && (int)hexC.charAt(i)<=81) || ((int)hexC.charAt(i)>=65 && (int)hexC.charAt(i)<=70) || (int)hexC.charAt(i)>=97 && (int)hexC.charAt(i)<=102)) {
                        flag = false;
                    }
                    return flag;
                }
            }
            return false;
        }
        return false;
    }

    // 6. Метод, который проверяет количество уникальных элементов двух массивов
    public static boolean same(int[] args1, int[] args2) {
        int summ1 = args1.length;
        int summ2 = args2.length;
        for (int i = 0; i < args1.length-1; i++) {
            int j = i;
            while (j < args1.length-1) {
                j += 1;
                if (args1[i]==args1[j]){
                    summ1 -= 1;
                    break;
                }
            }
        }
        for (int i = 0; i < args2.length-1; i++) {
            int j = i;
            while (j < args2.length-1) {
                j += 1;
                if (args2[i]==args2[j]){
                    summ2 -= 1;
                    break;
                }
            }
        }
        return summ1 == summ2;
    }

    // 7. Метод, который проверят, является ли число числом Капрекара
    public static boolean isKaprekar(int kap) {
        int kap2 = kap*kap;
        int counter = 0;
        for (int i = 1; kap2 > 0; i++) {
            kap2 = kap2 / 10;
            counter += 1;
        }
        if (counter % 2 == 0) {
            return (kap*kap/(int)Math.pow(10, counter/2) + kap*kap % (int)Math.pow(10, counter/2) == kap);
        } else {
            return (kap*kap/(int)Math.pow(10,counter/2 + 1) + kap*kap % (int)Math.pow(10, counter/2+1) == kap);
        }

    }

    // 8. Метод, который возвращает самую длинную последовательность нулей
    public static String longestZero(String line) {
        int maxCount = 0;
        int count = 0;
        String exitLine = "";
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '0') {
                count ++;
            } else {
                maxCount = Math.max(count, maxCount);
                count =0;
            }
        }
        for (int i = 0; i < maxCount; i++) {
            exitLine += "0";
        }
        return exitLine;
    }

    // 9. Метод, который находит следующее простое число или возвращает данное, если оно простое
    public static int nextPrime(int numb) {
        boolean flag = false;
        // проверка на то, является ли заданное число простым
        for (int i = 2; i < numb / 2 + 1; i++) {
            if (numb % i == 0) {
                flag = true;
            }
        }
        // если заданное число не простое - входим в цикл проверки, пока не найдем следующее простое
        if (flag == true) {
            boolean flag2 = true;
            while (flag2) {
                numb += 1;
                for (int i = 2; i < numb / 2 + 1; i++) {
                    if (numb % i == 0) {
                        //перестаем проверять при первом же наличии делителя, чтобы ускорить проверку
                        break;
                    }
                    // если дошли до конца и последнее число все так же не делится, то нашли то самое простое
                    if (i == numb/2 && numb % i != 0){
                        flag2 = false;
                    }
                }
            }
        }
        return numb;
    }

    // 10. Метод, который проверяет, являтся ли треугольник прямоугольным
    public static boolean rightTriangle(int x, int y, int z) {
        if ((x + y > z) && (x + z > y) && (y + z > x)){
            return ((x*x + y*y == z*z) || (y*y + z*z == x*x) || (x*x + z*z == y*y));
        }
        return false;
    }
}