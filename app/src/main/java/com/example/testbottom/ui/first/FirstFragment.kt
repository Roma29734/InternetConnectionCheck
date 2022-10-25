package com.example.testbottom.ui.first

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.testbottom.InternetCOnection
import com.example.testbottom.databinding.FragmentFirstBinding
class FirstFragment : Fragment() {

    private var binding: FragmentFirstBinding? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)

        val network = activity?.applicationContext?.let { InternetCOnection(it) }
        network?.observe(viewLifecycleOwner){ conect ->
            if(conect) {
                binding!!.tvInternet.text = "Okey"
            } else {
                binding!!.tvInternet.text = "Нет интенета"
            }
        }
        return binding!!.root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}