package com.ilker.application1

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.ilker.application1.databinding.StartFragmentBinding

class StartFragment : Fragment() {

    companion object {
        fun newInstance() = StartFragment()
    }

    private lateinit var viewModel: StartViewModel
    private lateinit var binding: StartFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.start_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(StartViewModel::class.java)

        // attach listers
        binding.button.setOnClickListener { onButtonClicked() }

        return binding.root
    }

    // private fun onClicked() {
    //     viewModel.onClick()
    //     binding.message.text = viewModel.cnt.toString()
    // }

    private fun onButtonClicked() {
       findNavController().navigate(R.id.action_startFragment_to_secondFragment)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        // TODO: Use the ViewModel
    }

}