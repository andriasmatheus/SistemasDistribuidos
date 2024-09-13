import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import Lexico.Token;
import Lexico.Lexer;
import Sintatico.Parser;

public class Main {
    
    public static void main(String[] args) throws IOException{
        List<Token> tokens = null;

        String data = readFile(args[0], StandardCharsets.UTF_8);
        Lexer lexer = new Lexer(data);
        tokens = lexer.getTokens();

        Parser parser = new Parser(tokens);
        parser.run();
    }

    static String readFile(String path, Charset encoding) throws IOException {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return encoding.decode(ByteBuffer.wrap(encoded)).toString();
    }
}
