public abstract class Computer implements ElectronicDevice{
    private String brandName;  //stores the name of the computer brand.
    private int ssdSize; //stores the size of the SSD card.
    private int cost; //stores the cost of the computer.

    //Default constructor
    public Computer () {
        this.brandName = "";
        this.cost = 0;
        this.ssdSize = 0;
    }

    //Second constructor with parameters
    public Computer (String brandName, int ssdSize, int cost) {
        this.brandName = brandName;
        setSsdSize(ssdSize);
        setCost(cost);
    }

    /*
    * Abstract method, the method does have a body because implementation of the method will be different for
    * different subclasses of the computer and the method returns nothing.
    * */
    public abstract void playGame ();

    /*
    * Non-abstract method, the method takes in a String type parameter (brandName) and prints out a message
    * using the argument provide when calling the method.
    * */
    public void greetMessage (String brandName) {
        System.out.println("You are using " + brandName);
    }

    /*
    * Non-Abstract method, this is one of the few methods of the computer class where it prints out a message
    * */
    public void shutDown () {
        System.out.println("Press the power button to shut down the computer");
    }


    /*
    * The generic method is inherited from the electronic device interface and the implementation of the method simply
    * prints out a message using the argument passed on when calling the method.
    * */
    public <T> void turnOn(T device) {
        System.out.println("press the green button to start " + device);
    }

    /*
     * The generic method is inherited from the electronic device interface and the implementation of the method simply
     * prints out a message using the argument passed on when calling the method.
     * */
    @Override
    public <T> void playMusic(T songName) {
        System.out.println("listening to " + songName);
    }

    //Setter for brandName
    public void setBrandName (String brandName) {
        this.brandName = brandName;
    }

    //Getter for brandName
    public String getBrandName () {
        return this.brandName;
    }

    //Setter for ssdSize
    public void setSsdSize(int ssdSize) {
        if (ssdSize <= 0) System.out.println("SSD size cannot be 0 or less than 0");
        else this.ssdSize=ssdSize;
    }

    //Getter for ssdSize
    public int getSsdSize() {
        return this.ssdSize;
    }


    //Setter for cost
    public void setCost (int cost) {
        if (cost <= 0) {
            System.out.println("Cost cannot be 0 or less than 0");
        } else {
            this.cost = cost;
        }
    }

    //Getter for cost
    public int getCost () {
        return this.cost;
    }
}
