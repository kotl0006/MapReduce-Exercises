package my;
import java.io.IOException;

import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class DNA2Reducer extends Reducer<Text, Text, Text, Text> {

  @Override
  public void reduce(Text key, Iterable<Text> values, Context context)
      throws IOException, InterruptedException {
	  
	  String dnaMatches = new String();
	  int numMatches = 0;
	  
	  for(Text iw:values)
	  {
		  numMatches ++;
		  if (numMatches == 1)
			  dnaMatches += iw.toString();
		  	  
		  else
			  dnaMatches += "," + iw.toString();

	  }
	  
	  if (numMatches > 1) 
		  context.write(key, new Text(dnaMatches));
  }
}
