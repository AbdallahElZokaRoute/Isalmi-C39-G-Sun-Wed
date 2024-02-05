package com.route.islami_c39_gsun_wed.islamiApp.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.route.islami_c39_gsun_wed.databinding.FragmentTasbeehBinding
import java.lang.Integer.parseInt

class TasbeehFragment : Fragment() {
    lateinit var binding: FragmentTasbeehBinding

    var numberOfTasbeh = 0
    var box: Int = 1

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


        binding.tasbehButton.setOnClickListener {

            tasbehClick()


        }

    }


    fun tasbehClick() {



        if (numberOfTasbeh < 33) {
            binding.tasbehNumber.text = (numberOfTasbeh + 1).toString()
            numberOfTasbeh++
            binding.sebhaBody.rotation += 6F
        } else if (numberOfTasbeh == 33 && box == 1) {
            binding.tasbehNumber.text = "0"
            numberOfTasbeh = 0
            box = 2
            binding.tasbehButton.text = "الحمد لله"
        } else if (numberOfTasbeh == 33 && box == 2) {
            binding.tasbehNumber.text = "0"
            numberOfTasbeh = 0
            box = 3
            binding.tasbehButton.text = "الله أكبر"
        } else if (numberOfTasbeh == 33 && box == 3) {
            binding.tasbehNumber.text = "0"
            numberOfTasbeh = 0
            box = 1
            binding.tasbehButton.text = "سبحان الله"
        }

    }

}
