package com.example.casasbahia.ui.home

import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.casasbahia.R


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val tvVersionName: TextView = root.findViewById(R.id.title_version_name);
        val tvVersionCode: TextView = root.findViewById(R.id.title_version_code);
        val context = this@HomeFragment.context;
        context?.let {
            val pInfo = context.packageManager.getPackageInfo(context.packageName, 0);
            val versionCode: Int;

            versionCode = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                pInfo.longVersionCode.toInt()
            } else {
                pInfo.versionCode
            }

            tvVersionName.setText("VERSION (" + pInfo.versionName + ")");
            tvVersionCode.setText("version_code (" +versionCode.toString() + ")");
        }
        return root
    }
}
