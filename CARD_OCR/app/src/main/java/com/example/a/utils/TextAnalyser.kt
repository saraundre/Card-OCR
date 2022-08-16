package com.example.a.utils

import android.content.Context
import android.net.Uri
import android.util.Log
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.TextRecognizerOptions
import com.example.a.ui.CameraTextAnalyzerListener

class TextAnalyser(
    private val textListener: CameraTextAnalyzerListener,
    private var context: Context,
    private val fromFile: Uri,
) {

    private val recognizer by lazy {
//Gets a new instance of TextRecognizer to perform optical character recognition
// on device with the specified TextRecognizerOptionsInterface.
        TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
    }

    fun analyseImage() {
        try {
            val image = InputImage.fromFilePath(context, fromFile)

            recognizer.process(image)
                .addOnSuccessListener { visionText ->
                    //Successful recognition
                    Log.e("text", visionText.text)
                    textListener(visionText.text)
                }
                .addOnFailureListener { e ->
                    // Unsuccessful text recognition
                    // Task failed with an exception
                    Log.e("text", e.localizedMessage)
                }
        } catch (e: Exception) {
            Log.e("text ", e.localizedMessage)
        }
    }
}

