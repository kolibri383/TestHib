package com.example.testhib.service

import com.example.testhib.dao.AuthorRepository
import com.example.testhib.model.Author
import org.springframework.stereotype.Service

@Service
class AuthorServiceImpl(
    val authorRepository: AuthorRepository,
) : AuthorService {

    override fun findById(id: Long): Author =
        authorRepository.findById(id).orElseThrow()

    override fun create(newAuthor: Author) {
        val author = Author(

            firstName = newAuthor.firstName,
            lastName = newAuthor.lastName,
            books = newAuthor.books
        )
        authorRepository.save(author)
    }

    override fun findAll(): List<Author> = authorRepository.findAll().toList()
    override fun delete(id: Long) {
        authorRepository.delete(findById(id))
    }

    override fun findAuthorByName(firstName: String, lastName: String):Author =
        authorRepository.findAuthorByName(firstName,lastName)



}