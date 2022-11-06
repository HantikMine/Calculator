package com.example.calculator


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResultListener
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

        binding.NavigationOne.setOnClickListener{ showFragmentFirst() }
        binding.NavigationTwo.setOnClickListener{ showFragmentSecond() }
        binding.NavigationThree.setOnClickListener{ showFragmentThird() }
        binding.NavigationFour.setOnClickListener{ showFragmentFour() }

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

    fun showFragmentFirst() {
        binding.NavigationOne.isEnabled = true
        binding.NavigationTwo.isEnabled = false
        binding.NavigationThree.isEnabled = false
        binding.NavigationFour.isEnabled = false

        launchFragment(FragmentFirst())
    }


    override fun showFragmentSecond() {
        binding.NavigationOne.isEnabled = true
        binding.NavigationTwo.isEnabled = true
        binding.NavigationThree.isEnabled = false
        binding.NavigationFour.isEnabled = false

        launchFragment(FragmentSecond())
    }

    override fun showFragmentThird() {
        binding.NavigationOne.isEnabled = true
        binding.NavigationTwo.isEnabled = true
        binding.NavigationThree.isEnabled = true
        binding.NavigationFour.isEnabled = false
        launchFragment(FragmentThird())
    }

    override fun showFragmentFour() {
        binding.NavigationOne.isEnabled = true
        binding.NavigationTwo.isEnabled = true
        binding.NavigationThree.isEnabled = true
        binding.NavigationFour.isEnabled = true
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
