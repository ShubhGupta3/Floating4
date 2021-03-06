package com.example.floating

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.floating.databinding.FragmentJudyStoBinding

/**
 * A simple [Fragment] subclass.
 */
class JudySto : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentJudyStoBinding>(inflater,
            R.layout.fragment_judy_sto,container,false)
        (activity as AppCompatActivity).supportActionBar?.title=
            getString(R.string.xd)
        return binding.root
    }

}
