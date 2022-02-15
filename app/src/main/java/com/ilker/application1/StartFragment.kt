package com.ilker.application1

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
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
        // binding.buttonNext.setOnClickListener { onClickedNext() }

        return binding.root
    }

    // private fun onClicked() {
    //     viewModel.onClick()
    //     binding.message.text = viewModel.cnt.toString()
    // }

    // private fun onClickedNext() {
    // findNavController().navigate(R.id.action_mainFragment_to_nextFragment)
    // }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(StartViewModel::class.java)
        // TODO: Use the ViewModel
    }

}