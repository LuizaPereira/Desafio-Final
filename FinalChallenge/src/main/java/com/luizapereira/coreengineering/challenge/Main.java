package com.luizapereira.coreengineering.challenge;

import com.luizapereira.coreengineering.challenge.persistence.FolderWatcher;

public class Main {
    public static void main(String[] args) throws Throwable {
        FolderWatcher folderWatcher = new FolderWatcher();
        folderWatcher.startWatching();
    }
}