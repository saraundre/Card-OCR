package com.example.a.ui

import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.CommonDataKinds
import android.provider.ContactsContract.CommonDataKinds.Phone
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.mlkit.nl.entityextraction.*
import com.example.a.R
import com.example.a.databinding.FragmentDisplayInfoBinding
import com.example.a.extensions.snack


class DisplayInfoFragment : Fragment(R.layout.fragment_display_info) {

    private lateinit var entityExtractor: EntityExtractor
    lateinit var binding: FragmentDisplayInfoBinding
    private val DisplayInfoFragmentArgs: DisplayInfoFragmentArgs by navArgs()

//**********************************************************************************************************//
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentDisplayInfoBinding.bind(view)
        binding.rawtext.append(DisplayInfoFragmentArgs.text)

        //create an object for an entity extractor and configure it with the EntityExtractorOption.
        entityExtractor =
            EntityExtraction.getClient(
                EntityExtractorOptions.Builder(DisplayInfoFragmentArgs.language)
                    .build()
            )

        binding.btnSave.setOnClickListener {
            if (binding.tvMobile.text.toString().isEmpty()
                ||binding.tvname.text.toString().isEmpty()
            ) {
                binding.root.snack(
                    message = getString(R.string.phone_number_needed),
                    action = getString(R.string.ok)
                )
                return@setOnClickListener
            }


            // save data in contact
            val intent = Intent(ContactsContract.Intents.Insert.ACTION)
            intent.type = ContactsContract.RawContacts.CONTENT_TYPE
                //email
            intent.putExtra(ContactsContract.Intents.Insert.EMAIL, binding.tvemail.text.toString())
                .putExtra(
                    ContactsContract.Intents.Insert.EMAIL_TYPE,
                    CommonDataKinds.Email.TYPE_WORK
                ).putExtra(
                    //name
                    ContactsContract.Intents.Insert.NAME, binding.tvname.text.toString())
                .putExtra(
                    //phone num
                    ContactsContract.Intents.Insert.PHONE,
                    binding.tvMobile.text.toString()
                )
                .putExtra(
                    ContactsContract.Intents.Insert.PHONE_TYPE,
                    Phone.TYPE_MOBILE,
                )
                .putExtra(
                    ContactsContract.Intents.Insert.SECONDARY_PHONE,
                    binding.tvhome.text.toString()
                )
                .putExtra(
                    ContactsContract.Intents.Insert.PHONE_TYPE,
                    Phone.TYPE_HOME
                )
            startActivity(intent)
        }
        extractEntities()
    }





//**********************************************************************************************************//

    private fun extractEntities() {
        entityExtractor
            .downloadModelIfNeeded()
            .addOnSuccessListener { _ ->
               //OnSuccessListener and, when our model is successfully downloaded,we can call the extraction API.
                val params =
                    EntityExtractionParams.Builder(DisplayInfoFragmentArgs.text).build()
                entityExtractor
                    .annotate(params)
                    .addOnSuccessListener { entityAnnotation ->

                        categoriesEntities(entityAnnotation)
                    }
                    .addOnFailureListener {
                        Toast.makeText(
                            requireContext(),
                            "Entity Extraction failed",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
            }
            .addOnFailureListener { _ ->
                //OnFailureListener—if the model fails to download, we’ll be able to show the user an error.
                Toast.makeText(requireContext(), "Model Download failed", Toast.LENGTH_SHORT).show()
            }
    }






//**********************************************************************************************************//
    private fun categoriesEntities(entityAnnotation: MutableList<EntityAnnotation>) {
        binding.rawtext.append("\n ======= Other Entities ======= \n")
        for (A_entitiy in entityAnnotation) {
            val listOfEntities = A_entitiy.entities
            for (lof_entity in listOfEntities) {
                when (lof_entity.type) {
                    Entity.TYPE_ADDRESS ->   { binding.tvaddress.append(A_entitiy.annotatedText) }
                    Entity.TYPE_DATE_TIME -> { binding.tvdate.append(A_entitiy.annotatedText)    }
                    Entity.TYPE_EMAIL ->     { binding.tvemail.setText(A_entitiy.annotatedText)  }
                    Entity.TYPE_PHONE ->     {

                        if (binding.tvMobile.text.toString().isEmpty()) {
                            binding.tvMobile.setText(A_entitiy.annotatedText)
                        } else if (binding.tvhome.text.toString().isEmpty()) {
                            binding.tvhome.setText(A_entitiy.annotatedText)
                        }
                    }
                    Entity.TYPE_URL -> { binding.tvUrl.setText(A_entitiy.annotatedText) }
                    else -> {
                        binding.rawtext.append(A_entitiy.annotatedText + "\n")
                    }
                }
            }
        }
    }
//**********************************************************************************************************//
}