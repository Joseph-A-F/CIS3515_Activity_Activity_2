package edu.temple.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts

const val TEXT_SIZE_MESSAGE = "text_size_message";

class DisplayActivity : AppCompatActivity() {

    // TODO Step 1: Launch TextSizeActivity when button clicked to allow selection of text size value

    // TODO Step 3: Use returned value for lyricsDisplayTextView text size
    val launcher = registerForActivityResult(ActivityResultContracts
        .StartActivityForResult()){
    if (it.resultCode == RESULT_OK){
        it.data?.apply {
            lyricsDisplayTextView.textSize = getFloatExtra(TEXT_SIZE_MESSAGE,
                0.0f);
        }
    }
    }
    private lateinit var lyricsDisplayTextView: TextView
    private lateinit var textSizeSelectorButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display)

        lyricsDisplayTextView = findViewById(R.id.lyricsDisplayTextView)
        textSizeSelectorButton = findViewById(R.id.textSizeSelectorButton)

        textSizeSelectorButton.setOnClickListener {
            var launchIntent = Intent(this@DisplayActivity,
                TextSizeActivity::class.java)

            launcher.launch(launchIntent)
        }
    }
}