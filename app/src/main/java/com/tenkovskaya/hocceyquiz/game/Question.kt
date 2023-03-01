package com.tenkovskaya.hocceyquiz.game

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.tenkovskaya.hocceyquiz.R
import com.tenkovskaya.hocceyquiz.data.QuestionData
import com.tenkovskaya.hocceyquiz.data.DataSet
import kotlinx.android.synthetic.main.activity_question.*


class Question : AppCompatActivity() {

    private var Name:String? = null
    private var score:Int = 0

    private var positionCurrent:Int = 1
    private var arrayListQuestion:ArrayList<QuestionData> ? = null
    private var optionSeleckt:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        Name = intent.getStringExtra(DataSet.name)

        arrayListQuestion = DataSet.getQuestion()

        questionSet()


        questionR_1.setOnClickListener{
            optionStyleSelected(questionR_1,1)
            selectOptionCorrect()
        }

        questionR_2.setOnClickListener{
            optionStyleSelected(questionR_2,2)
            selectOptionCorrect()
        }

        questionR_3.setOnClickListener{
            optionStyleSelected(questionR_3,3)
            selectOptionCorrect()
        }

        questionR_4.setOnClickListener{
            optionStyleSelected(questionR_4,4)
            selectOptionCorrect()
        }



        bt_next_question.setOnClickListener {
            bt_next_question.isSelected != bt_next_question.isSelected
            positionCurrent++
            when {
                positionCurrent <= arrayListQuestion!!.size->{
                    questionSet()
                }
                else->{
                    var intent= Intent(this, Result::class.java)
                    intent.putExtra(DataSet.name, Name.toString())
                    intent.putExtra(DataSet.score, score.toString())
                    intent.putExtra("total size", arrayListQuestion!!.size.toString())

                    startActivity(intent)
                    finish()
                }
            }

            bt_next_question.isClickable = false
            optionBtn(true)
        }

    }
    @SuppressLint("SetTextI18n")
    fun questionSet(){
        val question = arrayListQuestion!![positionCurrent - 1]
        setStyle()

        progress_text.text="${positionCurrent}"+"/"+"${arrayListQuestion!!.size}"
        question_text.text=question.question
        questionR_1.text=question.option_one
        questionR_2.text=question.option_tw0
        questionR_3.text=question.option_three
        questionR_4.text=question.option_four

    }

    fun optionBtn(isDisabled: Boolean) {
        questionR_1.isClickable = isDisabled
        questionR_2.isClickable = isDisabled
        questionR_3.isClickable = isDisabled
        questionR_4.isClickable = isDisabled
    }

    fun optionStyleSelected(view: TextView, opt: Int) {
        setStyle()
        optionSeleckt = opt
        view.apply {
            background = ContextCompat.getDrawable(this@Question, R.drawable.selected_question_option)
            typeface = Typeface.DEFAULT_BOLD
            setTextColor(Color.parseColor("#000000"))
        }
    }


    fun selectOptionCorrect() {
        val question = arrayListQuestion!![positionCurrent-1]

        val selectedOptionIsCorrect = optionSeleckt == question.correct_ans

        if (!selectedOptionIsCorrect) {
            highlightOption(optionSeleckt, R.drawable.wrong_question_option)
        } else {
            score++
        }

        highlightOption(question.correct_ans, R.drawable.correct_question_option)

        bt_next_question.text = if (positionCurrent == arrayListQuestion!!.size) "Finish" else "Go to Next"

        optionSeleckt = 0
        optionBtn(false)
        bt_next_question.isClickable = true
    }



    fun highlightOption(option: Int, color: Int) {
        val optionView = when (option) {
            1 -> questionR_1
            2 -> questionR_2
            3 -> questionR_3
            4 -> questionR_4
            else -> throw IllegalArgumentException("Invalid option number: $option")
        }
        optionView.background = ContextCompat.getDrawable(this, color)
    }


    private fun setStyle() {
        val optionList = listOf(questionR_1, questionR_2, questionR_3, questionR_4)

        optionList.forEach { option ->
            with(option) {
                setTextColor(Color.parseColor("#555151"))
                background = ContextCompat.getDrawable(this@Question, R.drawable.ramka)
                typeface = Typeface.DEFAULT
            }
        }
    }



}