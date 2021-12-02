package starter.pages;

import org.junit.Test;
import starter.utils.LoggerClass;
import java.util.Random;

public class GeneratorCnp {

    private int getRandomMonth;
    private int getRandomDay;
    private int getRandomCity;
    private int integer;
    private int randomNr1;
    private int randomNr2;
    private int randomNr3;

    @Test
    public void cnpGenerator() {

        //Generation on sex, year, month, day numbers
        generateRandomMonth();
        generateRandomCity();
        generateRandomDay();

        int[] arraySex = {1, 2, 5, 6};
        int sexPersoana = randomFromArray(arraySex);
        LoggerClass.info("SEX is " + sexPersoana);

        int year = generateRandomNr(1920, 2002);
        LoggerClass.info("AN " + year);

        //Assign correct sex according to year
        if (year >= 2000 && sexPersoana == 1) {
            sexPersoana = 5;
            LoggerClass.info("Changed sexInt to 5");
        } else if (year >= 2000 && sexPersoana == 2) {
            sexPersoana = 6;
            LoggerClass.info("Changed sexInt to 6");
        } else if (year <= 1999 && sexPersoana == 5) {
            sexPersoana = 1;
            LoggerClass.info("Changed sexInt to 1");
        } else if (year <= 1999 && sexPersoana == 6) {
            sexPersoana = 2;
            LoggerClass.info("Changed sexInt to 2");
        }

        //Year format
        String yearString = String.valueOf(year);
        char year1Char = yearString.charAt(2);
        char year2Char = yearString.charAt(3);
        int yearInt1 = Character.getNumericValue(year1Char);
        int yearInt2 = Character.getNumericValue(year2Char);

        LoggerClass.info("Sex is " + sexPersoana);
        LoggerClass.info("yearInt1 is " + yearInt1);
        LoggerClass.info("yearInt2 is " + yearInt2);
        LoggerClass.info("Luna 1 is " + formatMonth("firstValue"));
        LoggerClass.info("Luna 2 is " + formatMonth("secondValue"));
        LoggerClass.info("Zi 1 is " + formatDay("firstValue"));
        LoggerClass.info("Zi 2 is " + formatDay("secondValue"));
        LoggerClass.info("Judet 1 is " + formatCity("firstValue"));
        LoggerClass.info("Judet 2 is " + formatCity("secondValue"));

        this.randomNr1 = generateRandomNr(1, 9);
        this.randomNr2 = generateRandomNr(1, 9);
        this.randomNr3 = generateRandomNr(1, 9);

        //Calculate control number
        int sexInt = sexPersoana * 2;
        int year1Calculated = yearInt1 * 7;
        int year2Calculated = yearInt2 * 9;
        int month1Calculated = Integer.parseInt(formatMonth("firstValue"));
        int month2Calculated = Integer.parseInt(formatMonth("secondValue")) * 4;
        int day1Calculated = Integer.parseInt(formatDay("firstValue")) * 6;
        int day2Calculated = Integer.parseInt(formatDay("secondValue")) * 3;
        int city1Calculated = Integer.parseInt(formatCity("firstValue")) * 5;
        int city2Calculated = Integer.parseInt(formatCity("secondValue")) * 8;
        int randomCalculatedNr1 = getRandomNr1() * 2;
        int randomCalculatedNr2 = getRandomNr2() * 7;
        int randomCalculatedNr3 = getRandomNr3() * 9;

        int sum = sexInt + year1Calculated + year2Calculated + month1Calculated
                + month2Calculated + day1Calculated + day2Calculated + city1Calculated
                + city2Calculated + randomCalculatedNr1 + randomCalculatedNr2 + randomCalculatedNr3;

        int controlNumber = sum % 11;

        if (controlNumber == 10) {
            controlNumber = 1;
        }

        LoggerClass.info("Cifra control egal " + controlNumber);

        String CNP = sexPersoana
                + String.valueOf(yearInt1)
                + yearInt2
                + formatMonth("firstValue")
                + formatMonth("secondValue")
                + formatDay("firstValue")
                + formatDay("secondValue")
                + formatCity("firstValue")
                + formatCity("secondValue")
                + getRandomNr1()
                + getRandomNr2()
                + getRandomNr3()
                + controlNumber;

        LoggerClass.info(CNP);
//        return CNP;
    }

    //Month, day city format
    public String formatMonth(String value) {
        integer = getRandomMonth();
        return generalFormat(value);
    }

    public String formatDay(String value) {
        integer = getRandomDay();
        return generalFormat(value);
    }

    public String formatCity(String value) {
        integer = getRandomCity();
        return generalFormat(value);
    }

    public static int generateRandomNr(int low, int high) {
        Random r = new Random();
        return r.nextInt(high - low) + low;
    }

    public static int randomFromArray(int[] myArray) {
        Random generator = new Random();
        int randomIndex = generator.nextInt(myArray.length);
        return myArray[randomIndex];
    }

    public void generateRandomMonth() {
        Random r = new Random();
        this.getRandomMonth = r.nextInt(12 - 1) + 1;
    }

    public void generateRandomDay() {
        Random r = new Random();
        this.getRandomDay = r.nextInt(28 - 1) + 1;
    }

    public String generalFormat(String value) {
        String result = "0";
        if (integer < 10) {
            String integer1 = "0";
            if (value.equalsIgnoreCase("firstValue")) {
                result = integer1;
            } else if (value.equalsIgnoreCase("secondValue")) {
                result = String.valueOf(integer);
            }
        } else {
            char var1 = String.valueOf(integer).charAt(0);
            char var2 = String.valueOf(integer).charAt(1);
            if (value.equalsIgnoreCase("firstValue")) {
                result = String.valueOf(var1);
            } else if (value.equalsIgnoreCase("secondValue")) {
                result = String.valueOf(var2);
            }
        }
        return result;
    }

    //Getters
    public void generateRandomCity() {
        this.getRandomCity = generateRandomNr(1, 46);
    }

    public int getRandomMonth() {
        return getRandomMonth;
    }

    public int getRandomCity() {
        return getRandomCity;
    }

    public int getRandomDay() {
        return getRandomDay;
    }

    public int getRandomNr1() {
        return randomNr1;
    }

    public int getRandomNr2() {
        return randomNr2;
    }

    public int getRandomNr3() {
        return randomNr3;
    }
}
