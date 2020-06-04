package com.example.floating

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.floating.databinding.FragmentFrnCheckBinding

/**
 * A simple [Fragment] subclass.
 */
class FrnCheck : Fragment() {

    data class Question(
        val text: String,
        val answers: List<String>
    )

    private val questions: MutableList<Question> = mutableListOf(
        Question(
            text = "If you are getting bullied in front of your friend, what would your friend do?",
            answers = listOf(
                "Try and stop the bully",
                "Run for his safety",
                "Watch in silence",
                "Start bullying you"
            )
        ),
        Question(
            text = "What does your friend do when you ask for any help?",
            answers = listOf(
                "Offers to help",
                "Makes excuses",
                "Denies without thinking",
                "Changes the topic"
            )
        ),
        Question(
            text = "When did you last talk?",
            answers = listOf(
                "This month only",
                "It has been months",
                "It has been years",
                "We don\'t talk"
            )
        ),
        Question(
            text = "How comfortable are you sharing your secrets with your friend?",
            answers = listOf(
                "Extremely comfortable",
                "It is an iffy feeling",
                "Not at all comfortable",
                "My friend doesn\'t listen"
            )
        ),
        Question(
            text = "With whom does your friend like to hang out?",
            answers = listOf("Always me", "With his/her other friends", "Not always me", "Never me")
        ),
        Question(
            text = "Does your friend tell you his/her secrets",
            answers = listOf("Yes, always", "Never", "Maybe", "Sometimes")
        ),
        Question(
            text = "If you had a crush, and you told your friend, and then your crush asked your friend out, would he/she say yes??",
            answers = listOf("No chance", "There is a chance", "Of course", "Already happened once")
        ),
        Question(
            text = "If you see your friend talking to some friends, and he/she saw you coming down the hallway what would your friend do??",
            answers = listOf(
                "Include me in the convo",
                "Turn away and act like I was unseen",
                "Joke about me to the group",
                "Leave the place with the group"
            )
        ),
        Question(
            text = "Do you think your friend thinks of you as a good friend?",
            answers = listOf("Yes for sure", "Not at all", "Not sure", "I don\'t know")
        ),
        Question(
            text = "You won a contest. How does your friend react?",
            answers = listOf(
                "Smiles and congratulates you",
                "Gets jealous",
                "Pretends to smile",
                "Does nothing"
            )
        )
    )


    lateinit var currentQuestion: Question
    lateinit var answers: MutableList<String>
    private var questionIndex = 0
    private val numQuestions = Math.min((questions.size + 1) / 2, 3)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = DataBindingUtil.inflate<FragmentFrnCheckBinding>(
            inflater, R.layout.fragment_frn_check, container, false
        )


        randomizeQuestions()


        binding.game = this


        binding.submitButton.setOnClickListener @Suppress("UNUSED_ANONYMOUS_PARAMETER")
        { view: View ->
            val checkedId = binding.questionRadioGroup.checkedRadioButtonId
            // Do nothing if nothing is checked (id == -1)
            if (-1 != checkedId) {
                var answerIndex = 0
                when (checkedId) {
                    R.id.secondAnswerRadioButton -> answerIndex = 1
                    R.id.thirdAnswerRadioButton -> answerIndex = 2
                    R.id.fourthAnswerRadioButton -> answerIndex = 3
                }
                // The first answer in the original question is always the correct one, so if our
                // answer matches, we have the correct answer.
                if (answers[answerIndex] == currentQuestion.answers[0]) {
                    questionIndex++
                    // Advance to the next question
                    if (questionIndex < numQuestions) {
                        currentQuestion = questions[questionIndex]
                        setQuestion()
                        binding.invalidateAll()
                    } else {
                        // We've won!  Navigate to the gameWonFragment.
                        view.findNavController()
                            .navigate(FrnCheckDirections.actionFrnCheckToCheckGoodFrn())
                    }
                } else {
                    // Game over! A wrong answer sends us to the gameOverFragment.
                    view.findNavController()
                        .navigate(FrnCheckDirections.actionFrnCheckToCheckBadFrn())
                }
            }
        }
        return binding.root
    }


    private fun randomizeQuestions() {
        questions.shuffle()
        questionIndex = 0
        setQuestion()
    }


    private fun setQuestion() {
        currentQuestion = questions[questionIndex]
        // randomize the answers into a copy of the array
        answers = currentQuestion.answers.toMutableList()
        // and shuffle them
        answers.shuffle()
        (activity as AppCompatActivity).supportActionBar?.title =
            getString(R.string.frncheck_question, questionIndex + 1, numQuestions)
    }

}
