package com.example.diplom.diseases.headache

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diplom.R
import com.example.diplom.common.ScreenRoute.nextScreen
import kotlinx.android.synthetic.main.headache_fragment.view.*

class HeadacheFragment : Fragment() {

    companion object {
        fun newInstance() =
            HeadacheFragment()
    }

    private lateinit var viewModel: HeadacheViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.headache_fragment, container, false)
       v.next.setOnClickListener {
           nextScreen()
       }
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HeadacheViewModel::class.java)
        // TODO: Use the ViewModel
    }

}