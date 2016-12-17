package com.example.quent.geophone;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by quent on 17/12/2016.
 */

public class Contact implements AdapterView.OnClickListener{

    private String nomContact;
    private String telContact;
    private String mailContact;
    private String bluetoothContact;
    private String wifiContact;
    private int nbContact;

    public String getNomContact()
    {
        return nomContact;
    }

    public void setNomContact(String name)
    {
        this.nomContact = name;
    }

    public String getTelContact()
    {
        return telContact;
    }

    public void setTelContact(String tel)
    {
        this.telContact = tel;
    }


    public String getMailContact()
    {
        return mailContact;
    }

    public void setMailContact(String mail)
    {
        this.mailContact = mail;
    }

    public String getBluetoothContact()
    {
        return bluetoothContact;
    }

    public void setBluetoothContact(String bluetooth)
    {
        this.bluetoothContact = bluetooth;
    }

    public String getWifiContact()
    {
        return wifiContact;
    }

    public void setWifiContact(String wifi)
    {
        this.wifiContact = wifi;
    }

    public int getNbContact()
    {
        return nbContact;
    }

    public void setNbContact(int nb)
    {
        this.nbContact = nb;
    }

    public int incNbContact()
    {

        int nombreContact = getNbContact()+1;
        this.nbContact = nombreContact;
        return nombreContact;
    }



    @Override
    public void onClick(View v) {

    }
}
