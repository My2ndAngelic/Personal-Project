package aoc.AoC2020;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class AoC9 {
    public static void main(String[] args) {
        List<String> al = new ArrayList<>();
        try {
            al = CommonUsage.fileReader(System.getProperty("user.dir") + "/src/aoc.AoC2020/input/input9.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Long> al2 = al.stream().map(Long::parseLong).collect(Collectors.toList());
        int s = 25;
        {
            for (int i = 0; i < al2.size() - s - 1; i++) {
                List<Long> al3 = al2.subList(i, i + s);
                ArrayList<Long> al4 = new ArrayList<>();
                Long d = al2.get(i + s);
                for (int j = 0; j < al3.size() - 1; j++) {
                    for (int k = j + 1; k < al3.size(); k++) {
                        al4.add(al3.get(j) + al3.get(k));
                    }
                }
                if (!al4.contains(d)) {
                    System.out.println(d);
                    long d2;
                    for (int j = 0; j < al2.size() - 1; j++) {
                        d2 = al2.get(j);
                        for (int k = j + 1; k < al2.size(); k++) {
                            d2 += al2.get(k);
                            if (d2 == d) {
                                List<Long> al5 = al2.subList(j, k + 1);
                                Collections.sort(al5);
                                System.out.println(al5);
                                System.out.println(al5.get(0) + al5.get(al5.size() - 1));
                                break;
                            }
                        }
                    }

                }
            }
        }
    }
}
