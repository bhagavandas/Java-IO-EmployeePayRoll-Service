package com.bl.EmpPayrollServices;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.IntStream;

class NIOFileAPITest extends FileUtils {
    private static final String HOME = System.getProperty("user.home");
    private static final String PLAY_WITH_NIO = "TempPlayGround";

    @Test
    public void givenPathWhenCheckedThenConfirm() throws IOException {

        Path currentDirPath = Paths.get(HOME);
        Assertions.assertTrue(Files.exists(currentDirPath));

        Path playPath = Paths.get(HOME + "/" + PLAY_WITH_NIO);
        //deletes the files
        if(Files.exists(playPath)) FileUtils.deleteFiles(playPath.toFile());
        Assertions.assertTrue(Files.notExists(playPath));
        //creates the directory
        Files.createDirectory(playPath);
        Assertions.assertTrue(Files.exists(playPath));
        IntStream.range(1,10).forEach(cntr ->{
            Path tempFile = Paths.get(playPath + "/temp" +cntr);
            Assertions.assertTrue(Files.notExists(tempFile));
            try{
                Files.createFile(tempFile);
            }catch (IOException e){
                Assertions.assertTrue(Files.exists(tempFile));
            }
        });
        //List the files
        Files.list(playPath).filter(Files::isRegularFile).forEach(System.out::println);
        Files.newDirectoryStream(playPath).forEach(System.out::println);
        Files.newDirectoryStream(playPath, path ->
                path.toFile().isFile() && path.toString().
                        startsWith("temp")).forEach(System.out::println);
    }
@Test
public void givenADirectoryWhenWatchedListsAllTheActivities() throws IOException {
        Path dir = Paths.get(HOME+"/" +  PLAY_WITH_NIO);
        Files.list(dir).filter(Files::isRegularFile).forEach(System.out::println);
        new Java8WatchServiceExample(dir).processEvents();

}

}