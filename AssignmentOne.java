import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.function.Predicate;

public class AssignmentOne {
    public static void main(String[] args) {
        NumberFormat currency = NumberFormat.getCurrencyInstance(); //

        // Part 2 – Using abstract classes and interfaces
        //First object created using the default constructor.
        Laptop lenovo = new Laptop();


        //Second object created using the constructor with parameters.
        Laptop mac = new Laptop("apple", 450, 2400, false, 16);
        mac.printDetails();
        System.out.println("------------------------------");

        // Part 3 – Polymorphism
        /*Polymorphism in a simple term means many forms. The below method DemonstratePolymorphism() takes a Laptop object
        as a parameter and the object will inherit the playGame() methods from abstract computer class. Since it is an abstract
        method, the implementation of the method will be different for different subclasses of the Computer class. In
        this case I am simply printing "Playing game on the particular device" but same method will perform different
        tasks in different subclasses of the Computer class.
        This is polymorphism where the methods perform a single action in different ways
        */
        DemonstratePolymorphism(new Laptop("samsung", 128, 1800, false, 8));
        System.out.println("------------------------------");

        // Part 4 – Generic classes
        //The laptop objects are stored in an array list.
        ArrayList <Laptop> laptops = new ArrayList<>();
        laptops.add(new Laptop("LG", 250, 1000, true, 32));
        laptops.add(new Laptop("Dell", 128, 1321, false, 4));
        laptops.add(new Laptop("Sony", 520, 1334, false, 16));
        laptops.add(new Laptop("Xolo", 320, 424, true, 33));
        laptops.add(new Laptop("HP", 250, 820, true, 64));
        System.out.println("------------------------------");

        // Part 5 - Generic methods
        /*
        * Sort method is called from the collection class to sort the laptop objects in a natural order.
        * */
        laptops.sort(null);
        System.out.println("{ SORTED LISTS OF LAPTOPS }");
        for (Laptop elements: laptops) {
            System.out.println("Price :" + currency.format(elements.getCost()) +"  " +
                                "RAM size : " + elements.getRamSize());
        }
        System.out.println("------------------------------");

        // Part 6 - Wildcards
        /*
         * Wildcard <?> represents any unknown type in a generic programming which can be used as a parameter, field
         * or local variable.
         * Upper bound wildcard is used in the method which allows the type parameters to cope with the types that are in the
         * super class. The method demonstrateWildcards takes an arraylist of laptop objects as a parameter and each object calls a
         * method from the computer class. The method parameter can take any type of arraylist as long as the type
         * is the subclass of computer class.
         **/
        DemonstrateWildcards(laptops);
        System.out.println("------------------------------");

        // Part 7 - Simple lambda expressions
        /*
        * Lambda expression is an anonymous function which does not have method name, consist of arrow token and it can
        * be used with or without parameters. As the method takes in two parameter, laptop reference predicate as Predicate
        * interface and the list of laptops created in part 4 as the second argument are used to demonstrate how to
        * write a simple lambda expression.
        * */
        DemonstrateLambdas(Laptop::isTurnedOn, laptops);
        System.out.println("------------------------------");
    }

    public static void DemonstratePolymorphism(Computer computer) {
        computer.playGame();
    }

    /*
    * The method parameter takes an Arraylist of any subclass (any type denoted by ?) of the abstract computer class.
    * The list of array objects loops and a method of the class is called and in this case, getCost method is called on
    * each object. If there is another subclass of Computer class, the method will be able to take an array of that
    * particular class and implement the method body as directed.
    * */
    public static void DemonstrateWildcards(ArrayList<? extends Computer> arr) {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        for (Computer elements: arr) {
            System.out.println(currency.format(elements.getCost()));
        }
    }

    /*
    * The method has two parameter, an interface (Predicate) and an arraylist of laptop objects. It loops through
    * the objects and checks if certain condition is true or false by calling the test method from the predicate
    * reference. In this case, it validates if the laptop objects are new or old and prints out a message according to
    * the result.
    *
    * */
    public static void DemonstrateLambdas(Predicate <Laptop> predicate, ArrayList <Laptop> laptopList ) {
        for (Laptop elements: laptopList) {
            if (predicate.test(elements)) {
                System.out.println(elements.getBrandName() + " : The device is turned on, it is probably used or demo");
            } else {
                System.out.println(elements.getBrandName() + " : The device is turned off, it is probably brand newr");
            }
        }
    }
}
