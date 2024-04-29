package com.thoughtworks.mobile.ui.fragments.bookDetails

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.thoughtworks.mobile.data.modal.Book
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookDetailsFragment : Fragment() {

    private val viewModel: BookDetailsViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                val book: Book = arguments?.getParcelable("book") ?: Book(
                    id = null,
                    name = "",
                    author = "",
                    publicationYear = "",
                    isbn = ""
                )
                BookDetailsScreen(book = book)
            }
        }
    }
}