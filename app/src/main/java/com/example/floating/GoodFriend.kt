package com.example.floating

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.floating.databinding.FragmentGoodFriendBinding

/**
 * A simple [Fragment] subclass.
 */
class GoodFriend : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentGoodFriendBinding>(inflater,
            R.layout.fragment_good_friend,container,false)
        return binding.root
    }

}
