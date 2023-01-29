package com.kickthedrawer.ynab.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kickthedrawer.ynab.amazon.LoadAmazonTransactions;

import lombok.extern.java.Log;
import picocli.CommandLine;

@SpringBootApplication(scanBasePackages = {"com.kickthedrawer.ynab"})
@Log
public class YnabUtilsApplication implements CommandLineRunner, ExitCodeGenerator {
	private int exitCode;

	@Autowired
	private LoadAmazonTransactions amazonTransactions;

	@Override
	public void run(String... args) throws Exception {
		log.info("Starting application run");
		CommandLine commandLine = new CommandLine(amazonTransactions);
		exitCode = commandLine.execute(args);
	}

	@Override
	public int getExitCode() {
		return exitCode;
	}

	public static void main(String[] args) {
		SpringApplication.run(YnabUtilsApplication.class, args);
	}

}
