package parser;

import java.io.*;

import ast.*;
import java_cup.runtime.*;

/** 
 * The entry point of the SLP (Straight Line Program) application.
 */
public class Main {
	private static boolean printtokens = false;
	
	/** Reads an SLP and pretty-prints it.
	 * 
	 * @param args Should be the name of the file containing an SLP.
	 */
	public static void main(String[] args) {
		FileReader txtFile = null;
		Symbol parseSymbol = null;
		
		try {
			if (args.length == 0) {
				System.out.println("Error: Missing input file argument!");
				printUsage();
				System.exit(-1);
			}
			if (args.length == 2) {
				if (args[1].equals("-printtokens")) {
					printtokens = true;
				}
				else {
					printUsage();
					System.exit(-1);
				}
			}
			
			// Parse the input file
			txtFile = new FileReader(args[0]);
			Lexer scanner = new Lexer(txtFile);
			Parser parser = new Parser(scanner);
			parser.printTokens = printtokens;
			
			parseSymbol = parser.parse();
			System.out.println("Parsed " + args[0] + " successfully!");
			Program root = (Program) parseSymbol.value;
			
			SemanticAnalayzer sa = new SemanticAnalayzer(root);
			root.accept(sa);
			
			// Pretty-print the program to System.out
			PrettyPrinter printer = new PrettyPrinter(args[0], root);
			printer.print();	
		} catch (FileNotFoundException fnfException) {
            System.err.println("The file " + args[0] + " not found");
        } catch (LexicalError lexicalError) {
            System.err.println("LexicalError: " + lexicalError.getMessage());
        } catch (SyntaxError syntaxError) {
            System.err.println("SyntaxError: " + syntaxError.getMessage());
        } catch (Exception ex) {
            ex.printStackTrace();
            System.err.println("IO Error (brutal exit) " + ex.getMessage() + " " + parseSymbol.value);
        } finally {
            try {
                if (txtFile != null) {
                    txtFile.close();
                }
            } catch (IOException ex) {
                System.err.println("txtFile.close()");
            }
        }
		
	}
	
	/** 
	 * Prints usage information about this application to System.out
	 */
	public static void printUsage() {
		System.out.println("Usage: slp file [-printtokens]");
	}
}