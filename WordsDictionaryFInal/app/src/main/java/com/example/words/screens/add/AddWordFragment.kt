package com.example.words.screens.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.words.R
import com.example.words.database.WordDatabase
import com.example.words.databinding.FragmentAddWordBinding
import com.google.android.material.snackbar.Snackbar


class AddWordFragment : Fragment() {

    lateinit var viewModel: AddWordViewModel
    private lateinit var layout: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        layout = inflater.inflate(R.layout.fragment_add_word, container, false)
        val application = requireNotNull(activity).application
        val binding = FragmentAddWordBinding.inflate(inflater)
        binding.lifecycleOwner = this.viewLifecycleOwner

        // Get the word object from the argument passed to it so that it can
        // be passed the view model via the view model factory.

        val word = AddWordFragmentArgs.fromBundle(arguments!!).wordDef
        val dao = WordDatabase.getInstance(application).wordDao
        val viewModelFactory = AddWordViewModelFactory(word, dao)




        // The ViewModelProvider uses the factory to create the view model.
        viewModel = ViewModelProvider(this, viewModelFactory).get(AddWordViewModel::class.java)



        // -------Navigates back to the search fragment
        binding.searchAgain.setOnClickListener {
            findNavController().navigate(R.id.action_addWordFragment_to_searchWordFragment)
        }


        viewModel.addWordStatus.observe(this.viewLifecycleOwner, {
            viewModel.addWordStatus.value
        })


        // --------Save in database
        // TODO setup a listener for the add button. The listener code should call a function
        // on the view model to add the word to the database.
        binding.addWord.setOnClickListener {
            viewModel.addWord()

            val snack = Snackbar.make(it,"Word Saved Successfully",Snackbar.LENGTH_LONG)
            snack.show()

            // Here is the code that I was trying to implement to make the difference if
            // the word is already save

            /*viewModel.addWordStatus.observe(this.viewLifecycleOwner, {
                if(viewModel.addWordStatus.value == AddWordStatus.DUPLICATE){
                    val snack = Snackbar.make( binding.wordId,
                        "Word already in the database",Snackbar.LENGTH_LONG)
                    snack.show()
                }
                else{
                    val snack = Snackbar.make(binding.wordId,"Word Saved Successfully",Snackbar.LENGTH_LONG)
                    snack.show()
                }
            }) */


            findNavController().navigate(R.id.action_addWordFragment_to_searchWordFragment)
        }

        binding.viewModel = ViewModelProvider(this, viewModelFactory).get(AddWordViewModel::class.java)

        return binding.root
    }

}