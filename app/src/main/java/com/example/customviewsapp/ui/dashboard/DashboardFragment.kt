package com.example.customviewsapp.ui.dashboard

import android.animation.*
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.*
import androidx.core.animation.doOnEnd
import androidx.core.animation.doOnStart
import androidx.core.view.ViewCompat
import androidx.core.view.ViewPropertyAnimatorUpdateListener
import androidx.fragment.app.Fragment
import com.example.customviewsapp.R
import kotlinx.android.synthetic.main.fragment_dashboard.*

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = inflater.inflate(R.layout.fragment_dashboard, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        objectAnimatorFromCode()
//        objectAnimatorFromXml()
//        valueAnimatorExample()
        viewPropertyAnimatorExample()
    }

    private fun objectAnimatorFromCode() {
        val animX = ObjectAnimator.ofFloat(iv_image, View.TRANSLATION_X, 300F)
        val animY = ObjectAnimator.ofFloat(iv_image, View.TRANSLATION_Y, 300F)
        val animatorSet = AnimatorSet()
        animatorSet.play(animX).with(animY)
        animatorSet.duration = 6000
        animatorSet.interpolator = BounceInterpolator()
        animatorSet.doOnStart { println("7777 view data = ${iv_image.x}") }
        animatorSet.doOnEnd { println("7777 view data = ${iv_image.x}") }
        animatorSet.start()
    }

    private fun objectAnimatorFromXml() {
        val set = AnimatorInflater.loadAnimator(
            requireContext(),
            R.animator.bounce_animator
        ) as AnimatorSet
        set.setTarget(iv_image)
        set.start()
    }

    private fun valueAnimatorExample() {
        val animator = ValueAnimator.ofFloat(0f, 300f)
        animator.duration = 3000
        animator.start()

        animator.addUpdateListener { animation ->
            val animatedValue = animation.animatedValue as Float
            iv_image.translationX = animatedValue
        }
    }

    private fun viewPropertyAnimatorExample() {
        val vpa = ViewCompat.animate(iv_image)
            .setDuration(5000)
            .translationX(300f)
            .translationY(300f)
            .setInterpolator(AccelerateDecelerateInterpolator())
            .withEndAction { println("7777 end animation") }
    }
}