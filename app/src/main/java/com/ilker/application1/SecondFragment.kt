package com.ilker.application1

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.ilker.application1.databinding.SecondFragmentBinding

class SecondFragment : Fragment() {

    companion object {
        fun newInstance() = SecondFragment()
    }

    private lateinit var viewModel: SecondViewModel
    private lateinit var binding: SecondFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.second_fragment,
            container,
            false
        )
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        binding.button2.setOnClickListener { onClickedButton2() }

        viewModel.setActivity((activity as MainActivity))
        viewModel.setCnt()
        binding.mes.setText("cnt="+viewModel.testCnt.toString())

        return binding.root
    }

    private fun onClickedButton2() {

        viewModel.addCnt()
        binding.mes.setText("cnt="+viewModel.testCnt.toString())

        // (activity as MainActivity).myDb

        //viewModel.
        //binding.message.text = viewModel.cnt.toString()
    }

    // private fun onClickedNext() {
    // findNavController().navigate(R.id.action_mainFragment_to_nextFragment)
    // }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        // TODO: Use the ViewModel
    }

}