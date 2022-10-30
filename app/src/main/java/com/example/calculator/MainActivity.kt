package com.example.calculator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.example.calculator.databinding.ActivityMainBinding
import com.example.calculator.databinding.FragmentFirstBinding
import com.example.calculator.contract.*


class MainActivity : AppCompatActivity(), Navigator {

    private lateinit var binding: ActivityMainBinding

    private val currentFragment: Fragment
        get() = supportFragmentManager.findFragmentById(R.id.FragmentContainer)!!



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater).also { setContentView(it.root) }

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.FragmentContainer, FragmentFirst())
                .commit()
        }
    }

    override fun goBack() {
        onBackPressed()
    }

    override fun showFragmentSecond() {
        launchFragment(FragmentSecond())
    }

    override fun showFragmentThird() {
        launchFragment(FragmentThird())
    }

    override fun showFragmentFour() {
        launchFragment(FragmentFour())
    }



    private fun launchFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .addToBackStack(null)
            .replace(R.id.FragmentContainer, fragment)
            .commit()
    }


}
