package com.example.diplom.diseases.dizziness

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.diplom.R
import com.example.diplom.common.ScreenRoute
import kotlinx.android.synthetic.main.dizziness_fragment.view.*

class DizzinessFragment : Fragment() {

    companion object {
        fun newInstance() =
            DizzinessFragment()
    }

    private lateinit var viewModel: DizzinessViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val v: View = inflater.inflate(R.layout.dizziness_fragment, container, false)
        v.next.setOnClickListener {
            ScreenRoute.nextScreen()
        }
        return v
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(DizzinessViewModel::class.java)
        // TODO: Use the ViewModel
    }

}