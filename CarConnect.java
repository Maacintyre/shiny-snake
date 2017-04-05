package carconnect;

public class CarConnect {

  public static void main(String[] args) {
    System.out.println("Hello World!!!");
    firstTest();
  }

  public static void firstTest() {
    System.out.println("Beginning test: ");

    System.out.println("Creating car: ");
    BasicCar testCar = new BasicCar(0,"lemon");
    System.out.println("testCar Id: " + testCar.getID());
    System.out.println("testCar model: " + testCar.getModel());
    testCar.drive(0);
    System.out.println("");

    System.out.println("Creating car1: ");
    BasicCar testCar1 = new BasicCar(1, "lime", 0.5d, 0.7d, 0.9d);
    System.out.println("testCar1 Id: " + testCar1.getID());
    System.out.println("testCar1 model: " + testCar1.getModel());
    System.out.println("testCar1 direction: " + testCar1.getDirection());
    System.out.println("testCar1 longitude: " + testCar1.getyPos());
    System.out.println("testCar1 latitude: " + testCar1.getxPos());
    testCar1.drive(0);
    System.out.println("");

    System.out.println("Creating smartCar1: ");
    SmartCar testCar2 = new SmartCar(2, "and coconut", 0.5d, 0.7d, 0.9d);
    System.out.println("testCar2 Id: " + testCar2.getID());
    System.out.println("testCar2 model: " + testCar2.getModel());
    System.out.println("testCar2 direction: " + testCar2.getDirection());
    System.out.println("testCar2 longitude: " + testCar2.getyPos());
    System.out.println("testCar2 latitude: " + testCar2.getxPos());
    testCar2.drive(0);
    testCar2.setSpeed(0.0d);
    testCar2.setAcceleration(0.0d);
    testCar2.send();
    testCar2.send(3,"HelloWorld!!!");
    System.out.println("");

    System.out.println("Ending test: ");
  }
}
