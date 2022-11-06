package com.example.calculator

import android.R
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import com.example.calculator.contract.navigator
import com.example.calculator.databinding.FragmentSecondBinding



class FragmentSecond : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentSecondBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(inflater,container, false)

        binding.BackButton.setOnClickListener{ onBackPressed() }
        binding.NextButton.setOnClickListener{ onNextPressed() }

        return binding.root
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    private fun onBackPressed() {
        navigator().goBack()

    }

    private fun onNextPressed() {
        val result = binding.SecondNum.text.toString()
        Log.d("result_tag", result)

        setFragmentResult("requestKey2", bundleOf("bundleKey" to result))

        navigator().showFragmentThird()

    }


}