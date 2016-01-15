package com.example.minhtien.btbuoi10;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;

import Objects.Item;

/**
 * Created by minhtien on 1/12/16.
 */
public class MyDefaulHandle extends DefaultHandler {
    private ArrayList<Item> arrNews=new ArrayList<Item>();
    private Item item=new Item();
    public static final String KEY_ITEM="item";
    public static final String KEY_TITLE="title";
    public static final String KEY_PUBDATE="pubDate";
    public static final String KEY_LINK="link";
    public static final String KEY_DESC="description";
    private StringBuilder builder;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        if (qName.equalsIgnoreCase(KEY_ITEM)){
            item = new Item();
        }
        builder = new StringBuilder();
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equalsIgnoreCase(KEY_TITLE)){
            item.setTitle(builder.toString());
        }else if (qName.equalsIgnoreCase(KEY_PUBDATE)){
            item.setPubDate(builder.toString());
        }else if (qName.equalsIgnoreCase(KEY_LINK)){
            item.setLink(builder.toString());
        }else if (qName.equalsIgnoreCase(KEY_DESC)){
            int index=builder.toString().lastIndexOf("http");
            if (index!=-1) {
                String str = builder.toString().substring(0, index);
                String img = builder.toString().replace(str, "");
                img = img.substring(0, img.indexOf("'"));
                item.setImage(img);
            }
        }else if(qName.equalsIgnoreCase(KEY_ITEM)){
            //Khi dong 1 item
            arrNews.add(item);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        builder.append(ch, start, length);
    }

    public ArrayList<Item> getArrNews() {
        return arrNews;
    }
}
