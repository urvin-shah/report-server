package com.report;


/**
 * This is the Main class of Application
 */

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

import com.report.utils.CSVUtil;

@SpringBootApplication
@PropertySource("classpath:application.properties")
public class Application implements CommandLineRunner{
	@Autowired
	private CSVUtil csvUtil;
	
	@Value("${csvFilePath}")
	private String csvFilePath;
	@Value("${csvFileName}")
	private String csvFile;
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	public void run(String... args) throws Exception {
		csvUtil.parseCSV((csvFilePath+csvFile));
		watch();
	}
	
	public void watch() throws InterruptedException {
		try {
			final Path filePath = FileSystems.getDefault().getPath(csvFilePath);
			try (final WatchService watchService = FileSystems.getDefault().newWatchService()) {
			    final WatchKey watchKey = filePath.register(watchService, StandardWatchEventKinds.ENTRY_MODIFY);
			    while (true) {
			        final WatchKey wk = watchService.take();
			        for (WatchEvent<?> event : wk.pollEvents()) {
			            //we only register "ENTRY_MODIFY" so the context is always a Path.
			            final Path changed = (Path) event.context();
			            System.out.println(changed);
			            if (changed.endsWith(csvFile)) {
			            	System.out.println("Data file changed");
			            	csvUtil.parseCSV((csvFilePath+csvFile));
			            }
			        }
			        // reset the key
			        boolean valid = wk.reset();
			        if (!valid) {
			            System.out.println("Key has been unregistered");
			        }
			    }
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
