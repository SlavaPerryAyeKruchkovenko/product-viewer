package com.example.product_viewer

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.example.product_viewer.databinding.FragmentSecondBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val dataManager = Mock()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        init()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        this._binding = null
    }
    private fun init(){
        if(arguments != null){
            val id =  this.arguments?.getString("product_id")
            val product = id?.let { dataManager.getProduct(it) }

            if(product != null){
                binding.cardIdBtn.text = id
                binding.cardImage.setImageResource(product.imageId)
                binding.productToolbar.title = product.titleText
            }
        }
        binding.productToolbar.setNavigationOnClickListener { findNavController().popBackStack() }
        binding.switchColor.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                binding.textLayout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.purple_200))
            } else {
                binding.textLayout.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.purple_300))
            }
        })
    }
}