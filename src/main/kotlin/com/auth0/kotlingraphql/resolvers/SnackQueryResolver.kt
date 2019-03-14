package com.auth0.kotlingraphql.resolvers

import com.auth0.kotlingraphql.entity.Review
import com.auth0.kotlingraphql.entity.Snack
import com.auth0.kotlingraphql.repository.SnackRepository
import com.coxautodev.graphql.tools.GraphQLQueryResolver
import org.springframework.data.mongodb.core.MongoOperations
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import org.springframework.stereotype.Component

@Component
class SnackQueryResolver(val snackRepository: SnackRepository,
                         private val mongoOperations: MongoOperations) : GraphQLQueryResolver {
    fun snacks(): List<Snack> {
        val list = snackRepository.findAll()
        for (item in list) {
            item.reviews = getReviews(snackId = item.id)
        }
        return list
    }

    private fun getReviews(snackId: String): List<Review> {
        val query = Query()
        query.addCriteria(Criteria.where("snackId").`is`(snackId))
        return mongoOperations.find(query, Review::class.java)
    }
}