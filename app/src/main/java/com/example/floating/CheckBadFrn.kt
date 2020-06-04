package com.example.floating

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.floating.databinding.FragmentCheckBadFrnBinding
import com.example.floating.databinding.FragmentCheckGoodFrnBinding

/**
 * A simple [Fragment] subclass.
 */
class CheckBadFrn : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentCheckBadFrnBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_check_bad_frn, container, false)
        binding.tryAgainButton.setOnClickListener { view: View -> view.findNavController()
            .navigate(CheckBadFrnDirections.actionCheckBadFrnToFrnCheck()) }
        binding.button7.setOnClickListener { view: View -> view.findNavController()
            .navigate(R.id.action_checkBadFrn_to_badFriendList) }

        (activity as AppCompatActivity).supportActionBar?.title=
            getString(R.string.resultneg_title)
        return binding.root
    }

}
