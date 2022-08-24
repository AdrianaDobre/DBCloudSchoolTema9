package com.DobreAdrianaLiaTema9.DobreAdrianaLiaTema9.exception;

public class NoStudentException extends Exception{
    public NoStudentException(){
        super("The student does not exist!");
    }
}
