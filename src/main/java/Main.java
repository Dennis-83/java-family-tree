import org.w3c.dom.ls.LSOutput;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");


        Person batman = new Person("Bruce", "Wayne", 22, "male");

        Person son = new Person("Damian", "Wayne", 5, "male");
//        batman.addChild(son);
        System.out.println(batman);
        System.out.println(son);
        batman.addChild(son);
        System.out.println(batman);
    }

}
