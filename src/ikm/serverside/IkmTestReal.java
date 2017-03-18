package ikm.serverside;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Created by mayank.gupta on 06/01/17.
 */
public class IkmTestReal {
    public static void main(String[] args) {
        SortedSet<Element> s = new TreeSet<Element>();
        s.add(new Element(15));
        s.add(new Element(10));
        s.add(new Element(25));
        s.add(new Element(10));
        System.out.println(s.first() + " " + s.size());
    }
}

class Element implements Comparable {
    int id;
    Element(int id) {
        this.id = id;
    }

    public int compareTo(Object obj) {
        Element e = (Element) obj;
        return this.id - e.id;

    }

    public String toString() {
        return "" + this.id;
    }
}