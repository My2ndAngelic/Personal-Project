package aoc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Function;

public class AoCUtils {
    public static <ElementType, ListType> List<ElementType> fileImportToGeneric(String path, Function<String, ElementType> mapper   , Class<ListType> listType) throws FileNotFoundException {
        File myFile = new File(path);
        Scanner sc = new Scanner(myFile);
        List<ElementType> myData;
        if (listType.equals(ArrayList.class)) {
            myData = new ArrayList<>();
        } else if (listType.equals(LinkedList.class)) {
            myData = new LinkedList<>();
        } else { // Handle other types or throw an exception
            throw new IllegalArgumentException("Unsupported listType: " + listType);
        }

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            ElementType value = mapper.apply(line);
            myData.add(value);
        }

        sc.close();
        return myData;
    }
}
