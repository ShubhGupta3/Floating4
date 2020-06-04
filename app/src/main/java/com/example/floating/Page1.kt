package com.example.floating

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.floating.databinding.FragmentPage1Binding

/**
 * A simple [Fragment] subclass.
 */
class Page1 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (savedInstanceState != null) {
            super.onSaveInstanceState(savedInstanceState)
        }
        val binding = DataBindingUtil.inflate<FragmentPage1Binding>(inflater,
            R.layout.fragment_page1,container,false)
        binding.button1.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_page1_to_stories)
        }
        binding.button2.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_page1_to_goodFriend)
        }
        binding.button3.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_page1_to_frnCheck)
        }
        binding.button4.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_page1_to_badFriendList)
        }
        binding.button5.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_page1_to_friendList)
        }
        binding.button6.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_page1_to_aboutMe)
        }
        (activity as AppCompatActivity).supportActionBar?.title=
            getString(R.string.select)
        return binding.root
    }

}
