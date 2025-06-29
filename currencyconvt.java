import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;
import org.json.JSONObject;

public class RealTimeCurrencyConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.println("🌐 Real-Time Currency Converter");

            
            System.out.print("Enter base currency (e.g., USD): ");
            String base = sc.nextLine().toUpperCase();

            System.out.print("Enter target currency (e.g., INR): ");
            String target = sc.nextLine().toUpperCase();

            System.out.print("Enter amount to convert: ");
            double amount = sc.nextDouble();

            
            String apiUrl = "https://api.exchangerate-api.com/v4/latest/" + base;
            URL url = new URL(apiUrl);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer responseContent = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                responseContent.append(inputLine);
            }
            in.close();

            
            JSONObject jsonObj = new JSONObject(responseContent.toString());
            JSONObject rates = jsonObj.getJSONObject("rates");

            if (!rates.has(target)) {
                System.out.println("❌ Invalid target currency!");
                return;
            }

            double rate = rates.getDouble(target);
            double result = amount * rate;

           
            System.out.printf("💱 %.2f %s = %.2f %s\n", amount, base, result, target);

        } catch (Exception e) {
            System.out.println("⚠️ Error fetching exchange rate: " + e.getMessage());
        }

        sc.close();
    }
}

