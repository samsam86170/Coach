package com.example.coach.modele;

public class Profil {

    // constantes
    private static final Integer minFemme = 25; // maigre si en dessous
    private static final Integer maxFemme = 30; // gros si au dessus
    private static final Integer minHomme = 15; // maigre si en dessous
    private static final Integer maxHomme = 20; // gros si au dessus

    private Integer poids;
    private Integer taille;
    private Integer age;
    private Integer sexe;
    private float img;
    private String message;

    /**
     * constructeur : valorise poids, taille, age, sexe
     * et appelle les méthodes pour valoriser img et message
     * @param poids
     * @param taille en cm
     * @param age
     * @param sexe 1 pour homme, 0 pour femme
     */
    public Profil(Integer poids, Integer taille, Integer age, Integer sexe) {
        this.poids = poids;
        this.taille = taille;
        this.age = age;
        this.sexe = sexe;
        this.calculIMG();
        this.resultIMG();
    }

    /**
     * getter sur poids
     * @return poids
     */
    public Integer getPoids() {
        return poids;
    }

    /**
     * getter sur taille
     * @return taille en cm
     */
    public Integer getTaille() {
        return taille;
    }

    /**
     * getter sur age
     * @return age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * getter sur sexe
     * @return 1 pour homme, 0 pour femme
     */
    public Integer getSexe() {
        return sexe;
    }

    /**
     * getter sur img
     * @return img
     */
    public float getImg() {
        return img;
    }

    /**
     * getter sur message
     * @return "normal", "trop faible", "trop élevé"
     */
    public String getMessage() {
        return message;
    }

    /**
     * calcul de l'img
     */
    private void calculIMG(){
        float taillecm = ((float)taille)/100;
        this.img = (float)((1.2 * poids/(taillecm*taillecm)) + (0.23 * age) - (10.83 * sexe) - 5.4);
    }

    /**
     * création du message suivant la valeur de l'img et des constantes
     */
    private void resultIMG(){
        message = "normal";
        Integer min = minFemme, max = maxFemme;
        if(sexe == 1){
            min = minHomme;
            max = maxHomme;
        }
        else{
            min = minFemme;
            max = maxFemme;
        }
        if(img<min){
            message = "trop faible";
        }else{
            if(img>max){
                message = "trop élevé";
            }
        }
    }

}
