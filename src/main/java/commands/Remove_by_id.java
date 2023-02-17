package commands;

import dataBase.DataBase;
import defaultClasses.Person;

import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Iterator;


public class Remove_by_id extends BaseCommand {

    public void execute(DataBase obj) throws IOException {
        try{
            Long a = Long.parseLong(super.getParameter());
            var array = obj.getCollection();
            Iterator<Person> it = array.iterator();
            while(it.hasNext()){
                if(it.next().getId().equals(a)){
                    it.remove();
                    break;
                }
            }
            System.out.println("Element with id " + a + " removed");
        }catch (Exception e){
            System.out.println("Incorrect argument, command cannot be executed");
        }

    }


    public void describe() {

    }
}