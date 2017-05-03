package com.marlabs.bigdata;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class WordMain {
	
	public static void main(String args[]) throws IOException, ClassNotFoundException, InterruptedException
	{
		
		if(args.length!=2)
		{
			System.err.println("invalid");
			System.exit(0);
		}
		Configuration conf = new Configuration();
		Job job = new Job(conf,"WordMain");
		
		job.setJarByClass(WordMain.class);
		
		job.setMapperClass(WordMap.class);
		job.setMapOutputKeyClass(Text.class);
		job.setMapOutputValueClass(LongWritable.class);
		
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(LongWritable.class);
		job.setReducerClass(WordReduce.class);
		
		FileInputFormat.setInputPaths(job,new Path (args[0]));
		FileOutputFormat.setOutputPath(job, new Path (args[1]));
		
		job.waitForCompletion(true);
		
	}

}
