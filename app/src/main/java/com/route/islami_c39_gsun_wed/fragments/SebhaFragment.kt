package com.route.islami_c39_gsun_wed.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import com.route.islami_c39_gsun_wed.R
import com.route.islami_c39_gsun_wed.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    private lateinit var binding: FragmentSebhaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSebhaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onTasbeehClick()
    }

    private fun onTasbeehClick() {
        var counter = 1;
        binding.imvSebhaBody.setOnClickListener {
            binding.tvTasbeehCounter.text = counter++.toString()
            if (binding.tvTasbeehCounter.text == "33" && binding.tvTasbeehPhrase.text == "سبحان الله") {
                binding.tvTasbeehCounter.text = "0"
                counter = 1
                binding.tvTasbeehPhrase.text = "الحمدلله"
            } else if (binding.tvTasbeehCounter.text == "33" && binding.tvTasbeehPhrase.text == "الحمدلله") {
                binding.tvTasbeehCounter.text = "0"
                counter = 1
                binding.tvTasbeehPhrase.text = "الله أكبر"
            } else if (binding.tvTasbeehCounter.text == "33" && binding.tvTasbeehPhrase.text == "الله أكبر") {
                binding.tvTasbeehCounter.text = "0"
                counter = 1
                binding.tvTasbeehPhrase.text = "سبحان الله"
            }
            val rotate = AnimationUtils.loadAnimation(
                context, R.anim.rotate_sebha
            )
            binding.imvSebhaBody.startAnimation(rotate)
        }
    }
}