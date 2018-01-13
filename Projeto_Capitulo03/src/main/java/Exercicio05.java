import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by suemareverton on 14/08/17.
 * Apache Commons IO
 * IOUtils
 */
public class Exercicio05 {

    public static void main(String[] args) {

        // Forma tradicional
        InputStream in = null;
        /*try {
            in = new URL( "https://www.java.com" ).openStream();
            InputStreamReader inR = new InputStreamReader(in);
            BufferedReader buf = new BufferedReader(inR);
            String line;
            while ( ( line = buf.readLine() ) != null ) {
                System.out.println( line );
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            if(in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }*/

        // IOUtils
        try {
            in = new URL( "https://www.java.com").openStream();
            System.out.println( IOUtils.toString( in ) );
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(in);
        }
    }

}
