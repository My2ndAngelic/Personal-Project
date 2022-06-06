package hello;

public class StringSwitchCaseExample {
    public static void main(String[] args) {
        String hello = "a";

        switch (hello) {
            case "a" -> System.out.println("Alice");
            case "b" -> System.out.println("Bob");
            case "c" -> System.out.println("Charlie");
            default -> System.out.println("I don't know your name.");
        }
    }
}

