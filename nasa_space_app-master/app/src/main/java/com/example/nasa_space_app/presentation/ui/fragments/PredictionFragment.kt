package com.example.nasa_space_app.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nasa_space_app.R
import com.example.nasa_space_app.databinding.FragmentPredictionBinding
import com.example.nasa_space_app.presentation.ui.viewmodel.PredictionViewModel

class PredictionFragment : Fragment() {

private var _binding: FragmentPredictionBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val dashboardViewModel =
            ViewModelProvider(this).get(PredictionViewModel::class.java)

    _binding = FragmentPredictionBinding.inflate(inflater, container, false)
    val root: View = binding.root


    binding.predict.setImageResource(R.drawable.predict)
    binding.predict2.setImageResource(R.drawable.predict2)
      binding.linear.visibility = View.GONE
      binding.predictBtn.setOnClickListener {
          it.visibility = View.GONE
          binding.linear.visibility = View.VISIBLE

      }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}