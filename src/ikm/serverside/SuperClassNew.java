package ikm.serverside;

/**
 * Created by mayank.gupta on 06/01/17.
 */
public class SuperClassNew {

    int index = 1;
    public void printTypeName() {
        System.out.println("superclass");
    }
}

class SubClassNew extends SuperClassNew{
    int index = 2;
    public void printTypeName() {
        System.out.println("subclass");
    }
}

class Test {
    public static void main(String[] args) {
        SuperClassNew superClassNew = new SubClassNew();
        superClassNew.printTypeName();
        System.out.println("," + superClassNew.index);
    }
}
