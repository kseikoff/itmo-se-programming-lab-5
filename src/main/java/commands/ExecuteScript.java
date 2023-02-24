package commands;

import org.apache.commons.io.IOUtils;

import dataBase.DataBase;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;

public class ExecuteScript extends BaseCommand {

    public static LinkedList<String> historyOfDangerScript = new LinkedList<>();

    public void execute(DataBase obj) throws IOException {
        if (historyOfDangerScript.contains(super.getParameter())){
            System.out.println("Loop in script");
            return;
        }
        File file = new File (super.getParameter());
        try (InputStream in = new FileInputStream(file))
        {
            String contents = IOUtils.toString(in, StandardCharsets.UTF_8);
            var a = contents.split("\n");
            for (var t: a){
                if (t.split(" ")[0].equals("execute_script")){
                    historyOfDangerScript.add(super.getParameter());
                }
                CommandHandler.handleCommand(t);
            }
        }
        catch (IOException e) {
            System.out.println("Incorrect script");
        }
        historyOfDangerScript.clear();
    }

    public void describe() {

    }
}
