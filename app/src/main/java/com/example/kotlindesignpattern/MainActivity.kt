package com.example.kotlindesignpattern

import android.os.Bundle
import android.util.AttributeSet
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.kotlindesignpattern.factory.without_factory.MyView
import java.nio.file.attribute.AttributeView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myView= MyView(this)
        setContentView(myView)
//        val mainView = findViewById<ConstraintLayout>(R.id.root)
//
//        val display = windowManager.defaultDisplay
//        val width = display.width
//        val height = display.height
//
//        val number_side = width / 100
//        val number_down = height / 100

//            mainView.addView(
//                MyView(
//                    this
//                )
//            )


    }


    override fun onResume() {
        super.onResume()
        /*AlertDialog.Builder(this)
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
            .show()*/
    }


}