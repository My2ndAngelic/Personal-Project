package aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class AoCUtils {
    public static <T> List<T> fileImportToGeneric(String path, Function<String, T> mapper) throws FileNotFoundException {
        File myFile = new File(path);
        Scanner sc = new Scanner(myFile);
        List<T> myData = new ArrayList<T>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            T value = mapper.apply(line);
            myData.add(value);
        }

        sc.close();
        return myData;
    }
}
