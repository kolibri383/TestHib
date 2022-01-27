package com.example.testhib.service

import com.example.testhib.model.Author

interface AuthorService {
    fun findById(id:Long):Author
    fun create(newAuthor:Author)
    fun findAll():List<Author>
    fun delete(id:Long)
    fun findAuthorByName(firstName: String,lastName:String):Author

}