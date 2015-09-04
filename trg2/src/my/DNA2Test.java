package my;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mrunit.mapreduce.MapDriver;
import org.apache.hadoop.mrunit.mapreduce.MapReduceDriver;
import org.apache.hadoop.mrunit.mapreduce.ReduceDriver;
import org.apache.hadoop.mrunit.types.Pair;
import org.junit.Before;
import org.junit.Test;

public class DNA2Test {

	/*
	 * Declare harnesses that let you test a mapper, a reducer, and a mapper and
	 * a reducer working together.
	 */
	MapDriver<Object, Text, Text, Text> mapDriver;
	ReduceDriver<Text, Text, Text, Text> reduceDriver;
	MapReduceDriver<Object, Text, Text, Text, Text, Text> mapReduceDriver;

	/*
	 * Set up the test. This method will be called before every test.
	 */
	@Before
	public void setUp() {
		System.out.println("setup started");
		/*
		 * Set up the mapper test harness.
		 */
		DNA2Mapper mapper = new DNA2Mapper();
		mapDriver = new MapDriver<Object, Text, Text, Text>();
		mapDriver.setMapper(mapper);
		/*
		 * Set up the reducer test harness.
		 */
		DNA2Reducer reducer = new DNA2Reducer();
		reduceDriver = new ReduceDriver<Text, Text, Text, Text>();
		reduceDriver.setReducer(reducer);

		/*
		 * Set up the mapper/reducer test harness.
		 */
		mapReduceDriver = new MapReduceDriver<Object, Text, Text, Text, Text, Text>();
		mapReduceDriver.setMapper(mapper);
		mapReduceDriver.setReducer(reducer);
		
		
		System.out.println("setup finished");
	}

	/*
	 * Test the mapper.
	 */
//	@Test

	
//	public void testMapper() {

		/*
		 * For this test, the mapper's input will be "1 cat cat dog" TODO:
		 * implement
		 */

		/*
		mapDriver.setInputKey("1");
		mapDriver.setInputValue(new Text("this\nis\ntest\nstet"));
		List<Pair<Text, Text>> x;
		try {
			x = mapDriver.run();
			System.out.println (x.get(0).getFirst().toString());
			System.out.println (x.get(0).getSecond().toString());
			assertEquals(x.size(), 3);
			assertEquals(x.get(0).getFirst().toString(), "this");
			assertEquals(x.get(1).getFirst().toString(), "");
			assertEquals(x.get(2).getFirst().toString(), "test");
			
			for(Pair<Text, LongWritable> p:x)
			{
				System.out.println("MAPPER: " + p.getFirst() + ": " + p.getSecond());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
*/
	
//	}


	/*
	 * Test the reducer.
	 */
	//@Test
	//public void testReducer() {

		/*
		 * For this test, the reducer's input will be "cat 1 1". The expected
		 * output is "cat 2". TODO: implement
		 */
		
		//fail("Please implement test.");

	//}

	/*
	 * Test the mapper and reducer working together.
	 */

	@Test
	public void testMapReduce() throws IOException {
		
		
		mapReduceDriver.addInput(new Pair<Object, Text>(1, new Text("User1\tACGT")));
		mapReduceDriver.addInput(new Pair<Object, Text>(2, new Text("User2\tTGCA")));
		mapReduceDriver.addInput(new Pair<Object, Text>(3, new Text("User3\tACG")));
		mapReduceDriver.addInput(new Pair<Object, Text>(4, new Text("User4\tACGT")));
		mapReduceDriver.addInput(new Pair<Object, Text>(5, new Text("User5\tACG")));
		mapReduceDriver.addInput(new Pair<Object, Text>(6, new Text("User6\tAGCT")));
		
		
		List<Pair<Text, Text>> output = mapReduceDriver.run();
		
		//assertEquals(11, output.size());
		for (Pair<Text, Text> p : output) {
			System.out.println(p.getFirst() + "-" + p.getSecond());
		}
		
	}
	
}
