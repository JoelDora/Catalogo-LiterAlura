package literalura;

import java.util.List;

public class Book {
    private Integer id;
    private String title;
    private List<Author> authors;
    private List<String> languages;
    private Integer download_count;

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public Integer getDownload_count() {
        return download_count;
    }
}
