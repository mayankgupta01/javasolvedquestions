import java.util.ArrayList;

/**
 * Created by mayank.gupta on 07/12/16.
 */
public class IdentifySubArray {

    public void findInstanceOfSecondArrayInFirst(int[] parent, int[] child) {
        System.out.printf("Looking for array : \n" , child, "\n Inside array : \n ", parent);
        for(int i = 0; i < parent.length; i++) {
            if ((child[0] == parent[i]) && child.length < (parent.length - i)) {
                for(int j  = i; j < i + child.length; j++) {

                }
            }
        }
    }
}
