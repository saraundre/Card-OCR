package com.example.a.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.mlkit.nl.entityextraction.EntityExtractorOptions

import com.example.a.adapter.LanguagesAdapter
import com.example.a.databinding.LLanguagesBinding


typealias languageClickListener = (language: String) -> Unit

class ChangeLanguage(val languageChangeListener: languageChangeListener) : BottomSheetDialogFragment() {
    lateinit var binding: LLanguagesBinding

//**********************************************************************************************************//
    private val languageList = listOf(

        "English (US, UK)",
        "Portuguese",
        "Dutch",
        "French",
        "German",
        "Italian",
        "Polish",
        "Russian",
        "Spanish",
        "Turkish"
    )
//**********************************************************************************************************//
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LLanguagesBinding.inflate(layoutInflater)
        binding.rvlanaguages.adapter = LanguagesAdapter {selectedLanguage ->
            val option =  when (selectedLanguage) {
                "English (US, UK)" -> {EntityExtractorOptions.ENGLISH}
                "Portuguese" -> {EntityExtractorOptions.PORTUGUESE}
                "Dutch" -> {EntityExtractorOptions.DUTCH}
                "French" -> {EntityExtractorOptions.FRENCH}
                "German" -> {EntityExtractorOptions.GERMAN}
                "Italian" -> {EntityExtractorOptions.ITALIAN}
                "Polish" -> {EntityExtractorOptions.POLISH}
                "Russian" -> {EntityExtractorOptions.RUSSIAN}
                "Spanish" -> {EntityExtractorOptions.SPANISH}
                "Turkish" -> {EntityExtractorOptions.TURKISH}
                else -> {
                    EntityExtractorOptions.ENGLISH
                }
            }

            languageChangeListener(option)
            this.dismiss()
        }.apply {
            differ.submitList(languageList)
        }
        return binding.root
    }

//**********************************************************************************************************//
    companion object {

        fun newInstance(
            languageChangeListener: languageChangeListener
        ): ChangeLanguage =
            ChangeLanguage (languageChangeListener).apply {

            }
    }
//**********************************************************************************************************//

}