package br.ufrn.imd.blackjackClient.utils;

import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import br.ufrn.imd.blackjackClient.exceptions.InputTimeoutException;

public class TimeoutInput {
	
	private static Long DEFAULT_TIMEOUT = 15l;
	private static Integer DEFAULT_THREAD_NUMBER = 1;
	
	public static String inputString() throws InputTimeoutException {
		
		Callable<String> callable = () -> new Scanner(System.in).next();
		ExecutorService service = Executors.newFixedThreadPool(DEFAULT_THREAD_NUMBER);
		Future<String> inputFuture = service.submit(callable);
		
		try {
			return inputFuture.get(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException ex) {
			throw new InputTimeoutException();
		}
		
	}
	
	public static Long inputLong() throws InputTimeoutException {
		Callable<Long> callable = () -> new Scanner(System.in).nextLong();
		ExecutorService service = Executors.newFixedThreadPool(DEFAULT_THREAD_NUMBER);
		Future<Long> inputFuture = service.submit(callable);
		
		try {
			return inputFuture.get(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
		} catch (InterruptedException | ExecutionException | TimeoutException ex) {
			throw new InputTimeoutException();
		}
	}

}
