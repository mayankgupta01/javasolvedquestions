package ikm.java7;

/**
 * Created by mayank.gupta on 01/01/17.
 */
public class Question30 {

    public static void main(String[] args) {
        try{
            int number1 = Integer.parseInt(args[0]);
            int number2 = Integer.parseInt(args[1]);
            System.out.println("Answer : " + (number1 /  number2));
        }
//        catch (NumberFormatException | IndexOutOfBoundsException e) { // multi catches are not permitted
        catch (NumberFormatException e) {
             System.out.println(e.getClass());
        }
        catch (NullPointerException e) {
            System.out.println(e.getClass());
        }
        catch (Exception e) {
            System.out.println(e.getClass());
        }
    }
}
