package com.cloud_burst.vm_manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;import java.lang.*;import java.lang.Process;import java.lang.Runtime;import java.lang.String;import java.lang.StringBuffer;import java.lang.System;

/**
 * Executes commands on terminal.
 */
public class ExecuteCommand {
    /**
     * Execute given command in terminal.
     *
     * @param command   Command to be executed in terminal.
     * @return          Output from terminal.
     */
    public static String exec(String command) {
        StringBuffer output = new StringBuffer();
        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line + "\n");
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (java.lang.InterruptedException e) {
            System.err.println("The process was interrupted!");
        }

        return output.toString();
    }
}