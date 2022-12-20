package com.example.coach.controleur;

import com.example.coach.modele.Profil;
import com.example.coach.outils.Serializer;
import android.content.Context;

public final class Controle {
    private static Controle instance = null ;
    private static Profil profil;
    private static String nomFic = "saveprofil";

    /**
     * constructeur privé
     */
    private Controle(){
        super();
    }

    /**
     * récupération de l'instance unique de Controle
     * @return instance
     */
    public static final Controle getInstance(Context context){
        if(Controle.instance == null){
            Controle.instance = new Controle();
            recupSerialize(context);
        }
        return Controle.instance;
    }

    /**
     * Création du profil
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1 pour homme, 0 pour femme
     * @param context
     */
    public void creerProfil(Integer poids, Integer taille, Integer age, Integer sexe, Context context){
        profil = new Profil(poids, taille, age, sexe);
        Serializer.serialize(nomFic, profil, context);
    }

    /**
     * getter sur l'img du profil
     * @return img
     */
    public float getImg(){
        return profil.getImg();
    }

    /**
     * getter sur le message du profil
     * @return message
     */
    public String getMessage(){
        return profil.getMessage();
    }

    /**
     * récupération du profil sérialisé et affichage des informations
     * @param context
     */
    private static void recupSerialize(Context context){
        profil = (Profil)Serializer.deSerialize(nomFic, context);
    }

    public Object getTaille() {
        if(profil != null){
            return profil.getTaille();
        }
        return null;
    }

    public Integer getPoids() {
        if(profil != null){
            return profil.getPoids();
        }
        return null;
    }

    public Integer getAge() {
        if(profil != null){
            return profil.getAge();
        }
        return null;
    }

    public Integer getSexe() {
        if(profil != null){
            return profil.getSexe();
        }
        return null;
    }

}
