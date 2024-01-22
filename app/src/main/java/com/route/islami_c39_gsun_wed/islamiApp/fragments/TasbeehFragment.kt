package com.route.islami_c39_gsun_wed.islamiApp.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.ImageView
import androidx.core.content.ContentProviderCompat
import androidx.core.content.ContentProviderCompat.requireContext
import androidx.fragment.app.Fragment
import com.route.islami_c39_gsun_wed.R
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
        binding = FragmentTasbeehBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sebhaBody.setOnClickListener{
            rotateImage(binding.sebhaBody)
            tasbeeh()

        }
    }

    private fun rotateImage(imageView: ImageView ) {
        // Create a rotation animation
        val rotateAnimation = AnimationUtils.loadAnimation(context, R.anim.rotate_animation)

        // Set the animation listener to reset the rotation after the animation completes
        rotateAnimation.setAnimationListener(object : android.view.animation.Animation.AnimationListener {
            override fun onAnimationStart(animation: android.view.animation.Animation) {}
            override fun onAnimationEnd(animation: android.view.animation.Animation) {
                imageView.rotation = 0F // Reset rotation to 0 degrees
            }
            override fun onAnimationRepeat(animation: android.view.animation.Animation) {}
        })

        // Start the animation
        imageView.startAnimation(rotateAnimation)
    }


    private fun tasbeeh() {
        numberOfTasbeeh = binding.tasbeehCount.text.toString()
        tasbeehContent=binding.tasbeehContent.text.toString()
        tasbeehCounter()
        tasbeehContentChanger()

    }

    private fun tasbeehContentChanger() {
        if (numberOfTasbeeh.equals("30") && tasbeehContent.equals("سبحان الله")) {
            binding.tasbeehContent.text = "الحمد الله"
            binding.tasbeehCount.text = "0"
        } else if (numberOfTasbeeh.equals("30") && tasbeehContent.equals("الحمد الله")) {
            binding.tasbeehContent.text = "الله اكبر"
            binding.tasbeehCount.text = "0"
        } else if (numberOfTasbeeh.equals("30") && tasbeehContent.equals("الله اكبر")) {
            binding.tasbeehContent.text = "سبحان الله"
            binding.tasbeehCount.text = "0"
        }
    }

    private fun tasbeehCounter() {
        var tasbeehValu = numberOfTasbeeh.toInt()
        tasbeehValu++
        binding.tasbeehCount.text = tasbeehValu.toString()    }

}






