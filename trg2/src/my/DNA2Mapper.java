package my;
import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;


public class DNA2Mapper extends Mapper<Object, Text, Text, Text> {

  @Override
  public void map(Object key, Text value, Context context)
      throws IOException, InterruptedException {
    /*
     * TODO implement
     */
	  String[] words = value.toString().split("\t");
	  
	  
	  String reverseDNA = new StringBuilder(words[1]).reverse().toString();
	  
	  String dnaValue = (reverseDNA.compareTo(words[1]) > 0)? reverseDNA : words[1];
	  
	  context.write(new Text(dnaValue),  new Text(words[0]));
  }
}
