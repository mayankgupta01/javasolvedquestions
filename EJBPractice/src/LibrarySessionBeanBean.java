import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mayank.gupta on 02/01/17.
 */
@Stateless(name = "LibrarySessionBeanEJB")
public class LibrarySessionBeanBean implements LibrarySessionBeanRemote {
    public LibrarySessionBeanBean() {
        bookShelf = new ArrayList<String>();
    }
    List<String> bookShelf;

    @Override
    public void addBook(String bookName) {

    }

    @Override
    public List getBooks() {
        return null;
    }
}
