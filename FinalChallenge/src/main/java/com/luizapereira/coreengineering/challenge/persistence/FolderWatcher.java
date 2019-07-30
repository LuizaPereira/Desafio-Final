package com.luizapereira.coreengineering.challenge.persistence;

import java.io.IOException;
import java.nio.file.*;

public class FolderWatcher {
    private static final String FOLDER_PATH = "/data/in";
    private static final FilesDAO filesDAO = new FilesDAO();

    public void startWatching() throws Throwable {
        Path path = Paths.get(System.getProperty("user.home") + FOLDER_PATH);
        WatchService watchService;

        watchService = FileSystems.getDefault().newWatchService();
        path.register(watchService,StandardWatchEventKinds.ENTRY_CREATE);

        WatchKey watchKey;

        while ((watchKey = watchService.take()) != null) {
            this.loadFolder(path);

                for (WatchEvent<?> event : watchKey.pollEvents()) {
                    if (event.context().toString().contains(".dat")) {
                        filesDAO.readFile(event.context().toString());
                        filesDAO.writeFile();
                    }
                }
            watchKey.reset();
        }
    }

    private void loadFolder(Path path) throws Throwable {
        DirectoryStream<Path> stream = Files.newDirectoryStream(path, "*.dat");
        for (Path file : stream) {
            filesDAO.readFile(file.getFileName().toString());
        }
    }
}