package dadm.jmartor.QuotationShake.ui.settings

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.preference.PreferenceFragmentCompat
import dadm.jmartor.QuotationShake.R
import dadm.jmartor.QuotationShake.databinding.FragmentSettingsBinding

class NewSettingsFragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_settings, rootKey)
    }
}