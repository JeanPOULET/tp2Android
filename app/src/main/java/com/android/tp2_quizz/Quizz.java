package com.android.tp2_quizz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Quizz {


    String tasmanie = "Le diable de Tasmanie vit dans la jungle du Brésil.";
    String sauterelle = "La sauterelle saute l\'équivalent de 200 fois sa taille.";
    String pandas = "Les pandas hibernent.";
    String dromadaire = "On trouve des dromadaires en liberté en Australie.";
    String papillon = "Le papillon monarque vole plus de 4000km";
    String gorille = "Les gorilles mâles dorment dans les arbres.";
    private String[] qs = {tasmanie, sauterelle, pandas, dromadaire, papillon, gorille};


    private static List<String> questions;
    private static List<Boolean> reponses;

    public Quizz() {
        questions = new ArrayList<>();
        reponses = new ArrayList<>();
        this.addAll();

    }

    public void addAll() {
        questions.addAll(Arrays.asList(qs));
        reponses.add(false);
        reponses.add(true);
        reponses.add(false);
        reponses.add(true);
        reponses.add(true);
        reponses.add(false);
    }

    public void addQuestion(String question) {
        questions.add(question);
    }

    public void addQuestion(int index, String question) {
        questions.add(question);
    }

    public void addReponse(String reponse){
        if(reponse.equalsIgnoreCase("true") || reponse.equalsIgnoreCase("vrai")){
            reponses.add(true);
        }else{
            reponses.add(false);
        }
    }

    public void addReponse(int index, String reponse){
        if(reponse.equalsIgnoreCase("true") || reponse.equalsIgnoreCase("vrai")){
            reponses.add(index,true);
        }else{
            reponses.add(index,false);
        }
    }

    public void remove(int index){
        reponses.remove(index);
        questions.remove(index);
    }

    public List<String> getQuestions(){
        return this.questions;
    }
    public List<Boolean> getReponses(){
        return this.reponses;
    }

    public int size(){
        return questions.size();
    }
}
