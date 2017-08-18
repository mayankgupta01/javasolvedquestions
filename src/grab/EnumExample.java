package grab;

/**
 * Created by mayank.gupta on 17/05/17.
 */
public enum EnumExample {

    RED(10),BLUE(20),GREEN(30),YELLOW(40);

    private int colorValue;

    EnumExample(int value) {
        this.colorValue = value;
    }

    public static void makeRainBow() {
        System.out.println("Rainbow is here !");
    }

}
