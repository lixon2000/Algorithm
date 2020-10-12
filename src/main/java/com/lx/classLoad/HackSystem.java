package com.lx.classLoad;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class HackSystem {
    public static PrintStream out ;
    static{
        try
        {
            out = new MyPrintStream(new File("cfg/out.txt"));
        } catch (FileNotFoundException e)
        {
            e.printStackTrace();
        }
    }
}
