import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Main {
    static boolean PrefixChecker(String [] PrefixesList, String fourNumbers, String fiveNumbers) {
        return Arrays.asList(PrefixesList).contains(fourNumbers) || Arrays.asList(PrefixesList).contains(fiveNumbers);
    }

    public static void main(String[] args) {
        String [] MTNPrefixes = {"0703","0706","0803","0806","0810","0813","0814","0816","0903","0906","0913","0916","07025","07026","0704"};
        String [] AirtelPrefixes = {"0701","0708","0802","0808","0812","0901","0902","0904","0907","0912"};
        String [] GlobacomPrefixes ={"0705","0805","0807","0811","0815","0905","0915"};
        String [] NineMobilePrefixes = {"0809","0817","0818","0909","0908"};
        String [] MTELPrefixes={"0804"};

        ArrayList<String> MTN = new ArrayList<String>();
        ArrayList<String> Airtel = new ArrayList<String>();
        ArrayList<String> Globalcom = new ArrayList<String>();
        ArrayList<String> NineMobile = new ArrayList<String>();
        ArrayList<String> MTEL = new ArrayList<String>();

        try{
            File resource = new File("PhoneNumbers.txt");
            Scanner myReader = new Scanner(resource);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                Boolean MTNCheck = PrefixChecker(MTNPrefixes, data.substring(0, 4), data.substring(0, 5));
                Boolean MTELCheck = PrefixChecker(MTELPrefixes, data.substring(0, 4), data.substring(0, 5));
                Boolean AirtleCheck = PrefixChecker(AirtelPrefixes, data.substring(0, 4), data.substring(0, 5));
                Boolean GlobalcomCheck = PrefixChecker(GlobacomPrefixes, data.substring(0, 4), data.substring(0, 5));
                Boolean NineMobileCheck = PrefixChecker(NineMobilePrefixes, data.substring(0, 4), data.substring(0, 5));
                if (MTNCheck){
                    MTN.add(data);
                } else if (AirtleCheck) {
                    Airtel.add(data);
                } else if (GlobalcomCheck) {
                    Globalcom.add(data);
                } else if (NineMobileCheck) {
                    NineMobile.add(data);
                }else if (MTELCheck) {
                    MTEL.add(data);
                }
            }
            myReader.close();

            System.out.println("Summary Report");
            System.out.println("Total MTN Numbers: "+ MTN.size());
            System.out.println("Total MTEL Numbers: "+ MTEL.size());
            System.out.println("Total Airtel Numbers: "+ Airtel.size());
            System.out.println("Total 9Mobile Numbers: "+ NineMobile.size());
            System.out.println("Total Globacom Numbers: "+ Globalcom.size());

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred getting the File");
        }
    }
}