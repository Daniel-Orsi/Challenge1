package com.example.challenge1

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel : ViewModel() {


    val finalResult = MutableLiveData<String>()


    fun calculate(a: Int, b: Int) {
        getMajor(a, b)
        getResult(getMajor(a, b))
    }


    private fun getMajor(a: Int, b: Int): Sizes {
        when (a >= b) {
            true -> return Sizes(a, b)
            false -> return Sizes(b, a)
        }
    }


    private fun getResult(sizes: Sizes) {

        var major = sizes.sizeA
        var minor = sizes.sizeB
        var result = "Result: \n"
        var index = 0


        if (major == 0 || minor == 0) {

            result = "If any of the measures is equal to zero, there is no such paper"
            finalResult.postValue(result)

        }else{
            while (major > minor) {

                result = result.plus("1 Square of size $minor x $minor + \n ")

                index = index.plus(1)
                if (major - minor < minor) {

                    val major1 = minor
                    minor = major - minor
                    major = major1

                } else {

                    major = major.minus(minor)
                    minor = minor
                }
            }

            result = result.plus("1 Square of size $major x $major \n" )
            index = index.plus(1)

            result = result.plus("Total= $index Squares")

            finalResult.postValue(result)
        }
    }


}





