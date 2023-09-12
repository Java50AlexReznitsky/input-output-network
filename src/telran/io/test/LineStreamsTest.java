package telran.io.test;
import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LineStreamsTest {

	private static final String LINE = "Just Line";
	private static final String PRINT_STREAM_FILE = "PrintStreamFile";
	private static final String PRINT_WRITER_FILE = "PrintWriterFile";
	private static final String BIG_FILE ="big_file";
	private static final int N_LINES = 1_000_000;

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	@Order(1)
	@DisplayName("Output of lines using PrintStream")
	void printStreamtest() throws FileNotFoundException {
		try(PrintStream printStream = new PrintStream(PRINT_STREAM_FILE);){
			printStream.println(LINE);
		}
		
	}
	@Test
	@Order(2)
	@DisplayName("Output of lines using PrintWriter")
	void printWriterStreamtest() throws FileNotFoundException {
		try(PrintWriter printWriter = new PrintWriter(PRINT_WRITER_FILE);){
			printWriter.println(LINE);
		}
		
	}
	@Test
	@Order(3)
	@DisplayName("Input from file created by PrintStream")
	void inputStreamTest() throws IOException {
		try(BufferedReader reader = new BufferedReader(new FileReader(PRINT_STREAM_FILE));){
			assertEquals(LINE,reader.readLine());
		}
	}
	@Test
	@Order(4)
	@DisplayName("Input from file created by PrintWriter")
	void inputWriterTest() throws IOException {
		try(BufferedReader reader = new BufferedReader(new FileReader(PRINT_WRITER_FILE));){
			assertEquals(LINE,reader.readLine());
		}
	}
	@Test
	@Order(5)
	@DisplayName("Performance for printWriter")
	void PerformanceWriterTest() throws Exception {
		try(PrintWriter printWriter = new PrintWriter(BIG_FILE)){
			IntStream.range(0, 
					N_LINES).forEach(i -> printWriter.println(LINE));
		}
		
	}
	@Test
	@Order(6)
	@DisplayName("Performance for PrintStream")
	void PerformanceStreamTest() throws Exception {
		try(PrintStream printStream = new PrintStream(BIG_FILE)){
			IntStream.range(0, 
					N_LINES).forEach(i -> printStream.println(LINE));
		}
		
	}

}
