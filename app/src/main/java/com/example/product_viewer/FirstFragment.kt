package com.example.product_viewer

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.product_viewer.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment(), ProductListAdapter.Listener {

    private var _binding: FragmentFirstBinding? = null
    private val newsAdapter = ProductListAdapter(this)

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        init()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
    private fun init(){
        val list  = listOf(
            Product(
                0,R.drawable.avatar,"Header",
                "Subhead", "Title", "Subhead",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
                R.drawable.media,R.drawable.media_low
            ),
            Product(
                1,R.drawable.avatar,"Header",
                "Subhead", "Title", "Subhead",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
                R.drawable.media,R.drawable.media_low
            ),
            Product(
                0,R.drawable.avatar,"Header",
                "Subhead", "Title", "Subhead",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor",
                R.drawable.media,R.drawable.media_low
            ),
        )
        newsAdapter.submitList(list)
        binding.elements.layoutManager = LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        binding.elements.adapter = newsAdapter
        /*binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }*/
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onClick(news: Product) {
        TODO("Not yet implemented")
    }
}