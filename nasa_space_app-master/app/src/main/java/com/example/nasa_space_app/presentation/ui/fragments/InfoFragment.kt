package com.example.nasa_space_app.presentation.ui.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.nasa_space_app.R
import com.example.nasa_space_app.data.model.InfoData
import com.example.nasa_space_app.databinding.FragmentInfoBinding
import com.example.nasa_space_app.presentation.ui.adapter.RvInfoAdapter
import com.example.nasa_space_app.presentation.ui.viewmodel.InfoViewModel

class InfoFragment : Fragment() {

private var _binding: FragmentInfoBinding? = null
  // This property is only valid between onCreateView and
  // onDestroyView.
  private val binding get() = _binding!!
   var adapter : RvInfoAdapter? = null
   /* val info_desc="The Carrington Event was the most intense geomagnetic storm in recorded history, peaking from 1\n" +
            "to 2 September 1859 during the solar cycle. It created strong auroral displays that were reported\n" +
            "globally and caused sparking and even fires in multiple telegraph stations. The geomagnetic storm\n" +
            "was most likely the result of a coronal mass ejection from the Sun colliding with Earth's\n" +
            "magnetosphere.\n" +
            "The geomagnetic storm was associated with a very bright solar flare on 1 September 1859. It was\n" +
            "observed and recorded independently by British astronomers Richard Christopher Carrington and\n" +
            "Richard Hodgson.\n" +
            "A geomagnetic storm of this magnitude occurring today would cause widespread electrical\n" +
            "disruptions, blackouts, and damage due to extended outages of the electrical power grid."*/

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View {
    val homeViewModel =
            ViewModelProvider(this).get(InfoViewModel::class.java)

    _binding = FragmentInfoBinding.inflate(inflater, container, false)
    val root: View = binding.root
      adapter= RvInfoAdapter()
     // create list with photos and pass it instead of listof()
   val info_list_img = listOf(InfoData(R.drawable.info1),InfoData(R.drawable.info2),InfoData(R.drawable.info3),InfoData(R.drawable.info4),InfoData(R.drawable.info5),InfoData(R.drawable.info6),InfoData(R.drawable.info7),InfoData(R.drawable.info8),InfoData(R.drawable.info9))
   // val info_list_img = listOf(InfoData(R.drawable.info1))
      adapter?.submitList(info_list_img)
      binding.rv.adapter = adapter
    adapter?.notifyDataSetChanged()
      binding.infoDesc.text =  getString(R.string.info_desc)
      binding.readMore.setOnClickListener{
          val openURL = Intent(Intent.ACTION_VIEW)
          openURL.data = Uri.parse("http://theconversation.com/solar-storms-could-lead-to-a-global-techno-meltdown-16678")
          startActivity(openURL)
      }
    return root
  }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}