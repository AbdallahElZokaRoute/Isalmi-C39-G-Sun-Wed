package com.route.islami_c39_gsun_wed.islamiApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami_c39_gsun_wed.databinding.FragmentQuranBinding
import com.route.islami_c39_gsun_wed.databinding.FragmentTasbeehBinding
import com.route.islami_c39_gsun_wed.islamiApp.adapter.VersesAdapter

class TasbeehFragment : Fragment() {
    lateinit var binding: FragmentTasbeehBinding
    var count=0
    var index : Int =0
    var listOfDhikr = mutableListOf<String>("سبحان الله ","الحمد الله " , "لا اله الا الله ", "الله اكبر " , "استغفر الله" , "اللهم صل و سلم علي سيدنا محمد")
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
            binding.imvBodyOfSebha.rotation += 50f
            count++
            updataDhikr()
        }

    }

    private fun updataDhikr() {
        binding.tvCounter.text = count.toString()
        binding.tvDhikr.text = listOfDhikr[index]
        if (count==33){
            count=0
            index = (index+1)%listOfDhikr.size
            listOfDhikr[index]
        }
    }

}
