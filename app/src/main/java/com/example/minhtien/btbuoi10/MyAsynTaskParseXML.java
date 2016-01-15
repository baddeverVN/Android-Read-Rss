package com.example.minhtien.btbuoi10;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.ArrayList;


import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import Objects.Item;

/**
 * Created by minhtien on 1/12/16.
 */
public class MyAsynTaskParseXML extends AsyncTask<String, Void, ArrayList<Item>> {
    private Context context;
    private Handler handler;

    public MyAsynTaskParseXML(Context context, Handler handler) {
        this.context = context;
        this.handler = handler;
    }

    @Override
    protected ArrayList<Item> doInBackground(String... params) {
        try {
            String link = params[0];
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            MyDefaulHandle myDefaulHandle = new MyDefaulHandle();
            parser.parse(link,myDefaulHandle);
            return myDefaulHandle.getArrNews();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    protected void onPostExecute(ArrayList<Item> items) {
        super.onPostExecute(items);
        if (items==null){
            Toast.makeText(context, "Parser fail", Toast.LENGTH_SHORT).show();
        }else{
            Message msg=new Message();
            msg.what= MainActivity.WHAT_DATA;
            msg.obj=items;
            handler.sendMessage(msg);

        }
    }
}
