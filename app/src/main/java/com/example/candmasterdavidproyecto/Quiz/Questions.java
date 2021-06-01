package com.example.candmasterdavidproyecto.Quiz;

public class Questions {


    public String mQuestions[] = {

            "¿Cual es el perro mas listo del mundo?",
            "Cual es el perro por excelencia de la policia",
            "¿Cual es el perro mas cariñoso?",
            "¿Cual es el perro mas rapido del mundo?",
            "¿Cual de estas razas es un perro de pastoreo?",
            "¿Cual de estas razas es la mas maltratada en España?",
            "¿Cual de estas razas es la que esta mas de moda por videos de youtube",
            "¿Cual de estas razas  es un perro de caza?",
            "¿Cual de estas razas es la mas pequeña?"
    };


    private String mChoise[][] = {
            {"Border Collie", "Belga Malinois", "Beagle", "Galgo"},
            {"Belga Malinois", "Border Collie", "Galgo", "Beagle"},
            {"Galgo", "Beagle", "Border Collie", "Belga Malinois"},
            {"Beagle", "Galgo", "Belga Malinois", "Border Collie"},
            {"Galgo", "Border Collie", "Belga Malinois", "Beagle"},
            {"Galgo", "Beagle", "Border Collie", "Belga Malinois"},
            {"Beagle", "Galgo", "Belga Malinois", "Border Collie"},
            {"Border Collie", "Belga Malinois", "Beagle", "Galgo"},
            {"Beagle", "Galgo", "Belga Malinois", "Border Collie"}
    };


    private String mCorrectAnswer[] = {"Border Collie", "Belga Malinois", "Beagle", "Galgo","Border Collie","Galgo","Belga Malinois", "Beagle", "Beagle"};

    public String getQuestions(int a) {
        String question = mQuestions[a];
        return question;
    }

    public  String getChoice1(int a){
        String choice =  mChoise[a][0];
        return choice;
    }

    public  String getChoice2(int a){
        String choice =  mChoise[a][1];
        return choice;
    }
    public  String getChoice3(int a){
        String choice =  mChoise[a][2];
        return choice;
    }
    public  String getChoice4(int a){
        String choice =  mChoise[a][3];
        return choice;
    }



    public String getCorrectAnswer (int a){
        String answer =  mCorrectAnswer[a];
        return answer;
    }
}