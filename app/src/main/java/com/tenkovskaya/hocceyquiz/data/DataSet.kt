package com.tenkovskaya.hocceyquiz.data

object DataSet {

    const val name:String="name"
    const val score:String="score"

   fun getQuestion():ArrayList<QuestionData>{
       val questionDataArrayList:ArrayList<QuestionData> = arrayListOf()


       val question1 = QuestionData(
           1,
           "What is the maximum number of players allowed on the ice during a game of hockey?",

           "5",
           "6",
           "7",
           "8",
           2
       )
       val question2 = QuestionData(
           2,
           "What is the penalty called when a player uses their stick to trip an opponent?",

           "Holding",
           "Interference",
           "Tripping",
           "Slashing",
           3
       )
       val question3 = QuestionData(
           3,
           "How long is a standard period in a game of ice hockey?",

           "10 minutes",
           "15 minutes",
           "20 minutes",
           "25 minutes",
           3
       )
       val question4 = QuestionData(
           4,
           "What is the area called where a goalie is allowed to play the puck outside of their crease?",

           "Goal zone",
           "Neutral zone",
           "Restricted zone",
           "Trapping zone",
           1
       )

       val question5 = QuestionData(
           5,
           "What is the name of the trophy awarded to the team that wins the NHL championship?\n",

           "Stanley Cup",
           "President's Trophy",
           "Vezina Trophy",
           "Conn Smythe Trophy",
           1
       )

       val question6 = QuestionData(
           6,
           "What is the term used to describe when a team is short-handed due to a penalty?",

           "Power play",
           "Penalty kill",
           "Faceoff",
           "Offside",
           2
       )

       val question7 = QuestionData(
           7,
           "Which country has won the most Olympic gold medals in men's ice hockey?",

           "Russia",
           "Canada",
           "Sweden",
           "United States",
           2
       )

       val question8 = QuestionData(
           8,
           "What is the name of the protective gear worn by a player to protect their head?",

           "Shoulder pads",
           "Elbow pads",
           "Helmet",
           "Shin guards",
           3
       )

       val question9 = QuestionData(
           9,
           "What is the name of the player who takes faceoffs for their team?",

           "Center",
           "Defenseman",
           "Forward",
           "Goalie",
           1
       )

       val question10 = QuestionData(
           10,
           "How many players are on the ice for each team during a power play?",

           "3",
           "4",
           "5",
           "6",
           1
       )



       questionDataArrayList.add(question1)
       questionDataArrayList.add(question2)
       questionDataArrayList.add(question3)
       questionDataArrayList.add(question4)
       questionDataArrayList.add(question5)
       questionDataArrayList.add(question6)
       questionDataArrayList.add(question7)
       questionDataArrayList.add(question8)
       questionDataArrayList.add(question9)
       questionDataArrayList.add(question10)

       return questionDataArrayList
   }
}