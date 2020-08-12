package com.example.kotlindesignpattern.builder

import android.app.Dialog
import android.content.Context
import android.view.View

class RecyclerCustomDialog private constructor(val mcontext: Context) : Dialog(mcontext) {


    class Builder internal constructor(val context: Context) {

        private var myDialog = RecyclerCustomDialog(context)


        fun setView(res: Int): Builder {
            myDialog.setContentView(res)
            return this
        }

        fun setView(view: View): Builder {
            myDialog.setContentView(view)
            return this
        }

        fun setType(type: Dialogtype): Builder {
            when (type) {
                is Dialogtype.SUCCESSERROR -> {
                    myDialog
                }
                is Dialogtype.INFO -> {

                }

            }


            return this
        }


        sealed class Dialogtype {
            class SUCCESSERROR : Dialogtype()
            class INFO : Dialogtype()
        }

    }


}

