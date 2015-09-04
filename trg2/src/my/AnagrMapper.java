package my;
import java.io.IOException;
import java.util.Arrays;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AnagrMapper extends Mapper<Object, Text, Text, Text> {

  @Override
  public void map(Object key, Text value, Context context)
      throws IOException, InterruptedException {
    /*
     * TODO implement
     */
	  String[] words = value.toString().split("\n");
	  for(String word:words)
	  {
		  char[] wordchars = word.toCharArray();
		  Arrays.sort(wordchars);
		  System.out.println("MapKey:" + new String(wordchars) + " MapValue:" + word);
		 
		  
		  //System.out.println ("MapKey: " + newWord + " MapValue: " + word);
		  
		  context.write(new Text(new String(wordchars)),  new Text(word));
	  }
  }
}
