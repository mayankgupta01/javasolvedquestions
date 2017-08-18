package udemy.masterOOdesign.ems.builder;

/**
 * Created by mayank.gupta on 19/05/17.
 */
public class BuilderTester {

    public static void main(String[] args) {
        Vehicle maruti = new Vehicle.Builder("A-star",330000.5).color("Silver").companyName("Maruti").doors(4).build();
        System.out.println(maruti);
    }
}
