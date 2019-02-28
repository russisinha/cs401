package com.couponworld.Business;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.couponworld.Entities.*;
import com.couponworld.common.constants;

public class readfile_data {
	
	public Linked_list readfile(int length, String file) throws Exception {
		Linked_list lt = new Linked_list(length);
		String line = null;
		
	    FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        int counter = 0;
        while((line = bufferedReader.readLine()) != null) {
        	counter++;
            String[] data = line.split("##");
        	Date expiry = constants.convertToDate(data[4]);
        	coupon_entity cp = new coupon_entity(data[0], data[1], Integer.parseInt(data[2]), Integer.parseInt(data[3]), expiry, "unused", true);
    		int timeStamp = Integer.parseInt(new SimpleDateFormat("MMddHHmmss").format(new Date())) + counter; 
        	cp.set_cID(timeStamp);
    		lt.add(cp);
        }
        bufferedReader.close();
		
		return lt;
	}
	
}
