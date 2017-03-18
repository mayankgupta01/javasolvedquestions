package ikm.java7;

/**
 * Created by mayank.gupta on 01/01/17.
 */
public class Question31 {
    public static void main(String[] args) {
        Long l = new Long(1234);
        Long ll = l;

        if(l == ll){
            System.out.println("Equal Objects");
            System.out.println("Hashcode of l = " + l.hashCode());
            System.out.println("Hashcode of ll = " + ll.hashCode());
        }
        else
            System.out.println("Not Equal Objects");
        l++;
        if(l == ll)
            System.out.println("Equal Objects");
        else
            System.out.println("Not Equal Objects");
        System.out.println("Value of l = " + l);
        System.out.println("Value of ll = " + ll);
        System.out.println("Hashcode of l = " + l.hashCode());
        System.out.println("Hashcode of ll = " + ll.hashCode());
    }

}
