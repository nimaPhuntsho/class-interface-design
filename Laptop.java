public class Laptop extends Computer implements Comparable<Laptop>{

    /*
    * This is child class of abstract Computer class which inherits all the accessible methods from the parent class.
    * */
    private boolean isTurnedOn;
    private int ramSize;

    //Default constructor
    public Laptop () {
        this.isTurnedOn = false;
        this.ramSize = 0;
    }

    //Constructor with parameters
    public Laptop (String brandName,
                   int ssdSize,
                   int cost,
                   boolean isTurnedOn,
                   int ramSize) {
        super(brandName, ssdSize, cost);
        this.isTurnedOn = isTurnedOn;
        this.ramSize = ramSize;
    }

    //Setter for the boolean variable
    public void setTurnedOn (boolean isTurnedOn) {
        this.isTurnedOn = isTurnedOn;
    }

    //Getter for the boolean variable
    public boolean isTurnedOn()  {
        return isTurnedOn;
    }

    //Setter for ramSize
    public void setRamSize(int ramSize) {
        this.ramSize = ramSize;
    }


    //Getter for ramSize
    public int getRamSize() {
        return ramSize;
    }

    public void printDetails() {
        System.out.println("The computer details are:");
        System.out.println();
        System.out.println("Laptop Brand        : " + super.getBrandName());
        System.out.println("MemorySize          : " + super.getSsdSize());
        System.out.println("Price               : " + super.getCost());
        System.out.println("Device turned on    : " + isTurnedOn());
        System.out.println("RAM size            : " + getRamSize());
    }
    /*
    * abstract method inherited from comparable interface to compare the laptop objects based on their prices and the
    * size of the RAM. It will sort the collections in a natural ordering.
    * */
    @Override
    public int compareTo(Laptop o) {
        int result = Integer.compare(this.getCost(), o.getCost());
        if (result == 0) {
            result = Integer.compare(this.getRamSize(), o.getRamSize());
        }
        return result;
    }

    /*
    * Abstract method inherited from computer class where it prints out a simple message on the console using the
    * brandName for the particular laptop.
    * */

    @Override
    public void playGame () {
        System.out.println("Playing game on " + getBrandName());
    }
}
