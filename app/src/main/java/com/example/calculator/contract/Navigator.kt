package com.example.calculator.contract

import android.os.Parcelable
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner


fun Fragment.navigator(): Navigator {
    return requireActivity() as Navigator
}

interface Navigator {

    fun goBack()

    fun showFragmentSecond()

    fun showFragmentThird()

    fun showFragmentFour()
}