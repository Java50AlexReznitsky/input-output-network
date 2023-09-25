package telran.io.application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextNumbersSeparator {

	public static void main(String[] args) throws Exception {
		if(args.length < 3) {
			System.out.println("Too few arguments, usage: <source file> <numbers file> <text file>");
		}else {
			try(BufferedReader sourceFile = new BufferedReader(new FileReader(args[0]));
					PrintWriter numbersFile = new PrintWriter(args[1]);
					PrintWriter textFile = new PrintWriter(args[2]);
					){
				if(!Files.exists(Path.of(args[0]))) {
					throw new FileNotFoundException();
				}
				Pattern pattern = Pattern.compile("\\d+"); // only numbers
				sourceFile.lines().forEach(line -> {
					Matcher matcher = pattern.matcher(line);
					while(matcher.find()) {
						String number = matcher.group();
						if(number.length() > 1) {
							numbersFile.println(number);
						}
					}
					String text = line.replaceAll("\\d+[.]|\\d+", ""); //replacing (numbers with dots or just numbers) with empty String
					textFile.println(text);
				});
			}
		}
		
		

	}

}
