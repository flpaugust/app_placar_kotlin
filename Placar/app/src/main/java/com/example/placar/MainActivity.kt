package com.example.placar

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
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

        binding.btFinishMatch.setOnClickListener {
            val ret = Intent()
            ret.putExtra(KEY_RESULT_EXTRA_PLAYER_ONE_NAME, binding.tvPlayerOneName.text.toString())
            ret.putExtra(KEY_RESULT_EXTRA_PLAYER_TWO_NAME, binding.tvPlayerTwoName.text.toString())
            ret.putExtra(KEY_RESULT_EXTRA_PLAYER_ONE_SCORE,
                binding.tvPlayerOneScore.text.toString().toInt())
            ret.putExtra(KEY_RESULT_EXTRA_PLAYER_TWO_SCORE,
                binding.tvPlayerTwoScore.text.toString().toInt())
            setResult(RESULT_OK, ret)
            super.finish()
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