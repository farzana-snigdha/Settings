package com.example.settingstrials

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val settingsBtn: Button = findViewById(R.id.settingsBtn)
        settingsBtn.text = "Settings"
        settingsBtn.setOnClickListener {
            if (savedInstanceState == null) {
                val f = SettingPreferenceFragment()
                val t: FragmentTransaction = supportFragmentManager.beginTransaction()
                t.add(R.id.mainPage, f).commit()
            }
            settingsBtn.visibility= View.GONE
        }
    }

}