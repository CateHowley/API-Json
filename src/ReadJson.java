import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;



// video to load jar
//https://www.youtube.com/watch?v=QAJ09o3Xl_0

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import javax.swing.*;
import javax.swing.plaf.basic.BasicOptionPaneUI;

// Program for print data in JSON format.
public class ReadJson  implements ActionListener {


    private JFrame mainFrame;
    private JLabel headerLabel;
    private JTextArea statusLabel;
    private JPanel controlPanel;
    private JPanel topPanel;

    private JMenuBar mb;
    private JMenu file, edit, help;
    private JMenuItem cut, copy, paste, selectAll;
    private JTextArea url;
    private int WIDTH = 800;
    private int HEIGHT = 700;
    private JTextArea search;
    private JTextArea results;
    private JLabel emptySpace;
    private JScrollPane scrollPane;


    public static void main(String args[]) throws ParseException {
        // In java JSONObject is used to create JSON object
        // which is a subclass of java.util.HashMap.

        JSONObject file = new JSONObject();
        file.put("Full Name", "Ritu Sharma");
        file.put("Roll No.", 1704310046);
        file.put("Tution Fees", 65400);

        ReadJson reading = new ReadJson();
        // To print in JSON format.
        System.out.print(file.get("Tuition Fees"));


    }

    public ReadJson()  throws ParseException{
        pull();
        prepareGUI();
    }


    public void prepareGUI() {
        mainFrame = new JFrame("Java SWING");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(3, 1));

        topPanel = new JPanel();
        topPanel.setLayout(new GridLayout(1, 3));
        cut = new JMenuItem("cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        selectAll = new JMenuItem("selectAll");
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        selectAll.addActionListener(this);

        mb = new JMenuBar();
        file = new JMenu("File");
        edit = new JMenu("Edit");
        help = new JMenu("Help");
        edit.add(cut);
        edit.add(copy);
        edit.add(paste);
        edit.add(selectAll);
        mb.add(file);
        mb.add(edit);
        mb.add(help);


        url = new JTextArea("url");
        emptySpace = new JLabel("space");
        search = new JTextArea("search term");


        mainFrame.add(mb);
        topPanel.add(url);
        topPanel.add(emptySpace);
        topPanel.add(search);

        mainFrame.setJMenuBar(mb);
        mainFrame.add(topPanel);

        headerLabel = new JLabel("", JLabel.CENTER);
        results = new JTextArea();
        results.setSize(350, 100);

//        scrollPane = new JScrollPane(results);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        mainFrame.setVisible(true);

    }


public void Array(){
    JButton okayButton = new JButton("okay");
    JButton submitButton = new JButton("submit");
    JButton cancelButton = new JButton("canel");

    okayButton.setActionCommand("okay");
    submitButton.setActionCommand("submit");
    cancelButton.setActionCommand("cancel");

    okayButton.addActionListener( new ButtonClickListener());
    submitButton.addActionListener( new ButtonClickListener());
    cancelButton.addActionListener(new ButtonClickListener());

    controlPanel.add(okayButton);
    controlPanel.add(submitButton);
    controlPanel.add(cancelButton);
    controlPanel. add(okayButton);

    mainFrame.setVisible(true);

}





    public  void pull() throws ParseException {
        String output = "abc";
        String totlaJson="";
        try {
            URL url = new URL("https://last-airbender-api.fly.dev/api/v1/characters\n");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
           conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");

           if (conn.getResponseCode() != 200) {

                throw new RuntimeException("Failed : HTTP error code : "
                       + conn.getResponseCode());
            }

           BufferedReader br = new BufferedReader(new InputStreamReader(
                    (conn.getInputStream())));


            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
                totlaJson+=output;
            }

            conn.disconnect();

        } catch (MalformedURLException e) {
            e.printStackTrace();

        } catch (IOException e) {
            e.printStackTrace();
        }

        JSONParser parser = new JSONParser();
        //System.out.println(str);
        org.json.simple.JSONArray JSONArray = (org.json.simple.JSONArray) parser.parse(totlaJson);
        System.out.println(JSONArray);


        try {
            System.out.println(JSONArray.get(0));
            JSONObject secretTunnelGuy=(JSONObject) JSONArray.get(0);
            System.out.println(secretTunnelGuy.get("name"));
            org.json.simple.JSONArray secretTunnelGuyAllies= (JSONArray) secretTunnelGuy.get("allies");
            System.out.println(secretTunnelGuyAllies.get(0));

            JSONObject secretTunnelGuy1=(JSONObject) JSONArray.get(1);
            System.out.println(secretTunnelGuy1.get("name"));

            JSONObject secretTunnelGuy2=(JSONObject) JSONArray.get(2);
            System.out.println(secretTunnelGuy2.get("name"));

            JSONObject secretTunnelGuy3=(JSONObject) JSONArray.get(3);
            System.out.println(secretTunnelGuy3.get("name"));

            for(int x=0; x<JSONArray.size();x++){
                JSONObject secretTunnelGuy4 =(JSONObject) JSONArray.get(x);
                System.out.println(secretTunnelGuy4.get("name"));


            }



            //           String name = (String)JSONArray.get("eyes_color");

       //     org.json.simple.JSONArray msg = (org.json.simple.JSONArray) JSONArray.get("starships");
        //    int n =   msg.size(); //(msg).length();
          //  for (int i = 0; i < n; ++i) {
          //      String test =(String) msg.get(i);
          //      System.out.println(test);
                // System.out.println(person.getInt("key"));
           // }
          //  String name= (String)jsonObject.get("height");
          //  System.out.println(name);
        }

        catch (Exception e) {
            e.printStackTrace();
        }






}

    @Override
    public void actionPerformed(ActionEvent e) {

    }
    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("OK")) {
                statusLabel.setText("Ok Button clicked.");
            } else if (command.equals("Submit")) {
                statusLabel.setText("Submit Button clicked.");
            } else if (command.equals("Cate!")) {
                statusLabel.setText("Cate! Button clicked");
            } else if (command.equals("hello")) {
                statusLabel.setText("hello! Button clicked");
            } else{
                statusLabel.setText("Cancel Button clicked.");

            }
        }
    }
}





