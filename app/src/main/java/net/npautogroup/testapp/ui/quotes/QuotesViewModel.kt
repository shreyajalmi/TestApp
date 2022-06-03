package net.npautogroup.testapp.ui.quotes

import androidx.lifecycle.ViewModel
import net.npautogroup.testapp.data.Quote
import net.npautogroup.testapp.data.QuoteRepository

// QuoteRepository dependency will again be passed in the
// constructor using dependency injection
class QuotesViewModel(private val quoteRepository: QuoteRepository)
    : ViewModel() {

    fun getQuotes() = quoteRepository.getQuotes()

    fun addQuote(quote: Quote) = quoteRepository.addQuote(quote)
}