package com.example.challenge1


import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.challenge1.databinding.FragmentInputBinding
import kotlinx.android.synthetic.main.fragment_input.*
import java.text.NumberFormat

/**
 * A simple [Fragment] subclass.
 */
class Input : Fragment() {

    private lateinit var viewModel: ViewModel

    private lateinit var inputObjectBinding: FragmentInputBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        inputObjectBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_input, container, false)



        viewModel = ViewModelProvider(this).get(ViewModel::class.java)

        inputObjectBinding.btCalculate.setOnClickListener {
            val sizeA = inputObjectBinding.etSizeA.text.toString().toInt()
            val sizeB = inputObjectBinding.etSizeB.text.toString().toInt()

            viewModel.calculate(sizeA,sizeB)

        }

        inputObjectBinding.tvResults.movementMethod = ScrollingMovementMethod()

        viewModel.finalResult.observe(viewLifecycleOwner, Observer { finalResult ->
            inputObjectBinding.tvResults.text = finalResult.toString()
        })

        return inputObjectBinding.root
    }



}
