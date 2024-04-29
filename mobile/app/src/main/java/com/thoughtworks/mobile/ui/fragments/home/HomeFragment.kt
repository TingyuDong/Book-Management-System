package com.thoughtworks.mobile.ui.fragments.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.navigation.fragment.findNavController
import com.thoughtworks.mobile.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
            setContent {
                HomeScreen(
                    viewModel = viewModel,
                    onClickAddButton = {
                        findNavController().navigate(R.id.action_home_to_add)
                    },
                    onClickBook = { book ->
                        val bundle = Bundle().apply {
                            putParcelable("book", book)
                        }
                        findNavController().navigate(R.id.bookDetails, bundle)
                    })
            }
        }
    }
}