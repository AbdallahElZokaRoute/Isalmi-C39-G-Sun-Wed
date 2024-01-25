package com.route.islami_c39_gsun_wed.islamiApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.route.islami_c39_gsun_wed.databinding.FragmentQuranBinding
import com.route.islami_c39_gsun_wed.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {
    lateinit var binding: FragmentTasbeehBinding
    var currentIndex = 0
    var counter = 0
    var listOfDhikr = mutableListOf<String>("سبحان الله ","الحمد الله ","لا اله الا الله ", "الله اكبر ")
    lateinit var counterTextView : TextView
    lateinit var dhikrTextView : TextView

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
        binding.imvBodyOfSebha.setOnClickListener{
            sebhaRotation()
            ubdateDhikr()


        }

    }




    private fun sebhaRotation() {
        binding.imvBodyOfSebha.rotation += 30f


    }

    private fun ubdateDhikr() {
        counterTextView = binding.tvCounter
        dhikrTextView = binding.tvDhikr
        if (counter < 33) {
            counter++
            counterTextView.text = counter.toString()
            dhikrTextView.text = listOfDhikr[currentIndex]

        } else {
            counter = 0
            counterTextView.text = counter.toString()
            currentIndex = (currentIndex + 1) % listOfDhikr.size
            dhikrTextView.text = listOfDhikr[currentIndex]
        }


    }}