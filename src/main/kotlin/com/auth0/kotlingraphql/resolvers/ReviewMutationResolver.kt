package com.auth0.kotlingraphql.resolvers

import com.coxautodev.graphql.tools.GraphQLMutationResolver
import com.auth0.kotlingraphql.entity.Review
import com.auth0.kotlingraphql.repository.ReviewRepository
import org.springframework.stereotype.Component

@Component
class ReviewMutationResolver (private val reviewRepository: ReviewRepository): GraphQLMutationResolver {
    fun newReview(snackId: String, rating: Int, text:String): Review {
        val review = Review(snackId, rating, text)
        reviewRepository.save(review)
        return review
    }
}