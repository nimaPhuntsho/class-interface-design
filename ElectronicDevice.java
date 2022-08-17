public interface ElectronicDevice {
    /*
    * These are the two generic methods for all the electronic device. The method takes a T type (any data type) as a
    * parameter and returns nothing. These methods will be accessible on those classes which implements this interface
    * */
    <T> void turnOn (T device);
    <T> void playMusic (T songName);
}
