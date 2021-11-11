/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FileHandling;

import Model.Intervention;
import Model.PDQ;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.attribute.standard.SheetCollate;

/**
 *
 * @author osama
 */
public class WriteFile {
    private FileWriter fw = null;
    private BufferedWriter bw = null;
    private PrintWriter pw = null;
    
    public WriteFile(){
    }
    
    public WriteFile(String path){
        try {
            this.fw = new FileWriter(path, true);
        } catch (IOException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
        this.bw = new BufferedWriter(this.fw);
        this.pw = new PrintWriter(this.bw);
    }
    
    public void AddIntervention(Intervention intervention){
        String row = String.valueOf(intervention.GETIDINTERVENTION()).concat("\t").concat(intervention.GETDATEINCIDENT()).concat("\t").concat(intervention.GETCATÉGORIE()).concat("\t").concat(intervention.GETPDQ()).concat("\t").concat(intervention.GETQUARTTRAVAIL());
        this.pw.println(row);
        try {
            CloseStream();
        } catch (IOException ex) {
            Logger.getLogger(WriteFile.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println(ex.toString());
        }
    }
    
    public void UpdatePDQ(PDQ pdq, String pathway) throws IOException{
        Path path = Paths.get(pathway);
        List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
        int response = pdq.GetResponseRate();
        response += 1;
        String data = String.valueOf(pdq.GetPDQNUM()).concat(";").concat(pdq.GetLocation()).concat(";").concat(String.valueOf(response));
        System.out.println(data);
        lines.set(pdq.GetLineNumber() - 1, data);
        Files.write(path, lines, StandardCharsets.UTF_8);
    }
    
    public void CloseStream() throws IOException{
        this.bw.close();
        this.fw.close();
        this.pw.close();
    }
}
