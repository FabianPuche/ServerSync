package com.superzanti.serversync.gui;

import com.superzanti.serversync.ServerSync;

import javax.swing.*;
import java.lang.reflect.InvocationTargetException;

public class FileProgress implements Runnable {

    StringBuilder sb;
    int progress = 0;

    public void updateProgress(int progress, String fileName) {
        sb = new StringBuilder(100);
        this.progress = progress;
        sb.append("Updating: ");
        sb.append(fileName);
        try {
            SwingUtilities.invokeAndWait(this);
        } catch (InvocationTargetException | InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void fileFinished() {
        updateFileProgress(null, 0);
    }

    @Override
    public void run() {
        if (sb != null) {
            updateFileProgress(sb.toString(), progress);
        }
    }

    private void updateFileProgress(String message, int progress) {
        if (ServerSync.clientGUI != null) {
            ServerSync.clientGUI.updateFileProgress(message, progress);
        }
    }

}
