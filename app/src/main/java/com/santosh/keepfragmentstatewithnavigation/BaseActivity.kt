package com.santosh.keepfragmentstatewithnavigation

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

open class BaseActivity : AppCompatActivity() {

    private fun removeFragmentFromStack(fragment: Fragment, tag: String) {
        supportFragmentManager.apply {
            beginTransaction().remove(fragment).commit()
            popBackStackImmediate(
                tag, FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        }
        return
    }

    override fun onBackPressed() {
        onBackPress()
    }

    //Manual handling of back press needs to be done in activity
    private fun onBackPress() {
        val count: Int = supportFragmentManager.backStackEntryCount
        if (count == 0) {
            super.onBackPressed()
        } else {
            val fragmentList: List<Fragment> = supportFragmentManager.fragments
            for (fragment: Fragment in fragmentList) {
                when (fragment) {
                    is KeepPreviousStateFragment -> {
                        removeFragmentFromStack(
                            fragment,
                            Constants.NEXT_FRAGMENT
                        )
                    }
                }

            }
        }
    }
}