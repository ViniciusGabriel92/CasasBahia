package com.example.casasbahia.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.example.casasbahia.R
import com.example.core.domain.entity.commom.Image

class ViewPagerAdapter(private val context: Context, imagesDetails: List<Image>) : PagerAdapter() {
    private var layoutInflater: LayoutInflater? = null;
    lateinit var imagesDetails: List<Image>;

    init {
        this.imagesDetails = imagesDetails;
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`;
    }

    override fun getCount(): Int {
        return imagesDetails.size;
    }

    override fun instantiateItem(container: View, position: Int): Any {
        layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val v = layoutInflater!!.inflate(R.layout.image_view_slide_detail, null);
        val imageViewSlide = v.findViewById<View>(R.id.imageViewSlideDetail) as ImageView;

        Glide.with(context.applicationContext)
            .asBitmap()
            .override(imageViewSlide.width, imageViewSlide.height)
            .load(imagesDetails[position].URL.replace("http", "https"))
            .error(R.drawable.ic_menu_camera)
            .into(imageViewSlide);

        val viewPager = container as ViewPager;
        viewPager.addView(v,0);
        return v;
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        val viewPager = container as ViewPager;
        val v = `object` as View;
        viewPager.removeView(v);
    }
}