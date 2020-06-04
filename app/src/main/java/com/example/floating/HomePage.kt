package com.example.floating

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.floating.databinding.FragmentHomePageBinding

/**
 * A simple [Fragment] subclass.
 */
class HomePage : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentHomePageBinding>(inflater,
            R.layout.fragment_home_page,container,false)
        binding.buttonDivein.setOnClickListener { view : View ->
            view.findNavController().navigate(R.id.action_homePage_to_page1) }
        (activity as AppCompatActivity).supportActionBar?.title=
            getString(R.string.home_page)
        return binding.root

    }

}
