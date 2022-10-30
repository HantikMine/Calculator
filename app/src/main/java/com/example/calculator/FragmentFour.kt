package com.example.calculator

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.fragment.app.setFragmentResultListener
import com.example.calculator.contract.navigator
import com.example.calculator.databinding.FragmentFirstBinding
import com.example.calculator.databinding.FragmentFourBinding
import com.example.calculator.databinding.FragmentSecondBinding
import com.example.calculator.databinding.FragmentThirdBinding


class FragmentFour : Fragment() {
    // TODO: Rename and change types of parameters
    private lateinit var binding: FragmentFourBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFourBinding.inflate(inflater,container, false)

        binding.BackButton.setOnClickListener{ onBackPressed() }

        return binding.root
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setFragmentResultListener("requestKey") { requestKey, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported

            var result = bundle.getInt("bundleKey")


            binding.Result.setText(result)

            // Do something with the result
        }
    }





    private fun onBackPressed() {
        navigator().goBack()

    }



}