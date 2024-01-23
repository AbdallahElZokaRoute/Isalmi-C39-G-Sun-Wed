package com.route.islami_c39_gsun_wed.islamiApp.fragments

import android.animation.ObjectAnimator
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.route.islami_c39_gsun_wed.databinding.FragmentQuranBinding
import com.route.islami_c39_gsun_wed.databinding.FragmentTasbeehBinding

class TasbeehFragment : Fragment() {

    lateinit var numberOfTasbeeh:String
    lateinit var tasbeehContent:String
    lateinit var binding: FragmentTasbeehBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentTasbeehBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.seb7aIc.setOnClickListener{
            seb7aRotation()
            tasbeeh()

        }
    }

    private fun seb7aRotation() {
        val rotateAnimator= ObjectAnimator.ofFloat(binding.seb7aIc,"rotation",0f,360f)
        rotateAnimator.duration=500
        rotateAnimator.start()
    }

    fun tasbeeh(){
        numberOfTasbeeh = binding.valueOfTasbeeh.text.toString()
        tasbeehContent=binding.tasbeehContent.text.toString()
        tasbeehCounter()
        tasbeehContent()


    }


    private fun tasbeehCounter() {
        var tasbeehValu = numberOfTasbeeh.toInt()
        tasbeehValu++
        binding.valueOfTasbeeh.text = tasbeehValu.toString()
    }
    fun tasbeehContent(){
        if (numberOfTasbeeh.equals("20")&&tasbeehContent.equals("سبحان الله")){
            binding.tasbeehContent.text="الحمد الله"
            binding.valueOfTasbeeh.text="0"
        }else if (numberOfTasbeeh.equals("20")&&tasbeehContent.equals("الحمد الله")){
            binding.tasbeehContent.text="الله اكبر"
            binding.valueOfTasbeeh.text="0"
        }else if (numberOfTasbeeh.equals("20")&&tasbeehContent.equals("الله اكبر")){
            binding.tasbeehContent.text="سبحان الله"
            binding.valueOfTasbeeh.text="0"



        }
    }}
