package bg.softuni.bookshop.service;

import bg.softuni.bookshop.data.repositories.AuthorRepository;

import java.io.IOException;

public interface AuthorService {

    void seedAuthors() throws IOException;

    boolean areAuthorsImported();

    void printAllAuthorsWithOneBookBefore1990();

    void printAllAuthorsWithDescCount();
}
