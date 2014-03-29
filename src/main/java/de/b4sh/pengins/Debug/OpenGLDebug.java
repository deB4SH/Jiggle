package de.b4sh.pengins.Debug;

import org.lwjgl.opengl.ARBDebugOutput;
import org.lwjgl.opengl.ARBDebugOutputCallback;

public class OpenGLDebug {

    private static ARBDebugOutputCallback callback;

    public OpenGLDebug()
    {
        callback = new ARBDebugOutputCallback();
    }

    public static void print()
    {
        ARBDebugOutput.glDebugMessageCallbackARB(callback);

        System.out.println(callback);
    }

    public static void printError()
    {
        int errorCode = ARBDebugOutput.GL_DEBUG_TYPE_ERROR_ARB;

        if(errorCode != 33356) //33356 is default value
        {
            System.out.println("ARB-Errorcode: " + errorCode);
        }
    }
}
