package com.example.as_lab02_linerlayout

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private var selectedMood = 0
    private lateinit var moodImages: List<ImageView>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moodImages = listOf(
            findViewById(R.id.mood1),
            findViewById(R.id.mood2),
            findViewById(R.id.mood3),
            findViewById(R.id.mood4),
            findViewById(R.id.mood5)
        )
        moodImages.forEachIndexed { index, imageView ->
            imageView.setOnClickListener {
                selectMood(index)
    }
}

        val saveButton: Button = findViewById(R.id.saveButton)
        saveButton.setOnClickListener {
            saveMood()
        }

        val cancelButton: Button = findViewById(R.id.cancelButton)
        cancelButton.setOnClickListener {
            clearForm()
    }
}

    private fun selectMood(index: Int){
    selectedMood = index + 1
    moodImages.forEachIndexed { i, imageView ->
        if (i <= index){
            imageView.setImageResource(android.R.drawable.btn_star_big_on)
        } else{
            imageView.setImageResource(android.R.drawable.btn_star_big_off)
        }
    }
}

    private fun saveMood(){
        val commentEditText: EditText = findViewById(R.id.commentEditText)
        val comment = commentEditText.text.toString()
        if (selectedMood == 0){
            Toast.makeText(this,"Выберите настроение!", Toast.LENGTH_SHORT).show()
            return
        }
        val message = "Настроение: $selectedMood/5\nКомментарий: $comment"
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        clearForm()
    }

    private fun clearForm(){
        selectedMood = 0
        moodImages.forEach{
            it.setImageResource(android.R.drawable.btn_star_big_off)
        }
        val commentEditText: EditText = findViewById(R.id.commentEditText)
        commentEditText.setText("")
    }
}