package com.santosh.keepfragmentstatewithnavigation

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

open class BaseFragment :Fragment()
{
    fun addFragmentToActivity(
        manager: FragmentManager,
        fragment: Fragment,
        frameId: Int,
        tag: String
    ) {
        val transaction: FragmentTransaction = manager.beginTransaction()
        transaction.add(frameId, fragment, tag).addToBackStack(tag)
        transaction.commit()
    }
}