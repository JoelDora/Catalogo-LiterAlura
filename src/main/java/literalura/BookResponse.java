package literalura;

import java.util.List;

public class BookResponse {
    private Integer count;
    private String next;
    private String previous;
    private List<Book> results;

    public List<Book> getResults() {
        return results;
    }
}
