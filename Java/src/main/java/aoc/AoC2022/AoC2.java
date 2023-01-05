package aoc.AoC2022;

import lombok.SneakyThrows;

import java.util.Random;

public class AoC2 {
    @SneakyThrows
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println(new Random().nextInt(69));
        }


    }
}
