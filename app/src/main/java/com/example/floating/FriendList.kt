@file:Suppress("DEPRECATION")

package com.example.floating

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.get
import com.example.floating.databinding.FragmentFriendListBinding
import kotlinx.android.synthetic.main.fragment_friend_list.*

/**
 * A simple [Fragment] subclass.
 */

class FriendList : Fragment() {

    private lateinit var viewModel: FriendListViewModel

    private lateinit var binding: FragmentFriendListBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_friend_list, container, false
        )
        val application = requireNotNull(this.activity).application

        val dataSource = NameDataBase.getInstance(application).nameDatabaseDao

        val viewModelFactory = FriendListViewModelFactory(dataSource, application)

        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(FriendListViewModel::class.java)

        val friendListViewModel = ViewModelProviders.of(
            this,
            viewModelFactory
        ).get(FriendListViewModel::class.java)

        binding.friendList = friendListViewModel
        binding.lifecycleOwner = this
        binding.saveBtn.setOnClickListener { onAddBtn() }


        return binding.root
    }


    private fun onAddBtn() {
        val temp: String = editText.text.toString()
        if (temp != "") {
            viewModel.onAdd(temp)
        }
    }
}
