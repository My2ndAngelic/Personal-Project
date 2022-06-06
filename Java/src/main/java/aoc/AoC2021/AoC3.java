package aoc.AoC2021;

import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AoC3 {
    public static int problemOne(ArrayList<String> dataIn) {
        StringBuilder gamma = new StringBuilder();
        StringBuilder epsilon = new StringBuilder();
        int length = dataIn.get(0).length();
        IntStream.range(0, length).forEach(i -> {
            int zero = count(dataIn, i, '0');
            int one = count(dataIn, i, '1');
            if (zero > one) {
                gamma.append(0);
                epsilon.append(1);
            } else {
                gamma.append(1);
                epsilon.append(0);
            }
        });
        return Integer.parseInt(gamma.toString(), 2) * Integer.parseInt(epsilon.toString(), 2);
    }

    public static int count(ArrayList<String> dataIn, int pos, char what) {
        int output = 0;
        for (String s : dataIn) {
            if (s.charAt(pos) == what) {
                output++;
            }
        }
        return output;
    }

    public static int problemTwo(ArrayList<String> dataIn) {
        ArrayList<String> dataTemp = dataIn;
        int i = 0;
        while (dataTemp.size() > 1) {
            int zero = count(dataTemp, i, '0');
            int one = count(dataTemp, i, '1');
            dataTemp = one >= zero ? arrayListExtractor(dataTemp, i, '1') : arrayListExtractor(dataTemp, i, '0');
            i++;
        }
        String O2 = dataTemp.get(0);

        i = 0;
        dataTemp = dataIn;
        while (dataTemp.size() > 1) {
            int zero = count(dataTemp, i, '0');
            int one = count(dataTemp, i, '1');
            dataTemp = zero <= one ? arrayListExtractor(dataTemp, i, '0') : arrayListExtractor(dataTemp, i, '1');
            i++;
        }
        String CO2 = dataTemp.get(0);
        return Integer.parseInt(O2, 2) * Integer.parseInt(CO2, 2);
    }

    public static ArrayList<String> arrayListExtractor(ArrayList<String> dataIn, int pos, char what) {
        return dataIn.stream().filter(e -> e.charAt(pos) == what).collect(Collectors.toCollection(ArrayList::new));
    }
}
