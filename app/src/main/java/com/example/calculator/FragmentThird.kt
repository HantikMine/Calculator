package com.example.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.calculator.contract.navigator
import com.example.calculator.databinding.FragmentFirstBinding
import com.example.calculator.databinding.FragmentSecondBinding
import com.example.calculator.databinding.FragmentThirdBinding


class FragmentThird : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentThirdBinding



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentThirdBinding.inflate(inflater,container, false)

        binding.BackButton.setOnClickListener{ onBackPressed() }
        binding.NextButton.setOnClickListener{ onNextPressed() }

        return binding.root
    }

    private fun onBackPressed() {
        navigator().goBack()

    }

    private fun onNextPressed() {
        navigator().showFragmentFour()

    }


}