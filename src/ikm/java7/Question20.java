package ikm.java7;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayank.gupta on 31/12/16.
 */
public class Question20 {
//    http://javarevisited.blogspot.in/2011/09/javalangoutofmemoryerror-permgen-space.html
//    http://www.cubrid.org/blog/dev-platform/how-to-tune-java-garbage-collection/
    List<?> myList = new ArrayList<String>();
}
