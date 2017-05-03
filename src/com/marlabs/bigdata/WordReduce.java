package com.marlabs.bigdata;

import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class WordReduce extends Reducer<Text, LongWritable, Text, LongWritable> {
	
	@Override
	public void reduce(Text key, Iterable<LongWritable> value, Context context) throws IOException, InterruptedException{
		
		long sum=0;
		for(LongWritable val:value){
			
			sum = sum + val.get();
			
		}
		context.write(key,new LongWritable(sum));
	}

}
