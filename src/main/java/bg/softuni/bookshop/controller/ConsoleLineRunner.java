package bg.softuni.bookshop.controller;


import bg.softuni.bookshop.service.AuthorService;
import bg.softuni.bookshop.service.BookService;
import bg.softuni.bookshop.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component //Engine pattern
public class ConsoleLineRunner implements CommandLineRunner {
    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;

    @Autowired
    public ConsoleLineRunner(CategoryService categoryService, AuthorService authorService, BookService bookService) {
        this.categoryService = categoryService; // always use the interface
        this.authorService = authorService;
        this.bookService = bookService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (!this.categoryService.isImported()) {
            this.categoryService.seedCategories();
        }
        if (!this.authorService.areAuthorsImported()) {
            this.authorService.seedAuthors();
        }
        if (!this.bookService.areBooksImported()) {
            this.bookService.seedBooks();
        }
        this.bookService.printAllBooksAfter2000();
        this.authorService.printAllAuthorsWithOneBookBefore1990();
        this.authorService.printAllAuthorsWithDescCount();
        this.bookService.printAllBooksFromGeorge();
    }
}
