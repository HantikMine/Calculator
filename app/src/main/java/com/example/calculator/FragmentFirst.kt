package com.example.calculator

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.calculator.contract.navigator
import com.example.calculator.databinding.FragmentFirstBinding


class FragmentFirst : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentFirstBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater,container, false)

        binding.NextButton.setOnClickListener{ onNextPressed() }

        return binding.root
    }


    private fun onNextPressed() {

        val result = binding.FirstNum

        // Use the Kotlin extension in the fragment-ktx artifact
        setFragmentResult("requestKey", bundleOf("bundleKey" to result))
        navigator().showFragmentSecond()

    }



}