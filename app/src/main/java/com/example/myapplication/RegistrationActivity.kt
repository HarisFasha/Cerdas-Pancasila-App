package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatSpinner

class RegistrationActivity : AppCompatActivity() {

    private lateinit var nameEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var gradeSpinner: AppCompatSpinner
    private lateinit var registerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        this.enableEdgeToEdge()
        nameEditText = findViewById(R.id.name_edittext)
        ageEditText = findViewById(R.id.age_edittext)
        gradeSpinner = findViewById(R.id.grade_spinner)
        registerButton = findViewById(R.id.register_button)

        // Set up the grade spinner with options
        val gradeOptions = resources.getStringArray(R.array.grades)
        gradeSpinner.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, gradeOptions)

        // Check if user has already registered
        val sharedPreferences = getSharedPreferences("QuizApp", Context.MODE_PRIVATE)
        val name = sharedPreferences.getString("name", "")
        val age = sharedPreferences.getInt("age", 0)
        val grade = sharedPreferences.getString("grade", "")

        if (!name.isNullOrEmpty()) {
            if (!grade.isNullOrEmpty()) {
                // User has already registered, start AppScreen activity
                val intent = Intent(this, AppScreen::class.java)
                intent.putExtra("name", name)
                intent.putExtra("age", age)
                intent.putExtra("grade", grade)
                startActivity(intent)
                finish()
            }
        }

        registerButton.setOnClickListener {
            try {
                val name = nameEditText.text.toString()
                val ageString = ageEditText.text.toString()
                val age = ageString.toInt()
                // Check if the age is valid
                if (age <= 0) {
                    Toast.makeText(this, "Umur Harus lebih dari 0", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                val selectedGrade = gradeSpinner.getSelectedItem().toString()

                // Validate input data
                if (name.isEmpty() || selectedGrade.isEmpty()) {
                    Toast.makeText(this, "Isi semua Isian", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                // Save user data to local storage
                val editor = sharedPreferences.edit()
                editor.putString("name", name)
                editor.putInt("age", age)
                editor.putString("grade", selectedGrade)
                editor.apply()

                // Start the quiz activity with the user's data
                val intent = Intent(this, AppScreen::class.java)
                intent.putExtra("name", name)
                intent.putExtra("age", age)
                intent.putExtra("grade", selectedGrade)
                startActivity(intent)

                finish()
            } catch (e: NumberFormatException) {
                Toast.makeText(this, "Format Umur Salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}