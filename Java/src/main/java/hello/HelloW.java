package hello;

public class HelloW {
    public void display() {
        System.out.println("Meow");
    }
}

class ChoiceHelloW extends HelloW {
    @Override
    public void display() {
        super.display();
        System.out.println("Woof");
    }
}

class UrMom {
    public static void main(String[] args) {
        HelloW h1 = new HelloW();
        ChoiceHelloW h2 = new ChoiceHelloW();

        displayQ(h1);
        displayQ(h2);
    }

    public static void displayQ(HelloW hw) {
        hw.display();
    }
}
