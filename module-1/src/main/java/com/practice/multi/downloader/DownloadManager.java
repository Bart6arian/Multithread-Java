package com.practice.multi.downloader;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.util.concurrent.Semaphore;

public class DownloadManager implements Runnable {

    private static Semaphore semaphore = new Semaphore(10);

    private void transfer() throws IOException {
        URL website = new URL("https://www.dundeecity.gov.uk/sites/default/files/publications/civic_renewal_forms.zip");
        ReadableByteChannel rbc = Channels.newChannel(website.openStream());
        FileOutputStream fos = new FileOutputStream("output.html");
        fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
    }

    @Override
    public void run() {
        try {
            semaphore.acquire();
            transfer();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }
}
