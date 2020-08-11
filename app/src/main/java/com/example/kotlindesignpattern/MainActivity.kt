package com.example.kotlindesignpattern

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.kotlindesignpattern.singleton.RetrofitService

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        AlertDialog.Builder(this)
            .setTitle("Ahmed Dialog")
            .setMessage("This is my Ahmed Dialog")
            .show()


        AlertDialog.Builder(this)
            .setTitle("new Ahmed Dialog")
            .setMessage("This is my new Ahmed Dialog")
            .setIcon(R.mipmap.ic_launcher_round)
            .show()

        AlertDialog.Builder(this)
            .setTitle("new Ahmed Dialog")
            .setMessage("This is my new Ahmed Dialog")
            .setIcon(R.mipmap.ic_launcher_round)
            .setPositiveButton("",object :DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {

                }
            })
            .setNegativeButton("",object :DialogInterface.OnClickListener{
                override fun onClick(dialog: DialogInterface?, which: Int) {

                }
            })
            .show()
    }
}