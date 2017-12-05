/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.patrick.demo.java8kattas.utils;

import com.technologyconversations.java8exercises.streams.Person;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author patrickn
 */
public class PersonUtils {
    public static final String GENERATE_XSD_OUTPUT_DIR = "src/main/resources/json";
    //https://restcountries.eu/rest/v2/all
    
  
    public static JSONArray names ;
    public static JSONArray countries ;
    
    static{
        
         JSONParser parser = new JSONParser();
        try {
            Object obj = parser.parse(new FileReader("src/main/resources/json/coutries.json"));
            countries = (JSONArray) obj;
            
            Object obj2 = parser.parse(new FileReader("src/main/resources/json/names.json"));
            names = (JSONArray) obj2;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(PersonUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(PersonUtils.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(PersonUtils.class.getName()).log(Level.SEVERE, null, ex);
        }catch (Exception e){
            Logger.getLogger(PersonUtils.class.getName()).log(Level.SEVERE, null, e);
        }

        
    }
    public static void  getCountries(){
        
        try {
            File dir = new File(GENERATE_XSD_OUTPUT_DIR);
            if(!dir.exists())
                dir.mkdir();

		URL url = new URL("https://restcountries.eu/rest/v2/all");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

                
                StringBuilder sb = new StringBuilder();
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
                        sb.append(output);
		}

                File out = new File(dir, "coutries.json");
                if(out.exists())
                    out.delete();
                out.createNewFile();
                PrintStream outStream = new PrintStream(new FileOutputStream(out));
                outStream.print(sb);
		conn.disconnect();

	  } catch (MalformedURLException e) {

		e.printStackTrace();

	  } catch (IOException e) {

		e.printStackTrace();

	  }

        
    }
    
    public static Person getRandomPerson(){
        
        int indexName = new Random().nextInt(names.size());
        String name = (String) names.get(indexName);
        
        int indexNameCountry = new Random().nextInt(countries.size());
        String country = (String) ((Map) countries.get(indexNameCountry)).get("name");
        
        return new Person(name, new Random().nextInt(80), country);
        
    }
    
    public static List<Person> getPersonList(int size){
        List<Person> ret = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            ret.add(getRandomPerson());
        }
        return ret;
    }
    
    
    
}
