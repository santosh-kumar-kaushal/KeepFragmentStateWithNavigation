package com.santosh.keepfragmentstatewithnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.Navigation

/**
 * If we want to keep the state of this fragment we will have to add the launching fragment to this fragment.
 * Problem with navigation component is it always replaces the fragment in case there is a form we want to fill
 * and come back again for the change it looses the state this way we can keep the state of the fragment.
 */
class KeepStateFragment :BaseFragment()
{

    private var counter:Int = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_keep_state, container, false)

        view.findViewById<ImageView>(R.id.minus).setOnClickListener {
            counter--
            view.findViewById<TextView>(R.id.textview).text=counter.toString()
        }

        view.findViewById<ImageView>(R.id.plus).setOnClickListener {

            counter++
            view.findViewById<TextView>(R.id.textview).text=counter.toString()
        }

        //Keeps the state of the fragment.
        view.findViewById<Button>(R.id.keep_state_button).setOnClickListener {
            addFragmentToActivity(requireActivity().supportFragmentManager,KeepPreviousStateFragment(),R.id.my_nav_host_fragment,Constants.NEXT_FRAGMENT)
        }

        //Do not keep the state of this fragment
        view.findViewById<Button>(R.id.lose_state_button).setOnClickListener {
            Navigation.findNavController(view).navigate(R.id.action_lose_fragment_to_register)
        }
        return view
    }

}