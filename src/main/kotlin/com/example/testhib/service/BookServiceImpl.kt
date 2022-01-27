package com.example.testhib.service

import com.example.testhib.dao.BookRepository
import com.example.testhib.model.Book
import org.hibernate.annotations.OrderBy
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service("book_service")
class BookServiceImpl(
    @Autowired
    val bookRepository: BookRepository
) : BookService {
    override fun findAllBooks(): List<Book> = bookRepository.findAll().toList()

    override fun findBookById(id: Long): Book = bookRepository.findById(id).orElseThrow()

    override fun findBooksByAuthor(firsName: String, lastName: String): List<Book> =
        bookRepository.allBooksByAuthor(firsName,lastName)


    override fun addBook(newBook: Book) {
        val book = Book(
            title = newBook.title,
            author = newBook.author,
        )
        bookRepository.save(book)
    }

    override fun deleteBookById(id: Long) {
        bookRepository.delete(findBookById(id = id))
    }

    override fun findAllBookSorting(firsName: String, lastName: String): List<Book> =
        bookRepository.findBookByAuthor_FirstNameAndAuthor_LastNameOrderByTitle(firsName,lastName)

}