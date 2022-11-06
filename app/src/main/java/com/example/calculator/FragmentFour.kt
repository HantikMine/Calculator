package com.example.calculator

import android.os.Bundle
import android.util.Log
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
        var result = 0

        setFragmentResultListener("requestKey1") { requestKey, bundle ->
            val num1: String
            num1 = bundle.getString("bundleKey").toString()

            setFragmentResultListener("requestKey2") { requestKey, bundle ->
                val num2: String
                num2 = bundle.getString("bundleKey").toString()

                setFragmentResultListener("requestKey3") { requestKey, bundle ->
                    val symb: String

                    symb = bundle.getString("bundleKey").toString()
                    Log.d("result_tag", symb)
                    when(symb) {
                        "*" -> result = num1.toInt() * num2.toInt()
                        "/" -> result = num1.toInt() / num2.toInt()
                        "+" -> result = num1.toInt() + num2.toInt()
                        "-" -> result = num1.toInt() - num2.toInt()
                    }

                    binding.Result.setText(result.toString())

                }


            }



        }

//        setFragmentResultListener("requestKey2") { requestKey2, bundle ->
//
//            var num2 = bundle.getString("bundleKey")
////            binding.Result.setText(num2)
//
//        }


    }

    private fun onBackPressed() {
        navigator().goBack()

    }

}