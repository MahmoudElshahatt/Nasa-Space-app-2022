package com.example.nasa_space_app.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nasa_space_app.R
import com.example.nasa_space_app.databinding.FragmentCautionsBinding
import com.example.nasa_space_app.presentation.ui.adapter.CautionAdapter
import com.example.nasa_space_app.presentation.ui.viewmodel.CautionsViewModel

class CautionsFragment : Fragment() {

    private lateinit var binding: FragmentCautionsBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val notificationsViewModel =
            ViewModelProvider(this).get(CautionsViewModel::class.java)
        binding = FragmentCautionsBinding.inflate(inflater, container, false)
        val cautions = mutableListOf<String>(
            getString(R.string.caution_1),
            getString(R.string.caution_2),
            getString(R.string.caution_3),
            getString(R.string.caution_4),
            getString(R.string.caution_5),
            getString(R.string.caution_6),
            getString(R.string.caution_7),
            getString(R.string.caution_8),
            getString(R.string.caution_9),
        )
        val adapter = CautionAdapter()

       binding.cautionRV.adapter= adapter
        adapter.data = cautions
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }
}