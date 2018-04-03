/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restfula1;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;
import org.json.JSONObject;
/**
 *
 * @author entrar
 */
public class RestfulA1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws MalformedURLException, IOException {
           
        String s = "http://services.groupkt.com/country/get/iso2code/IN";
        URL url = new URL(s);
        URLConnection tc = url.openConnection();
        BufferedReader in = new BufferedReader(new InputStreamReader(tc.getInputStream()));
        String rest = new String();
        String line;
        while((line = in.readLine()) !=null){
            rest+=line;
        }
        System.out.println(rest);
        in.close();

        JSONObject obj = new JSONObject(rest);
        JSONObject res = obj.getJSONObject("RestResponse").getJSONObject("result");
        System.out.println("res: "+ res);
        String r1 = res.toString();
        System.out.println("r1: "+r1);
        Gson gson = new Gson();
        Country  target = gson.fromJson(r1, Country.class);
        System.out.println(target.getName());
        
        
       
    }
    
}
