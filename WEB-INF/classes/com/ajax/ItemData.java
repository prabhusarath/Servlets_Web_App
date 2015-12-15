package com.ajax;

import java.util.*;
import java.io.*;


public class ItemData{

	private HashMap items;


	public HashMap getitems(){
		return items;
	}

	public ItemData(){
		items = new HashMap();
		items.put("ps1",new MainCatalogItem("ps1","Play Station 3 - Limited Edition","SONY Limited 32GB Play Station 3 - Limited Edition",150.00));
		items.put("ps2",new MainCatalogItem("ps2","Play Station 3 - Black Edition","SONY Black 32GB Play Station 3 - Black Edition ",150.00));
		items.put("ps3",new MainCatalogItem("ps3","Play Station 3 - Yellow Edition","SONY Yellow 32GB Play Station 3 - Yellow Edition",150.00));
		items.put("ps4",new MainCatalogItem("ps4","Play Station 4 - BATMAN Edition","SONY BATMAN Play Station 4 - BATMAN Edition",150.00));
		items.put("x1",new MainCatalogItem("x1","X Box Original","MICROSOFT X Box Original",120.00));
		items.put("x2",new MainCatalogItem("x2","X Box 360","MICROSOFT X Box 360",120.00));
		items.put("x3",new MainCatalogItem("x3","X Box One","MICROSOFT X Box One",120.00));
		items.put("wii1",new MainCatalogItem("wii1","WII-1X","NINTENDO WII-1X",100.00));
		items.put("wii2",new MainCatalogItem("wii2","WII-2X","NINTENDO WII-2X", 100.00));
		items.put("wii3",new MainCatalogItem("wii3","WIIU","NINTENDO WIIU",100.00));			
		items.put("games1",new MainCatalogItem("games1","Assasins Creed 4 - PS3","Assasins Creed 4 - PS3",50.00));
		items.put("games2",new MainCatalogItem("games2","God Of War 3 - PS4","God Of War 3 - PS4",50.00));
		items.put("games3",new MainCatalogItem("games3","Mario 8 Racing - WII"," Mario 8 Racing - WII ",50.00));
		items.put("games4",new MainCatalogItem("games4","All Stars Battle Royal - PSVITA","All Stars Battle Royal - PSVITA",50.00));
		items.put("a1",new MainCatalogItem("a1","PS4 - Race Controller","by SONY PS4 - Race Controller",80.00));
		items.put("a2",new MainCatalogItem("a2","XBOXController","by MICROSOFT XBOXController",80.00));
		items.put("a3",new MainCatalogItem("a3","WII Controller -Special Edition","by NINTENDO WII Controller -Special Edition",80.00));
	}
}