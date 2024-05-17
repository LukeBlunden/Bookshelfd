package com.example.Bookshelfd.config;

import com.example.Bookshelfd.entities.Book;
import com.example.Bookshelfd.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;

//@Configuration
//public class BookConfig {
//    @Bean
//    CommandLineRunner commandLineRunner(BookRepository bookRepository) {
//        return args -> {
//            Book assassinsApprentice = new Book(
//                    "Assassin's Apprentice",
//                    "assassins-apprentice",
//                    Collections.singletonList("Robin Hobb"),
//                    "https://images-na.ssl-images-amazon.com/images/S/compressed.photo.goodreads.com/books/1673728072i/77197.jpg",
//                    "In a faraway land where members of the royal family are named for the virtues they embody, one young boy will become a walking enigma.",
//                    "1995",
//                    "Book",
//                    Collections.singletonList("Fiction")
//            );
//            Book solaris = new Book(
//                    "Solaris",
//                    "solaris",
//                    Collections.singletonList("Stanislaw Lem"),
//                    "https://upload.wikimedia.org/wikipedia/en/d/d1/SolarisNovel.jpg?20121001154852",
//                    "The first of Lem’s novels to be published in americanca and still the best known. A scientist examining the ocean that covers the surface of the planet Solaris is forced to confront the incarnation of a painful, hitherto unconscious memory, inexplicably created by the ocean. An undisputed SF classic. Translated by Joanna Kilmartin and Steve Cox.",
//                    "1987",
//                    "Book",
//                    Collections.singletonList("Fiction")
//            );
//            bookRepository.saveAll(
//                    List.of(assassinsApprentice, solaris)
//            );
//        };
//    }
//}
