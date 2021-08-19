package com.vaniala.threads

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tvData: TextView
    lateinit var progress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn = findViewById<Button>(R.id.button_load_data)
        tvData = findViewById(R.id.textview_data)
        progress = findViewById(R.id.progressbar_load_indicator)

        //TODO: 018 - fazer o handle do clique do botão
        btn.setOnClickListener {
            launchAsyncTask()
        }
    }


    fun showData(astros: List<AstrosPeople>?) {
        tvData.text = ""
        astros?.forEach { people ->
            tvData.append("${people.name} - ${people.craft} \n\n\n")
        }
    }

    fun showLoadingIndicator() {
        progress.visibility = View.VISIBLE
    }

    fun hideLoadingIndicator() {
        progress.visibility = View.GONE
    }

    fun launchAsyncTask() {
        AstrosTask().execute()
    }


    inner class AstrosTask() : AsyncTask<Void, Void, List<AstrosPeople>?>() {
        private val repository = AstrosRepository()

        override fun onPreExecute() {
            super.onPreExecute()
            showLoadingIndicator()
        }

        override fun doInBackground(vararg params: Void?): List<AstrosPeople>? {
            val result = repository.loadAstros()
            return result?.people
        }

        override fun onPostExecute(result: List<AstrosPeople>?) {
            super.onPostExecute(result)
            hideLoadingIndicator()
            showData(result)
        }
    }


}