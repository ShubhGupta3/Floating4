package com.example.floating

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.example.floating.databinding.FragmentAboutMeBinding

/**
 * A simple [Fragment] subclass.
 */
class aboutMe : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentAboutMeBinding>(inflater,R.layout.fragment_about_me,
            container,false)
        (activity as AppCompatActivity).supportActionBar?.title=
            getString(R.string.dev)
        return binding.root
    }

}
