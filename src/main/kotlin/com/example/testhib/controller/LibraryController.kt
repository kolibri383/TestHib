package com.example.testhib.controller

import com.example.testhib.model.Author
import com.example.testhib.model.Book
import com.example.testhib.service.AuthorService
import com.example.testhib.service.BookService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RequestMapping("/author")
@RestController
class AuthorController (
    @Autowired val authorService: AuthorService){

    @ResponseStatus(HttpStatus.FOUND)
    @GetMapping("/{id}")
    fun getAuthorById(@PathVariable id:Long) = authorService.findById(id)

    @ResponseStatus(HttpStatus.CREATED)
    @PutMapping
    fun addNewAuthor(@RequestBody author: Author){
        authorService.create(author)
    }

    @GetMapping
    fun findAllAuthors() = authorService.findAll()

    @ResponseStatus(HttpStatus.CONTINUE)
    @DeleteMapping("/{id}")
    fun deleteAuthorById(@PathVariable id:Long) = authorService.delete(id)

    @GetMapping("/name")
    fun findAuthorByName(@RequestBody author: Author) =
        authorService.findAuthorByName(author.firstName,author.lastName)
}

@RequestMapping("/book")
@RestController
class BookController(
    @Autowired
    @Qualifier("book_service")
    val bookService: BookService,
    ){

    @GetMapping
    fun findAllBooks() = bookService.findAllBooks()


    @GetMapping("/{id}")
    fun findBookById(@PathVariable id:Long) = bookService.findBookById(id)

    @PutMapping
    fun addNewBoo(@RequestBody book: Book){
        bookService.addBook(book)
    }
    @DeleteMapping("/{id}")
    fun deleteBookById(@PathVariable id: Long){
        bookService.deleteBookById(id)
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/author")
    fun findBookByAuthor(@RequestBody author: Author) =
        bookService.findBooksByAuthor(author.firstName,author.lastName)

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @GetMapping("/sorting")
    fun findAllBookSorting(@RequestBody author:Author) :List<Book> {
        return bookService.findAllBookSorting(author.firstName, author.lastName)
    }

}