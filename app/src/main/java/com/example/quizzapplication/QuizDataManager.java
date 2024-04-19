package com.example.quizzapplication;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class QuizDataManager {
    public static List<Question> getQuestions() {
        List<Question> questions = new ArrayList<>();

        questions.add(new Question("Which team did Lewis Hamilton drive for in the 2021 Formula 1 season?",
                Arrays.asList("Red Bull", "Ferrari", "Mercedes", "McLaren"), 2));
        questions.add(new Question("Who won the Formula 1 World Championship in 2020?",
                Arrays.asList("Max Verstappen", "Sebastian Vettel", "Lewis Hamilton", "Charles Leclerc"), 2));
        questions.add(new Question("What color is traditionally associated with Ferrari in Formula 1?",
                Arrays.asList("Green", "Blue", "Red", "Yellow"), 2));
        questions.add(new Question("In what year did Formula 1 start?",
                Arrays.asList("1950", "1960", "1940", "1970"), 0));
        questions.add(new Question("Which country hosts the race known as the Monaco Grand Prix?",
                Arrays.asList("France", "Italy", "Monaco", "Spain"), 2));
        questions.add(new Question("Which driver has won the most Formula 1 World Championships?",
                Arrays.asList("Michael Schumacher", "Lewis Hamilton", "Juan Manuel Fangio", "Alain Prost"), 1));
        questions.add(new Question("What is the name of the official Formula 1 tire supplier as of 2021?",
                Arrays.asList("Michelin", "Pirelli", "Goodyear", "Bridgestone"), 1));
        questions.add(new Question("Which circuit is the longest in the current Formula 1 calendar?",
                Arrays.asList("Monza", "Spa-Francorchamps", "Silverstone", "Monaco"), 1));
        questions.add(new Question("Who was the youngest Formula 1 champion?",
                Arrays.asList("Sebastian Vettel", "Lewis Hamilton", "Fernando Alonso", "Max Verstappen"), 0));
        questions.add(new Question("What is DRS in Formula 1?",
                Arrays.asList("Driver Rotation System", "Drag Reduction System", "Dynamic Race Simulation", "Downforce Reduction Setup"), 1));

        return questions;
    }

}
