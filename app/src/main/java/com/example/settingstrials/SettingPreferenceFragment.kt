package com.example.settingstrials

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.*


class SettingPreferenceFragment : PreferenceFragmentCompat() {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        addPreferencesFromResource(R.xml.preference_main)
        (activity as AppCompatActivity?)!!.supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val preferenceScreen: PreferenceScreen = this.preferenceScreen

        val preferenceCategory = setPreferenceCategory(preferenceScreen, "yourTitle")

        val preference = setPreference(preferenceScreen, preferenceCategory, "yourTitle")
        val preference1 = setPreference(preferenceScreen, preferenceCategory, "yourTitle1")
        val preference2 = setPreference(preferenceScreen, preferenceCategory, "yourTitle2")

    }

    private fun setPreference(
        preferenceScreen: PreferenceScreen,
        preferenceCategory: PreferenceCategory,
        preferenceTitle: String
    ) {
        val preference = Preference(preferenceScreen.context)
        preference.title = preferenceTitle
        preference.key = preferenceTitle
        val intent = Intent(context, MainActivity2::class.java)
        preference.intent = intent
        preferenceCategory.addPreference(preference)
    }

    private fun setPreferenceCategory(
        preferenceScreen: PreferenceScreen,
        categoryTitle: String
    ): PreferenceCategory {
        val preferenceCategory = PreferenceCategory(preferenceScreen.context)
        preferenceCategory.title = categoryTitle
        preferenceScreen.addPreference(preferenceCategory)
        return preferenceCategory
    }
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        if (item.itemId == android.R.id.home) {
//            onBackPressed()
//        }
//        return super.onOptionsItemSelected(item)
//    }

    companion object {
        private val TAG = SettingPreferenceFragment::class.java!!.simpleName

        private fun bindPreferenceSummaryToValue(preference: Preference) {
            preference.onPreferenceChangeListener = sBindPreferenceSummaryToValueListener

            sBindPreferenceSummaryToValueListener.onPreferenceChange(
                preference,
                PreferenceManager
                    .getDefaultSharedPreferences(preference.context)
                    .getString(preference.key, "")
            )
        }

        private val sBindPreferenceSummaryToValueListener =
            Preference.OnPreferenceChangeListener { preference, newValue ->
                val stringValue = newValue.toString()

                if (preference is Preference) {
                    preference.summary = stringValue
                }
                true
            }
    }
}