package com.jimmytai.library.utils.log;

import android.util.Log;

/**
 * Created by JimmyTai on 2016/11/17.
 * <p>
 * JLog class provide a possibility to control log output easily.
 */

public class JLog {
    /**
     * Send a INFO log message.
     *
     * @param isDebug Used to control whether print the log.
     * @param tag     Used to identify the source of a log message.  It usually identifies
     *                the class or activity where the log call occurs.
     * @param content The message you would like logged.
     */
    public static void i(boolean isDebug, String tag, String content) {
        if (isDebug)
            Log.i(tag, content);
    }

    /**
     * Send a INFO log message and log the exception.
     *
     * @param isDebug Used to control whether print the log.
     * @param tag     Used to identify the source of a log message.  It usually identifies
     *                the class or activity where the log call occurs.
     * @param content The message you would like logged.
     * @param tr      An exception to log
     */
    public static void i(boolean isDebug, String tag, String content, Throwable tr) {
        if (isDebug)
            Log.i(tag, content, tr);
    }

    /**
     * Send a DEBUG log message.
     *
     * @param isDebug Used to control whether print the log.
     * @param tag     Used to identify the source of a log message.  It usually identifies
     *                the class or activity where the log call occurs.
     * @param content The message you would like logged.
     */
    public static void d(boolean isDebug, String tag, String content) {
        if (isDebug)
            Log.d(tag, content);
    }

    /**
     * Send a DEBUG log message and log the exception.
     *
     * @param isDebug Used to control whether print the log.
     * @param tag     Used to identify the source of a log message.  It usually identifies
     *                the class or activity where the log call occurs.
     * @param content The message you would like logged.
     * @param tr      An exception to log
     */
    public static void d(boolean isDebug, String tag, String content, Throwable tr) {
        if (isDebug)
            Log.d(tag, content, tr);
    }

    /**
     * Send a ERROR log message.
     *
     * @param isDebug Used to control whether print the log.
     * @param tag     Used to identify the source of a log message.  It usually identifies
     *                the class or activity where the log call occurs.
     * @param content The message you would like logged.
     */
    public static void e(boolean isDebug, String tag, String content) {
        if (isDebug)
            Log.e(tag, content);
    }

    /**
     * Send a ERROR log message and log the exception.
     *
     * @param isDebug Used to control whether print the log.
     * @param tag     Used to identify the source of a log message.  It usually identifies
     *                the class or activity where the log call occurs.
     * @param content The message you would like logged.
     * @param tr      An exception to log
     */
    public static void e(boolean isDebug, String tag, String content, Throwable tr) {
        if (isDebug)
            Log.e(tag, content, tr);
    }

    /**
     * Send a ERROR log message.
     *
     * @param isDebug Used to control whether print the log.
     * @param tag     Used to identify the source of a log message.  It usually identifies
     *                the class or activity where the log call occurs.
     * @param content The message you would like logged.
     */
    public static void w(boolean isDebug, String tag, String content) {
        if (isDebug)
            Log.w(tag, content);
    }

    /**
     * Send a ERROR log message and log the exception.
     *
     * @param isDebug Used to control whether print the log.
     * @param tag     Used to identify the source of a log message.  It usually identifies
     *                the class or activity where the log call occurs.
     * @param content The message you would like logged.
     * @param tr      An exception to log
     */
    public static void w(boolean isDebug, String tag, String content, Throwable tr) {
        if (isDebug)
            Log.w(tag, content, tr);
    }

    /**
     * Send a VERBOSE log message.
     *
     * @param isDebug Used to control whether print the log.
     * @param tag     Used to identify the source of a log message.  It usually identifies
     *                the class or activity where the log call occurs.
     * @param content The message you would like logged.
     */
    public static void v(boolean isDebug, String tag, String content) {
        if (isDebug)
            Log.v(tag, content);
    }

    /**
     * Send a VERBOSE log message and log the exception.
     *
     * @param isDebug Used to control whether print the log.
     * @param tag     Used to identify the source of a log message.  It usually identifies
     *                the class or activity where the log call occurs.
     * @param content The message you would like logged.
     * @param tr      The message you would like logged.
     */
    public static void v(boolean isDebug, String tag, String content, Throwable tr) {
        if (isDebug)
            Log.v(tag, content, tr);
    }

    /**
     * What a Terrible Failure: Report a condition that should never happen. The error will always be logged at level ASSERT with the call
     * stack. Depending on system configuration, a report may be added to the DropBoxManager and/or the process may be terminated
     * immediately with an error dialog.
     *
     * @param isDebug Used to control whether print the log.
     * @param tag     Used to identify the source of a log message.
     * @param content The message you would like logged.
     */
    public static void wtf(boolean isDebug, String tag, String content) {
        if (isDebug)
            Log.wtf(tag, content);
    }

    /**
     * What a Terrible Failure: Report a condition that should never happen. The error will always be logged at level ASSERT with the call
     * stack. Depending on system configuration, a report may be added to the DropBoxManager and/or the process may be terminated
     * immediately with an error dialog.
     *
     * @param isDebug Used to control whether print the log.
     * @param tag     Used to identify the source of a log message.
     * @param content The message you would like logged.
     * @param tr      An exception to log. May be null.
     */
    public static void wtf(boolean isDebug, String tag, String content, Throwable tr) {
        if (isDebug)
            Log.wtf(tag, content, tr);
    }
}
