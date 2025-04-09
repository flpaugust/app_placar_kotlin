package com.example.placar

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.placar.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var playerOneScore = 0
    private var playerTwoScore = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setUpExtras(savedInstanceState)
        setUpListener()
    }

    private fun setUpListener() {
        binding.btPlayerOneScore.setOnClickListener{
           playerOneScore++
           binding.tvPlayerOneScore.text = playerOneScore.toString()
        }

        binding.btPlayerTwoScore.setOnClickListener{
            playerTwoScore++
            binding.tvPlayerTwoScore.text = playerTwoScore.toString()
        }
    }

    private fun setUpExtras(savedInstanceState: Bundle?) {

        if(savedInstanceState != null){
            playerOneScore = savedInstanceState.getInt("PLAYER1", 0)
            playerTwoScore = savedInstanceState.getInt("PLAYER2", 0)
            binding.tvPlayerOneScore.text = playerOneScore.toString()
            binding.tvPlayerTwoScore.text = playerOneScore.toString()



        }
        binding.tvPlayerOneName.text = intent.getStringExtra("PLAYER1")
        binding.tvPlayerTwoName.text = intent.getStringExtra("PLAYER2")


    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("PLAYER_ONE_SCORE", playerOneScore)
        outState.putInt("PLAYER_TWO_SCORE", playerTwoScore)
    }
}