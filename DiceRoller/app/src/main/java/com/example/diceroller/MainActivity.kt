package com.example.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import android.widget.Button
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        //Second button "countUp"
        val countButton: Button = findViewById(R.id.countup_button)
        countButton.setOnClickListener { countUp() }

        //Reset button "reset"
        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() }
    }

    // rollDice button
    private fun rollDice() {
        // This following line is for the emergent message "button clicked"
        //A toast is a view that shows the user a simple message in a small popup window.
        //Toast.makeText(this, "button clicked",
        //Toast.LENGTH_SHORT).show()
        val resultText: TextView = findViewById(R.id.result_text)
        //THis line is used for show the text
        //resultText.text = "Dice Rolled!"
        val randomInt = (1..6).random()
        resultText.text = randomInt.toString()
    }

    // countUp button
    private fun countUp() {
        val resultText: TextView = findViewById(R.id.result_text)
        //If the result text view does not yet contain a number
        // (that is, if the text view still has the default "Hello World" string), set the result text to 1.

        if (resultText.text == "Hello World!") {
            resultText.text = "1"
        } else {
            //If the number is already 6, do nothing.

            var resultInt = resultText.text.toString().toInt()

            if (resultInt < 6) {
                resultInt++
                resultText.text = resultInt.toString()
            }
        }
    }

    // reset button - Homework
    // "Reset" that appears just below the Roll button. Have that button
    // reset the result text view to 0.
    private fun reset() {
        val resultText: TextView = findViewById(R.id.result_text)
        resultText.text = "0"
    }
}