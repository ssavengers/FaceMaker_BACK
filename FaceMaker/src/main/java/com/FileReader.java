package com;
import java.io.File;
import java.io.FileWriter;

public class FileReader {

  public static void main(String[] args) throws Exception {
    //fileSearch("./src/main/webapp/img");
    //fileSearch("C:\\Users\\ELIJAH\\Desktop\\FaceMaker_BACK\\FaceMaker\\src\\main\\webapp\\img");
  }



  public static void fileSearch(String path) throws Exception {
    File dir = new File(path);
    File[] fileList = dir.listFiles();
    //FileWriter writer = new FileWriter(new File("/Users/user/바탕화면/test.txt"), true);

    for(int i=0; i<fileList.length; i++) {
      File file = fileList[i]; 

      if(file.isFile()){
        if(!file.getName().equals(".DS_Store")) {
          System.out.println("파일 : " + file.getName());
          //writer.write(file.getName() + "\n");
          //writer.flush();
        }
      } else if(file.isDirectory()) {
        fileSearch(file.getCanonicalPath().toString()); 
      }          
    }
  }
}