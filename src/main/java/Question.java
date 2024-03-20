import java.util.ArrayList;

public class Question {
   private ArrayList<String> Question;
   ArrayList<String> Answer;



    public void ShowQuestion (int number)
    {
            System.out.println(Question.get(number-1)+"\n\n");
    }
    public void AddQuestion()
    {
        Question.add("Which of these numbers if divided by 7 will have a remainder?");

    }






}
