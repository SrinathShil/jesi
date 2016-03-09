package jesi;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.testng.annotations.Test;

public class NewTest {
  @Test
  public void f() throws IOException {
	  System.out.println("hello1ss");
	  URL url= new URL("http://localhost:8089/rest");
HttpURLConnection con=  (HttpURLConnection) url.openConnection();
con.setRequestMethod("POST");
System.out.println("END ofconnection");

}
}
