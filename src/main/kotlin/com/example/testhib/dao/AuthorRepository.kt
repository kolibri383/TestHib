package com.example.testhib.dao

import com.example.testhib.model.Author
import org.hibernate.annotations.SQLInsert
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.io.Serializable

@Repository
interface AuthorRepository: JpaRepository<Author, Serializable> {
    @Query("select a from Author a where a.firstName=?1 and a.lastName=?2 ")
    fun findAuthorByName(firstName: String,lastName:String):Author

}