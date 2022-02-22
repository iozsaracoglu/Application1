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

    //var getStr = "realestate"
    //var getStr = "table.csv?s=MSFT"
    //var getStr = "finance/quote/TSLA:NASDAQ?window=1M"
    //var getStr = "query?function=TIME_SERIES_INTRADAY&symbol=IBM&interval=5min&apikey=1N3JM7DW2NQVFXME&datatype=csv"
    //var getStr = "https://android-kotlin-fun-mars-server.appspot.com/realestate"
    //var getStr = "latestPrice?token=pk_5c9f7c4fc75b447e8b12e97c55a1e623"
    // var getStr = "https://finance.yahoo.com/quote/TECL"

    //var getStr = "https://cloud.iexapis.com/stable/stock/TECL/quote/latestPrice?token=pk_5c9f7c4fc75b447e8b12e97c55a1e623"

    //var getStr = "https://cloud.iexapis.com/stable/stock/TECL/quote?token=pk_5c9f7c4fc75b447e8b12e97c55a1e623&format=csv"
    var getStr = "https://query1.finance.yahoo.com/v7/finance/download/TECL?period1=1637452800&period2=1645401600&interval=1d&events=history&includeAdjustedClose=true"


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
        viewModel.executeHTTP(getStr)
    }

    private fun onClickedButton2() {
        viewModel.addCnt()
        binding.mes.setText("cnt="+viewModel.testCnt.toString())
    }

    fun setTextMessage(mes: String) {
        binding.textView.setText(mes)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SecondViewModel::class.java)
        // TODO: Use the ViewModel
    }

}