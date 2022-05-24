package com.smart.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        val notificationId=123

        val icontext:TextView=findViewById(R.id.icontext)
        val titletext:TextView=findViewById(R.id.titletext)
        val textext:TextView=findViewById(R.id.texttext)
        val again:Button=findViewById(R.id.againbutton)


        val iconString= intent.extras?.get("spinner")
        val title= intent.extras?.get("title")
        val text=intent.extras?.get("text")

        icontext.text=iconString.toString()
        titletext.text=title.toString()
        textext.text=text.toString()

        var icon:Int = R.drawable.ic_stat_name
        when (iconString as String){
            "android"-> icon = R.drawable.ic_stat_name
            "comment"-> icon = R.drawable.ic_stat_comment
            "chat" -> icon = R.drawable.ic_stat_chat
        }



            val builder = NotificationCompat.Builder(this,"channel").setSmallIcon(icon).setContentTitle(title as String).setContentText(text as String).setPriority(NotificationCompat.PRIORITY_DEFAULT)
            with(NotificationManagerCompat.from(this)){
                notify(notificationId,builder.build())
            }

        again.setOnClickListener {
            finish()
        }

    }
}