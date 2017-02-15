package com.def;

import java.util.Scanner;


//tasks
public class Player {
	//
	public static void main (String [] args)
	{
		//
		
		//сканнер для считывания
		Scanner sc = new Scanner(System.in);
		//долгота
		String LONG = sc.next();
		//широта
		String LAT = sc.next();
		//число дефиблиряторов
		int N = sc.nextInt();
		//
		Defibrilator [] def = new Defibrilator [N];
		//
		sc.nextLine();
		//
		for (int i = 0; i < N; i++)
		{
			String s = sc.nextLine();
			String [] array = s.split("\\;");
			//
			
			def[i] = new Defibrilator();
			def[i].setId(array[0]);
			def[i].setName(array[1]);
			def[i].setAdress(array[2]);
			def[i].setPhoneNumber(array[3]);
			def[i].setLongitude(Double.parseDouble(array[4].replace(',', '.')));
			def[i].setLatitude(Double.parseDouble(array[5].replace(',', '.')));
			
		}
		//Calulate Min distance
		double mDistance = minDistance(LONG, LAT, def[0]);
		String name = def[0].getName();
		for (int i = 1; i <N; i++)
		{
			double locminDist = minDistance(LONG,LAT, def[i]);
			if (locminDist<mDistance)
			{
				mDistance = locminDist;
				name = def[i].getName();
			}
		}
		System.out.println(name);
		
		
	}
	public static double minDistance (String longitude, String lat, Defibrilator d)
	{
		//angle in radians
		double rlongitudeB = Double.parseDouble(longitude.replace(',', '.'))*(Math.PI/180);
		//angle in radians
		double rlatitudeB = Double.parseDouble(lat.replace(',', '.'))*(Math.PI/180);
		//
		double rlongitudeA = d.getLongitude()*(Math.PI/180);
		double rlatitudeA = d.getLatitude()*(Math.PI/180);
		//
		double x = (rlongitudeB-rlongitudeA)*Math.cos(0.5*(rlatitudeA+rlatitudeB));
		//
		double y = rlatitudeB-rlatitudeA;
		//
		double distance = Math.sqrt(x*x+y*y);
		return distance*6371;
	}

}
class Defibrilator
{
	String id;
	String name;
	String adress;
	String phoneNumber;
	double longitude;
	double latitude;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

 