package com.example.Gesbib.exeption;

public enum ErrorCodes {
    ADHERENT_NOT_FOUND(1000),
    ADHERENT_NOT_VALID(1001),
    AUTEUR_NOT_FOUND(2000),
    AUTEUR_NOT_VALID(2001),
    //TODO complete the rest of the error codes
    BIBLIOTHEQUAIRE_NOT_FOUND(3000),
    BIBLIOTHEQUAIRE_NOT_VALID(3001),
    CATEGORIE_NOT_FOUND(4000),
    CATEGORIE_NOT_VALID(4001),
    COMPTE_NOT_FOUND(5000),
    EMPRUNTER_NOT_FOUND(6000),
    ETAT_LIVRE_NOT_FOUND(7000),
    EXEMPLAIRE_NOT_FOUND(8000),
    LIVRE_NOT_FOUND(9000),
    LIVRE_NOT_VALID(9001),
    POSSEDER_NOT_FOUND(10000),
    RESERVER_NOT_FOUND(11000),
    RESERVER_NOT_VALID(11001),
    SANCTION_NOT_FOUND(12000),
    ;

    private int code;

    ErrorCodes(int code){
        this.code = code;
    }

    public int getCode(){
        return code;
    }
}
