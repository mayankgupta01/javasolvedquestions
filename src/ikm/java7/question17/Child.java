package ikm.java7.question17;

/**
 * Created by mayank.gupta on 31/12/16.
 */
public class Child extends Parent {
    /* private modifier gives compile error as subclass should either declare protected or public. Attempting to assign
    * weaker access privileges, private, was protected*/
    /*    @Override
     int getLocalCode(String value, boolean isValidated) {
        return super.getLocalCode(value, isValidated);
    }*/

    /*Incompatible return type with Integer, short, long*/
//    @Override
//    protected Integer getLocalCode(String value, boolean isValidated) {
//        return super.getLocalCode(value, isValidated);
//    }


    @Override
    public int getLocalCode(String value, boolean isValidated) {
        return super.getLocalCode(value, isValidated);
    }
}
