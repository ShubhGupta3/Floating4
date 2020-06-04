package com.example.floating

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.floating.databinding.FragmentStoriesBinding

/**
 * A simple [Fragment] subclass.
 */
class Stories : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentStoriesBinding>(inflater,
            R.layout.fragment_stories,container,false)
        binding.image1.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_stories_to_potterSto)
        }
        binding.name1.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_stories_to_potterSto) }
        binding.image2.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_stories_to_sheldonSto)
        }
        binding.name2.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_stories_to_sheldonSto)
        }
        binding.image3.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_stories_to_frenSto)
        }
        binding.name3.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_stories_to_frenSto)
        }
        binding.image4.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_stories_to_sherSto)
        }
        binding.name4.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_stories_to_sherSto)
        }
        binding.image5.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_stories_to_boyleSto)
        }
        binding.name5.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_stories_to_boyleSto)
        }
        binding.image6.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_stories_to_judySto)
        }
        binding.name6.setOnClickListener{ view: View ->
            view.findNavController().navigate(R.id.action_stories_to_judySto)
        }
        (activity as AppCompatActivity).supportActionBar?.title=
            getString(R.string.xd)
        return binding.root
    }

}
