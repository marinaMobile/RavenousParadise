package com.habby.archeroa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.habby.archeroa.BIGClass.Companion.grhtyhyddd
import com.habby.archeroa.BIGClass.Companion.lkflflflds
import com.habby.archeroa.BIGClass.Companion.lnlnlnlnlnlnln
import com.habby.archeroa.databinding.ActivityMainBinding
import kotlinx.coroutines.*
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    lateinit var bibibibibiibi: ActivityMainBinding
    lateinit var jojojjojojoj: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bibibibibiibi = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bibibibibiibi.root)
        jojojjojojoj = ""
        val job = GlobalScope.launch(Dispatchers.IO) {
            jojojjojojoj = coTask()
        }

        runBlocking {
            try {
                job.join()

                if (jojojjojojoj == grhtyhyddd) {
                    Intent(applicationContext, UGamer::class.java).also { startActivity(it) }
                } else {
                    Intent(applicationContext, LetsDoIt::class.java).also { startActivity(it) }
                }
                finish()
            } catch (e: Exception) {

            }
        }

    }

    private suspend fun coTask(): String {

        val nmnmnmnmnmnmnmnmmnm =
            "${lkflflflds}${lnlnlnlnlnlnln}"

        withContext(Dispatchers.IO) {
            codecodecodecode(nmnmnmnmnmnmnmnmmnm)
//            Log.d("Check1C", nmnmnmnmnmnmnmnmmnm)
        }
        return jojojjojojoj
    }

    private fun codecodecodecode(link: String) {
        val ruleri = URL(link)
        val conconconconcon = ruleri.openConnection() as HttpURLConnection

        try {
            val txtxtxtxttxtxtxtx = conconconconcon.inputStream.bufferedReader().readText()
            if (txtxtxtxttxtxtxtx.isNotEmpty()) {

                jojojjojojoj = txtxtxtxttxtxtxtx
            }
        } catch (ex: Exception) {

        } finally {
            conconconconcon.disconnect()
        }
    }
}
