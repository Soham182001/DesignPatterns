package CompositeDesignPatternLLD.FileSystemComposite;

import java.util.ArrayList;
import java.util.List;

public class Directory implements FileSystem {
    String directoryName;
    List<FileSystem> fileSystemList;

    public Directory(String name){
        this.directoryName = name;
        fileSystemList = new ArrayList<>();
    }

    public void add(FileSystem fileSystemObj){
        this.fileSystemList.add(fileSystemObj);
    }

    public void ls(){
        System.out.println("Directory Name: "+ directoryName);
        for(FileSystem fileSystemObj: fileSystemList){
            fileSystemObj.ls();
        }
    }
}
