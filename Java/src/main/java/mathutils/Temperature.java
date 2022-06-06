package mathutils;

import java.text.DecimalFormat;

public class Temperature {

    /**
     * Main method for testing
     *
     * @param args do not care
     */
    public static void main(String[] args) {
        String tempK = "420.15K";
        String tempF = "69F";
        String tempC = "37C";
        DecimalFormat df = new DecimalFormat("#0.00");
        System.out.println(df.format(tempConverter(tempK, "K")));
        System.out.println(df.format(tempConverter(tempK, "F")));
        System.out.println(df.format(tempConverter(tempK, "C")));
        System.out.println(df.format(tempConverter(tempF, "K")));
        System.out.println(df.format(tempConverter(tempF, "F")));
        System.out.println(df.format(tempConverter(tempF, "C")));
        System.out.println(df.format(tempConverter(tempC, "K")));
        System.out.println(df.format(tempConverter(tempC, "F")));
        System.out.println(df.format(tempConverter(tempC, "C")));
    }

    /**
     * Convert your temperature. Support: K, F, C. Note: 1K = 273.15oC
     *
     * @param sourceString source temperature in String. Example: 420.15K, 69F, 37C
     * @param destTemp     destination temperature. Support: K, F, C
     * @return temperature value in double.
     */
    public static double tempConverter(String sourceString, String destTemp) {
        String sourceTemp = sourceString.substring(sourceString.length() - 1);
        double inputTemperature = Double.parseDouble(sourceString.substring(0, sourceString.length() - 1));
        switch (sourceTemp.toUpperCase()) {
            case "K":
                switch (destTemp.toUpperCase()) {
                    case "K":
                        return inputTemperature;
                    case "F":
                        return (inputTemperature - 273.15) * 9 / 5 + 32;
                    case "C":
                        return inputTemperature - 273.15;
                }
            case "F":
                switch (destTemp) {
                    case "K":
                        return (inputTemperature - 32) / 9 * 5 + 273.15;
                    case "F":
                        return inputTemperature;
                    case "C":
                        return (inputTemperature - 32) / 9 * 5;
                }
            case "C":
                switch (destTemp) {
                    case "K":
                        return inputTemperature + 273.15;
                    case "F":
                        return inputTemperature * 9 / 5 + 32;
                    case "C":
                        return inputTemperature;
                }
        }
        throw new IllegalArgumentException("Check your input.");
    }
}
