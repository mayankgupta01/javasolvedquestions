import javax.ejb.Remote;
import java.util.List;

/**
 * Created by mayank.gupta on 02/01/17.
 */
@Remote
public interface LibrarySessionBeanRemote {
    public void addBook(String bookName);
    List getBooks();
}
