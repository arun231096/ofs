package com.objectfrontier.training.java.base;
/* Jobs to be done :- 

    get the full name
    get the last name from full name
    get the initial(First letter) letter from the last name
    get the console from system
    print the first name with initial

    Entity Identification :- 
        actor -  developer
        Entity :- ComputerInitial, String
    */

public class ComputeInitial {

    public static void main(String[] args) {

        ComputeInitial name = new ComputeInitial();
        // displayNameWithInitial (fullname)
        name.displayNameWithInitial(args[0], args[1]);
    }

    private void displayNameWithInitial(String firstname, String lastname) {

        //firstname = getFirstName();
        //lastname = getLastName();
        //initial = getFirstLetterOfLastname(lastname)
        //nameWithInitial = firstname+initial;
        String nameWithInitial = firstname+" "+lastname.charAt(0);
        //Console console = new Console();
        //console.print(nameWithInitial);
        System.out.println(nameWithInitial);
    }
}
