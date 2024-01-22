package com.route.islami_c39_gsun_wed.islamiApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami_c39_gsun_wed.databinding.FragmentQuranBinding
import com.route.islami_c39_gsun_wed.databinding.FragmentTasbeehBinding

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

        var counter: Int = 0
        val numOfMaxTasbeeh = 33
        val tasbeehTexts = arrayListOf("سبحان الله", "الحمد لله", "الله أكبر", "لا اله الا الله","استغفر الله")
        var currentTasbeehIndex = 0


        binding.seb7aBodyImgView.setOnClickListener {
            if (counter < numOfMaxTasbeeh) {
                binding.seb7aBodyImgView.rotation += 90f
                binding.tasbeehSentenceTxtView.text = tasbeehTexts[currentTasbeehIndex]
                counter += 1
                binding.tasbeehCounterTxtView.text = counter.toString()
            } else {
                currentTasbeehIndex = (currentTasbeehIndex + 1) % tasbeehTexts.size
                counter = 0
            }


        }


    }


}
