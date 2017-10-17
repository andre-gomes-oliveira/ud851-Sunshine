package com.example.android.sunshine;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.EditTextPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.support.v7.preference.PreferenceScreen;

import com.example.android.sunshine.R;

/**
 * Created by Andre on 16/10/2017.
 */

// COMPLETED (10) Implement OnSharedPreferenceChangeListener from com.example.android.sunshine.SettingsFragment
public class SettingsFragment extends PreferenceFragmentCompat implements SharedPreferences.OnSharedPreferenceChangeListener
{
    // Do steps 5 - 11 within com.example.android.sunshine.SettingsFragment

    // COMPLETED (5) Override onCreatePreferences and add the preference xml file using addPreferencesFromResource

    @Override
    public void onCreatePreferences(Bundle savedInstanceState, String rootKey)
    {
        // Do step 9 within onCreatePreference
        // COMPLETED (9) Set the preference summary on each preference that isn't a CheckBoxPreference
        addPreferencesFromResource(R.xml.sunshine_preferences);

        PreferenceScreen prefScreen = getPreferenceScreen();
        SharedPreferences sharedPrefs = prefScreen.getSharedPreferences();

        for (int i = 0; i < prefScreen.getPreferenceCount() ; i++)
        {
            Preference pref = prefScreen.getPreference(i);

            if (!(pref instanceof CheckBoxPreference))
            {
               String value = sharedPrefs.getString(pref.getKey(), "");
               setPreferenceSummary(pref, value);
            }
        }
    }

    // COMPLETED (11) Override onSharedPreferenceChanged to update non CheckBoxPreferences when they are changed
    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key)
    {
        Preference preference = findPreference(key);

        if(preference != null)
        {
            if (!(preference instanceof CheckBoxPreference))
            {
                String value = sharedPreferences.getString(key, "");
                setPreferenceSummary(preference, value);
            }
        }
    }

    // COMPLETED (12) Register com.example.android.sunshine.SettingsFragment (this) as a SharedPreferenceChangedListener in onStart
    @Override
    public void onStart()
    {
        super.onStart();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    // COMPLETED (13) Unregister com.example.android.sunshine.SettingsFragment (this) as a SharedPreferenceChangedListener in onStop
    @Override
    public void onStop()
    {
        super.onStop();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    // COMPLETED (8) Create a method called setPreferenceSummary that accepts a Preference and an Object and sets the summary of the preference
    private void setPreferenceSummary (Preference preference, Object value)
    {
        if (preference instanceof ListPreference)
        {
            ListPreference list = (ListPreference) preference;
            int prefIndex = list.findIndexOfValue(value.toString());
            if (prefIndex >= 0)
            {
                list.setSummary(list.getEntries()[prefIndex]);
            }
        }
        else if (preference instanceof EditTextPreference)
        {
            // For EditTextPreferences, set the summary to the value's simple string representation.
            preference.setSummary(value.toString());
        }
    }
}
