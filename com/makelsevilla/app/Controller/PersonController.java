package com.makelsevilla.app.Controller;

import java.sql.ResultSet;
import com.makelsevilla.app.DB;
import com.makelsevilla.app.Model.Person;

/**
 * PersonController
 */
public class PersonController {
    private DB db = DB.getInstance();

    public static void main(String[] args) {
        PersonController personController = new PersonController();
        Person p1 = personController.show(3);

        System.out.println(p1.getFullName());
        personController.delete(3);
    }

    public Person show(int id) {
        String fname = "", lname = "";
        int age = 0; 

        try {
            ResultSet result = db.query(String.format("SELECT * FROM persons WHERE id = %d LIMIT 1", id));

            if(result.next()) {

                fname = result.getString("fname");
                lname = result.getString("lname");
                age = result.getInt("age");
            } else {
                System.out.println("No results found.");
            }
        } catch (Exception e) {
            // System.out.println(e);
            e.printStackTrace();
            return null;
        }

        // print
        // System.out.println("Full Name");
        // System.out.println("\tFirst: " + fname);
        // System.out.println("\tLast: " + lname);
        // System.out.println("Age: " + age);

        return new Person(fname, lname, age);
    }

    public void insert(String fname, String lname, int age) {

    }

    public void update() {

    }

    public void delete(int id) {
        String query = "DELETE FROM persons WHERE id = " + id;
        try {
            if(db.execute(query) != 0) {
                System.out.println("Successfullly deleted");
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}