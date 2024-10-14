package com.noitcereon.memeservletdemo;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class MemeServlet extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter writer = response.getWriter();
        writer.print("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "</head>\n");
        int memeId = Integer.parseInt(request.getParameter("memeId"));

        String localFileDirectory = "./assets/";
        Map<Integer, String> memePaths = new HashMap<>();
        memePaths.put(404, "http://sd.keepcalm-o-matic.co.uk/i/error-404-meme-not-found.png");
        memePaths.put(1, localFileDirectory + "Bust-A-Nut.png");
        memePaths.put(2, localFileDirectory + "clint eastwood.jpg");
        memePaths.put(3, localFileDirectory + "who is a good boy.jpg");
        memePaths.put(4, localFileDirectory + "broes.mp4");
        memePaths.put(5, localFileDirectory + "http-code-fun.png");
        memePaths.put(6, localFileDirectory + "oh-no.mp4");
        memePaths.put(9001, "https://i.ytimg.com/vi/LqSg9yVfzV0/maxresdefault.jpg");

        if (memePaths.containsKey(memeId)) {
            printMeme(memePaths.get(memeId), writer);
        } else {
            printMeme(memePaths.get(404), writer);
        }
        writer.println("</html>");
    }

    private void printMeme(String memePath, PrintWriter writer) {
        if (memePath.endsWith(".mp4")) {
            writer.printf("<video controls>" +
                    "<source src='%s' type='video/mp4'>" +
                    "</video>", memePath);
            return;
        }

        writer.printf("<img src=\"%s\" alt='meme image'>", memePath);
    }
}
