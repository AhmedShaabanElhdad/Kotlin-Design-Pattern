package com.example.kotlindesignpattern.builder

import java.math.BigInteger
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException

//
class PersonWithoutBuilder {

    var fname: String
    var lname: String
    var username: String
    var gender: String
    var address: ArrayList<String>
    var phone: String
    var phoneCode: String?
    var date: String?
    var email: String
    var password: String
    var language: String?
    var accessCode: String?
    var CC: String?
    var DOB: String?


    // we have to process these different variations of handling at once.
    // there are "too many things going on" in function blocks, like the constructor?
    // It is cluttered by logic of handling different parameters.
    constructor(
        fname: String,
        lname: String,
        gender: String,
        address: ArrayList<String>?,
        phone: String,
        phoneCode: String?,
        date: String?,
        email: String,
        password: String,
        language: String?,
        accessCode: String?,
        CC: String?,
        DOB: String?
    ) {
        this.fname = fname.capitalize()
        this.lname = lname.capitalize()
        this.username = "$fname $lname"
        this.gender = gender
        if (address!!.isNullOrEmpty())
            throw Error("Empty Address")
        this.address = address
        if (phone.length != 11)
            throw Error("in valid Phone")
        this.phone = phone
        this.phoneCode = phoneCode
        //make in new format if api needed
        this.date = date
        this.email = email


        //encrypt password as api want or generate api for user
        try {
            val md: MessageDigest = MessageDigest.getInstance("MD5")
            val messageDigest: ByteArray = md.digest(password.toByteArray())
            val number = BigInteger(1, messageDigest)
            var md5: String = number.toString(16)
            while (md5.length < 32) md5 = "0$md5"
            this.password = md5
        } catch (e: NoSuchAlgorithmException) {
            this.password = ""
        }

        this.language = language
        this.accessCode = accessCode
        this.CC = CC
        this.DOB = DOB

    }
}


class PersonWithBuilder private constructor(
    val fname: String,
    val lname: String,
    val gender: String,
    val address: ArrayList<String>?,
    val phone: String?,
    val password: String,
    val email: String
) {


    var phoneCode: String? = null
        private set
    var date: String? = null
        private set
    var language: String? = null
        private set
    var accessCode: String? = null
        private set
    var CC: String? = null
        private set
    var DOB: String? = null
        private set

    class Builder internal constructor(
        val fname: String,
        val lname: String,
        val gender: String,
        val address: ArrayList<String>?,
        val phone: String?,
        val password: String,
        val email: String
    ) {

        private var personToBuild: PersonWithBuilder? = null

        init {
            personToBuild = PersonWithBuilder(fname, lname, gender, address, phone, password, email)
        }

        internal fun build(): PersonWithBuilder? {
            val builtPerson = personToBuild
            //personToBuild = PersonWithBuilder(fname,lname,gender,address,phone,password,email)
            return builtPerson
        }

        fun setfPhoneCode(phoneCode: String): Builder {
            this.personToBuild!!.phoneCode = fname
            return this
        }

        fun setDate(date: String): Builder {
            this.personToBuild!!.date = date
            return this
        }

        fun setLanguage(language: String): Builder {
            this.personToBuild!!.language = language
            return this
        }

        fun setAccessCode(accessCode: String): Builder {
            this.personToBuild!!.accessCode = accessCode
            return this
        }

        fun setCC(CC: String): Builder {
            this.personToBuild!!.CC = CC
            return this
        }

        fun setDOB(DOB: String): Builder {
            this.personToBuild!!.DOB = DOB
            return this
        }
    }

}

data class Person(
    val fname: String,
    val lname: String,
    val gender: String,
    val address: ArrayList<String>,
    val phone: String?,
    val password: String,
    val email: String,
    var phoneCode: String? = null,
    var date: String? = null,
    var language: String? = null,
    var accessCode: String? = null,
    var CC: String? = null,
    var DOB: String? = null
) {
    fun phoneCode(m: String) = apply {
        phoneCode = m
    } // No need to "return this"

    fun date(m: String) = apply {
        date = m
    } // No need to "return this"

    fun language(m: String) = apply {
        language = m
    } // No need to "return this"

    fun accessCode(m: String) = apply {
        accessCode = m
    } // No need to "return this"

    fun CC(m: String) = apply {
        CC = m
    } // No need to "return this"

    fun DOB(m: String) = apply {
        DOB = m
    } // No need to "return this"
}




fun testData() {

    var addresses = ArrayList<String>()
    addresses.add("9  anything street at anything city")


    val personWithoutBuilder = PersonWithoutBuilder("Ahmed", "Shaaban", "male", addresses, "01069845358", null, null,"ahmed.shaaban.elhdah@gmail.com","123456",null,null,null,null)

    val person = Person("Ahmed", "Shaaban", "male", addresses, "01069845358", "123456", "ahmed.shaaban.elhdah@gmail.com")
        .phoneCode("").date("").accessCode("")

    PersonWithBuilder.Builder("Ahmed", "Shaaban", "male", addresses, "01069845358", "123456", "ahmed.shaaban.elhdah@gmail.com")
        .setDate("")
        .setDOB("")
        .build()


    val myPerson = Person(fname = "Ahmed", lname = "Shaaban", gender = "male", address = addresses, phone = "01069845358", password = "123456", email = "ahmed.shaaban.elhdah@gmail.com")
    myPerson.date = ""
    myPerson.CC = ""
    myPerson.accessCode = ""


    DSLPerson.dslPerson("Ahmed", "Shaaban", "male", addresses, "01069845358", "123456", "ahmed.shaaban.elhdah@gmail.com")
    {
        accessCode = accessCode
    }


}


class DSLPerson(
    val fname: String,
    val lname: String,
    val gender: String,
    val address: ArrayList<String>,
    val phone: String?,
    val password: String,
    val email: String,
    var phoneCode: String? = null,
    var date: String? = null,
    var language: String? = null,
    var accessCode: String? = null,
    var CC: String? = null,
    var DOB: String? = null
) {
    private constructor(builder: Builder) : this(
        builder.fname,
        builder.lname,
        builder.gender,
        builder.address,
        builder.phone,
        builder.password,
        builder.email,
        builder.phoneCode,
        builder.date,
        builder.language,
        builder.accessCode,
        builder.CC,
        builder.DOB
    )

    companion object {
        inline fun dslPerson(
            fname: String,
            lname: String,
            gender: String,
            address: ArrayList<String>,
            phone: String,
            password: String,
            email: String,
            block: DSLPerson.Builder.() -> Unit
        ) =
            DSLPerson.Builder(fname, lname, gender, address, phone, password, email).apply(block)
                .build()
    }

    class Builder(
        fname: String,
        lname: String,
        gender: String,
        address: ArrayList<String>,
        phone: String,
        password: String,
        email: String
    ) {
        var fname: String = fname
        var lname: String = lname
        var gender: String = gender
        var address: ArrayList<String> = address
        var phone: String = phone
        var password: String = password
        var email: String = email
        var phoneCode: String? = null
        var date: String? = null
        var language: String? = null
        var accessCode: String? = null
        var CC: String? = null
        var DOB: String? = null
        fun build() = DSLPerson(this)
    }
}