package com.abhijith.a7minuteworkout

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.abhijith.a7minuteworkout.databinding.ActivityFinishBinding
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class FinishActivity : AppCompatActivity() {

    private var binding: ActivityFinishBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinishBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        setSupportActionBar(binding?.toolbarFinishActivity)
        // to show the back navigation button
        if (supportActionBar != null) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
        binding?.toolbarFinishActivity?.setNavigationOnClickListener {
            onBackPressed()
        }

        binding?.btnFinish?.setOnClickListener {
            finish()
        }

        val dao = (application as WorkOutApp).db.historyDao()
        addDateToDatabase(dao)

    }

    private fun addDateToDatabase(historyDao: HistoryDao) {

        val c = Calendar.getInstance()
        val dateTime = c.time
        Log.e("Date", "" + dateTime)

        val sdf = SimpleDateFormat("dd MM yyyy HH:mm:ss", Locale.getDefault())
        val date = sdf.format(dateTime)
        Log.e("Formatted Date : ", "" + date)


        lifecycleScope.launch {
            historyDao.insert(HistoryEntity(date))
            Log.e("Date", "Added... ")
        }

    }
}