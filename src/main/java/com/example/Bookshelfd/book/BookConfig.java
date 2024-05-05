package com.example.Bookshelfd.book;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class BookConfig {
    @Bean
    CommandLineRunner commandLineRunner(BookRepository bookRepository) {
        return args -> {
            Book AssassinsApprentice = new Book(
                    "sghofgh",
                    "Assassin's Apprentice",
                    new String[]{"Robin Hobb"},
                    "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1673728072i/77197.jpg",
                    "In a faraway land where members of the royal family are named for the virtues they embody, one young boy will become a walking enigma.",
                    "1995",
                    "Book",
                    new String[]{"Fiction"}
            );

            bookRepository.saveAll(
                    List.of(AssassinsApprentice)
            );
        };
    }
}
