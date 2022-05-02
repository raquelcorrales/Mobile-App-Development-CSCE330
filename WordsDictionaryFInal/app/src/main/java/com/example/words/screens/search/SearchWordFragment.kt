package com.example.words.screens.search

import android.os.Bundle
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.words.R
import com.example.words.database.WordDatabase
import com.example.words.entity.Word
import com.example.words.network.DictionaryApi
import com.example.words.network.parseJsonToWord
import com.example.words.screens.add.AddWordFragmentArgs
import com.example.words.screens.overview.DictWordsFragmentDirections
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.launch

// The fragment is responsible for handling events. These events include responding to
// user input and data changes through observation of view model data changes.
class SearchWordFragment : Fragment() {
    private val TAG = javaClass.simpleName
    private lateinit var layout: View
    private lateinit var viewModel: SearchWordViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        layout = inflater.inflate(R.layout.fragment_search_word, container, false)

        val application = requireNotNull(activity).application
        val dao = WordDatabase.getInstance(application).wordDao
        val viewModelFactory = SearchWordViewModelFactory(dao)

        viewModel = ViewModelProvider(this, viewModelFactory)
            .get(SearchWordViewModel::class.java)

        val searchButton = layout.findViewById<Button>(R.id.search_button)
        searchButton.setOnClickListener {
            wordSearch()
        }

        // Observe the wordDef so that when a word is found (an exact match of the user input)
        // by the Dictionary API we navigate to the add word screen.
        viewModel.wordDef.observe(this, Observer { word ->
            if (null != word) {
                findNavController()
                    .navigate(
                        SearchWordFragmentDirections.actionSearchWordFragmentToAddWordFragment(word))
                Log.d(TAG, "Observed ${viewModel.wordDef.value}")
                // This sets the wordDef property to null so that the observer doesn't get notified
                // again when navigating back to the search screen
                viewModel.resetWordDef()
            }
        })

        // Observe the suggestedWords so that when a list of suggested words is
        // returned by the API we can display this on the search word screen.
        viewModel.suggestedWords.observe(this, Observer { suggestedWords ->
            if (null != suggestedWords) {
                TODO("These words should appear on the search word screen")
            }
        })

        return layout
    }

    private fun wordSearch() {
        // search for the word that the user entered
        var searchInput: TextInputLayout = layout.findViewById(R.id.search_input)
        var searchWord = searchInput.editText?.text.toString()

        // The search is performed by the view model, because the view model
        // is responsible for data access
        viewModel.performWordSearch(searchWord)
    }
}