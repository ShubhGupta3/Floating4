@file:Suppress("DEPRECATION")

package com.example.floating

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.floating.databinding.FragmentBadFriendListBinding
import kotlinx.android.synthetic.main.fragment_bad_friend_list.*

/**
 * A simple [Fragment] subclass.
 */

class BadFriendList : Fragment() {

    private lateinit var viewModel2: BadFriendListViewModel
    private lateinit var binding: FragmentBadFriendListBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_bad_friend_list, container, false
        )
        val application = requireNotNull(this.activity).application

        val dataSource2 = BadNameDataBase.getInstance(application).badNameDatabaseDao

        val viewModelFactory2 = BadFriendListViewModelFactory(dataSource2, application)

        viewModel2 =
            ViewModelProviders.of(this, viewModelFactory2).get(BadFriendListViewModel::class.java)

        val badFriendListViewModel = ViewModelProviders.of(
            this,
            viewModelFactory2
        ).get(BadFriendListViewModel::class.java)

        binding.badFriendList = badFriendListViewModel
        binding.lifecycleOwner = this
        binding.addBad.setOnClickListener { onAddBtn2() }
        return binding.root
    }

    private fun onAddBtn2() {
        val temp: String = naam.text.toString()
        if (temp != "") {
            viewModel2.onAdd2(temp)
        }
    }


}
