package com.auth0.kotlingraphql.resolvers

import com.auth0.kotlingraphql.entity.Snack
import com.auth0.kotlingraphql.repository.SnackRepository
import com.coxautodev.graphql.tools.GraphQLMutationResolver
import org.springframework.stereotype.Component
import java.util.*

@Component
class SnackMutationResolver (private val snackRepository: SnackRepository): GraphQLMutationResolver {
    fun newSnack(name: String, amount: Float): Snack {
        val snack = Snack(name, amount)
        snack.id = UUID.randomUUID().toString()
        snackRepository.save(snack)
        return snack
    }

    fun deleteSnack(id:String): Boolean {
        snackRepository.deleteById(id)
        return true
    }

    fun updateSnack(id:String, amount:Float): Snack {
        val snack = snackRepository.findById(id)
        snack.ifPresent {
            it.amount = amount
            snackRepository.save(it)
        }
        return snack.get()
    }
}