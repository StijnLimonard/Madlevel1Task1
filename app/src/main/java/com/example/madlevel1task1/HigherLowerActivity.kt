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
    private var diceimages = arrayOf(R.drawable.dice1, R.drawable.dice2,R.drawable.dice3,R.drawable.dice4,R.drawable.dice5, R.drawable.dice6)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHigherLowerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViews()
    }

    fun initViews(){
        updateUI()
        binding.btnEqual.setOnClickListener(){ onEqualClick() }
        binding.btnHigher.setOnClickListener(){ onHigherClick() }
        binding.btnLower.setOnClickListener(){ onLowerClick() }
        binding.diceImage.setOnClickListener(){updateUI()}
    }
    fun updateUI(){
        binding.lastThrowText.text = getString(R.string.last_throw, lastThrow)
        binding.diceImage.setImageResource(diceimages[lastThrow-1])

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
        Toast.makeText(this, getString(R.string.correctanswer) +currentThrow,Toast.LENGTH_SHORT).show()
    }

    /**
     * Displays an incorrect Toast message.
     */
    private fun onAnswerIncorrect() {
        Toast.makeText(this, getString(R.string.incorrectanswer) +currentThrow,Toast.LENGTH_SHORT).show()
        }
}