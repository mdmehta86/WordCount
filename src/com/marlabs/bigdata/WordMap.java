package com.marlabs.bigdata;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordMap extends Mapper<LongWritable, Text, Text, LongWritable>{
	
	@Override
	public void map(LongWritable key , Text value ,Context context) throws IOException, InterruptedException{
		
		String s = value.toString();
		String st[] = s.split(" ");
		for(int i=0;i<st.length;i++)
		{
			context.write(new Text(st[i]),new LongWritable(1));
			
		}
	}

}
