/*
 * Copyright (C) 2019 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.guesstheword.screens.title

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.NonNull
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.android.guesstheword.R
import com.example.android.guesstheword.databinding.TitleFragmentBinding
import kotlinx.android.synthetic.main.title_fragment.*


/**
 * Fragment for the starting or title screen of the app
 */
class TitleFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment
        val binding: TitleFragmentBinding = DataBindingUtil.inflate(
            inflater, com.example.android.guesstheword.R.layout.title_fragment, container, false
        )

        binding.switch1.isChecked = true
        binding.switch1.isEnabled = true


        binding.playGameButton.setOnClickListener {

            val action = TitleFragmentDirections.actionTitleToGame()
            // the switch is checked, if it is turn on
            if(binding.switch1.isChecked){
                // the value of the slider is passed
                action.timerSecond = binding.slider.value.toInt()
            }
            else{
                // if the switch is off, the value of a -1 is passed, it indicates
                    // the timer is not working
                action.timerSecond = -1
            }
            findNavController().navigate(action)
        }
        // With this enable or disable timer slider given the value of the timer
        binding.switch1.setOnCheckedChangeListener{_ , isChecked ->
            binding.slider.isEnabled = isChecked
        }

        return binding.root
    }
}