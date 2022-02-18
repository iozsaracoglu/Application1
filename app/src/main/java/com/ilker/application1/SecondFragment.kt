package com.ilker.application1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.ilker.application1.databinding.SecondFragmentBinding

class SecondFragment : Fragment() {

    companion object {
        fun newInstance() = SecondFragment()
    }

    private lateinit var binding: SecondFragmentBinding
    private lateinit var viewModel: SecondViewModel

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
        binding.button3.setOnClickListener { onClickedButton3() }

        viewModel.setActivity((activity as MainActivity))
        viewModel.setView(this)

        viewModel.setCnt()
        binding.mes.setText("cnt="+viewModel.testCnt.toString())

        return binding.root
    }

    private fun onClickedButton3() {
        viewModel.executeURL("https://android-kotlin-fun-mars-server.appspot.com/",
            "realestate")
        binding.textView.setText(viewModel.urlResponse)
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

    fun setTextMessage(msg: String) {
        binding.textView.setText(msg)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        // TODO: Use the ViewModel
    }

}