/*
 * Copyright (c) Alexander Kammerer 2015.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the MIT License
 * which accompanies this distribution.
 */

package org.openhab;

/**
 * Created by Alexander on 26.08.2015.
 */
public class Utils {
    public static String yesOrNo(Boolean expr) {
        return (expr) ? "Yes" : "No";
    }

    public static String trueOrFalse(Boolean expr) {
        if (expr == null) {
            expr = false;
        }
        return (expr) ? "true" : "false";
    }
}
