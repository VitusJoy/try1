package com.login.vitus.try1;

/**
 * Created by fujitsu on 14-Jan-18.
 */

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

public class BackgroundWorker extends AsyncTask<String,Void,String> {

    Context context;
    AlertDialog alertDialog;

    BackgroundWorker(Context ctx){
        context = ctx;
    }

    @Override
    protected String doInBackground(String... voids) {

        String type = voids[0];
        String login_url = "http://ec2-13-127-130-48.ap-south-1.compute.amazonaws.com/Android/login.php"; //<<<----Server ip here

        if (type.equals("login")){

            try {

                String usn = voids[1];
                String pass = voids[2];

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String post_data = URLEncoder.encode("usn","UTF-8")+"="+URLEncoder.encode(usn,"UTF-8")+"&"
                        +URLEncoder.encode("pass","UTF-8")+"="+URLEncoder.encode(pass,"UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();

                InputStream inputStream =httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while ((line = bufferedReader.readLine())!=null){
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }

        }

        return null;

    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Login Status");

    }

    @Override
    protected void onPostExecute(String result) {
        alertDialog.setMessage(result);
        alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
