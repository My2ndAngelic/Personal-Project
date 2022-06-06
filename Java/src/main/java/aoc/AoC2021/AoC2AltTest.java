package aoc.AoC2021;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class AoC2AltTest {
    public static void main(String[] args) throws FileNotFoundException {
        // Problem 1
        AoC2Alt aoC2Alt = new AoC2Alt(AoCUtilities.fileImportToStringArrayList(System.getProperty("user.dir") + "/src/aoc.AoC2021/input/input2.txt"));
        ArrayList<String> data = aoC2Alt.getData();
        for (String s : data) {
            String[] ss = s.split(" ");
            aoC2Alt.changePos1(ss[0], Integer.parseInt(ss[1]));
        }
        System.out.println(aoC2Alt.getPos());

        AoC2Alt aoC2Alt2 = new AoC2Alt(AoCUtilities.fileImportToStringArrayList(System.getProperty("user.dir") + "/src/aoc.AoC2021/input/input2.txt"));
        data = aoC2Alt2.getData();
        // Problem 2
        for (String s : data) {
            String[] ss = s.split(" ");
            aoC2Alt2.changePos2(ss[0], Integer.parseInt(ss[1]));
        }
        System.out.println(aoC2Alt2.getPos());
    }
}
