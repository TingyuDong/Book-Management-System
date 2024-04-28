package com.thoughtworks.mobile.ui.fragments.bookAdding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import com.thoughtworks.mobile.data.modal.Book
import org.koin.androidx.viewmodel.ext.android.viewModel

class BookAddFragment : Fragment() {

    private val bookAddViewModel: BookAddViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                BookAddScreen(viewModel = bookAddViewModel)
            }
        }
    }

}