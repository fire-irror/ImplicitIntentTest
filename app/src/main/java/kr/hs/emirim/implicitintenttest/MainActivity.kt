package kr.hs.emirim.implicitintenttest

import android.app.SearchManager
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btnCall : Button
    lateinit var btnPicture : Button
    lateinit var btnSms : Button
    lateinit var btnSearch : Button
    lateinit var btnMap : Button
    lateinit var btnHome : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "암시적 인텐트 연습"

        btnCall = findViewById(R.id.btnCall)
        btnPicture = findViewById(R.id.btnPicture)
        btnSms = findViewById(R.id.btnSms)
        btnSearch = findViewById(R.id.btnSearch)
        btnMap = findViewById(R.id.btnMap)
        btnHome = findViewById(R.id.btnHome)

        btnCall.setOnClickListener{
            var uri = Uri.parse("tel:010-3333-1234")
            var intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }


        btnHome.setOnClickListener{
            var uri = Uri.parse("http://m.naver.com")
            var intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        btnMap.setOnClickListener{
            var uri = Uri.parse("https://maps.google.com/maps?q="+37.4663507+","+126.9328951)
            var intent = Intent(Intent.ACTION_VIEW,uri)
            startActivity(intent)
        }

        btnSearch.setOnClickListener{
            var intent = Intent(Intent.ACTION_WEB_SEARCH)
            intent.putExtra(SearchManager.QUERY,"미림마이스터고")
            startActivity(intent)
        }

        btnSms.setOnClickListener{
            var intent = Intent(Intent.ACTION_SENDTO)
            intent.putExtra("sms_body","효진이 바보")
            intent.data = Uri.parse("smsto:"+Uri.encode("02-777-3333"))
            startActivity(intent)
        }

        btnPicture.setOnClickListener{
           var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
    }
}