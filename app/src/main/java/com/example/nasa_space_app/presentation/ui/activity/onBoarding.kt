package com.example.nasa_space_app.presentation.ui.activity

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import androidx.viewpager.widget.ViewPager.OnPageChangeListener
import com.example.nasa_space_app.MainActivity
import com.example.nasa_space_app.R
import com.example.nasa_space_app.presentation.ui.adapter.ViewPagerAdapter


class onBoarding : AppCompatActivity() {
    var mSLideViewPager: ViewPager? = null
    var mDotLayout: LinearLayout? = null
    var backbtn: Button? = null
    var nextbtn: Button? = null
    var skipbtn: Button? = null
    var elipse: ImageView? = null
    lateinit var dots: Array<TextView?>
    var viewPagerAdapter: ViewPagerAdapter? = null
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        backbtn = findViewById(R.id.back_btn)
        nextbtn = findViewById(R.id.nextbtn)
        skipbtn = findViewById(R.id.skipButton)
        elipse = findViewById(R.id.ellipse1)
        elipse?.visibility= View.INVISIBLE
        backbtn?.visibility = View.INVISIBLE

        backbtn?.setOnClickListener(View.OnClickListener {
            if (getitem(0) > 0) {
                mSLideViewPager!!.setCurrentItem(getitem(-1), true)
            }
        })
        nextbtn?.setOnClickListener(View.OnClickListener {
            if (getitem(0) < 2) mSLideViewPager!!.setCurrentItem(getitem(1), true) else {
                val i = Intent(this@onBoarding, MainActivity::class.java)
                startActivity(i)
                finish()
            }
        })
        skipbtn?.setOnClickListener(View.OnClickListener {
            val i = Intent(this@onBoarding, MainActivity::class.java)
            startActivity(i)
            finish()
        })
        mSLideViewPager = findViewById<View>(R.id.slideViewPager) as ViewPager
        mDotLayout = findViewById<View>(R.id.indicator_layout) as LinearLayout
        viewPagerAdapter = ViewPagerAdapter(this)
        mSLideViewPager!!.adapter = viewPagerAdapter
        setUpindicator(0)
        mSLideViewPager!!.addOnPageChangeListener(viewListener)
    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun setUpindicator(position: Int) {
        dots = arrayOfNulls(3)
        mDotLayout!!.removeAllViews()
        for (i in dots.indices) {
            dots[i] = TextView(this)
            dots[i]!!.text = Html.fromHtml("&#8226")
            dots[i]!!.textSize = 35f
            dots[i]!!
                .setTextColor(resources.getColor(R.color.inactive, applicationContext.theme))
            mDotLayout!!.addView(dots[i])
        }
        dots[position]!!
            .setTextColor(resources.getColor(R.color.active, applicationContext.theme))
    }

    var viewListener: OnPageChangeListener = object : OnPageChangeListener {
        override fun onPageScrolled(
            position: Int,
            positionOffset: Float,
            positionOffsetPixels: Int,
        ) {
        }

        @RequiresApi(Build.VERSION_CODES.M)
        override fun onPageSelected(position: Int) {
            setUpindicator(position)
            if (position > 0) {
                backbtn!!.visibility = View.VISIBLE
                elipse?.visibility= View.VISIBLE
                backbtn?.visibility = View.VISIBLE


            } else {
                backbtn!!.visibility = View.INVISIBLE
                elipse?.visibility= View.INVISIBLE
                backbtn?.visibility = View.INVISIBLE

            }
        }

        override fun onPageScrollStateChanged(state: Int) {}
    }

    private fun getitem(i: Int): Int {
        return mSLideViewPager!!.currentItem + i
    }
}