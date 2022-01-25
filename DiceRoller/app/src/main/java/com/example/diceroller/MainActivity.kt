package com.example.diceroller

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import android.widget.Button
import android.widget.ImageView
import java.util.*




class MainActivity : AppCompatActivity() {
    //The lateinit keyword promises the Kotlin compiler that the
    // variable will be initialized before the code calls any operations on it.
    lateinit var diceImage : ImageView

    //DiceRoller 2
    lateinit var diceImage2 : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the Button view from the layout and assign a click
        // listener to it.
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        diceImage = findViewById(R.id.dice_image)
        diceImage2 = findViewById(R.id.dice_image2)

        //Clear button
        val clearButton: Button = findViewById(R.id.clear_button)
        clearButton.setOnClickListener { clear() }
    }


    private fun rollDice() {
        // DiceRoller1
        diceImage.setImageResource(getRandomDiceImage())
        //DiceRoller2
        diceImage2.setImageResource(getRandomDiceImage())
    }


    //Private function to get a random drawable
    // image and return an integer for the drawable resource,
    // for each of the dice images.
    private fun getRandomDiceImage() : Int {
        val randomInt = (1..6).random()

        return when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
    }

    // reset button - Homework
    // "Reset" that appears just below the Roll button. Have that button
    // reset the result text view to 0 = empty_dyce image.
    private fun clear() {
        // Dice1
        diceImage.setImageResource(R.drawable.empty_dice)
        //Dice2
        diceImage2.setImageResource(R.drawable.empty_dice)
    }

}



/* Original code of the diceRoller before use the images
class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val diceImage : ImageView = findViewById(R.id.dice_image)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }
        diceImage = findViewById(R.id.dice_image)

        /*
        //Second button "countUp"
        val countButton: Button = findViewById(R.id.countup_button)
        countButton.setOnClickListener { countUp() }

        //Reset button "reset"
        val resetButton: Button = findViewById(R.id.reset_button)
        resetButton.setOnClickListener { reset() } */
    }

    // rollDice button
    private fun rollDice() {
        // This following line is for the emergent message "button clicked"
        //A toast is a view that shows the user a simple message in a small popup window.
        //Toast.makeText(this, "button clicked",
        //Toast.LENGTH_SHORT).show()
       // val diceImage: ImageView = findViewById(R.id.dice_image)
        //THis line is used for show the text
        //resultText.text = "Dice Rolled!"
        val randomInt = (1..6).random()
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }
        diceImage.setImageResource(drawableResource)
    }

    // countUp button
    /*private fun countUp() {
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
    } */
}*/