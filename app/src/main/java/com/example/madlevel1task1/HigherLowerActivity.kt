package com.example.madlevel1task1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.madlevel1task1.databinding.ActivityHigherLowerBinding
import kotlinx.android.synthetic.main.activity_higher_lower.*

class HigherLowerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHigherLowerBinding
    private var currentThrow: Int = 1
    private var lastThrow: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_higher_lower)
    }

    fun initViews(){
        updateUI()
        binding.btnEqual.setOnClickListener(){ onEqualClick() }
        binding.btnHigher.setOnClickListener(){ onHigherClick() }
        binding.btnLower.setOnClickListener(){ onLowerClick() }
    }
    fun updateUI(){
        binding.lastThrowText.text = getString(R.string.last_throw, lastThrow)
    }

    private fun rollDice() {
        lastThrow = currentThrow
        currentThrow = (1..6).random()
        updateUI()
    }

    private fun onHigherClick() {
        rollDice()
        if(lastThrow > currentThrow){
            onAnswerCorrect()
        }else{
            onAnswerIncorrect()
        }
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onLowerClick() {
        rollDice()
        if(lastThrow < currentThrow){
            onAnswerCorrect()
        }else{
            onAnswerIncorrect()
        }
    }

    /**
     * Calls [rollDice] and checks if the answer is correct.
     */
    private fun onEqualClick() {
        rollDice()
        if(lastThrow == currentThrow){
            onAnswerCorrect()
        }else{
            onAnswerIncorrect()
        }
    }

    private fun onAnswerCorrect() {
        //Implement this function yourself!
        Toast.makeText(this, getString(R.string.correctanswer),Toast.LENGTH_SHORT).show()
    }

    /**
     * Displays an incorrect Toast message.
     */
    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrectanswer),Toast.LENGTH_SHORT).show()
    }
}