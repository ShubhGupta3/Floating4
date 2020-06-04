package com.example.floating

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.floating.databinding.FragmentCheckGoodFrnBinding
import kotlinx.android.synthetic.main.fragment_check_good_frn.*

/**
 * A simple [Fragment] subclass.
 */
class CheckGoodFrn : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding: FragmentCheckGoodFrnBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_check_good_frn, container, false
        )
        binding.nextMatchButton.setOnClickListener { view: View ->
            view.findNavController()
                .navigate(CheckGoodFrnDirections.actionCheckGoodFrnToFrnCheck())
        }
        binding.button.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_checkGoodFrn_to_friendList)
        }
        (activity as AppCompatActivity).supportActionBar?.title=
            getString(R.string.resultpos_title)
        return binding.root
    }
}


