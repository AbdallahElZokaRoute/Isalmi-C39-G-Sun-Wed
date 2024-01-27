package com.route.islami_c39_gsun_wed.islamiApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami_c39_gsun_wed.R
import com.route.islami_c39_gsun_wed.databinding.FragmentTasbeehBinding
import com.route.islami_c39_gsun_wed.islamiApp.adapter.SuraNameAdapter
import com.route.islami_c39_gsun_wed.islamiApp.model.SuraNameIndex
import com.route.islami_c39_gsun_wed.islamiApp.model.suraNamesList

class TasbeehFragment : Fragment() {
    lateinit var binding: FragmentTasbeehBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTasbeehBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var NumberOfTasbehat=0
        binding.numberOfTasbeha.text=NumberOfTasbehat.toString()
        binding.nameOfTasbeha.text="سبحان الله"
        binding.buttonOFsebha.setOnClickListener{
            binding.buttonOFsebha.setRotation(binding.buttonOFsebha.getRotation() + 90)
            NumberOfTasbehat++
            binding.numberOfTasbeha.text=NumberOfTasbehat.toString()

            if (NumberOfTasbehat == 33&& binding.nameOfTasbeha.text.equals("سبحان الله"))
            {
                NumberOfTasbehat=0
                binding.numberOfTasbeha.text=NumberOfTasbehat.toString()
                binding.nameOfTasbeha.text = "الحمد لله"
            }
            if (NumberOfTasbehat==33&& binding.nameOfTasbeha.text.equals("الحمد لله"))
            {
                NumberOfTasbehat=0
                binding.numberOfTasbeha.text=NumberOfTasbehat.toString()
                binding.nameOfTasbeha.text="الله اكبر"
            }
            if (NumberOfTasbehat==33&& binding.nameOfTasbeha.text.equals("الله اكبر"))
            {
                NumberOfTasbehat=0
                binding.numberOfTasbeha.text=NumberOfTasbehat.toString()
                binding.nameOfTasbeha.text="سبحان الله"
            }
        }


    }


}
